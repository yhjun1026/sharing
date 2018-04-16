package cn.sharing.platform.goods;

import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 物品服务接口
 *
 * Created by guotao on 2018.01.18.
 */
@RequestMapping("/api/goods")
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
   * @param goodsUuid 物品uuid
   * @return 物品信息
   */
  @RequestMapping(value = "/query" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "查询")
  public ResponseResult<SGoods> query (@RequestBody String goodsUuid);
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
  public ResponseResult<Void> borrow (@RequestBody SGoodsBorrow sGoodsBorrow);

  /**
   * 物品归还
   * @param sGoodsBorrow 物品借用信息对象
   * @return 物品信息
   */
  @RequestMapping(value = "/back" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "物品归还")
  public ResponseResult<Void> back (@RequestBody SGoodsBorrow sGoodsBorrow);


}
