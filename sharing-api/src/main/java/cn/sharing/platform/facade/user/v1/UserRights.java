package cn.sharing.platform.facade.user.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by zenglin on 2018/5/15.
 */
@Data
public class UserRights {
  @ApiModelProperty(notes = "有权限菜单列表")
  private List<MenuRights> menuRightses;
  @ApiModelProperty(notes = "有权限按钮列表")
  private List<String> buttonCodes;
}
