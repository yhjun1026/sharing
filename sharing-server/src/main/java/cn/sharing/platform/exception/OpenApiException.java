/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2017，所有权利保留。
 * 项目名：marketing3
 * 文件名：MarketingException
 * 模块说明：
 * 修改历史：
 * 2017-08-22 - suizhe - 创建
 */
package cn.sharing.platform.exception;

import com.qianfan123.sailing.open.api.ReturnCodeEnum;

/**
 * MarketingException
 *
 * @author suizhe
 */
public class OpenApiException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public OpenApiException() {
    super(ReturnCodeEnum.FAIL.getDesc());
    code = ReturnCodeEnum.FAIL.value();
  }

  public OpenApiException(String message) {
    super(message);
    code = ReturnCodeEnum.FAIL.value();
  }

  public OpenApiException(ReturnCodeEnum returnCode) {
    super(returnCode == null ? null : returnCode.getDesc());
    if (returnCode != null) {
      code = returnCode.value();
    }
  }

  public OpenApiException(int code, String desc) {
    super(desc);
    this.code = code;
  }

  public OpenApiException(ReturnCodeEnum returnEnum, Object... objects) {
    super(String.format(returnEnum.getDesc(), objects));
    this.code = returnEnum.value();
  }

  private int code;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

}

