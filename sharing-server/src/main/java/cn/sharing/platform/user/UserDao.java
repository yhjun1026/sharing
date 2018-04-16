package cn.sharing.platform.user;

import com.sharing.dao.entity.User;
import com.sharing.dao.entity.UserExample;
import com.sharing.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户操作实现
 * Created by guotao on 2018.01.17.
 */
@Component
public class UserDao {
  @Autowired
  UserMapper userMapper;

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
   * 更新用户数据
   * @param user  用户
   * @return 插入是否成功
   */

  public Boolean insertUser(User user){
    /** 判断用户是否存在 */
    if (ExistUserByUuid(user.getUuid())){
      /** 存在 按主键更新*/
      int count = userMapper.updateByPrimaryKey(user);
      return count > 0;
    } else{
      /** 不存在 */
      int count =userMapper.insertSelective(user);
      return count > 0;
    }
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



}
