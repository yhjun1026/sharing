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
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author yanghongjun
 * @version 1.0
 */
@RestController
@ControllerAdvice
public class DemoImpl implements Demo {

  @Override
  public ResponseResult<Void> login(@RequestHeader("orgCode") String orgCode, @RequestBody @Valid Map<String, String> param){
    File path = null;
    try {
      path = new File(ResourceUtils.getURL("classpath:").getPath());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    if(!path.exists()) path = new File("");
    System.out.println("path:"+path.getAbsolutePath());
    return new ResponseResult<>();
  }

  @Override
  public  ResponseResult<Void>  offline(@RequestHeader("orgCode") String orgCode, @RequestBody @Valid String[]
          conectInfo){
    return new ResponseResult<>();
  }
}
