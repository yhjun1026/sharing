package cn.sharing.platform.exception;


import com.qianfan123.sailing.open.api.ReturnCodeEnum;
import org.apache.commons.lang.ArrayUtils;

/**
 * Created by jiangjun on 2017/3/30.
 */
public class AuthenticationException extends RuntimeException {
    private static final long serialVersionUID = 5364074022601337358L;

    public AuthenticationException(int code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }


    public AuthenticationException(ReturnCodeEnum returnCodeEnum, Object... objects) {
        super(returnCodeEnum.getDesc());
        this.code = returnCodeEnum.value();
        if (ArrayUtils.isNotEmpty(objects)) {
            this.desc = String.format(returnCodeEnum.getDesc(), objects);
        } else {
            this.desc = returnCodeEnum.getDesc();
        }
    }

    private final int code;
    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
