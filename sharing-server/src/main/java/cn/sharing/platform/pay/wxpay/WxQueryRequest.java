package cn.sharing.platform.pay.wxpay;

import cn.sharing.platform.pay.wxpay.utils.*;
import org.apache.log4j.Logger;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class WxQueryRequest {
	private static final String querydorderURL = "https://api.mch.weixin.qq.com/pay/orderquery";
	private WxAccount wxaccount;
	private String out_trade_no; //原交易商户订单号
	private String transaction_id;

	private String retcode;
	private String retmsg;	
	private String result_code;
	private String err_code;
	private String err_code_des;
	
	private String openid;
	private String trade_state;
	private String bank_type;
	private String total_fee;
	private String time_end;
	private String trade_state_desc;

	private static final Logger LOGGER = Logger.getLogger(WxQueryRequest.class);
	
	public WxQueryRequest(WxAccount wxaccount, String out_trade_no) {
		// TODO Auto-generated constructor stub
		this.wxaccount = wxaccount;
		this.out_trade_no = out_trade_no;
	}
	
	 /**
	   * @return 
	 * @throws Exception 
	   * 微信订单查询
	   * 1.0
	   * */		
	public void OrderQuery() throws Exception{
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
      reqHandler.setGateUrl(querydorderURL);	

		HashMap<String, String> nativeObj = new HashMap<String, String>();
		nativeObj.put("appid", wxaccount.getAppId());
		nativeObj.put("mch_id", wxaccount.getMchId());
		if (wxaccount.getSubMchId() == null || wxaccount.getSubMchId().length() <= 0){
			
		}else
		{
			nativeObj.put("sub_mch_id", wxaccount.getSubMchId());
		}
		nativeObj.put("nonce_str", CommonUtil.CreateNoncestr());
		nativeObj.put("out_trade_no", out_trade_no);	
		nativeObj.put("sign", GetBizSign(nativeObj));        
      //-----------------------------
      //设置通信参数
      //-----------------------------
      //设置请求返回的等待时间
      httpClient.setTimeOut(2);	
      //Added by liweihua 增加商户id传入过去
      httpClient.setMchid(wxaccount.getMchId());
      //设置发送类型POST
      httpClient.setMethod("POST");     
      
      //设置请求内容
      String requestUrl = reqHandler.getRequestURL();
      httpClient.setReqContent(requestUrl);
      httpClient.setReqXmlPosData(CommonUtil.ArrayToXmlEx(nativeObj));
      String rescontent = "null";        
      //后台调用
      if(httpClient.call()) {        	
      	//设置结果参数
      	resHandler.setCharset("UTF-8");
      	rescontent = httpClient.getResContent();
      	resHandler.setContent(rescontent);      
      	
      	//获取返回参数
      	retcode = resHandler.getParameter("return_code");
      	retmsg = new String(resHandler.getParameter("return_msg").getBytes("GBK"),"UTF-8");
      	LOGGER.info("retcode:" + retcode + " " + URLDecoder.decode(retmsg, "utf-8"));
      	
      	result_code = resHandler.getParameter("result_code");
      	err_code = resHandler.getParameter("err_code");
      	err_code_des = resHandler.getParameter("err_code_des");
      	
      	openid = resHandler.getParameter("openid");
      	trade_state = resHandler.getParameter("trade_state");
      	bank_type = resHandler.getParameter("bank_type");
      	if (resHandler.getParameter("total_fee") == null || resHandler.getParameter("total_fee").length() <= 0){
      		
      	}else{
      		total_fee = String.valueOf(Double.parseDouble(resHandler.getParameter("total_fee"))/100);
      	}        	
      	
      	
      	transaction_id = resHandler.getParameter("transaction_id");
      //	time_end = resHandler.getParameter("time_end");
      	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	time_end = df.format(new Date());
      	trade_state_desc = resHandler.getParameter("trade_state_desc");
      	     	
      }else {
      	
      	System.out.println("后台调用通信失败");   	
      	System.out.println(httpClient.getResponseCode());
      	System.out.println(httpClient.getErrInfo());  
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
		bizString  = bizString + "&key=" + wxaccount.getAppkey();
		System.out.println(bizString);
		return MD5Util.MD5Encode(bizString, "utf-8").toUpperCase();
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
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getTrade_state_desc() {
		return trade_state_desc;
	}
	public void setTrade_state_desc(String trade_state_desc) {
		this.trade_state_desc = trade_state_desc;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
