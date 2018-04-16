package cn.sharing.platform.store;

/**
 * 用户更新内容
 * Created by guotao on 2018.01.18.
 *
 */
public class SStore {
  private String uuid;
  private String code;
  private String name;
  private String licence;
  private String upperuuid;
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
  /*上级组织UUID*/
  public String getUpperuuid() {
    return upperuuid;
  }

  public void setUpperuuid(String upperuuid) {
    this.upperuuid = upperuuid;
  }
  /*备注*/
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
  /*认证信息*/
  public String getLicence() {
    return licence;
  }

  public void setLicence(String licence) {
    this.licence = licence;
  }
}
