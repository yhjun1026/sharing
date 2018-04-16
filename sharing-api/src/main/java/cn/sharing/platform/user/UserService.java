package cn.sharing.platform.user;

import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
   * @param storeCode  组织
   * @param userLogin  用户登录信息
   * @return  登陆信息
   */
  @RequestMapping(value = "/login" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "登录")
  public ResponseResult<UserResponse> login (@RequestHeader("storeCode") String storeCode, @RequestBody UserLogin userLogin);

  /**
   * 用户更新
   * @param userUpdate 用户更新信息对象
   * @return 是否更新成功
   */
  @RequestMapping(value = "/update" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "更新")
  public ResponseResult<Void> update (@RequestBody SUser userUpdate);

}
