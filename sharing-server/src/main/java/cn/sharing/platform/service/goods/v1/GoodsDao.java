package cn.sharing.platform.service.goods.v1;

import cn.sharing.dao.mapper.GoodsMapper;
import cn.sharing.dao.mapper.StockMapper;
import cn.sharing.platform.facade.goods.v1.GoodsQuery;
import cn.sharing.platform.facade.goods.v1.SGoods;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 物品信息操作
 * <p>
 * Created by guotao on 2018.01.19.
 */
@Component
public class GoodsDao {
  protected Logger logger = LoggerFactory.getLogger(this.getClass());
  private String sMessage;
  @Autowired
  GoodsMapper goodsMapper;
  @Autowired
  StockMapper stockMapper;


  /**
   * 判断物品库存是否存在
   *
   * @param uuid
   *         uuid
   * @return true表示存在，false表示不存在
   */
  public boolean isExistsStockByUuid(String uuid) {
    if (StringUtils.isEmpty(uuid)) {
      return false;
    }
    return stockMapper.getByPrimaryKey(uuid) == null ? false : true;
  }

  /**
   * 根据条件查询所有可租用的物品
   * @param goods
   * @return
   */
  public List<SGoods> getAllRentGoods(SGoods goods) {
    GoodsQuery goodsQuery = new GoodsQuery();
    return SGoodsConvert.perzConvertList(goodsMapper.getAllRentGoods(GoodsConvert.perzConvert(goods), new RowBounds(goodsQuery.getPage(),
            goodsQuery.getPageSize())));
  }

  /**
   * 查询科可租用的数量
   * @param goods
   * @return
   */
  public int getAllRentGoodsCount(SGoods goods){
    return goodsMapper.getAllRentGoodsCount(GoodsConvert.perzConvert(goods));
  }

  /**
   * 根据主键查询
   * @param uuid uuid
   * @return
   */
  public SGoods getGoodsByUuid(String uuid){
    return SGoodsConvert.perzConvert(goodsMapper.getByPrimaryKey(uuid));
  }
}
