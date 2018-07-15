package cn.sharing.platform.service.pay.wxpay;

import cn.sharing.platform.facade.pay.v1.PayIn;

import cn.sharing.platform.service.pay.wxpay.utils.*;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class WxScanPayRequest {
	public static final String unifiedorderURL = "https://api.mch.wechat.qq.com/pay/micropay";
	private WxAccount wxaccount;
    private PayIn payin;
    private static final Logger LOGGER = Logger.getLogger(WxScanPayRequest.class);
    private String out_trade_no; //原交易商户订单号
	private String transaction_id;  //
	private String out_refund_no; //商户退款单号  退货交易流水
	private String total_fee;
	private String refund_fee;
	private String op_user_id;
	private String op_user_passwd;
	
	private String retcode;
	private String retmsg;	
	private String result_code;
	private String err_code;
	private String err_code_des;
	private String code_url;
	private String prepay_id;
	private String product_id;
	private String openid;
	private String auth_code;
	private String trade_state;
	private String bank_type;
	private String time_end;
	private String body;

	    public WxScanPayRequest(WxAccount wxaccount, PayIn payin) {
		// TODO Auto-generated constructor stub
	        this.wxaccount = wxaccount;
	        this.payin = payin;
	        
	    }
	
	    /**
		 * @return 
		 * @throws Exception 
		   * 微信统一订单请求客户端
		   * 
	    * */	
		public void UnifieldOrderClient() throws Exception{
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
	        String ip=addr.getHostAddress().toString();//获得本机IP        
	        
	        reqHandler.init();
	        reqHandler.setKey(wxaccount.getAppkey());
	        reqHandler.setGateUrl(unifiedorderURL);
	        
			    HashMap<String, String> nativeObj = new HashMap<String, String>();
			    nativeObj.put("appid", wxaccount.getAppId());
			    nativeObj.put("mch_id", wxaccount.getMchId());
			    if (wxaccount.getSubMchId() == null || wxaccount.getSubMchId().length() <= 0){
				
			    }else{
				    nativeObj.put("sub_mch_id", wxaccount.getSubMchId());
			    }
		    	nativeObj.put("nonce_str", CommonUtil.CreateNoncestr());
			    nativeObj.put("body", "微信支付");
			    nativeObj.put("out_trade_no", payin.getOut_trade_no());
			 //   nativeObj.put("total_fee",String.valueOf((int)(payin.getOri_total_fee()*100)));
			    BigDecimal b1 = new BigDecimal(Double.toString(payin.getOri_total_fee()));
			    nativeObj.put("total_fee",String.valueOf((b1.multiply(new BigDecimal("100")))));
			    nativeObj.put("spbill_create_ip", ip);
			    //nativeObj.put("product_id", product_id);
			    nativeObj.put("auth_code", payin.getAuth_code());
			    //nativeObj.put("openid", openid);
			    //nativeObj.put("device_info", "WEB");
			    nativeObj.put("sign", GetBizSign(nativeObj));
	        //设置请求返回的等待时间
	        httpClient.setTimeOut(2);	
	        
	        //设置发送类型POST
	        httpClient.setMethod("POST");     
	        
	        //设置请求内容
	        String requestUrl = reqHandler.getRequestURL();
	        httpClient.setReqContent(requestUrl);
	        httpClient.setReqXmlPosData(CommonUtil.ArrayToXmlEx(nativeObj));
			    LOGGER.info("调用微信扫码付接口参数1："+requestUrl);
			    LOGGER.info("调用微信扫码付接口参数2："+CommonUtil.ArrayToXmlEx(nativeObj));
	        String rescontent = "null";        
	        //后台调用
	        if(httpClient.call()) {
	        	//设置结果参数
	        	resHandler.setCharset("UTF-8");
	        	rescontent = httpClient.getResContent();
	        	LOGGER.info("后台调用通信成功:" + rescontent);
	        	resHandler.setContent(rescontent);      
	        	
	        	//获取返回参数
	        	retcode = resHandler.getParameter("return_code");
	        	retmsg = new String(resHandler.getParameter("return_msg").getBytes("GBK"),"UTF-8");
	        	LOGGER.info("retcode:" + retcode + " " + URLDecoder.decode(retmsg, "utf-8"));
	        	
	        	result_code = resHandler.getParameter("result_code");
	        	err_code = resHandler.getParameter("err_code");
	        	err_code_des = resHandler.getParameter("err_code_des");
	        	
	        	openid = resHandler.getParameter("openid");
	        	trade_state = resHandler.getParameter("trade_type");
	        	bank_type = resHandler.getParameter("bank_type");
				    try {
				    	total_fee = String.valueOf(Double.parseDouble(resHandler.getParameter("total_fee")) / 100);
				    }catch(Exception e){
					    total_fee = "0";
					    LOGGER.error("金额转型错误，赋值为0，由其他错误引起："+err_code_des);
				    }
						transaction_id = resHandler.getParameter("transaction_id");
	        //	time_end = resHandler.getParameter("time_end");
	        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        	time_end = df.format(new Date());
	        }else {

				    LOGGER.info("后台调用通信失败");
				    LOGGER.info(httpClient.getResponseCode());
				    LOGGER.info(httpClient.getErrInfo());
	        	err_code = "Error";
	        	err_code_des = "后台调用通信失败"+httpClient.getErrInfo();
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
//			bizParameters.put("key", WxPayConfig.appkey);		
			bizString  = bizString + "&key=" + wxaccount.getAppkey();
			System.out.println(bizString);
			
			//return MD5Util.MD5(bizString).toUpperCase();
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

		public String getAuth_code() {
			return auth_code;
		}

		public void setAuth_code(String auth_code) {
			this.auth_code = auth_code;
		}

		public String getTrade_state() {
			return trade_state;
		}

		public void setTrade_state(String trade_state) {
			this.trade_state = trade_state;
		}

		public String getBank_type() {
			return bank_type;
		}

		public void setBank_type(String bank_type) {
			this.bank_type = bank_type;
		}

		public String getTime_end() {
			return time_end;
		}

		public void setTime_end(String time_end) {
			this.time_end = time_end;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}
		
	
	

}
