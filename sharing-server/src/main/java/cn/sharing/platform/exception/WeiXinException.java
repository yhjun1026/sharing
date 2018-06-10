package cn.sharing.platform.exception;

import cn.sharing.platform.common.ReturnCodeEnum;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by MSI on 2018/6/10.
 */
public class WeiXinException extends RuntimeException {
    public WeiXinException(int code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }


    public WeiXinException(ReturnCodeEnum returnCodeEnum, Object... objects) {
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
