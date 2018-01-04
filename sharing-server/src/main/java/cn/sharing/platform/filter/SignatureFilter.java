task/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：mpos
 * 文件名：SignatureFilter
 * 模块说明：
 * 修改历史：
 * 2017-03-21 - liaozhi - 创建
 */
package cn.sharing.platform.filter;


import com.qianfan123.sailing.open.api.ResponseResult;
import com.qianfan123.sailing.open.api.ReturnCodeEnum;
import com.qianfan123.sailing.open.server.config.SignFilterConfig;
import com.qianfan123.sailing.open.server.constant.Constants;
import com.qianfan123.sailing.open.server.entity.IdentityInfo;
import com.qianfan123.sailing.open.server.interceptor.ContentCachedHttpServletRequestWrapper;
import com.qianfan123.sailing.open.server.mapper.IdentityInfoMapper;
import com.qianfan123.sailing.open.server.utils.JsonHelper;
import com.qianfan123.sailing.open.server.utils.MD5;
import com.qianfan123.sailing.open.server.utils.RequestContext;
import com.qianfan123.sailing.open.server.utils.RequestContextUtils;
import com.qianfan123.sailing.open.server.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.UUID;

/**
 * 接口签名认证过滤器
 *
 * @author yanghongjun
 */
@Slf4j
public class SignatureFilter implements Filter {
  @Autowired
  IdentityInfoMapper identityInfoMapper;

  @Autowired
  SignFilterConfig config;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
          throws IOException, ServletException {
    log.info("开始执行过滤>>>>>");
    //过滤

    ContentCachedHttpServletRequestWrapper requestWrapper = null;
    ContentCachingResponseWrapper responseWrapper = null;

    if (servletRequest instanceof HttpServletRequest) {
      requestWrapper = new ContentCachedHttpServletRequestWrapper((HttpServletRequest) servletRequest);
    }

    if (servletResponse instanceof HttpServletResponse) {
      responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);
    }

    if (config.isEnable()) {
      String requestUrl = requestWrapper.getRequestURI();

      String appId = requestWrapper.getHeader("appId");
      long timestamp = requestWrapper.getDateHeader("timesatmp");
      String sign = requestWrapper.getHeader("sign");
      log.info("地址：" + requestUrl + " appId:" + appId + " timestamp:" + timestamp + " sign:" + sign);
      if (StringUtils.isEmpty("appId") || StringUtils.isEmpty(sign) || timestamp < 0) {
        identityError(responseWrapper);
        return;
      }
      //根据appId获取对应信息
      IdentityInfo identityInfo = identityInfoMapper.selectByPrimaryKey(appId);
      if(identityInfo == null && StringUtils.isEmpty(identityInfo.getPrivateKey())){
        identityError(responseWrapper);
        return;
      }
      try {
        //超时验证
        if (!verifiedTimestamp(requestWrapper, timestamp)) {
          identityError(responseWrapper);
          return;
        }
        //签名验证
        //待签名字符串
        String content = "appId=" + appId + "&timestamp=" + timestamp + "&" + identityInfo.getPrivateKey();
        if (!MD5.verify(content, sign)) {
          //MD5验签未过
          identityError(responseWrapper);
          return;
        }
      } catch (Exception e) {
        identityError(responseWrapper);
        return;
      }
    }
    String traceId = UUID.randomUUID().toString();
    setRequestContext(traceId, requestWrapper);
    log.info("归还接口调用");
    try {
      filterChain.doFilter(requestWrapper, responseWrapper);
    } finally {
      responseWrapper.copyBodyToResponse();
      RequestContextUtils.remove();
    }
    log.info("执行结束<<<<<<");
  }


  @Override
  public void destroy() {

  }

  /**
   * 设置请求上下文
   *
   * @param traceId
   * @param request
   */
  private void setRequestContext(String traceId, HttpServletRequest request) {
    RequestContext requestContext = new RequestContext();
    requestContext.setSign(org.apache.commons.lang.StringUtils.trim(request.getHeader(Constants.HEADER_SIGN)));
    requestContext.setOrgCode(org.apache.commons.lang.StringUtils.trim(request.getHeader(Constants.HEADER_ORGCODE)));
    requestContext.setAppId(org.apache.commons.lang.StringUtils.trim(request.getHeader(Constants.HEADER_APPID)));
    requestContext.setUrl(org.apache.commons.lang.StringUtils.trim(request.getRequestURL().toString()));
    if (org.apache.commons.lang.StringUtils.trim(request.getHeader(Constants.HEADER_TIMESTAMP)) != null) {
      requestContext.setTimestamp(Long.parseLong(org.apache.commons.lang.StringUtils.trim(request.getHeader(Constants
              .HEADER_TIMESTAMP))));
    }
    requestContext.setBeginTime(new Date());
    requestContext.setTraceId(traceId);
    RequestContextUtils.setRequestContext(requestContext);
  }

  private void identityError(ContentCachingResponseWrapper response) throws IOException {
    try {
      ResponseResult<Void> res = new ResponseResult<>(ReturnCodeEnum.AUTH_FAIL);
      String result = JsonHelper.toJson(res);
      response.setContentType("application/json");
      response.setCharacterEncoding("utf-8");
      ServletOutputStream out = response.getOutputStream();
      OutputStreamWriter ow = new OutputStreamWriter(out, "UTF-8");
      ow.write(result);
      ow.flush();
      ow.close();
    } finally {
      response.copyBodyToResponse();
      RequestContextUtils.remove();
    }

  }

  /** 验证请求是否过期 */
  private Boolean verifiedTimestamp(HttpServletRequest request, long timestamp) throws Exception {
    Long nowMills = System.currentTimeMillis();

    if (Math.abs(nowMills - timestamp) > 5 * 60 * 1000) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
}
