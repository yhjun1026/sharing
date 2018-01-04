package cn.sharing.platform.common;

import lombok.Data;

/**
 * Created by MSI on 2018/1/4.
 */
public enum  ReturnCodeEnum {
    BAD_REQUEST(400, "错误的请求"),
    Fail(500, "服务处理失败");
    private String desc;
    private int code;

    

    ReturnCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public int value(){
        return this.code;
    }
    @Override
    public String toString() {
        return code + "," + desc;
    }
}
