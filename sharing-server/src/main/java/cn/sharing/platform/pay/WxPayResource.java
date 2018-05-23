package cn.sharing.platform.pay;

import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.pay.v1.PayIn;
import cn.sharing.platform.facade.pay.v1.PayOut;
import cn.sharing.platform.facade.pay.v1.PayService;

import cn.sharing.platform.pay.wxpay.WxAccount;
import cn.sharing.platform.pay.wxpay.WxPayClient;
import cn.sharing.platform.pay.wxpay.WxRefundRequest;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Root resource (exposed at "wx" path)
 */
@RequestMapping("/api/v1/pay/wx")
@RestController
public class WxPayResource implements PayService{
	private static final Logger LOGGER = Logger.getLogger(WxPayResource.class);
//	@Autowired
//    private WxAccountService wxaccountService;
//	@Autowired
//	private MpayTranDtlService mpayService;
	
    private static final HashMap<String, PayIn> memoryBase;
    static {
        memoryBase = com.google.common.collect.Maps.newHashMap();
    }
    
	/*@POST
	public PayIn Submit(final PayIn preorder){
		preorder.setOut_trade_no("123445677");
		WxPayResource.memoryBase.put(preorder.getOut_trade_no(), preorder);
		LOGGER.info(preorder.toString());
		return preorder;
		
	}*/

	@Override
	public PayOut PreparePay(@RequestBody PayIn preorder){

		return null;
//		PayOut payout = new PayOut();
//
//
//		//对请求数据进行存储
//		LOGGER.info("预支付：是否存在数据实体:" + preorder.getOut_trade_no());
//		MpayTranDtl mpay = new MpayTranDtl(preorder.getOut_trade_no()); //mpayService.getMpay(payin.getOut_trade_no());
//		LOGGER.info("预支付：数据实体展示:" + mpay.toString());
//		mpay.setUUID(preorder.getOut_trade_no());
//		mpay.setPosNo(preorder.getPosno());
//		mpay.setFlowNo(preorder.getFlowno());
//		mpay.setEmpCode(preorder.getEmp());
//		mpay.setCuAmt(preorder.getOri_total_fee());
//		/*try {
//			mpay.setSubject(URLEncoder.encode(preorder.getSubject(),"utf-8"));
//			mpay.setBody(URLEncoder.encode(preorder.getBody(),"utf-8"));
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}*/
//		mpay.setSubject("微信支付");
//		mpay.setBody("微信支付");
//		mpay.setPayType("微信");
//		mpay.setTranType("销售");
//		mpay.setStat(0);
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		mpay.setTranDate(format.format(new Date()));
//		LOGGER.info("预支付：当前交易记录：" + mpay.toString()+mpay.getBody());
//		try{
//		   if(mpayService.saveMpayTranDtl(mpay) == null){
//			  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("订单保存到数据库失败，请重新发起支付流程！");
//			  LOGGER.info("预支付：微信二维码付款数据，保存到数据库失败，订单返回错误");
//			  return payout;
//		   }
//		}catch(Exception e){
//			  payout.setResult_code("F");
//			  payout.setSub_code("Error");
//			  payout.setSub_desc("订单保存到数据库失败，请检查后台数据！");
//			  LOGGER.info("预支付：微信二维码撤销结束，数据保存到数据库失败，订单返回错误"+e.getMessage());
//		      return payout;
//		}
//		LOGGER.info("预支付：构建微信请求参数");
//	/*	WxPreparePayRequest QrPayReq = new WxPreparePayRequest(wxaccount, preorder);*/
//		WxUnifieldRequest QrPayReq = new WxUnifieldRequest(wxaccount,preorder);
//		WxPayClient WXCl = new WxPayClient();
//		WXCl.WxPrePay(QrPayReq,payout);
//		LOGGER.info("预支付：微信预支付请求完成：\n" + payout.toString());
//		return payout;
	}
	
	@Override
	public ResponseResult<PayOut> ScanPay(@RequestBody PayIn preorder) {
		return null;
//		LOGGER.info("支付：商铺" + preorder.getGround() + " 微信二维码支付 " + preorder.getOut_trade_no() + " 订单请求");
//		PayOut payout=new PayOut();
//		final WxAccount wxaccount = wxaccountService.getAccount(preorder.getGround());
//		try{
//		  if(wxaccount==null){
//		      LOGGER.info("支付：账号不匹配");
//			  payout.setResult_code("F");
//		      payout.setSub_code("Error");
//			  payout.setSub_desc("未找到商户对应的微信账户信息！");
//			  return payout;
//		  }
//		}catch(Exception e){
//			  LOGGER.info("支付：微信账户查询异常，异常信息："+e.getMessage());
//			  payout.setResult_code("F");
//		  	  payout.setSub_code("Error");
//			  payout.setSub_desc("查找微信账户信息出错！");
//			  return payout;
//		}
//		LOGGER.info("支付：是否存在数据实体:" + preorder.getOut_trade_no());
//		MpayTranDtl mpay = new MpayTranDtl(preorder.getOut_trade_no()); //mpayService.getMpay(payin.getOut_trade_no());
//		LOGGER.info("支付：数据实体展示:" + mpay.toString());
//		mpay.setUUID(preorder.getOut_trade_no());
//		mpay.setPosNo(preorder.getPosno());
//		mpay.setFlowNo(preorder.getFlowno());
//		mpay.setEmpCode(preorder.getEmp());
//		mpay.setCuAmt(preorder.getOri_total_fee());
//		mpay.setSubject("微信支付");
//		mpay.setBody("微信支付");
//		/*try {
//			mpay.setSubject(URLEncoder.encode(preorder.getSubject(),"utf-8"));
//			mpay.setBody(URLEncoder.encode(preorder.getBody(),"utf-8"));
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}*/
//		mpay.setPayType("微信");
//		mpay.setTranType("销售");
//		mpay.setStat(0);
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		mpay.setTranDate(format.format(new Date()));
//		LOGGER.info("支付：当前交易记录：" + mpay.toString());
//		if(mpayService.saveMpayTranDtl(mpay) == null){
//			payout.setResult_code("F");
//			payout.setSub_code("Error");
//			payout.setSub_desc("订单保存到数据库失败，请重新发起支付流程！");
//			LOGGER.info("支付：微信二维码付款数据保存到数据库失败，订单返回错误");
//			return payout;
//		};
//		LOGGER.info("支付：构建微信二维码请求参数");
//		WxScanPayRequest wxpayrequest = new WxScanPayRequest(wxaccount, preorder);
//		WxPayClient WXCl = new WxPayClient();
//		WXCl.WxScanPay(wxpayrequest,payout);
//
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
// 		  if(mpayService.saveMpayTranDtl(mpay1) == null){
// 			  payout.setResult_code("F");
// 			  payout.setSub_code("Error");
// 			  payout.setSub_desc("订单保存到数据库失败，请重新发起支付流程！");
// 			  LOGGER.info("支付：微信扫码付款数据，保存到数据库失败，订单返回错误");
// 			  return payout;
// 		   }
// 		}catch(Exception e){
// 			  payout.setResult_code("F");
// 			  payout.setSub_code("Error");
// 			  payout.setSub_desc("订单保存到数据库失败，请检查后台数据！");
// 			  LOGGER.info("支付：微信扫码撤销结束，数据保存到数据库失败，订单返回错误"+e.getMessage());
// 			  return payout;
// 		}
//
//		LOGGER.info("支付：微信支付完成，\n"+payout.toString());
//		return payout;
	}
	
	@Override
	public PayOut Query(@PathVariable(value = "payId") @ApiParam(name = "payId", value = "支付代码") String
								payId) {
//
//		LOGGER.info("查询：商铺" +Ground + "微信扫码支付 " + out_trade_no + "订单请求");
//		PayOut payout = new PayOut();
//		final WxAccount wxaccount;
//		try{
//		  wxaccount = wxaccountService.getAccount(Integer.parseInt(Ground));
//		  if(wxaccount==null){
//			  payout.setResult_code("F");
//		   	  payout.setSub_code("Error");
//			  payout.setSub_desc("未找到商户对应的微信账户信息！");
//			  return payout;
//	    	}
//		}catch(Exception e){
//		  LOGGER.info("查询：微信账户查询异常，异常信息："+e.getMessage());
//		  payout.setResult_code("F");
//	   	  payout.setSub_code("Error");
//		  payout.setSub_desc("查找微信账户信息出错！");
//		  return payout;
//		}
//		  //对请求数据进行存储
//		WxQueryRequest QueryReq =new WxQueryRequest(wxaccount, out_trade_no);
//		LOGGER.debug("查询:" + "发起微信订单查询请求");
//		WxPayClient WXCl = new WxPayClient();
//		WXCl.WxQuery(QueryReq,payout);
//		LOGGER.info("查询：是否存在数据实体:" +out_trade_no);
//		MpayTranDtl mpay = mpayService.getMpay(out_trade_no);
//		LOGGER.info("查询：数据实体展示:" + mpay.toString());
//		if (payout.getResult_code()=="S"){
//			//查找数据库中是否有记录
//			mpay.setUUID(out_trade_no);
//			mpay.setStat(1);    // 交易状态，0交易请求中， 1交易付款成功, 交易失败
//			mpay.setCuAmt(payout.getTotal_fee());
//	        mpay.setTradeNO(payout.getTrade_no());
//	        mpay.setPayTime(payout.getPay_time());
//		}else if(payout.getResult_code()=="F"){
//		// 交易失败
//			mpay.setUUID(out_trade_no);
//			mpay.setResultCode(payout.getSub_code());
//			mpay.setResultDes(payout.getSub_desc());
//			mpay.setStat(2);    // 交易状态，0交易请求中， 1交易付款成功, 2交易失败
//		}
//		try{
//		    if(mpayService.saveMpayTranDtl(mpay) == null){
//				  payout.setResult_code("F");
//				  payout.setSub_code("Error");
//				  payout.setSub_desc("订单保存到数据库失败，请重新发起支付流程！");
//				  LOGGER.info("查询：微信查询付款订单，保存到数据库失败，订单返回错误");
//				  return payout;
//		    }
//		}catch(Exception e){
//				  payout.setResult_code("F");
//				  payout.setSub_code("Error");
//				  payout.setSub_desc("订单保存到数据库失败，请检查后台数据！");
//				  LOGGER.info("查询：微信查询订单结束，数据保存到数据库失败，订单返回错误"+e.getMessage());
//		}
//		LOGGER.info("查询：查询预支付订单完成");
//		return payout;
		return null;
	}
	
	@Override
	public PayOut Refund(@RequestBody  PayIn preorder) {
		PayOut payout = new PayOut();
		WxAccount wxaccount = new WxAccount();
		wxaccount.setAppId("");
		wxaccount.setAppkey("");
		wxaccount.setCertFileName("");
		wxaccount.setGround(0);
		wxaccount.setMchId("");
		wxaccount.setSubMchId("");

		

		//请求数据信息
		WxRefundRequest refundreq= new WxRefundRequest(wxaccount, preorder);
		LOGGER.debug("退款:" + "发起微信订单退货请求");
		WxPayClient WXCl = new WxPayClient();
	    WXCl.WxRefund(refundreq, payout);

		return payout;
		
	}
	@Override
	public PayOut Cancel(@RequestParam("out_trade_no") String out_trade_no) {

		LOGGER.info("撤销：微信扫码支付请求");
		return null;
	}
}