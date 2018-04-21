package cn.sharing.platform.goods.v1;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 物品信息
 *
 * Created by guotao on 2018.01.18.
 */
@Data
public class SGoods {

  /** 物品uuid */
  private String uuid;
  /** 物品代码 */
  private String code;
  /** 物品名称 */
  private String name;
  /** 物品类型 */
  private String type;
  /** 物品状态 */
  private Integer stat;
  /** 总库存 */
  private int quantity;
  /** 当前库存 */
  private int currentQuantity;
  /** 单位 */
  private String unit;
  /** 图片 */
  private String picture;
  /** 描述 */
  private String description;
  /** 单价（赔偿价格） */
  private BigDecimal price;
  /** 成本价格 */
  private BigDecimal costPrice;
  /** 租用价格 */
  private BigDecimal rentPrice;
  /** 最后修改人 */
  private String laster;
  /** 最后修改时间 */
  private Date lastupdtime;
  /** 备注 */
  private String memo;
  /** 组织uuid */
  private String storeuuid;

}
