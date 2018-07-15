package cn.sharing.platform.service.goods;

import cn.sharing.platform.dao.entity.Stock;
import cn.sharing.platform.facade.goods.v1.SGoodsStock;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SGoodsStockConvert {

  /**
   * 单个对象转换
   *
   * @param stock
   *         物品库存数据库对象
   * @return
   */
  public static SGoodsStock perzConvert(Stock stock) {
    SGoodsStock sGoodsStock = new SGoodsStock();
    BeanUtils.copyProperties(stock, sGoodsStock);
    return sGoodsStock;
  }

  /**
   * 列表对象转换
   *
   * @param stockList
   *         物品库存数据对象
   * @return
   */
  public static List<SGoodsStock> perzConvertList(List<Stock> stockList) {
    List<SGoodsStock> sGoodsStockList = new ArrayList<SGoodsStock>();
    for (Stock stock : stockList) {
      SGoodsStock sGoodsStock = perzConvert(stock);
      sGoodsStockList.add(sGoodsStock);
    }
    return sGoodsStockList;
  }

  /**
   * 从map转换成对象
   * @param map
   * @return
   */
  public static SGoodsStock perzConvertFromMap(Map<String, Object> map){
    SGoodsStock sGoodsStock = new SGoodsStock();
    sGoodsStock.setUuid((String)map.get("STOCKUUID"));
    sGoodsStock.setNo((Integer)map.get("NO"));
    sGoodsStock.setState((Integer)map.get("STOCKSTATE"));
    sGoodsStock.setMemo((String)map.get("STOCKMEMO"));
    sGoodsStock.setGoodsUuid((String)map.get("GOODSUUID"));
    sGoodsStock.setLockVersion((Integer)map.get("LOCKVERSION"));
    return sGoodsStock;
  }
}
