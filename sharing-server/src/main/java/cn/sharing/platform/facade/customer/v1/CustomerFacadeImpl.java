/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：CustomerServiceImpl
 * 模块说明：
 * 修改历史：
 * 2018/5/20 - yanghongjun - 创建
 */
package cn.sharing.platform.facade.customer.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.config.WxPayConfig;
import cn.sharing.platform.dao.entity.Customer;
import cn.sharing.platform.service.customer.CustomerServiceImpl;
import cn.sharing.platform.utils.StringUtils;
import cn.sharing.platform.service.wechat.OAuthJsToken;
import cn.sharing.platform.service.wechat.WeiXinXCXService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghongjun
 * @version 1.0
 */
@RestController
@Slf4j
public class CustomerFacadeImpl implements CustomerFacade {
    @Autowired
    WxPayConfig wxPayConfig;
    private static final Logger logger = LoggerFactory.getLogger(CustomerFacadeImpl.class);

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Override
    public ResponseResult<SCustomer> login(@RequestBody WeChatAppLoginReq weChatAppLoginReq){
        if(StringUtils.isNotEmpty(weChatAppLoginReq.getOpenId())){
            Customer customer = customerServiceImpl.get(weChatAppLoginReq.getOpenId(), null);
            if(customer != null){
                SCustomer SCustomer = new SCustomer();
                SCustomer.setAppId(wxPayConfig.getAppid());
                SCustomer.setCode(weChatAppLoginReq.getCode());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String now = sdf.format(new Date());
                SCustomer.setCreateTime(now);
                SCustomer.setOpenId(customer.getOpenid());
                SCustomer.setName(customer.getName());
                SCustomer.setIcon(customer.getIcon());


                SCustomer.setToken(customer.getToken());
                SCustomer.setUnionId(customer.getUnionId());

                SCustomer.setCity(customer.getCity());
                SCustomer.setProvince(customer.getProvince());
                SCustomer.setCountry(customer.getCountry());

                return new ResponseResult<>(SCustomer);
            }
        }
        if (weChatAppLoginReq.getCode() == null || weChatAppLoginReq.getCode() .equals("")) {
            return ResponseResult.failed("invalid null, code is null.");
        }

        Map<String, Object> ret = new HashMap<String, Object>();
        //拼接参数
        String param = "?grant_type=" + WxPayConfig.grantType + "&appid=" + wxPayConfig.getAppid() + "&secret=" + wxPayConfig.getAppsecret() + "&js_code=" + weChatAppLoginReq.getCode();

        logger.info("https://api.weixin.qq.com/sns/jscode2session" + param);

        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = null;
        try {
            res = http.get("https://api.weixin.qq.com/sns/jscode2session" + param);
            //根据请求结果判定，是否验证成功
            JSONObject jsonObj = res.asJSONObject();
            if (jsonObj != null) {
                Object errcode = jsonObj.get("errcode");
                if (errcode != null) {
                    //返回异常信息
                    throw new WeixinException(jsonObj.getString("errmsg"));
                }
                ObjectMapper mapper = new ObjectMapper();
                OAuthJsToken oauthJsToken = (OAuthJsToken) JSONObject.toBean(jsonObj, OAuthJsToken.class);
                com.alibaba.fastjson.JSONObject userInfo = WeiXinXCXService.getUserInfo(weChatAppLoginReq.getEncryptedData(),oauthJsToken.getSession_key(), weChatAppLoginReq.getIv());


                SCustomer SCustomer = new SCustomer();
                SCustomer.setAppId(wxPayConfig.getAppid());
                SCustomer.setCode(weChatAppLoginReq.getCode());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String now = sdf.format(new Date());
                SCustomer.setCreateTime(now);
                SCustomer.setOpenId(oauthJsToken.getOpenid());
                SCustomer.setName(userInfo.getString("nickName"));
                SCustomer.setIcon(userInfo.getString("avatarUrl"));
                SCustomer.setToken(oauthJsToken.getSession_key());
                SCustomer.setUnionId(userInfo.getString("unionId"));
                //userPo.setNation(userInfoObj.getString("city"));

                SCustomer.setCity(userInfo.getString("city"));
                SCustomer.setProvince(userInfo.getString("province"));
                SCustomer.setCountry(userInfo.getString("country"));
                customerServiceImpl.saveCustomer(SCustomer);
                return new ResponseResult<>(SCustomer);
            }
        } catch (WeixinException e) {
            return ResponseResult.failed(e.getMessage());
        }

        return ResponseResult.failed("未获取到用户的openid");
    }

    @Override
    public ResponseResult<Void> get(@RequestBody SCustomer SCustomer) {
        return null;
    }

    @Override
    public ResponseResult<Void> update(@RequestBody SCustomer SCustomer) {
        return null;
    }

    @Override
    public ResponseResult<QueryResult<SCustomer>> query(@RequestBody CustomerQuery param) {
        return null;
    }

    @Override
    public ResponseResult<SCustomer> get(@PathVariable String id) {
        return null;
    }
}
