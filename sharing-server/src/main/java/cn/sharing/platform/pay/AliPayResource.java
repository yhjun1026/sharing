//package cn.sharing.platform.pay;
//
//
//import cn.sharing.platform.facade.pay.v1.PayService;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//
//@RequestMapping("/api/v1/pay")
//@RestController
//public class AliPayResource implements PayService {
//
//	private static final Logger LOGGER = Logger.getLogger(AliPayResource.class);
//
//	@Autowired
//    private AliAccountService aliaccountService;
//	@Autowired
//	private MpayTranDtlService mpayService;
//
//    private static final HashMap<String, PayIn> memoryBase;
//    static {
//        memoryBase = com.google.common.collect.Maps.newHashMap();
//    }
//
//	@Override
//	public PayOut PreparePay(PayIn payin){
//		// TODO Auto-generated method stub
//		LOGGER.info("预支付：商铺" + payin.getGround() + " 支付宝扫码支付 " + payin.getOut_trade_no() + " 订单请求");
//		//获取当前支付商铺支付宝账户信息
//		LOGGER.info("预支付：查询账号信息");
//		PayOut payout = new PayOut();
//		final AliAccount aliaccount;
//		try{
//	   	  aliaccount = aliaccountService.getAccount(payin.getGround());
//		  if(aliaccount==null){
//		      LOGGER.info("预支付：账号不匹配");
//			  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("未找到商户对应的支付宝账户信息！");
//			  return payout;
//		  }
//		}catch(Exception e){
//			  LOGGER.error("预支付：支付宝账户查询异常，异常信息："+e.getMessage());
//			  payout.setResult_code("F");
//		   	  payout.setSub_code("Error");
//			  payout.setSub_desc("查找支付宝账户信息出错！");
//			  return payout;
//		}
//
//		//对请求账单进行存储
//		LOGGER.info("预支付：是否存在该数据实体:" + payin.getOut_trade_no());
//		MpayTranDtl mpay = new MpayTranDtl(payin.getOut_trade_no()); //mpayService.getMpay(payin.getOut_trade_no());
//		LOGGER.info("预支付:数据实体展示：" + mpay.toString());
//
//		mpay.setUUID(payin.getOut_trade_no());
//		mpay.setPosNo(payin.getPosno());
//		mpay.setFlowNo(payin.getFlowno());
//		mpay.setEmpCode(payin.getEmp());
//		mpay.setCuAmt(payin.getOri_total_fee());
//		/*mpay.setSubject(payin.getSubject());
//		mpay.setBody(payin.getBody());*/
//		mpay.setSubject("支付宝支付");
//		mpay.setBody("支付宝支付");
//		mpay.setPayType("支付宝");
//		mpay.setTranType("销售");
//		mpay.setStat(0);
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		mpay.setTranDate(format.format(new Date()));
//		LOGGER.info("预支付：当前交易记录：" + mpay.toString());
//		if(mpayService.saveMpayTranDtl(mpay) == null){
//			payout.setResult_code("F");
//			payout.setSub_code("Error");
//			payout.setSub_desc("订单保存到数据库失败，请重新发起支付流程！");
//			LOGGER.info("预支付：支付宝扫码付数据保存到数据库失败，订单返回错误");
//			return payout;
//		};
//		LOGGER.info("预支付：构建支付宝请求参数");
//		AliPreparePayRequest QrPayReq = new AliPreparePayRequest(aliaccount, payin);
//		// 发起支付宝请求
//		LOGGER.debug("预支付:" + "发起支付宝预支付请求, 支付宝版本：" + aliaccount.getVersion());
//		AliPayClient AliCl = new AliPayClient();
//		if (aliaccount.getVersion().equals("2.0")){
//			AlipayServiceEnvConstants.APP_ID = aliaccount.getAppId();
//			AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY = aliaccount.getAliPublicKey();
//			AliCl.AliQrPayV2(QrPayReq, payout);
//		}else{
//			AliCl.AliQRPay(QrPayReq, payout);
//			if(payout.getResult_code().equals("SUCCESS")){
//				payout.setResult_code("S");
//				LOGGER.info("更新交易信息息" );
//			}else{
//				/*向支付宝发起请求失败，返回错误信息给前台*/
//				payout.setResult_code("F");
//				payout.setSub_code("system Error");
//				payout.setSub_desc("支付宝1.0支付失败");
//			}
//		}
//		LOGGER.info("预支付：支付宝预支付请求完成：\n" + payout.toString());
//		return payout;
//	}
//
//	@Override
//	public PayOut ScanPay(PayIn preorder) {
//		// TODO Auto-generated method stub
//		LOGGER.info("支付：商铺"+preorder.getGround()+" 支付宝扫码支付"+preorder.getOut_trade_no()+"确认");
//		PayOut payout =new PayOut();
//		//获取当前支付宝账户信息
//		final AliAccount aliaccount ;
//		try{
//			aliaccount = aliaccountService.getAccount(preorder.getGround());
//			LOGGER.info(aliaccount.getGround());
//		    if(aliaccount==null){
//		        LOGGER.info("预支付：账号不匹配");
//			    payout.setResult_code("F");
//			    payout.setSub_code("Error");
//			    payout.setSub_desc("未找到商户对应的支付宝账户信息！");
//			    return payout;
//		    }
//		}catch(Exception e){
//			    LOGGER.info("预支付：支付宝账户查询异常，异常信息："+e.getMessage());
//			    payout.setResult_code("F");
//			 	payout.setSub_code("Error");
//				payout.setSub_desc("查找支付宝账户信息出错！");
//				return payout;
//		}
//		//对请求账单进行存储
//		LOGGER.info("支付：是否存在数据实体:" + preorder.getOut_trade_no());
//		MpayTranDtl mpay = new MpayTranDtl(preorder.getOut_trade_no());// mpayService.getMpay(preorder.getOut_trade_no());
//		LOGGER.info("支付：数据实体展示:" + mpay.toString());
//
//		mpay.setUUID(preorder.getOut_trade_no());
//		mpay.setPosNo(preorder.getPosno());
//		mpay.setFlowNo(preorder.getFlowno());
//		mpay.setEmpCode(preorder.getEmp());
//		mpay.setCuAmt(preorder.getOri_total_fee());
//		/*mpay.setSubject(preorder.getSubject());
//		mpay.setBody(preorder.getBody());*/
//		mpay.setSubject("支付宝支付");
//		mpay.setBody("支付宝支付");
//	    mpay.setPayType("支付宝");
//		mpay.setTranType("销售");
//		mpay.setStat(0);
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		mpay.setTranDate(format.format(new Date()));
//		LOGGER.info("支付：当前交易记录：" + mpay.toString());
//
//		if(mpayService.saveMpayTranDtl(mpay) == null){
//			payout.setResult_code("F");
//			payout.setSub_code("Error");
//			payout.setSub_desc("订单保存到数据库失败，请重新发起支付流程！");
//			LOGGER.info("支付：支付宝二维码付款数据保存到数据库失败，订单返回错误");
//			return payout;
//		};
//		LOGGER.info("支付：构建支付宝付款请求参数");
//		AliPayBarTradePay PayReq =new AliPayBarTradePay(aliaccount, preorder);
//
//		// 发起支付宝请求
//		LOGGER.info("支付:" + "发起支付宝请求, 版本：" + aliaccount.getVersion());
//		AliPayClient AliCl = new AliPayClient();
//
//		if (aliaccount.getVersion().equals("2.0")){
//			AlipayServiceEnvConstants.APP_ID = aliaccount.getAppId();
//			AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY = aliaccount.getAliPublicKey();
//			try {
//				AliCl.AliBarPayV2(PayReq, payout);
//			} catch (HttpException e) {
//				// TODO Auto-generated catch block
//				LOGGER.info("支付：支付宝2.0请求失败,http连接出现异常" );
//				payout.setResult_code("F");
//			    payout.setSub_code("network Error");
//			    payout.setSub_desc("支付宝2.0请求失败,http连接出现异常");
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				LOGGER.info("支付：支付宝2.0请求失败" );
//				payout.setResult_code("F");
//			    payout.setSub_code("system Error");
//			    payout.setSub_desc("支付宝2.0请求失败");
//				e.printStackTrace();
//			}
//		}else{
//			AliCl.AliBarPay(PayReq, payout);
//			// 向支付宝发起交易请求成功	更新到数据库
//			if(payout.getResult_code().equals("ORDER_SUCCESS_PAY_SUCCESS")){
//				payout.setResult_code("S");
//				LOGGER.info("更新交易信息息" );
//			}else if (payout.getResult_code().equals("ORDER_SUCCESS_PAY_INPROCESS")){
//				payout.setResult_code("W");
//				LOGGER.info("等待客户支付" );
//			}else{
//				/*向支付宝发起请求失败，返回错误信息给前台*/
//				payout.setResult_code("F");
//				payout.setSub_code("system Error");
//				payout.setSub_desc("支付宝1.0支付失败");
//			}
//		}
//		MpayTranDtl mpay1 = mpayService.getMpay(preorder.getOut_trade_no());
//		if (payout.getResult_code()=="S"){
//		    mpay1.setStat(1);
//		}else{
//			mpay1.setStat(2);
//		}
//		mpay1.setCuAmt(payout.getTotal_fee());
//		mpay1.setTradeNO(payout.getTrade_no());
//		mpay1.setResultCode(payout.getSub_code());
//		mpay1.setResultDes(payout.getSub_desc());
//		mpay1.setBuyerid(payout.getBuyer_logon_id());
//		mpay1.setPayTime(payout.getPay_time());
//        LOGGER.info("支付：交易完成后保存当前记录：" + mpay1.toString());
//        try{
//		  if(mpayService.saveMpayTranDtl(mpay1) == null){
//			  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("支付宝付款结束，订单更新到数据库失败，请检查后台数据！");
//			  LOGGER.info("支付：支付宝付款结束，订单更新到数据库失败");
//			  return payout;
//		  }
//        }catch(Exception e){
//        	  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("订单保存到数据库失败，请检查后台数据！");
//			  LOGGER.info("支付：支付宝付款结束，数据保存到数据库失败，订单返回错误"+e.getMessage());
//			  return payout;
//        }
//		LOGGER.info("支付：支付宝支付请求完成：\n" + payout.toString());
//		return payout;
//	}
//
//	@Override
//	public PayOut Query(String out_trade_no,String Ground) {
//		// TODO Auto-generated method stub
//		LOGGER.info("查询：支付宝交易查询"+out_trade_no);
//		PayOut payout =new PayOut();
//		//获取当前支付宝账户信息
//		final AliAccount aliaccount;
//		try{
//			aliaccount = aliaccountService.getAccount(Integer.parseInt(Ground));
//		    if(aliaccount==null){
//		        LOGGER.info("预支付：账号不匹配");
//			    payout.setResult_code("F");
//			    payout.setSub_code("Error");
//			    payout.setSub_desc("未找到商户对应的支付宝账户信息！");
//			    return payout;
//		    }
//		}catch(Exception e){
//			    LOGGER.info("预支付：支付宝账户查询异常，异常信息："+e.getMessage());
//			    payout.setResult_code("F");
//			 	payout.setSub_code("Error");
//				payout.setSub_desc("查找支付宝账户信息出错！");
//				return payout;
//		}
//
//		LOGGER.info("构建支付宝查询请求参数");
//		AliQueryRequest QueryReq =new AliQueryRequest(aliaccount, out_trade_no);
//		// 发起支付宝查询请求
//		LOGGER.debug("Query:" + "发起支付宝订单查询请求, 版本：" + aliaccount.getVersion());
//		AliPayClient AliCl = new AliPayClient();
//
//		if (aliaccount.getVersion().equals("2.0")){
//			AlipayServiceEnvConstants.APP_ID = aliaccount.getAppId();
//			AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY = aliaccount.getAliPublicKey();
//			AliCl.QueryV2(out_trade_no, payout);
//		}else{
//			AliCl.AliQuery(QueryReq, payout);
//			if(payout.getResult_code().equals("SUCCESS")){
//				payout.setResult_code("S");
//				if ("WAIT_BUYER_PAY".equalsIgnoreCase(payout.getOrder_state())) {
//					// 等待用户付款状态，需要轮询查询用户的付款结果
//					payout.setResult_code("W");
//				}
//			}else{
//				/*向支付宝发起请求失败，返回错误信息给前台*/
//				payout.setResult_code("F");
//				payout.setSub_code("system Error");
//				payout.setSub_desc("支付宝1.0支付失败");
//			}
//		}
//		MpayTranDtl mpay = mpayService.getMpay(out_trade_no);
//		//对请求账单进行存储  交易成功，更改stat为1
//		if (payout.getResult_code()=="S"){
//		    LOGGER.info("查询：查询接口成功返回");
//		    if (aliaccount.getVersion().equals("2.0")){
//			    if(payout.getOrder_state().equals("TRADE_SUCCESS")){        //支付成功
//				  // 查询到交易成功更新数据库
//				   mpay.setStat(1);
//				   mpay.setCuAmt(payout.getTotal_fee());
//				   mpay.setTradeNO(payout.getTrade_no());
//				   mpay.setBuyerid(payout.getBuyer_logon_id());
//				   mpay.setPayTime(payout.getPay_time());
//				   LOGGER.info("查询：支付宝V2，交易陈宫，更新交易信息"+mpay.toString());
//			    }else if(payout.getOrder_state().equals("WAIT_BUYER_PAY")){  //还在等待支付
//				   mpay.setStat(0);
//				   mpay.setCuAmt(payout.getTotal_fee());
//				   mpay.setTradeNO(payout.getTrade_no());
//				   LOGGER.info("查询：支付宝V2，交易中，更新交易信息"+mpay.toString());
//			    }else{
//				   mpay.setStat(2);
//				   mpay.setResultCode(payout.getSub_code());
//				   mpay.setResultDes(payout.getSub_desc());
//				   LOGGER.debug("查询：支付宝V2，交易失败，更新交易信息"+mpay.toString());
//			    }
//		    }else{
//			   if(payout.getResult_code().equals("S") && payout.getOrder_state().equals("TRADE_SUCCESS")){
//				  // 查询到交易成功更新数据
//				  mpay.setStat(1);
//				  mpay.setCuAmt(payout.getTotal_fee());
//				  mpay.setTradeNO(payout.getTrade_no());
//				  mpay.setBuyerid(payout.getBuyer_logon_id());
//			      mpay.setPayTime(payout.getPay_time());
//				  LOGGER.info("查询：支付宝V1，交易成功，更新交易信息"+mpay.toString());
//			   }else{
//				  payout.setResult_code("F");
//				  mpay.setStat(2);
//				  mpay.setResultCode(payout.getOrder_state());
//				  mpay.setResultDes("订单未完成支付");
//			   }
//			}
//
//		}else if(payout.getResult_code()=="F"){             // 交易失败
//			mpay.setStat(2);    // 交易状态，0交易请求中， 1交易付款成功, 交易失败
//	        mpay.setResultCode("Error");
//	        mpay.setResultDes(AliCl.sErrMsg);
//		}
//		try{
//	      if(mpayService.saveMpayTranDtl(mpay) == null){		//保存到数据库
//			  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("订单查询失败，请重新发起查询请求！");
//			  LOGGER.info("查询：订单查询失败，请重新发起查询请求！");
//			  return payout;
//		   };
//		}catch(Exception e){
//			  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("订单保存到数据库失败，请检查后台数据！");
//			  LOGGER.error("查询：支付宝查询订单结束，数据保存到数据库失败，订单返回错误"+e.getMessage());
//			  return payout;
//		}
//
//		LOGGER.info("查询：支付宝订单查询请求完成：\n" + payout.toString());
//		return payout;
//	}
//
//	@Override
//	public PayOut Refund(PayIn preorder) {
//		// TODO Auto-generated method stub
//		LOGGER.info("退款：商铺"+preorder.getGround()+"支付宝退款订单"+preorder.getOut_trade_no()+"确认");
//		PayOut payout =new PayOut();
//		//获取当前支付宝账户信息
//		final AliAccount aliaccount;
//		try{
//			aliaccount = aliaccountService.getAccount(preorder.getGround());
//		    if(aliaccount==null){
//		        LOGGER.info("预支付：账号不匹配");
//			    payout.setResult_code("F");
//			    payout.setSub_code("Error");
//			    payout.setSub_desc("未找到商户对应的支付宝账户信息！");
//			    return payout;
//		    }
//		}catch(Exception e){
//			    LOGGER.info("预支付：支付宝账户查询异常，异常信息："+e.getMessage());
//			    payout.setResult_code("F");
//			 	payout.setSub_code("Error");
//				payout.setSub_desc("查找支付宝账户信息出错！");
//				return payout;
//		}
//		//对请求账单进行存储
//		LOGGER.info("退款：是否存在数据实体:" + preorder.getOut_trade_no());
//		MpayTranDtl mpay = new MpayTranDtl(preorder.getOut_trade_no());
//		mpay.setUUID(preorder.getOut_trade_no());	   //现单据流水号
//		mpay.setPosNo(preorder.getPosno());
//		mpay.setFlowNo(preorder.getFlowno());
//		mpay.setEmpCode(preorder.getEmp());
//		mpay.setCuAmt(preorder.getOri_total_fee());
//		/*mpay.setSubject(preorder.getSubject());
//		mpay.setBody(preorder.getBody());*/
//		mpay.setSubject("支付宝支付");
//		mpay.setBody("支付宝支付");
//		mpay.setOriTradeNO(preorder.getOri_out_no());   //原支付宝流水号
//		mpay.setPayType("支付宝");
//		mpay.setTranType("退货");
//		mpay.setStat(0);   //交易状态
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		mpay.setTranDate(format.format(new Date()));
//		LOGGER.info("退款：当前交易记录：" + mpay.toString());
//		if(mpayService.saveMpayTranDtl(mpay) == null){
//			payout.setResult_code("F");
//			payout.setSub_code("Error");
//			payout.setSub_desc("退货订单保存到数据库失败，请重新发起退货流程！");
//			LOGGER.info("支付宝退货数据保存到数据库失败，订单返回错误");
//			return payout;
//		};
//		LOGGER.info("退款：构建支付宝退款请求参数");
//		AliRefundRequest RefundReq =new AliRefundRequest(aliaccount, preorder);
//		// 发起支付宝请求
//		LOGGER.info("退款:" + "发起支付宝退款请求, 版本：" + aliaccount.getVersion());
//		AliPayClient AliCl = new AliPayClient();
//
//		if (aliaccount.getVersion().equals("2.0")){
//			AlipayServiceEnvConstants.APP_ID = aliaccount.getAppId();
//			AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY = aliaccount.getAliPublicKey();
//		    AliCl.refundOrder_V2(RefundReq, payout);
//		}else{
//			AliCl.AliRefund(RefundReq, payout);
//			if(payout.getResult_code().equals("SUCCESS")){
//				payout.setResult_code("S");
//				LOGGER.info("退款成功" );
//			}else{
//				/*向支付宝发起请求失败，返回错误信息给前台*/
//				payout.setResult_code("F");
//				payout.setSub_code("system Error");
//				payout.setSub_desc("支付宝1.0退款失败");
//			}
//		}
//
//		MpayTranDtl mpay1 = mpayService.getMpay(preorder.getOut_trade_no());
//		if (payout.getResult_code()=="S"){
//		    mpay1.setStat(1);
//		}else{
//			mpay1.setStat(2);
//		}
//		mpay1.setCuAmt(payout.getTotal_fee());
//		mpay1.setTradeNO(payout.getTrade_no());          //现支付宝流水号
//		mpay1.setResultCode(payout.getSub_code());
//		mpay1.setResultDes(payout.getSub_desc());
//		mpay1.setBuyerid(payout.getBuyer_logon_id());
//		mpay1.setPayTime(payout.getPay_time());
//		mpay1.setOriUUID(payout.getOut_trade_no());      //原订单流水号
//        LOGGER.info("退款：交易完成后开始保存当前记录：" + mpay1.toString());
//        try{
//		  if(mpayService.saveMpayTranDtl(mpay1) == null){
//		  	  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("支付宝退款结束，订单更新到数据库失败，请检查后台数据！");
//			  LOGGER.info("退款：支付宝退款结束，订单更新到数据库失败");
//			  return payout;
//		  };
//        }catch(Exception e){
//        	  payout.setResult_code("F");
//		      payout.setSub_code("Error");
//			  payout.setSub_desc("订单保存到数据库失败，请检查后台数据！");
//			  LOGGER.error("退款：支付宝退款结束，数据保存到数据库失败，订单返回错误"+e.getMessage());
//			  return payout;
//        }
//
//		LOGGER.info("退款：支付宝退货请求完成：\n" + payout.toString());
//		return payout;
//	}
//
//	@Override
//	public PayOut Cancel(String out_trade_no,String Ground) {
//		// TODO Auto-generated method stub
//		LOGGER.info("撤销：支付宝交易撤销，单号："+out_trade_no);
//		PayOut payout =new PayOut();
//		//获取当前支付宝账户信息
//		final AliAccount aliaccount;
//		try{
//			aliaccount = aliaccountService.getAccount(Integer.parseInt(Ground));
//		    if(aliaccount==null){
//		        LOGGER.info("预支付：账号不匹配");
//			    payout.setResult_code("F");
//			    payout.setSub_code("Error");
//			    payout.setSub_desc("未找到商户对应的支付宝账户信息！");
//			    return payout;
//		    }
//		}catch(Exception e){
//			    LOGGER.error("预支付：支付宝账户查询异常，异常信息："+e.getMessage());
//			    payout.setResult_code("F");
//			 	payout.setSub_code("Error");
//				payout.setSub_desc("查找支付宝账户信息出错！");
//				return payout;
//		}
//		LOGGER.info("撤销：构建支付宝查询请求参数");
//		AliCancelRequest CancelReq =new AliCancelRequest(aliaccount, out_trade_no);
//		// 发起支付宝查询请求
//		LOGGER.info("撤销：" + "发起支付宝订单撤销请求, 版本：" + aliaccount.getVersion());
//		AliPayClient AliCl = new AliPayClient();
//		if (aliaccount.getVersion().equals("2.0")){
//			AlipayServiceEnvConstants.ALIPAY_PUBLIC_KEY = aliaccount.getAliPublicKey();
//			AlipayServiceEnvConstants.APP_ID = aliaccount.getAppId();
//			AliCl.cancelOrder_V2(out_trade_no, payout);
//		}else{
//			AliCl.AliCancel(CancelReq, payout);
//			if(payout.getResult_code().equals("SUCCESS")){
//				payout.setResult_code("S");
//				LOGGER.info("撤销成功" );
//			}else{
//				/*向支付宝发起请求失败，返回错误信息给前台*/
//				payout.setResult_code("F");
//				payout.setSub_code("system Error");
//				payout.setSub_desc("支付宝1.0退款失败");
//			}
//		}
//		LOGGER.info("撤销：是否存在数据实体:" + out_trade_no);
//		MpayTranDtl mpay = new MpayTranDtl(out_trade_no);
//		mpay.setUUID(out_trade_no);
//		mpay.setTranType("撤销");
//		//对请求账单进行存储  交易成功，更改stat为1
//		if (payout.getResult_code()=="S"){
//			//查找数据库中是否有 记录
//			mpay.setStat(1);    // 交易状态，0交易请求中， 1交易付款成功, 交易失败
//		}else if(payout.getResult_code()=="F"){
//		// 交易失败
//			mpay.setUUID(out_trade_no);
//			mpay.setResultCode(payout.getSub_code());
//			mpay.setResultDes(payout.getSub_desc());
//			mpay.setStat(2);    // 交易状态，0交易请求中， 1交易付款成功, 2交易失败
//		}
//
//		try{
//		  if(mpayService.saveMpayTranDtl(mpay) == null){
//			  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("订单撤销成功，保存到数据库失败！");
//			  LOGGER.info("撤销：订单撤销成功，保存到数据库失败！！");
//			  return payout;
//		  };
//		}catch(Exception e){
//			  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("订单保存到数据库失败，请检查后台数据！");
//			  LOGGER.error("撤销：支付宝撤销结束，数据保存到数据库失败，订单返回错误"+e.getMessage());
//			  return payout;
//		}
//	/*	MpayTranDtl mpay1 = mpayService.getMpay(out_trade_no);
//		mpay1.setStat(1);
//		mpay1.setCuAmt(payout.getTotal_fee());
//		mpay1.setTradeNO(payout.getTrade_no());          //现支付宝流水号
//		mpay1.setResultCode(payout.getSub_code());
//		mpay1.setResultDes(payout.getSub_desc());
//		mpay1.setBuyerid(payout.getBuyer_logon_id());
//		mpay1.setPayTime(payout.getPay_time());
//		mpay1.setOriUUID(payout.getOut_trade_no());      //原订单流水号
//        LOGGER.info("交易完成后开始保存当前记录：" + mpay1.toString());
//		if(mpayService.saveMpayTranDtl(mpay1) == null){
//			payout.setResult_code("Fail");
//			payout.setSub_code("DB Error");
//			payout.setSub_desc("支付宝退款结束，订单更新到数据库失败，请检查后台数据！");
//			LOGGER.info("支付宝退款结束，订单更新到数据库失败");
//			return payout;
//		};*/
//		LOGGER.info("撤销：支付宝订单撤销请求完成：\n" + payout.toString());
//		return payout;
//	}
//
//}
