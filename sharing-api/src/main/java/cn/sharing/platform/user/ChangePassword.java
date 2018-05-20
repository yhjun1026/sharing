package cn.sharing.platform.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by zenglin on 2018/5/20.
 */
@Data
@ApiModel(description = "系统用户")
public class ChangePassword {
  @ApiModelProperty(value = "用户代码", required = true)
  private String userCode;
  @ApiModelProperty(value = "原密码", required = true)
  private String oldPassword;
  @ApiModelProperty(value = "新密码", required = true)
  private String newPassword;
}
