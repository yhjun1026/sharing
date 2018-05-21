package cn.sharing.platform.service.goods.v1;

import cn.sharing.dao.entity.Goods;
import cn.sharing.platform.facade.goods.v1.SGoods;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将数据库对象转换成传输对象
 */
public class SGoodsConvert {

  /**
   * 单个对象转换
   * @param goods 物品传输对象
   * @return
   */
  public static SGoods perzConvert(Goods goods){
    SGoods sGoods = new SGoods();
    BeanUtils.copyProperties(goods, sGoods);
    sGoods.setCurrentQuantity(goods.getStockQuantity());
    sGoods.setStoreUuid(goods.getStoreuuid());
    return sGoods;
  }

  /**
   * 列表对象转换
   * @param goodsList 物品数据库对象
   * @return
   */
  public static List<SGoods> perzConvertList(List<Goods> goodsList){
    List<SGoods> sGoodsList = new ArrayList<SGoods>();
    for(Goods goods: goodsList){
      SGoods sGoods = perzConvert(goods);
      sGoodsList.add(sGoods);
    }
    return  sGoodsList;
  }

  /**
   * 从map转换成对象
   * @param map map
   * @return
   */
  public static SGoods perzConvertFromMap(Map<String, Object> map){
    SGoods sGoods = new SGoods();
    sGoods.setUuid((String)map.get("UUID"));
    sGoods.setCode((String)map.get("CODE"));
    sGoods.setName((String)map.get("NAME"));
    sGoods.setQuantity((Integer)map.get("QUANTITY"));
    sGoods.setState((Integer)map.get("STAT"));
    sGoods.setCurrentQuantity((Integer)map.get("STOCKQUANTITY"));
    sGoods.setPicture((String)map.get("PICTURE"));
    sGoods.setCostPrice(new BigDecimal((String)map.get("COSTPRICE")));
    sGoods.setDepositamt(new BigDecimal((String)map.get("DEPOSITAMT")));
    sGoods.setRentPrice(new BigDecimal((String)map.get("RENTPRICE")));
    sGoods.setRepayamt(new BigDecimal((String)map.get("REPAYAMT")));
    sGoods.setPrice(new BigDecimal((String)map.get("PRICE")));
    sGoods.setDescription((String)map.get("DESCRIPTION"));
    sGoods.setLaster((String)map.get("LASTER"));
    sGoods.setLastupdtime((Date)map.get("LASTUPDTIME"));
    sGoods.setStoreUuid((String)map.get("STOREUUID"));
    sGoods.setMemo((String)map.get("MEMO"));
    return sGoods;
  }
}
