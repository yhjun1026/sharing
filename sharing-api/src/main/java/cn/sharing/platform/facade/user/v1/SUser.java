package cn.sharing.platform.facade.user.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户更新内容
 * Created by guotao on 2018.01.18.
 *
 */
@Data
@ApiModel(description = "系统用户")
public class SUser {
  @ApiModelProperty(value = "用户uuid（修改时必填）", required = false)
  private String uuid;
  @ApiModelProperty(value = "用户代码", required = true)
  private String code;
  @ApiModelProperty(value = "用户名称", required = true)
  private String name;
  @ApiModelProperty(value = "用户类型", required = true)
  private String type;
  @ApiModelProperty(value = "用户组", required = false)
  private String groupUuid;
  @ApiModelProperty(value = "密码", required = true)
  private String password;
  @ApiModelProperty(value = "联系方式", required = true)
  private String mobile;
  @ApiModelProperty(value = "组织id", required = false)
  private String storeuuid;
  @ApiModelProperty(value = "备注", required = false)
  private String memo;
  @ApiModelProperty(value = "用户状态（0 启用，1 停用）", required = true)
  private Byte stat;
}
