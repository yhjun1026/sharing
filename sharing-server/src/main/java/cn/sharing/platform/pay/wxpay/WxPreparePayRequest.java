package cn.sharing.platform.pay.wxpay;

import cn.sharing.platform.facade.pay.v1.PayIn;

import cn.sharing.platform.pay.wxpay.utils.CommonUtil;
import cn.sharing.platform.pay.wxpay.utils.MD5Util;
import org.apache.log4j.Logger;

import java.net.URLEncoder;
import java.util.*;

public class WxPreparePayRequest {

    private WxAccount wxaccount;
    private PayIn payin;
    private static final Logger LOGGER = Logger.getLogger(WxPreparePayRequest.class);
    
    
	public WxPreparePayRequest(WxAccount wxaccount, PayIn payin) {
		// TODO Auto-generated constructor stub
	    this.wxaccount = wxaccount;
	    this.payin = payin;
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
//		bizParameters.put("key", WxPayConfig.appkey);		
		bizString  = bizString + "&key=" + wxaccount.getAppkey();
		System.out.println(bizString);		
		return MD5Util.MD5(bizString).toUpperCase();
		//return SHA1Util.Sha1(bizString);
	}	
	// 生成原生支付url
	/*
	 * weixin://wxpay/bizpayurl?sign=XXXXX&appid=XXXXXX&productid=XXXXXX&timestamp
	 * =XXXXXX&noncestr=XXXXXX
	 */
	public String CreateNativeUrl() throws SDKRuntimeException {
		String bizString = "";
		try {
			HashMap<String, String> nativeObj = new HashMap<String, String>();
			nativeObj.put("appid", wxaccount.getAppId());
			nativeObj.put("mch_id", wxaccount.getMchId());
			nativeObj.put("product_id", URLEncoder.encode(payin.getFlowno(), "utf-8"));
			nativeObj.put("time_stamp", Long.toString(new Date().getTime()/1000));
			nativeObj.put("nonce_str", CommonUtil.CreateNoncestr());
			//nativeObj.put("sign", GetBizSign(nativeObj));
			bizString = CommonUtil.FormatBizQueryParaMap(nativeObj, false);
			bizString = bizString + "&sign=" + GetBizSign(nativeObj);	
		} catch (Exception e) {
			LOGGER.info("生成原生支付URL异常："+e.getMessage());
			throw new SDKRuntimeException(e.getMessage());

		}
		LOGGER.info("weixin://wxpay/bizpayurl?" + bizString);
		return "weixin://wxpay/bizpayurl?" + bizString;	
	}

	public WxAccount getWxAccount() {
		return wxaccount;
	}

	public void setWxAccount(WxAccount wxaccount) {
		this.wxaccount = wxaccount;
	}

	public PayIn getPayin() {
		return payin;
	}

	public void setPayin(PayIn payin) {
		this.payin = payin;
	}
}
