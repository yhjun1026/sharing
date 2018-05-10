package cn.sharing.platform.user;

import cn.sharing.platform.BaseImpl;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.common.UCN;
import cn.sharing.platform.store.StoreDao;
import cn.sharing.dao.entity.Store;
import cn.sharing.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * 用户接口实现
 *
 * Created by guotao on 2018.01.07.
 */
@RestController
@ControllerAdvice
@Component
public class UserServiceImpl extends BaseImpl implements UserService {
  @Autowired
  UserDao userDao;
  @Autowired
  StoreDao storeDao;
  /**
   * 用户登录
   * @param storeCode  组织
   * @param userLogin  用户登录信息
   * @return
   */
  @Override
  public ResponseResult<UserResponse> login(@RequestHeader("storeCode") String storeCode, @RequestBody UserLogin userLogin){
    ResponseResult<UserResponse> response;
    if (userLogin == null) {
      response = ResponseResult.failed("参数解析错误.");
      return response;
    }
    if (userLogin.getUserCode() == "" || userLogin.getUserCode() == null) {
      response = ResponseResult.failed("用户代码未设置.");
      return response;
    }
    if (storeCode == null ||  storeCode.isEmpty()){
      return ResponseResult.failed("组织不能为空.");
    }
    try{
      /** 判断用户是否存在 */
      if (!userDao.isExistUserByCode(userLogin.getUserCode())){
        return ResponseResult.failed("用户代码不存在.");
      }
      /** 获取用户信息*/
      User user = userDao.getUserByCodeAndPassword(userLogin.getUserCode(), userLogin.getPassword());
      if (user == null){
        return ResponseResult.failed("用户密码错误.");
      }
      ResponseResult responseResult = ResponseResult.success();
      responseResult.setData(converUserResponse(user));
      return responseResult;
    } catch (Exception e) {
      logger.info("login error, userCode=" + userLogin.getUserCode() + ", password=" + userLogin.getPassword() + e.getMessage(), e);
      return ResponseResult.failed("登录异常.");
    }
  }

  /**
   * 用户更新
   *
   * @param userUpdate
   *         用户更新信息对象
   * @return 是否更新成功
   */
  @Override
  public ResponseResult<Void> update(@RequestBody SUser userUpdate) {
    ResponseResult<Void> response;
    if (userUpdate == null) {
      response = ResponseResult.failed("参数解析错误.");
      return response;
    }
    if (userUpdate.getUuid() == "" || userUpdate.getUuid() == null) {
      response = ResponseResult.failed("用户UUID未指定.");
      return response;
    }
    if (userUpdate.getCode() == "" || userUpdate.getCode() == null) {
      response = ResponseResult.failed("用户代码不能为空.");
      return response;
    }
    if (userUpdate.getName() == "" || userUpdate.getName() == null) {
      response = ResponseResult.failed("用户名称不能为空.");
      return response;
    }
    if (userUpdate.getStoreuuid() == "" || userUpdate.getStoreuuid() == null) {
      response = ResponseResult.failed("组织不能为空.");
      return response;
    }
    try{
      /** 获取组织信息 */
      Store store = storeDao.getStoreByUuid(userUpdate.getStoreuuid());
      if (store == null) {
        response = ResponseResult.failed("组织UUID不正确.");
        return response;
      }
      /** 更新用户信息*/
      if (!userDao.insertUser(converUser(userUpdate, store))){
        return ResponseResult.failed("更新失败.");
      }
      return ResponseResult.failed("更新成功.");
    } catch (Exception e) {
      logger.info("update user error, userCode=" + userUpdate.getCode() + e.getMessage(), e);
      return ResponseResult.failed("更新异常.");
    }
  }
  /**
   * 用户对象转换
   *
   * @param   userUpdate 用户信息
   * @return  用户对象
   */
  private User converUser(SUser userUpdate, Store store){
    User user = new User();
    user.setUuid(userUpdate.getUuid());
    user.setCode(userUpdate.getCode());
    user.setName(userUpdate.getName());
    user.setPassword(userUpdate.getPassword());
    user.setGroupuuid(userUpdate.getGroupuuid());
    user.setMobile(userUpdate.getMobile());
    user.setType(userUpdate.getType());
    user.setStoreuuid(userUpdate.getStoreuuid());
    user.setLastupdtime(new Date());
    user.setStoreuuid(store.getUuid());
    user.setStorecode(store.getCode());
    user.setStorename(store.getName());
    return user;
  }
  /**
   * 用户对象转换
   *
   * @param   user 用户信息
   * @return  用户返回对象
   */
  private UserResponse converUserResponse(User user){
    UserResponse userResponse = new UserResponse();
    userResponse.setUuid(user.getUuid());
    userResponse.setCode(user.getCode());
    userResponse.setName(user.getName());
    UCN store = new UCN();
    store.setUuid(user.getStoreuuid());
    store.setCode(user.getStorecode());
    store.setUuid(user.getStorename());
    userResponse.setStore(store);
    return writeUserToken(userResponse);
  }
  /**
   * 用户验证信息
   *
   * @param user 用户信息
   * @return  用户对象
   */
  private UserResponse writeUserToken(UserResponse user) {
    String uuid = UUID.randomUUID().toString();
    uuid = uuid.replaceAll("-", "");
    user.setToken(uuid);
    return user;
  }
}
