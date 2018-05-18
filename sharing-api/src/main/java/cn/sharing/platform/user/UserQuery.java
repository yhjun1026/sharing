package cn.sharing.platform.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by zenglin on 2018/5/18.
 */
@Data
public class UserQuery {
  @ApiModelProperty(value = "项目Id")
  private String storeId;
  @ApiModelProperty(value = "用户代码")
  private String userCode;
  @ApiModelProperty(value = "用户名称")
  private String userName;
  @ApiModelProperty(value = "用户类型")
  private String userType;
  @ApiModelProperty(value = "联系方式")
  private String mobile;
  @ApiModelProperty(value = "当前页号，默认1")
  private int page = 1;
  @ApiModelProperty(value = "每页大小，默认20，不超过200")
  private int pageSize = 20;
  @ApiModelProperty(value = "用户状态", required = false)
  private Integer stat;
}
