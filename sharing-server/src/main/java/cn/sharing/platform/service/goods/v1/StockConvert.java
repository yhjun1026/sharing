package cn.sharing.platform.service.goods.v1;

import cn.sharing.dao.entity.Stock;
import cn.sharing.platform.facade.goods.v1.SGoodsStock;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StockConvert {

  /**
   * 单个对象转换
   *
   * @param sGoodsStock
   *         物品库存传输对象
   * @return
   */
  public static Stock perzConvert(SGoodsStock sGoodsStock) {
    Stock stock = new Stock();
    BeanUtils.copyProperties(sGoodsStock, stock);
    return stock;
  }

  /**
   * 列表对象转换
   *
   * @param sGoodsStockList
   *         物品库存传输对象
   * @return
   */
  public static List<Stock> perzConvertList(List<SGoodsStock> sGoodsStockList) {
    List<Stock> stockList = new ArrayList<Stock>();
    for (SGoodsStock sGoods : sGoodsStockList) {
      Stock stock = perzConvert(sGoods);
      stockList.add(stock);
    }
    return stockList;
  }
}
