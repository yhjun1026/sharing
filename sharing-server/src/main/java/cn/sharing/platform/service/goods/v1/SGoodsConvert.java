package cn.sharing.platform.service.goods.v1;

import cn.sharing.dao.entity.Goods;
import cn.sharing.platform.facade.goods.v1.SGoods;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

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
    sGoods.setStoreuuid(goods.getStoreUuid());
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
}
