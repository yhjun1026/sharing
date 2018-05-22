package cn.sharing.platform.pay.wxpay;


import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class WxCancelRequest {
	private final String service="alipay.acquire.cancel";   /* 接口名称 */
	private WxAccount wxaccount;
	private String trade_no;
	private static final Logger LOGGER = Logger.getLogger(WxCancelRequest.class);
	
    public WxCancelRequest(WxAccount wxaccount, String trade_no){
	    this.wxaccount = wxaccount;
	    this.trade_no = trade_no;
	    }
	   
	/* 微信撤销请求 */
	public String CreateWXCancelReq() throws UnsupportedEncodingException{
		String sParamIn = null;
;
         return sParamIn;
    
	}
	
	
	

}
