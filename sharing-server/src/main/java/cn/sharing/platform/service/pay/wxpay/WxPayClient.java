package cn.sharing.platform.service.pay.wxpay;

import cn.sharing.platform.facade.pay.v1.PayOut;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;

public class WxPayClient {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final Logger LOGGER = Logger.getLogger(WxPayClient.class);


	public void WxPrePay(WxUnifieldRequest QrPayReq, PayOut payout){
		LOGGER.info("预支付：微信扫码付请求开始！");
		try {
			QrPayReq.UnifieldOrderClient();
			LOGGER.info("预支付：微信扫码支付请求返回：" + QrPayReq.getResult_code());
			if (QrPayReq.getRetcode().equals("SUCCESS")) {
			    if (QrPayReq.getResult_code().equals("SUCCESS")){
			    	payout.setResult_code("S");
			    	payout.setQrurl(QrPayReq.getCode_url());
			    	payout.setOut_trade_no(QrPayReq.getOut_trade_no());
			    	
			    }else if(QrPayReq.getErr_code().equals("SYSTEMERROR") || QrPayReq.getErr_code().equals("USERPAYING")){
			    	payout.setResult_code("W");
					payout.setOut_trade_no(QrPayReq.getOut_trade_no());
					payout.setBuyer_logon_id(QrPayReq.getOpenid());
					payout.setTrade_no(QrPayReq.getTransaction_id());
					payout.setOrder_state("USERPAYING");
			    }else{
			    	payout.setResult_code("F");
					payout.setSub_code(QrPayReq.getErr_code());
					payout.setSub_desc(QrPayReq.getErr_code_des());
			    }
				
			}else{
				payout.setResult_code("F");
				payout.setSub_code(QrPayReq.getRetcode());
				payout.setSub_desc(QrPayReq.getRetmsg());
			}
		} catch (SDKRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void WxScanPay(WxScanPayRequest scanPay,PayOut payout){
		LOGGER.info("扫码付：微信支付请求开始");
		try {
			// 使用SDK，调用交易下单接口
			scanPay.UnifieldOrderClient();		
			LOGGER.info("扫码付：微信扫码支付请求返回：" + scanPay.getBody());
			// 这里只是简单的打印，请开发者根据实际情况自行进行处理
			if (scanPay.getRetcode().equals("SUCCESS")){
				if (scanPay.getResult_code().equals("SUCCESS")) {
					payout.setResult_code("S");
					payout.setOut_trade_no(scanPay.getOut_trade_no());
					payout.setBuyer_logon_id(scanPay.getOpenid());

					payout.setTotal_fee(Double.valueOf(scanPay.getTotal_fee()).doubleValue());
					payout.setTrade_no(scanPay.getTransaction_id());
					if (scanPay.getTime_end() != null){
						//payout.setPay_time(sdf.format(scanPay.getTime_end()));
						payout.setPay_time(scanPay.getTime_end());
					//	payout.setPay_time((scanPay.getTime_end().substring(0, 4)+"-"+scanPay.getTime_end().substring(4, 6)
					//			            +"-"+scanPay.getTime_end().substring(6, 8)));
					}					
				}else if(scanPay.getErr_code().equals("SYSTEMERROR") || scanPay.getErr_code().equals("USERPAYING")){
					
					payout.setResult_code("W");
					payout.setOut_trade_no(scanPay.getOut_trade_no());
					payout.setBuyer_logon_id(scanPay.getOpenid());
					payout.setTotal_fee(Double.valueOf(scanPay.getTotal_fee()).doubleValue());
					payout.setTrade_no(scanPay.getTransaction_id());
				}else{
					payout.setResult_code("F");
					payout.setSub_code(scanPay.getErr_code());
					payout.setSub_desc(scanPay.getErr_code_des());	
					LOGGER.error("扫码付：微信扫码支付请求失败：" + scanPay.getErr_code_des());
				}					            
		
			} else {                           
				// 打印错误码
				payout.setResult_code("F");
				payout.setSub_code(scanPay.getRetcode());
				payout.setSub_desc(scanPay.getRetmsg());
				LOGGER.error("扫码付：微信扫码支付请求失败：" + scanPay.getErr_code_des());
			}
		} catch (Exception e) {
			payout.setResult_code("F");
			payout.setSub_code(e.getMessage());
			payout.setSub_desc(e.getMessage());		
			LOGGER.error("扫码付：微信扫码支付请求异常：" + e.getMessage());	
		}		
		LOGGER.info("扫码付：微信扫码支付请求结束！");
	}
	
	
	public void WxQuery(WxQueryRequest QueryReq, PayOut payout){
        //使用HTTPClient连接池方式的访问
		LOGGER.info("查询：微信交易查询请求开始！");
		try {
			QueryReq.OrderQuery();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			LOGGER.debug("查询：查询微信支付订单异常：" + e1.getMessage());
		}
		if (QueryReq.getResult_code().equals("SUCCESS")){
			if(QueryReq.getRetcode().equals("SUCCESS")){
				if(QueryReq.getTrade_state().equals("SUCCESS")){				
					payout.setResult_code("S");
					payout.setTrade_no(QueryReq.getTransaction_id());
					payout.setBuyer_logon_id(QueryReq.getOpenid());
					payout.setTotal_fee(Double.valueOf(QueryReq.getTotal_fee()).doubleValue());
					if (QueryReq.getTime_end() != null){
						//payout.setPay_time(sdf.format(QueryReq.getTime_end()));
						payout.setPay_time(QueryReq.getTime_end());
					}	
					payout.setOut_trade_no(QueryReq.getOut_trade_no());
					
				}else if (QueryReq.getTrade_state().equals("REVOKED")||QueryReq.getTrade_state().equals("PAYERROR")){					
					payout.setResult_code("F");
					payout.setSub_code(QueryReq.getTrade_state());
					payout.setSub_desc(QueryReq.getTrade_state_desc());						
				}else{
					payout.setResult_code("F");
					payout.setSub_code(QueryReq.getTrade_state());
					payout.setSub_desc(QueryReq.getTrade_state_desc());					
				}							
			}else{
				payout.setResult_code("F");
				payout.setSub_code(QueryReq.getErr_code());
				payout.setSub_desc(QueryReq.getErr_code_des());					
			}		
		}else{
			payout.setResult_code("F");
			payout.setSub_code(QueryReq.getRetcode());
			payout.setSub_desc(QueryReq.getRetmsg());			
		}
	}	

	public void WxRefund(WxRefundRequest refundreq, PayOut payout) {
        //使用HTTPClient连接池方式的访问   throws Exception
		LOGGER.info("退货：微信交易退货请求开始！");
        try{
	       refundreq.Refundclient();
        }catch(Exception e){
        	LOGGER.debug("退货异常：" + e.getMessage());
        	
        	//throw e;
        }
		if (refundreq != null && refundreq.getResult_code().equals("SUCCESS")){
			 if (refundreq.getRetcode().equals("SUCCESS")){
					payout.setResult_code("S");
					payout.setTrade_no(refundreq.getOut_trade_no());
					payout.setBuyer_logon_id(refundreq.getBuyer_user_id());
					payout.setTotal_fee(Double.valueOf(refundreq.getTotal_fee()).doubleValue());
					if (refundreq.getPay_date() != null){
						payout.setPay_time(sdf.format(refundreq.getPay_date()));
					}	
					payout.setOut_trade_no(refundreq.getOut_trade_no());
			 }else{
				    payout.setResult_code("F");
				    payout.setSub_code(refundreq.getDetail_error_code());
					payout.setSub_desc(refundreq.getDetail_error_des()); 
			 }
						
		}else{
			payout.setResult_code("F");
			payout.setSub_code(refundreq.getDetail_error_code());
			payout.setSub_desc(refundreq.getDetail_error_des());			
		}
	}
	
	
	
	
	
	
}
