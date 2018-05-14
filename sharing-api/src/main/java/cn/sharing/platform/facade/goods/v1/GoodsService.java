package cn.sharing.platform.facade.goods.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 物品服务接口
 * <p>
 * Created by guotao on 2018.01.18.
 */
@RequestMapping("/api/v1/goods")
@Api(tags = "物品接口")
public interface GoodsService {

  /** beanID */
  String DEFAULT_BEAN_ID = "sharing-api.goodsService";

  /**
   * 物品查询，查询信息包含物品的库存信息
   *
   * @param goodsId
   *         物品uuid
   * @return 物品信息
   */
  @RequestMapping(value = "/get/{goodsid}", method = RequestMethod.GET)
  @ApiOperation(value = "获取物品信息,包括物品的库存")
  ResponseResult<SGoods> get(@PathVariable(value = "goodsid") @ApiParam(name = "goodsid", value = "物品代码") String
                                     goodsId);

  /**
   * 分页查询可租用的物品信息
   *
   * @param param
   *         查询参数，包括分页参数
   * @return
   */
  @RequestMapping(value = "/get/rent/all", method = RequestMethod.POST)
  @ApiOperation(value = "获取可以租用的物品")
  ResponseResult<QueryResult<SGoods>> getRentGoods(@RequestBody @Valid GoodsQuery param);

  /**
   * 物品新增，用于新增物品或者增加物品的库存数量
   *
   * @param sGoods
   *         物品信息
   * @return 新增成功或者失败
   */
  @RequestMapping(value = "/add" + "", method = RequestMethod.POST)
  @ApiOperation(value = "物品新增，用于新增物品或者增加物品的库存数量")
  ResponseResult<Void> add(@RequestBody  @Valid SGoods sGoods);


  /**
   * 预定或者租用可以被租用的物品，一次只能租用一个物品，
   * 不需要传库存信息，系统随机选取一个可以租用的库存物品
   *
   * @param sGoods
   *         租用的物品信息
   * @return 租用的物品
   */
  @RequestMapping(value = "/borrow" + "", method = RequestMethod.POST)
  @ApiOperation(value = "预定或者租用可以被租用的物品，一次只能租用一个物品")
  ResponseResult<SGoods> borrow(@RequestBody SGoods sGoods);

  /**
   * 更新物品的状态
   *
   * @param sGoodsStock
   *        物品库存状态
   * @return 修改成功或者失败
   */
  @RequestMapping(value = "/update/stock/" + "", method = RequestMethod.POST)
  @ApiOperation(value = "更新物品的状态")
  ResponseResult<Void> updateState(@RequestBody SGoodsStock sGoodsStock);

  /**
   * 删除物品
   *
   * @param sGoods
   *         物品信息
   * @return 删除成功或者失败
   */
  @RequestMapping(value = "/delete" + "", method = RequestMethod.POST)
  @ApiOperation(value = "删除物品")
  ResponseResult<Void> delete(@RequestBody SGoods sGoods);

  /**
   * 修改物品信息，不修改物品库存信息
   *
   * @param sGoods
   *         物品信息
   * @return
   */
  @RequestMapping(value = "/update" + "", method = RequestMethod.POST)
  @ApiOperation(value = "修改物品信息")
  ResponseResult<Void> update(@RequestBody SGoods sGoods);
}
