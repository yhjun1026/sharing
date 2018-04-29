package cn.sharing.platform.facade.goods.v1;

import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.borrow.v1.SBorrow;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 物品服务接口
 *
 * Created by guotao on 2018.01.18.
 */
@RequestMapping("/api/v1/goods")
@Api(tags = "物品接口")
public interface GoodsService {
  /**
   * 物品更新
   * @param sGoods 物品信息对象
   * @return 是否更新成功
   */
  @RequestMapping(value = "/save" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "更新")
  public ResponseResult<Void> save (@RequestBody SGoods sGoods);
  /**
   * 物品查询
   * @param goodsid 物品uuid
   * @return 物品信息
   */
  @RequestMapping(value = "/get/{goodsid}", method = RequestMethod.GET)
  @ApiOperation(value = "获取")
  public ResponseResult<SGoods> get ( @PathVariable(value = "goodsid") @ApiParam(name = "goodsid",
          value = "物品代码")String goodsid);
  /**
   * 物品库存调整
   * @param sGoodsStock 物品库存信息对象
   * @return 是否更新成功
   */
  @RequestMapping(value = "/add" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "库存调整")
  public ResponseResult<Void> add (@RequestBody SGoodsStock sGoodsStock);

  /**
   * 物品使用
   * @param sGoodsBorrow 物品借用信息对象
   * @return 物品信息
   */
  @RequestMapping(value = "/borrow" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "物品借用")
  public ResponseResult<Void> borrow (@RequestBody SBorrow sGoodsBorrow);
  /**
   * 物品锁定
   * @param sGoodsBorrow 物品信息对象
   * @return
   */
  @RequestMapping(value = "/lock" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "物品借用")
  public ResponseResult<Void> lock (@RequestBody SBorrow sGoodsBorrow);

  /**
   * 物品归还
   * @param sGoodsBorrow 物品借用信息对象
   * @return 物品信息
   */
  @RequestMapping(value = "/back" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "物品归还")
  public ResponseResult<Void> back (@RequestBody SBorrow sGoodsBorrow);


}
