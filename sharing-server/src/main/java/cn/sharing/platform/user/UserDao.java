package cn.sharing.platform.user;

import cn.sharing.dao.entity.SharingMenu;
import cn.sharing.dao.entity.User;
import cn.sharing.dao.entity.UserExample;
import cn.sharing.dao.mapper.SharingMenuMapperExt;
import cn.sharing.dao.mapper.UserMapper;
import cn.sharing.platform.utils.JsonHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户操作实现
 * Created by guotao on 2018.01.17.
 */
@Component
@Slf4j
public class UserDao {

  @Autowired
  UserMapper userMapper;

  @Autowired
  SharingMenuMapperExt menuMapperExt;

  /**
   * 根据代码判断用户是否存在
   *
   * @param code 用户代码
   * @return 存在返回True 否则返回false
   */
  public Boolean isExistUserByCode(String code){
    UserExample example = new UserExample();
    UserExample.Criteria criteria= example.createCriteria();
    criteria.andCodeEqualTo(code);
    long count = userMapper.countByExample(example);
    return count > 0;
  }
  /**
   * 根据UUID判断用户是否存在
   *
   * @param uuid 用户代码
   * @return 存在返回True 否则返回false
   */
  public Boolean ExistUserByUuid(String uuid){
    UserExample example = new UserExample();
    UserExample.Criteria criteria= example.createCriteria();
    criteria.andUuidEqualTo(uuid);
    long count = userMapper.countByExample(example);
    return count > 0;
  }
  /**
   * 新增用户数据
   * @param user  用户
   */

  public void insertUser(User user){

    userMapper.insert(user);

  }

  public void updateUser(User user){

    userMapper.updateByPrimaryKey(user);

  }

  /**
   * 查询获取用户信息
   * @param code 用户代码
   * @param password  用户密码
   * @return  用户信息
   */
  public User getUserByCodeAndPassword(String code, String password){
    UserExample example = new UserExample();
    UserExample.Criteria criteria= example.createCriteria();
    criteria.andCodeEqualTo(code);
    criteria.andPasswordEqualTo(password);
    List<User> users = userMapper.selectByExample(example);
    return (users == null || users.isEmpty()) ? null : users.get(0);
  }

  public UserRights getUserRights(String userType) {

    UserRights userRights = new UserRights();
    List<SharingMenu> menus = menuMapperExt.selectMenuByUserType(userType);
    List<MenuRights> rightses = buildMenuTree(menus);
    userRights.setMenuRightses(rightses);
    userRights.setButtonCodes(menuMapperExt.selectOptionByUserType(userType));
    return userRights;
  }

  private List<MenuRights> buildMenuTree(List<SharingMenu> menus) {
    List<MenuRights> menuRightses = new ArrayList<>();
    for (SharingMenu item : menus) {
      if (item.getParentId().intValue() == 0) {
        MenuRights menuRights = new MenuRights();
        menuRights.setId(item.getId());
        menuRights.setCode(item.getCode());
        menuRights.setName(item.getName());
        menuRights.setRouter(item.getRouter());
        menuRights.setIcon(item.getIcon());
        buildOneNode(menuRights, menus);
        menuRightses.add(menuRights);
      }
    }
    return menuRightses;
  }

  private void buildOneNode(MenuRights menuRights, List<SharingMenu> menus){
    List<MenuRights> children = new ArrayList<>();
    menuRights.setChildren(children);
    for (SharingMenu item : menus) {
      if (menuRights.getId().intValue() == item.getParentId().intValue()) {
        MenuRights rights = new MenuRights();
        rights.setId(item.getId());
        rights.setCode(item.getCode());
        rights.setName(item.getName());
        rights.setRouter(item.getRouter());
        rights.setIcon(item.getIcon());
        children.add(rights);
        buildOneNode(rights, menus);
      }
    }
  }
}
