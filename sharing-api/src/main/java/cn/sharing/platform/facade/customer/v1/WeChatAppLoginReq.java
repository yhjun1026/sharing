package cn.sharing.platform.facade.customer.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by MSI on 2018/6/11.
 */
@Data
@ApiModel(value = "微信小程序登陆对象")
public class WeChatAppLoginReq {
    @ApiModelProperty(value = "小程序获取到的用户code")
    private String code;
    @ApiModelProperty(value = "包括敏感数据在内的完整用户信息的加密数据")
    private String encryptedData;
    @ApiModelProperty(value = "加密算法的初始向量 ")
    private String iv;
}
