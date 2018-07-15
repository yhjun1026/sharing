package cn.sharing.platform.service.pay.wxpay;

import cn.sharing.platform.facade.pay.v1.PayIn;

import cn.sharing.platform.service.pay.wxpay.utils.*;
import cn.sharing.platform.utils.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.*;

public class WxUnifieldRequest {
    public static final String unifiedorderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private String out_trade_no; //原交易商户订单号
    private String transaction_id;
    private String out_refund_no; //商户退款单号  退货交易流水
    private String total_fee;
    private String refund_fee;
    private String op_user_id;
    private String op_user_passwd;
    private String body;
    private String product_id;
    private String openid;
    private String trade_type;


    private String retcode;
    private String retmsg;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String code_url;
    private String prepay_id;
    private String timeStamp;
    private String nonceStr;


    private WxAccount wxaccount;
    private PayIn payin;
    private static final Logger LOGGER = Logger.getLogger(WxUnifieldRequest.class);


    public WxUnifieldRequest(WxAccount wxaccount, PayIn payin, WXPayTypeEnum wxPayTypeEnum) {
        this.wxaccount = wxaccount;
        this.payin = payin;
        this.trade_type = wxPayTypeEnum.getType();
    }

    /**
     * @return
     * @throws Exception 微信统一订单请求客户端
     */
    public void UnifieldOrderClient() throws Exception {
        //创建查询请求对象
        RequestHandler reqHandler = new RequestHandler(null, null);
        //通信对象
        TenpayHttpClient httpClient = new TenpayHttpClient();
        //应答对象
        ClientResponseHandler resHandler = new ClientResponseHandler();

        //-----------------------------
        //设置请求参数
        //-----------------------------
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress().toString();//获得本机IP
        LOGGER.info("开始调用微信统一订单请求客户端");
        reqHandler.init();
        reqHandler.setKey(wxaccount.getAppkey());
        reqHandler.setGateUrl(unifiedorderURL);

//	        reqHandler.setParameter("appid", WxPayConfig.appid);
//	        reqHandler.setParameter("mch_id", WxPayConfig.mchid);
//	        reqHandler.setParameter("sub_mch_id", WxPayConfig.sub_mch_id);
//	        reqHandler.setParameter("nonce_str", CommonUtil.CreateNoncestr());
//	        reqHandler.setParameter("body", "Heading WeiXing Pay！");
//	        reqHandler.setParameter("out_trade_no", this.out_trade_no);	
//	        reqHandler.setParameter("total_fee", this.total_fee);       
        //
//	        
//	        reqHandler.setParameter("spbill_create_ip", ip);
//	        reqHandler.setParameter("notify_url", WxPayConfig.NotifyUrl + "WxPay/Notify");        
//	        reqHandler.setParameter("trade_type", "NATIVE");
//	        reqHandler.setParameter("product_id", this.product_id);

        HashMap<String, String> nativeObj = new HashMap<String, String>();
        nativeObj.put("appid", wxaccount.getAppId());
        nativeObj.put("mch_id", wxaccount.getMchId());
        LOGGER.info("appid " + wxaccount.getAppId() + " mch_id " + wxaccount.getMchId());
        if (wxaccount.getSubMchId() == null || wxaccount.getSubMchId().length() <= 0) {

        } else {
            LOGGER.info("子商户" + wxaccount.getSubMchId());
            nativeObj.put("sub_mch_id", wxaccount.getSubMchId());
        }
        nativeObj.put("nonce_str", CommonUtil.CreateNoncestr());

        nativeObj.put("body", payin.getBody());//URLEncoder.encode(this.body, "utf-8").getBytes("UTF-8"),"UTF-8")
        nativeObj.put("out_trade_no", payin.getOut_trade_no());
        BigDecimal b1 = new BigDecimal(Double.toString(payin.getTotal_fee()));
        nativeObj.put("total_fee", b1.multiply(new BigDecimal("100")).setScale(0).toString());
        nativeObj.put("spbill_create_ip", ip);
        nativeObj.put("notify_url", wxaccount.getNotifyUrl());
        nativeObj.put("trade_type", trade_type);
        if(StringUtils.isNotEmpty(product_id)){
            nativeObj.put("product_id", product_id);
        }
        if (StringUtils.isNotEmpty(payin.getOpenid())) {
            nativeObj.put("openid", payin.getOpenid());
        }
        nativeObj.put("sign", GetBizSign(nativeObj));

        LOGGER.info("开始调用微信统一订单请求客户端");
//			HttpClient client = HttpClientUtils.getHttpClient();
//			HttpPost httpPost = new HttpPost(unifiedorderURL);
//			System.out.println("返回PackageXML:" + CommonUtil.ArrayToXml(nativeObj));
//			StringEntity postEntity = new StringEntity(CommonUtil.ArrayToXmlEx(nativeObj), "UTF-8");
//	        httpPost.addHeader("Content-Type", "text/xml");
//	        httpPost.setEntity(postEntity);
//	        
//	        HttpResponse response = client.execute(httpPost);
        //
//	        HttpEntity entity = response.getEntity();
        //
//	        String result = EntityUtils.toString(entity, "UTF-8");       
//	        System.out.println("单独的POST" + result);

        //-----------------------------
        //设置通信参数
        //-----------------------------
        //设置请求返回的等待时间
        httpClient.setTimeOut(2);

        //设置发送类型POST
        httpClient.setMethod("POST");


        //设置请求内容
        String requestUrl = reqHandler.getRequestURL();
        httpClient.setReqContent(requestUrl);

        LOGGER.info("调用微信接口参数" + requestUrl);
        httpClient.setReqXmlPosData(CommonUtil.ArrayToXmlEx(nativeObj));
        String rescontent = "null";
        //后台调用
        if (httpClient.call()) {
            //设置结果参数
            resHandler.setCharset("UTF-8");
            rescontent = httpClient.getResContent();
            LOGGER.info("  后台调用通信成功" + rescontent);
            resHandler.setContent(rescontent);

            //获取返回参数
            retcode = resHandler.getParameter("return_code");
            retmsg = resHandler.getParameter("return_msg");

            result_code = resHandler.getParameter("result_code");
            err_code = resHandler.getParameter("err_code");
            err_code_des = resHandler.getParameter("err_code_des");

            code_url = resHandler.getParameter("code_url");
            prepay_id = resHandler.getParameter("prepay_id");
            nonceStr =  resHandler.getParameter("nonce_str");

        } else {

            LOGGER.info("  后台调用通信失败");
            LOGGER.info(httpClient.getResponseCode());
            LOGGER.info(httpClient.getErrInfo());
            retcode = "Error";
            retmsg = httpClient.getErrInfo();
        }
    }

    public String GetBizSign(HashMap<String, String> bizObj)
            throws SDKRuntimeException {
        HashMap<String, String> bizParameters = new HashMap<String, String>();

        List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(
                bizObj.entrySet());

        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i < infoIds.size(); i++) {
            Map.Entry<String, String> item = infoIds.get(i);
            if (item.getKey() != "") {
                bizParameters.put(item.getKey().toLowerCase(), item.getValue());
            }
        }

        String bizString = CommonUtil.FormatBizQueryParaMap(bizParameters,
                false);

        if (wxaccount.getAppkey() == "") {
            throw new SDKRuntimeException("APPKEY为空！");
        }
        bizString = bizString + "&key=" + wxaccount.getAppkey();
        LOGGER.info("待签名字符串：" + bizString);

        return MD5Util.MD5Encode(bizString, "utf-8").toUpperCase();
        //return SHA1Util.Sha1(bizString);

    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getOp_user_id() {
        return op_user_id;
    }

    public void setOp_user_id(String op_user_id) {
        this.op_user_id = op_user_id;
    }

    public String getOp_user_passwd() {
        return op_user_passwd;
    }

    public void setOp_user_passwd(String op_user_passwd) {
        this.op_user_passwd = op_user_passwd;
    }

    public static String getRefundurl() {
        return unifiedorderURL;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public WxAccount getWxaccount() {
        return wxaccount;
    }

    public void setWxaccount(WxAccount wxaccount) {
        this.wxaccount = wxaccount;
    }

    public static String getUnifiedorderURL() {
        return unifiedorderURL;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public PayIn getPayin() {
        return payin;
    }

    public void setPayin(PayIn payin) {
        this.payin = payin;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }
}

