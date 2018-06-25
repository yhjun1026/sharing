package cn.sharing.platform.pay.wxpay;

/**
 * Created by MSI on 2018/6/10.
 */
public enum  WXPayTypeEnum {
    NATIVE(1,"NATIVE"),JSAPI(2,"JSAPI"),APP(3,"APP");
    private int code;
    private String type;

    WXPayTypeEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    @Override
    public String toString() {
        return code + "," + type;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
