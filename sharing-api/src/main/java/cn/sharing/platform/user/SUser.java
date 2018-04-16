package cn.sharing.platform.user;

/**
 * 用户更新内容
 * Created by guotao on 2018.01.18.
 *
 */
public class SUser {
  private String uuid;
  private String code;
  private String name;
  private String type;
  private String groupuuid;
  private String password;
  private String mobile;
  private String storeuuid;
  private String memo;

  /*用户UUID*/
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
  /*用户代码*/
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
  /*用户名称*/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  /*用户类型*/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  /*用户组UUID*/
  public String getGroupuuid() {
    return groupuuid;
  }

  public void setGroupuuid(String groupuuid) {
    this.groupuuid = groupuuid;
  }
  /*用户密码*/
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  /*用户手机号*/
  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }
  /*所属组织UUID*/
  public String getStoreuuid() {
    return storeuuid;
  }

  public void setStoreuuid(String storeuuid) {
    this.storeuuid = storeuuid;
  }
  /*备注*/
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
}
