package cn.sharing.platform.common;

/**
 * Created by zenglin on 2018/5/6.
 */
public enum BorrowStatEnum {

  NEW("new", "新增"),
  Paid("paid", "已支付"),
  USING("using", "已领取"),
  BACKED("backed", "已归还"),
  COMPENSATED("compensated", "已赔偿");
  private String desc;
  private String code;



  BorrowStatEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode(){
    return this.code;
  }

  public String getDesc(){
    return this.desc;
  }

  public String value(){
    return this.code;
  }
  @Override
  public String toString() {
    return code + "," + desc;
  }
}
