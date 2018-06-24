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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
     * 新顾客登陆
     *
     * @param weChatAppLoginReq
     *         顾客
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "小程序用户登陆")
    ResponseResult<SCustomer> login(@RequestBody WeChatAppLoginReq weChatAppLoginReq);

    /**
     * 顾客新增
     *
     * @param SCustomer
     *         顾客
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户")
    ResponseResult<Void> get(@RequestBody SCustomer SCustomer);

    /**
     * 用户信息更新
     * @param SCustomer
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "用户信息更新(只允许修改昵称、手机号、openId无法修改)")
    ResponseResult<Void> update(@RequestBody SCustomer SCustomer);

    /**
     * 用户查询
     * @param param
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "用户查询")
    public ResponseResult<QueryResult<SCustomer>> query(@RequestBody CustomerQuery param);

    /**
     * 用户获取（可以根据手机号，openid）
     * @param id
     * @return SCustomer
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "")
    public ResponseResult<SCustomer> get(@PathVariable String id);

}
