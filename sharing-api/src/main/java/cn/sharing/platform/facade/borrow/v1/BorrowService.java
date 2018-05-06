/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：BorrowService
 * 模块说明：
 * 修改历史：
 * 2018/4/29 - yanghongjun - 创建
 */
package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 物品租用服务
 *
 * @author yanghongjun
 * @version 1.0
 */
@RequestMapping("/api/v1/borrow")
@Api(tags = "租用单接口")
public interface BorrowService {
    /**
     * 物品使用
     *
     * @param borrowParam 物品借用信息对象
     * @return 物品信息
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "物品借用")
    public ResponseResult<String> borrow(@RequestBody BorrowParam borrowParam);

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "租用单查询")
    public ResponseResult<QueryResult<SBorrow>> query(@RequestBody @Valid BorrowQuery param);


    /**
     * 物品归还
     * @param sGoodsBorrow 物品借用信息对象
     * @return
     */
    @RequestMapping(value = "/back", method = RequestMethod.POST)
    @ApiOperation(value = "物品归还")
    public ResponseResult<Void> back(@RequestBody @Valid SBorrow sGoodsBorrow);


    /**
     * 物品赔偿
     * @param sGoodsBorrow 物品借用信息对象
     * @return
     */
    @RequestMapping(value = "/compensate", method = RequestMethod.POST)
    @ApiOperation(value = "物品赔偿")
    public ResponseResult<Void> compensate(@RequestBody @Valid SBorrow sGoodsBorrow);

    //新增两个接口 1. 获取明细   2.领取，记录领用人和领用时间（BORROWER 表结构调整）
}
