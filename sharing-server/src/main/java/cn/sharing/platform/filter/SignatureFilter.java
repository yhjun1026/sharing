/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：mpos
 * 文件名：SignatureFilter
 * 模块说明：
 * 修改历史：
 * 2017-03-21 - liaozhi - 创建
 */
package cn.sharing.platform.filter;

import cn.sharing.platform.config.SignFilterConfig;
import cn.sharing.platform.utils.RequestContextUtils;
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
  SignFilterConfig config;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
          throws IOException, ServletException {
    log.info("开始执行过滤>>>>>");
    //过滤
    log.info("归还接口调用");
      filterChain.doFilter(servletRequest, servletResponse);
    log.info("执行结束<<<<<<");
  }


  @Override
  public void destroy() {

  }
}
