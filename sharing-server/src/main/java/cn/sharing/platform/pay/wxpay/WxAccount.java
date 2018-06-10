package cn.sharing.platform.pay.wxpay;

import javax.persistence.*;


public class WxAccount {
	private int Ground;
	private String AppId;
	private String Appkey;
	private String MchId;
	private String SubMchId;
	private String CertFileName;
	private String NotifyUrl;
	

	public int getGround() {
		return Ground;
	}
	public void setGround(int ground) {
		Ground = ground;
	}
	

	public String getAppId() {
		return AppId;
	}
	public void setAppId(String appId) {
		AppId = appId;
	}

	public String getAppkey() {
		return Appkey;
	}
	public void setAppkey(String appkey) {
		Appkey = appkey;
	}
	

	public String getMchId() {
		return MchId;
	}
	public void setMchId(String mchId) {
		MchId = mchId;
	}

	public String getSubMchId() {
		return SubMchId;
	}
	public void setSubMchId(String subMchId) {
		SubMchId = subMchId;
	}

	public String getCertFileName() {
		return CertFileName;
	}
	public void setCertFileName(String certFileName) {
		CertFileName = certFileName;
	}
	@Override
	public String toString() {
		return "WxAccount [Ground=" + Ground + ", AppId=" + AppId + ", Appkey="
				+ Appkey + ", MchId=" + MchId + ", SubMchId=" + SubMchId
				+ ", CertFileName=" + CertFileName + "]";
	}

	public String getNotifyUrl() {
		return NotifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		NotifyUrl = notifyUrl;
	}
}
