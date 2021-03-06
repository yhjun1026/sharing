package cn.sharing.platform.facade.user.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.dao.entity.User;
import cn.sharing.platform.service.user.UserServiceImpl;
import cn.sharing.platform.utils.MD5;
import cn.sharing.platform.utils.StringUtils;
import cn.sharing.platform.utils.UUIDGenerator;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户接口实现
 *
 * Created by guotao on 2018.01.07.
 */
@RestController
@Slf4j
public class UserFacadeImpl implements UserFacade {

  @Autowired
  UserServiceImpl userDao;

  /**
   * 用户登录
   * @param userLogin  用户登录信息
   * @return
   */
  @Override
  public ResponseResult<UserResponse> login(@RequestBody UserLogin userLogin){
    ResponseResult<UserResponse> response;

    if (userLogin == null) {
      response = ResponseResult.failed("解析参数错误.");
      return response;
    }
    if (StringUtils.isEmpty(userLogin.getUserCode())) {
      response = ResponseResult.failed("用户代码不能为空.");
      return response;
    }
    if (StringUtils.isEmpty(userLogin.getPassword())) {
      response = ResponseResult.failed("用户密码不能为空.");
      return response;
    }
    User user = userDao.getUserByCode(userLogin.getUserCode());
    if (user == null) {
      response = ResponseResult.failed("用户不存在.");
      return response;
    }
    if (user.getStat().intValue() == 1) {
      response = ResponseResult.failed("用户已被停用.");
      return response;
    }
    if (!user.getPassword().equals(MD5.sign(userLogin.getPassword()))) {
      response = ResponseResult.failed("用户密码不正确.");
      return response;
    }


    try {
      UserRights userRights = userDao.getUserRights(user.getType());
      //更新登录时间
      user.setLoginTime(new Date());
      userDao.updateUser(user);
      UserResponse userResponse = new UserResponse();
      userResponse.setRights(userRights);
      userResponse.setCode(user.getCode());
      userResponse.setName(user.getName());
      userResponse.setUuid(user.getUuid());
      response = ResponseResult.success();
      response.setData(userResponse);
      return response;
    } catch (Exception e) {
      log.error("【用户登录】异常，" + e.getMessage());
      response = ResponseResult.failed("用户登录异常，" + e.getMessage());
      return response;
    }
  }

  /**
   * 用户更新
   *         用户更新信息对象
   * @return 是否更新成功
   */
  @Override
  public ResponseResult<Void> update(@RequestBody SUser user) {
    ResponseResult<Void> response;

    String message = checkParam(user, 1);  //检查参数
    if (!StringUtils.isEmpty(message)) {
      response = ResponseResult.failed(message);
      return response;
    }

    try {
      User shuser = converUserFromSuser(user);
      User user1 = userDao.getUserById(shuser.getUuid());
      shuser.setPassword(user1.getPassword());
      userDao.updateUser(shuser);

      response = ResponseResult.success();
      return response;
    } catch (Exception e) {
      log.error("【更新用户】异常，" + e.getMessage());
      response = ResponseResult.failed("更新用户异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<String> add(@RequestBody SUser user) {

    ResponseResult<String> response;

    String message = checkParam(user, 0);  //检查参数
    if (!StringUtils.isEmpty(message)) {
      response = ResponseResult.failed(message);
      return response;
    }

    user.setUuid(null);
    try {
      User shuser = converUserFromSuser(user);
      userDao.insertUser(shuser);

      response = ResponseResult.success();
      response.setData(shuser.getUuid());
      return response;
    } catch (Exception e) {
      log.error("【新增用户】异常，" + e.getMessage());
      response = ResponseResult.failed("新增用户异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<QueryResult<SUser>> query(@RequestBody UserQuery param) {

    try {
      PageInfo<User> pageInfo = userDao.query(param);
      List<SUser> users = new ArrayList<>();
      if (pageInfo.getList() != null) {
        for (User item : pageInfo.getList()) {
          users.add(converSUserFromUser(item));
        }
      }
      QueryResult<SUser> queryResult = new QueryResult<>();
      queryResult.setTotalCount(pageInfo.getTotal());
      queryResult.setPage(pageInfo.getPageNum());
      queryResult.setPageSize(pageInfo.getPageSize());
      queryResult.setItem(users);

      ResponseResult<QueryResult<SUser>> response = ResponseResult.success();
      response.setData(queryResult);
      return response;
    } catch (Exception e) {
      log.error("【查询用户】异常，" + e.getMessage());
      ResponseResult<QueryResult<SUser>> response = ResponseResult.failed("查询用户异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<SUser> get(@PathVariable String uuid) {
    ResponseResult<SUser> response;

    try {
      User user = userDao.getUserById(uuid);
      if (user == null) {
        response = ResponseResult.failed("用户不存在.");
        return response;
      }
      response = ResponseResult.success();
      response.setData(converSUserFromUser(user));
      return response;
    } catch (Exception e) {
      log.error("【获取用户详情】异常，" + e.getMessage());
      response = ResponseResult.failed("获取用户详情异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<Void> changePassword(@RequestBody ChangePassword changePassword) {

    ResponseResult<Void> response;
    if (changePassword == null) {
      response = ResponseResult.failed("解析参数错误.");
      return response;
    }
    if (StringUtils.isEmpty(changePassword.getUserCode())) {
      response = ResponseResult.failed("用户代码不能为空.");
      return response;
    }
    if (StringUtils.isEmpty(changePassword.getOldPassword())) {
      response = ResponseResult.failed("用户原密码不能为空.");
      return response;
    }
    if (StringUtils.isEmpty(changePassword.getNewPassword())) {
      response = ResponseResult.failed("用户新密码不能为空.");
      return response;
    }
    User user = userDao.getUserByCode(changePassword.getUserCode());
    if (user == null) {
      response = ResponseResult.failed("用户不存在.");
      return response;
    }

    //验证密码
    if (!user.getPassword().equals(MD5.sign(changePassword.getOldPassword()))) {
      response = ResponseResult.failed("原密码不正确.");
      return response;
    }

    user.setPassword(MD5.sign(changePassword.getNewPassword()));
    user.setLstUpdTime(new Date());
    try {
      userDao.updateUser(user);
      response = ResponseResult.success();
      return response;
    } catch (Exception e) {
      log.error("【修改密码】异常，" + e.getMessage());
      response = ResponseResult.failed("修改密码异常，" + e.getMessage());
      return response;
    }
  }

  private User converUserFromSuser(SUser sUser) {
    if (sUser == null) {
      return null;
    }

    User user = new User();
    BeanUtils.copyProperties(sUser, user);
    if (StringUtils.isEmpty(user.getUuid())) {
      user.setUuid(UUIDGenerator.getUUID());
    }
    user.setLstUpdTime(new Date());
    user.setPassword(MD5.sign(sUser.getPassword()));
    return user;
  }

  private SUser converSUserFromUser(User user) {
    if (user == null) {
      return null;
    }

    SUser sUser = new SUser();
    BeanUtils.copyProperties(user, sUser);
    sUser.setPassword(null);

    return sUser;
  }

  private String checkParam(SUser user, int type) {

    if (user == null) {
      return  "参数解析错误.";
    }
    if (type == 1) {  //修改
      if (StringUtils.isEmpty(user.getUuid())) {
        return "用户id未指定.";
      }
    }
    if (StringUtils.isEmpty(user.getCode())) {
      return "用户代码未填写.";
    }
    if (StringUtils.isEmpty(user.getName())) {
      return "用户名称未填写.";
    }
    if (StringUtils.isEmpty(user.getType())) {
      return "用户类型未填写.";
    }
    if (StringUtils.isEmpty(user.getPassword())) {
      return "用户密码未填写.";
    }
    if (StringUtils.isEmpty(user.getMobile())) {
      return "用户联系方式未填写.";
    }
    if (user.getStat() == null || user.getStat() < 0 || user.getStat() > 1) {
      return "用户状态未正确指定.";
    }
    User user1 = userDao.getUserByCode(user.getCode());
    if (user1 != null) {
      if (!user1.getUuid().equals(user.getUuid())) {
        return "用户代码已经存在.";
      }
    }
    if (type == 1) {
      if (!userDao.ExistUserByUuid(user.getUuid())) {
        return "用户不存在.";
      }
    }

    return null;
  }
}
