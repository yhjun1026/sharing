package cn.sharing.platform.service.goods.v1;

import cn.sharing.platform.BaseImpl;
import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.goods.v1.GoodsQuery;
import cn.sharing.platform.facade.goods.v1.GoodsService;
import cn.sharing.platform.facade.goods.v1.SGoods;
import cn.sharing.platform.facade.goods.v1.SGoodsStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 物品服务实现
 * <p>
 * Created by guotao on 2018.01.19.
 */
@Service(GoodsService.DEFAULT_BEAN_ID)
public class GoodsServiceImpl extends BaseImpl implements GoodsService {

  @Autowired
  private GoodsDao goodsDao;

  /**
   * 物品查询，查询信息包含物品的库存信息
   *
   * @param goodsId
   *         物品uuid
   * @return 物品信息
   */
  @Override
  public ResponseResult<SGoods> get(String goodsId) {
    return null;
  }

  /**
   * 分页查询可租用的物品信息
   *
   * @param param
   *         分页参数
   * @return
   */
  @Override
  public ResponseResult<QueryResult<SGoods>> getRentGoods(GoodsQuery param) {
    return null;
  }

  /**
   * 物品新增，用于新增物品或者增加物品的库存数量
   *
   * @param sGoods
   *         物品信息
   * @return 新增成功或者失败
   */
  @Override
  public ResponseResult<Void> add(SGoods sGoods) {
    return null;
  }

  /**
   * 预定或者租用可以被租用的物品，一次只能租用一个物品，
   * 不需要传库存信息，系统随机选取一个可以租用的库存物品
   *
   * @param sGoods
   *         租用的物品信息
   * @return 租用的物品
   */
  @Override
  public ResponseResult<SGoods> borrow(SGoods sGoods) {
    return null;
  }

  /**
   * 更新物品的状态
   *
   * @param sGoodsStock
   *         物品库存状态
   * @return 修改成功或者失败
   */
  @Override
  public ResponseResult<Void> updateState(SGoodsStock sGoodsStock) {
    return null;
  }


  /**
   * 删除物品
   *
   * @param sGoods
   *         物品信息
   * @return 删除成功或者失败
   */
  @Override
  public ResponseResult<Void> delete(SGoods sGoods) {
    return null;
  }

  /**
   * 修改物品信息
   *
   * @param sGoods
   *         物品信息
   * @return
   */
  @Override
  public ResponseResult<Void> update(SGoods sGoods) {
    return null;
  }
}
