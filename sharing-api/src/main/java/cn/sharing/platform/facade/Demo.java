/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：Demo
 * 模块说明：
 * 修改历史：
 * 2018/1/4 - yanghongjun - 创建
 */
package cn.sharing.platform.facade;

import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author yanghongjun
 * @version 1.0
 */
@RequestMapping("/api/v1/test")
@Api(tags = "测试接口")
public interface Demo {
  @RequestMapping(value = "/t1" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "登录")
  public ResponseResult<Void> login (@RequestHeader("orgCode") String orgCode, @RequestBody @Valid Map<String, String> param);

  @RequestMapping(value = "/t2", method = RequestMethod.POST)
  @ApiOperation(value = "断线")
  public  ResponseResult<Void>  offline(@RequestHeader("orgCode") String orgCode, @RequestBody @Valid String[] param);
}
