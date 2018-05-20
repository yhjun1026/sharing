package cn.sharing.platform.user;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户服务接口
 *
 * Created by guotao on 2018.01.07.
 */
@RequestMapping("/api/user")
@Api(tags = "用户接口")
public interface UserService {
  /**
   * 用户登录
   *
   * @param userLogin  用户登录信息
   * @return  登陆信息
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ApiOperation(value = "登录")
  public ResponseResult<UserResponse> login (@RequestBody UserLogin userLogin);

  /**
   * 用户更新
   * @param user 用户更新信息对象
   * @return 是否更新成功
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ApiOperation(value = "更新用户")
  public ResponseResult<Void> update (@RequestBody SUser user);


  @RequestMapping(value = "/add", method = RequestMethod.POST)
  @ApiOperation(value = "新增用户")
  public ResponseResult<String> add (@RequestBody SUser user);


  @RequestMapping(value = "/query", method = RequestMethod.POST)
  @ApiOperation(value = "用户查询")
  public ResponseResult<QueryResult<SUser>> query(@RequestBody UserQuery param);

  @RequestMapping(value = "/get/{uuid}", method = RequestMethod.GET)
  @ApiOperation(value = "用户详情")
  public ResponseResult<SUser> get(@PathVariable String uuid);

  @RequestMapping(value = "/update/password", method = RequestMethod.POST)
  @ApiOperation(value = "修改密码")
  public ResponseResult<Void> changePassword (@RequestBody ChangePassword changePassword);

}
