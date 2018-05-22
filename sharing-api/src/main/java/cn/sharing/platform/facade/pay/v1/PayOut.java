package cn.sharing.platform.facade.pay.v1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class PayOut implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String result_code;     /* Success  Fail  Wait*/
	private String result_msg;      /* Fail  时有内容*/
	private String out_trade_no;    /* 商户订单号  */
	private String trade_no;        /* 支付宝微信流水号  */
 	private double total_fee;       /* 订单总额   */
	private String qrurl;           /* 返回的供前台扫描的二维码 */
	private String order_state;     /* 订单状态 */
	private String pay_time;        /* 支付时间 */
	private String buyer_logon_id;  /* 买家账号*/
	private String buyer_user_id;   /* */
	private String sub_code;        /* 错误编码 */
	private String sub_desc;        /* 错误详细信息 */
	private String store_name;      /* 商户名称*/
	private String fund_change;     /* */
	private double send_back_fee;   /* 返回金额*/
	
    public PayOut(){
        super();
    }

    public PayOut(final String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

 
    @XmlAttribute(name = "result_code")
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	
    @XmlAttribute(name = "result_msg")
	public String getResult_msg() {
		return result_msg;
	}
	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}
	
	@XmlAttribute(name = "out_trade_no")
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	
	@XmlAttribute(name = "trade_no")
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	
	@XmlAttribute(name = "total_fee")
	public double getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}
	
	@XmlAttribute(name = "qrurl")
	public String getQrurl() {
		return qrurl;
	}
	public void setQrurl(String qrurl) {
		this.qrurl = qrurl;
	}
	
	@XmlAttribute(name = "order_state")
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	
	@XmlAttribute(name = "pay_time")
	public String getPay_time() {
		return pay_time;
	}
	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	
	@XmlAttribute(name = "buyer_logon_id")
	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}
	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}
	public String getBuyer_user_id() {
		return buyer_user_id;
	}

	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}

	
	@XmlAttribute(name = "sub_code")
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	
	@XmlAttribute(name = "sub_desc")
	public String getSub_desc() {
		return sub_desc;
	}
	public void setSub_desc(String sub_desc) {
		this.sub_desc = sub_desc;
	}
	
	@XmlAttribute(name = "store_name")
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	@XmlAttribute(name = "fund_change")
	public String getFund_change() {
		return fund_change;
	}

	public void setFund_change(String fund_change) {
		this.fund_change = fund_change;
	}

	@XmlAttribute(name = "send_back_fee")
	public double getSend_back_fee() {
		return send_back_fee;
	}

	public void setSend_back_fee(double send_back_fee) {
		this.send_back_fee = send_back_fee;
	}
	
	@Override
	public String toString() {
		return "PayOut [result_code=" + result_code + ", result_msg="
				+ result_msg + ", out_trade_no=" + out_trade_no + ", trade_no="
				+ trade_no + ", total_fee=" + total_fee + ", qrurl=" + qrurl
				+ ", order_state=" + order_state + ", pay_time=" + pay_time
				+ ", buyer_logon_id=" + buyer_logon_id + ", sub_code="
				+ sub_code + ", sub_desc=" + sub_desc + ", store_name="
				+ store_name + ", fund_change=" + fund_change
				+ ", send_back_fee=" + send_back_fee + "]";
	}


}
