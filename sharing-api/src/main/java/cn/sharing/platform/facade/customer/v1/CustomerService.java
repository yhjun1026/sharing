/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：CustomerService
 * 模块说明：
 * 修改历史：
 * 2018/5/19 - yanghongjun - 创建
 */
package cn.sharing.platform.facade.customer.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.borrow.v1.BorrowCollarParam;
import cn.sharing.platform.facade.borrow.v1.BorrowQuery;
import cn.sharing.platform.facade.borrow.v1.BorrowSummaryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yanghongjun
 * @version 1.0
 */
@RequestMapping("/api/v1/customer")
@Api(tags = "顾客接口")
public interface CustomerService {
    /** beanID */
    String DEFAULT_BEAN_ID = "sharing-api.customerService";
    /**
     * 顾客新增
     *
     * @param customer
     *         顾客
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户")
    ResponseResult<Void> get(@RequestBody Customer customer);

    /**
     * 用户信息更新
     * @param customer
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "用户信息更新(只允许修改昵称、手机号、openId无法修改)")
    ResponseResult<Void> update(@RequestBody Customer customer);

    /**
     * 用户查询
     * @param param
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "用户查询")
    public ResponseResult<QueryResult<Customer>> query(@RequestBody CustomerQuery param);

    /**
     * 用户获取（可以根据手机号，openid）
     * @param id
     * @return Customer
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "")
    public ResponseResult<Customer> get(@PathVariable String id);

}