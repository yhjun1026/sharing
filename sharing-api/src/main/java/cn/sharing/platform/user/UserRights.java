package cn.sharing.platform.user;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by zenglin on 2018/5/15.
 */
public class UserRights {
  @ApiModelProperty(notes = "有权限菜单列表")
  private List<MenuRights> menuRightses;
  @ApiModelProperty(notes = "有权限按钮列表")
  private List<String> buttonCodes;
}
