package cn.sharing.platform.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by MSI on 2018/6/10.
 */
@Configuration
@Data
public class WxPayConfig {
    //小程序appid
    @Value("${weixin.appid}")
    private  String appid = "";
    //微信支付的商户id
    @Value("${weixin.pay.mch_id}")
    private String mch_id = "";
    //微信支付的商户密钥
    @Value("${weixin.pay.key}")
    private String key = "";
    //支付成功后的服务器回调url
    @Value("${weixin.pay.notify_url}")
    private String notify_url = "https://??/??/weixin/api/wxNotify";
    //签名方式，固定值
    public static final String SIGNTYPE = "MD5";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}
