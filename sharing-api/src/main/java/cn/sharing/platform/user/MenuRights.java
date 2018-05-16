package cn.sharing.platform.user;

import lombok.Data;

import java.util.List;

/**
 * Created by zenglin on 2018/5/15.
 */
@Data
public class MenuRights {
  private Integer id;
  private String code;
  private String name;
  private String router;
  private String icon;
  private List<MenuRights> children;
}
