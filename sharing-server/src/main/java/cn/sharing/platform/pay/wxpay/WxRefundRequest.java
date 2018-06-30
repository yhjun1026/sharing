package cn.sharing.platform.pay.wxpay;

import cn.sharing.platform.facade.pay.v1.PayIn;

import cn.sharing.platform.pay.wxpay.utils.*;
import cn.sharing.platform.utils.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class WxRefundRequest {
    private static final Logger LOGGER = Logger.getLogger(WxRefundRequest.class);
    public static final String RefundURL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    private WxAccount wxaccount;
    private PayIn payin;
    /*业务参数*/
    private String result_code; //	响应码
    private String retcode;  //结果码
    private String trade_no; //移动支付交易号	String
    private String qr_code; //二维码码串	String
    private String out_trade_no; //商户网站唯一订单号
    private String out_refund_no; //商户退款单号  退货交易流水
    private String refund_channel; //退款渠道,0:退到财付通、1:退到银行
    private String refund_id;  //财付通退款单号

    private String total_fee;  // 交易返回金额
    private String pay_date; // 支付时间
    private String buyer_user_id; //买家用户号
    private String buyer_logon_id; //买家账号
    private String trade_status; // 交易状态
    private String detail_error_code; //	详细错误码	String
    private String detail_error_des; //	详细错误描述
    private String recv_user_id;   //转账退款接收退款的财付通帐号
    private String reccv_user_name;//转账退款接收退款的姓
    private String refund_fee;
    private String op_user_id;
    private String op_user_passwd;


    public WxRefundRequest(WxAccount wxaccount, PayIn payin) {
        // TODO Auto-generated constructor stub
        this.wxaccount = wxaccount;
        this.payin = payin;
    }

    /**
     * @throws Exception
     * @throws Throwable
     */
    public void Refundclient() throws Exception {
        //创建查询请求对象
        RequestHandler reqHandler = new RequestHandler(null, null);
        //通信对象
        TenpayHttpClient httpClient = new TenpayHttpClient();
        //应答对象
        ClientResponseHandler resHandler = new ClientResponseHandler();

        //-----------------------------
        //设置请求参数
        //-----------------------------
        reqHandler.init();
        reqHandler.setKey(wxaccount.getAppkey());
        reqHandler.setGateUrl(RefundURL);
        HashMap<String, String> nativeObj = new HashMap<String, String>();
        nativeObj.put("appid", wxaccount.getAppId());
        nativeObj.put("mch_id", wxaccount.getMchId());
        if (StringUtils.isNotEmpty(wxaccount.getSubMchId())) {
            nativeObj.put("sub_mch_id", wxaccount.getSubMchId());
        }
        nativeObj.put("nonce_str", CommonUtil.CreateNoncestr());
        //nativeObj.put("transaction_id", this.transaction_id);
        /*	nativeObj.put("out_trade_no", payin.getOut_trade_no());
			nativeObj.put("out_refund_no", payin.getOri_out_no());*/
        nativeObj.put("out_trade_no", payin.getOri_out_no());
        nativeObj.put("out_refund_no", payin.getOut_trade_no());
        BigDecimal b1 = new BigDecimal(Double.toString(payin.getTotal_fee()));
        nativeObj.put("total_fee", b1.multiply(new BigDecimal("100")).setScale(0).toString());
        nativeObj.put("refund_fee", b1.multiply(new BigDecimal("100")).setScale(0).toString());
        nativeObj.put("op_user_id", payin.getEmp());
        nativeObj.put("sign", GetBizSign(nativeObj));


        //-----------------------------
        //设置通信参数
        //-----------------------------
        //设置请求返回的等待时间
        httpClient.setTimeOut(5);
        httpClient.setMchid(wxaccount.getMchId());
//        LOGGER.debug("证书位置：" + "C:\\MPay\\" + wxaccount.getGround() + "\\apiclient_cert.p12");
//        //设置证书
//        httpClient.setCertLessFile(new File("C:\\MPay\\" + wxaccount.getGround() + "\\apiclient_cert.p12"));

        //设置发送类型POST
        httpClient.setMethod("POST");

        //设置请求内容

        String requestUrl = reqHandler.getRequestURL();
        httpClient.setReqContent(requestUrl);
        LOGGER.debug("退款：" + CommonUtil.ArrayToXmlEx(nativeObj));
        httpClient.setReqXmlPosData(CommonUtil.ArrayToXmlEx(nativeObj));
        String rescontent = "null";
        //后台调用
        try {
            if (httpClient.call()) {
                rescontent = httpClient.getResContentEx();
                resHandler.setContent(rescontent);
                //resHandler.setKey(WxPayConfig.paternerKey);

                //获取返回参数
                result_code = resHandler.getParameter("return_code");


                LOGGER.info("退款：接口返回值：" + result_code);
                //调用接口成功
                if ("SUCCESS".equals(result_code)) {
                    retcode = resHandler.getParameter("result_code");
                    if (retcode.equals("SUCCESS")) {
                        trade_no = resHandler.getParameter("transaction_id");
                        out_trade_no = resHandler.getParameter("out_trade_no");
                        refund_channel = resHandler.getParameter("refund_channel");
                        out_refund_no = resHandler.getParameter("out_refund_no");
                        refund_id = resHandler.getParameter("refund_id");
                        total_fee = (String.valueOf(Double.parseDouble(resHandler.getParameter("refund_fee")) / 100));
                    } else {
                        detail_error_code = resHandler.getParameter("err_code");
                        detail_error_des = resHandler.getParameter("err_code_des");
                    }
                } else {
                    detail_error_code = resHandler.getParameter("err_code");
                    detail_error_des = resHandler.getParameter("err_code_des");
                }
                //设置结果参数
                //获取返回参数
                //pay_date=resHandler.getParameter("return_msg");
                //获取debug信息,建议把请求、应答内容、debug信息，通信返回码写入日志，方便定位问题
                LOGGER.debug("http res:" + httpClient.getResponseCode() + "," + httpClient.getErrInfo());
                LOGGER.debug("req url:" + requestUrl);
                LOGGER.debug("req debug:" + reqHandler.getDebugInfo());
                LOGGER.debug("res content:" + rescontent);
                LOGGER.debug("res debug:" + resHandler.getDebugInfo());
            } else {
                LOGGER.debug("后台调用通信失败");
                LOGGER.debug(httpClient.getResponseCode());
                LOGGER.debug(httpClient.getErrInfo());
                detail_error_code = "Error";
                detail_error_des = "后台调用通信失败" + httpClient.getErrInfo();

            }
        } catch (Exception e) {
            LOGGER.debug("请求微信通讯异常，配置文件错误，异常信息：" + httpClient.getErrInfo());
            throw new Exception("请求微信通讯异常,配置信息错误");
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
        System.out.println(bizString);
        return MD5Util.MD5Encode(bizString, "utf-8").toUpperCase();
    }

    public static String getRequestXml(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getDetail_error_code() {
        return detail_error_code;
    }

    public void setDetail_error_code(String detail_error_code) {
        this.detail_error_code = detail_error_code;
    }

    public String getDetail_error_des() {
        return detail_error_des;
    }

    public void setDetail_error_des(String detail_error_des) {
        this.detail_error_des = detail_error_des;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getBuyer_user_id() {
        return buyer_user_id;
    }

    public void setBuyer_user_id(String buyer_user_id) {
        this.buyer_user_id = buyer_user_id;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_channel() {
        return refund_channel;
    }

    public void setRefund_channel(String refund_channel) {
        this.refund_channel = refund_channel;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public String getRecv_user_id() {
        return recv_user_id;
    }

    public void setRecv_user_id(String recv_user_id) {
        this.recv_user_id = recv_user_id;
    }

    public String getReccv_user_name() {
        return reccv_user_name;
    }

    public void setReccv_user_name(String reccv_user_name) {
        this.reccv_user_name = reccv_user_name;
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

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

}
