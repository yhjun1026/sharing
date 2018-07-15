package cn.sharing.platform.service.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by MSI on 2018/6/10.
 */
@Data
@ApiModel(description = "微信基础返回信息")
public class BaseResponse {
    @ApiModelProperty(value = "错误码")
    private int errcode;
    @ApiModelProperty(value = "错误信息")
    private String errmsg;
}
