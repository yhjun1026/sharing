package cn.sharing.platform.config;

import cn.sharing.platform.wechat.AccessToken;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;

import java.io.IOException;

/**
 * Created by MSI on 2018/6/10.
 */
@Configuration
@Data
public class WxPayConfig {
    //小程序appid
    @Value("${wechat.appid}")
    private  String appid = "";

    @Value("${wechat.appsecret}")
    private  String appsecret = "";
    //微信支付的商户id
    @Value("${wechat.pay.mch_id}")
    private String mch_id = "";
    //微信支付的商户密钥
    @Value("${wechat.pay.key}")
    private String key = "";
    //支付成功后的服务器回调url
    @Value("${wechat.pay.notify_url}")
    private String notify_url = "https://??/??/wechat/api/wxNotify";
    //签名方式，固定值
    public static final String SIGNTYPE = "MD5";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String TRADETYPE = "JSAPI";
    public static final String grantType = "client_credential";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.wechat.qq.com/pay/unifiedorder";

    public static AccessToken token = null;         //微信公众号的accessToken对象，由于请求次数有限制，这里使用全局静态变量保存起来
    public static AccessToken getToken(String appId, String secret) throws WeixinException, JsonParseException, JsonMappingException, IOException {
        if(token == null || token.getExpires_in() < System.currentTimeMillis()){
            //拼接参数
            String param = "?grant_type=" + grantType + "&appid=" + appId + "&secret=" + secret;
            //创建请求对象
            HttpsClient http = new HttpsClient();
            //调用获取access_token接口
            Response res = http.get("https://api.wechat.qq.com/cgi-bin/token" + param);
            System.out.println(res.asString());
            ObjectMapper mapper = new ObjectMapper();
            token = mapper.readValue(res.asString(),AccessToken.class);
        }
        return token;
    }
}
