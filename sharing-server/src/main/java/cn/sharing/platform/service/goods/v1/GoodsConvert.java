package cn.sharing.platform.service.goods.v1;


import cn.sharing.dao.entity.Goods;
import cn.sharing.platform.facade.goods.v1.SGoods;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 将物品转换为数据库物品对象
 */
public class GoodsConvert {

  /**
   * 单个对象转换
   * @param sGoods 物品传输对象
   * @return
   */
    public static Goods perzConvert(SGoods sGoods){
      Goods goods = new Goods();
      BeanUtils.copyProperties(sGoods, goods);
      goods.setStockQuantity(sGoods.getCurrentQuantity());
      goods.setStoreUuid(sGoods.getStoreuuid());
      return goods;
    }

  /**
   * 列表对象转换
   * @param sGoodsList 物品传输对象
   * @return
   */
  public static List<Goods> perzConvertList(List<SGoods> sGoodsList){
    List<Goods> goodsList = new ArrayList<Goods>();
    for(SGoods sGoods: sGoodsList){
      Goods goods = perzConvert(sGoods);
      goodsList.add(goods);
    }
    return  goodsList;
  }
}
