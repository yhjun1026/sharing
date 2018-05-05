package cn.sharing.platform.service.goods.v1;

import cn.sharing.platform.BaseImpl;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.goods.v1.GoodsService;
import cn.sharing.platform.facade.goods.v1.SGoods;
import org.springframework.stereotype.Service;

/**
 * 物品服务实现
 * <p>
 * Created by guotao on 2018.01.19.
 */
@Service(GoodsService.DEFAULT_BEAN_ID)
public class GoodsServiceImpl extends BaseImpl implements GoodsService {

  @Override
  public ResponseResult<SGoods> get(String goodsid) {
    return null;
  }

  @Override
  public ResponseResult<SGoods> getRentGoods(String goodsid) {
    return null;
  }

  @Override
  public ResponseResult<Void> add(SGoods sGoods) {
    return null;
  }

  @Override
  public ResponseResult<SGoods> borrow(SGoods sGoods) {
    return null;
  }

  @Override
  public ResponseResult<Void> updateStock(SGoods sGoods) {
    return null;
  }

  @Override
  public ResponseResult<Void> delete(SGoods sGoods) {
    return null;
  }
}
