package cn.sharing.platform.user;

import com.hd123.rumba.commons.biz.entity.UCN;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户 user
 *
 * Created by guotao on 2018.01.07.
 */
public class UserResponse extends UCN{
  /** 登录成功后的token */
  @ApiModelProperty(notes = "用户登录组织")
  @Getter @Setter private UCN Store;
  /** 登录成功后的token */
  @ApiModelProperty(notes = "用户登录成功后的token")
  @Getter @Setter private String token;
}
