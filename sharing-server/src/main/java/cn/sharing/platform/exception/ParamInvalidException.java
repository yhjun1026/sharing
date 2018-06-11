package cn.sharing.platform.exception;

import cn.sharing.platform.common.ReturnCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ValidationException;

/**
 * 接口入参有误时抛出该异常
 * Created by Terence on 2017/3/27.
 */
@Setter
@Getter
@ToString
public class ParamInvalidException extends ValidationException {

    private static final long serialVersionUID = 5364074022601337358L;

    public ParamInvalidException(int code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }


    public ParamInvalidException(ReturnCodeEnum returnCodeEnum, Object... objects) {
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
}
