package cn.sharing.platform.facade.pay.v1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class PayIn implements Serializable{
    private static final long serialVersionUID = 1L;

    private int ground;
    private String posno;
    private String flowno;
    private String out_trade_no;
    private String ori_out_no;
    private String auth_code;
    private double ori_total_fee;
    private String subject;
    private double total_fee;
    private String body;
    private String emp;
    private String extend_params;
    
    public PayIn(){
        super();
    }

    public PayIn(final String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public PayIn(final String posno, final String flowno) {
        super();
        this.posno = posno;
        this.flowno = flowno;
    }

    @XmlAttribute(name = "ground")
	public int getGround() {
		return ground;
	}
	public void setGround(int ground) {
		this.ground = ground;
	}

    @XmlAttribute(name = "posno")
	public String getPosno() {
		return posno;
	}

	public void setPosno(String posno) {
		this.posno = posno;
	}

    @XmlAttribute(name = "flowno")
	public String getFlowno() {
		return flowno;
	}

	public void setFlowno(String flowno) {
		this.flowno = flowno;
	}

    @XmlAttribute(name = "out_trade_no")
	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

    @XmlAttribute(name = "subject")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

    @XmlAttribute(name = "total_fee")
	public double getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}

    @XmlAttribute(name = "body")
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

    @XmlAttribute(name = "emp")
	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}
	
	@XmlAttribute(name = "ori_out_no")
	public String getOri_out_no() {
		return ori_out_no;
	}

	public void setOri_out_no(String ori_out_no) {
		this.ori_out_no = ori_out_no;
	}

	@XmlAttribute(name = "ori_total_fee")
	public double getOri_total_fee() {
		return ori_total_fee;
	}

	public void setOri_total_fee(double ori_total_fee) {
		this.ori_total_fee = ori_total_fee;
	}

	@Override
	public String toString() {
		return "PayIn [ground=" + ground + ", posno=" + posno + ", flowno="
				+ flowno + ", out_trade_no=" + out_trade_no + ", ori_out_no="
				+ ori_out_no + ", auth_code=" + auth_code + ", ori_total_fee="
				+ ori_total_fee + ", subject=" + subject + ", total_fee="
				+ total_fee + ", body=" + body + ", emp=" + emp
				+ ", extend_params=" + extend_params + "]";
	}

	public String getExtend_params() {
		return extend_params;
	}

	public void setExtend_params(String extend_params) {
		this.extend_params = extend_params;
	}

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
}
