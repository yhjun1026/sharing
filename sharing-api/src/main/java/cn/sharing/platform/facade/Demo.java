/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：Demo
 * 模块说明：
 * 修改历史：
 * 2018/1/4 - yanghongjun - 创建
 */
package cn.sharing.platform.facade;

/**
 * @author yanghongjun
 * @version 1.0
 */
@RequestMapping("/api/v1/wifi")
@Api(tags = "WIFI接口")
public interface Demo {
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ApiOperation(value = "WIFI登录")
  public ResponseResult<Void> login (@RequestHeader("orgCode") String orgCode, @RequestBody @Valid LoginInfo loginInfo);

  @RequestMapping(value = "/offline", method = RequestMethod.POST)
  @ApiOperation(value = "WIFI断线")
  public  ResponseResult<Void>  offline(@RequestHeader("orgCode") String orgCode, @RequestBody @Valid ConectInfo conectInfo);
}
