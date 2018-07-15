package cn.sharing.platform.facade.user.v1;

import cn.sharing.platform.common.UCN;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户 user
 *
 * Created by guotao on 2018.01.07.
 */
@Data
public class UserResponse extends UCN {
  /** 登录成功后的token */
  @ApiModelProperty(notes = "用户登录组织")
  private UCN Store;
  /** 登录成功后的token */
  @ApiModelProperty(notes = "用户登录成功后的token")
  private String token;
  @ApiModelProperty(notes = "用户权限列表")
  private UserRights rights;

}
