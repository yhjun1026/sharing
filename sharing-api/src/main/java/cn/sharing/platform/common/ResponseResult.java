package cn.sharing.platform.common;

import lombok.Data;


/**
 * Created by MSI on 2018/1/4.
 */
@Data
public class ResponseResult<T> {
    public static final int SUCCESS = 0;
    /** 一般调用失败 */
    public static final int FAILED = 1;
    /** token 无效 */
    public static final int TOKEN_INVALID = 2;
    /** API不匹配 */
    public static final int API_INVALID = 3;

    public static final String SUCCESSSTRING = "成功";

    private int status;
    private String message;
    private T data;

    public ResponseResult(){

    }

    public ResponseResult(T data) {
        this.data = data;
    }

    public static ResponseResult success(){
        ResponseResult r = new ResponseResult();
        r.setMessage(SUCCESSSTRING);
        r.setStatus(SUCCESS);
        return r;
    }
    public static ResponseResult failed(String message){
        ResponseResult r = new ResponseResult();
        r.setMessage(message);
        r.setStatus(FAILED);
        return r;
    }

    public static ResponseResult failed(int Code, String message){
        ResponseResult r = new ResponseResult();
        r.setMessage(message);
        r.setStatus(Code);
        return r;
    }
}
