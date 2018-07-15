package cn.sharing.platform.facade.user.v1;

/**
 * 用户 user
 *
 * Created by guotao on 2018.01.07.
 */

public class UserLogin {
  private String userCode;
  private String password;

  /** 用户代码 */
  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  /** 用户密码 */
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
