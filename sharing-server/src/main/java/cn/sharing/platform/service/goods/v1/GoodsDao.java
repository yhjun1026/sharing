package cn.sharing.platform.service.goods.v1;

import cn.sharing.dao.mapper.GoodsMapper;
import cn.sharing.dao.mapper.StockMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
   * 根据代码判断物品是否存在
   *
   * @param uuid
   *         物品uuid
   * @return 存在返回True 否则返回false
   */
  public Boolean isExistGoodsByUuid(String uuid) {
    if (StringUtils.isEmpty(uuid)) {
      return false;
    }
    return true;
  }

}
