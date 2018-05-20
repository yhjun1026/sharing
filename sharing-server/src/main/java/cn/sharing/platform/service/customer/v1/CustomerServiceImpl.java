/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：CustomerServiceImpl
 * 模块说明：
 * 修改历史：
 * 2018/5/20 - yanghongjun - 创建
 */
package cn.sharing.platform.service.customer.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.customer.v1.Customer;
import cn.sharing.platform.facade.customer.v1.CustomerQuery;
import cn.sharing.platform.facade.customer.v1.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghongjun
 * @version 1.0
 */
@RestController
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public ResponseResult<Void> get(@RequestBody Customer customer) {
        return null;
    }

    @Override
    public ResponseResult<Void> update(@RequestBody Customer customer) {
        return null;
    }

    @Override
    public ResponseResult<QueryResult<Customer>> query(@RequestBody CustomerQuery param) {
        return null;
    }

    @Override
    public ResponseResult<Customer> get(@PathVariable String id) {
        return null;
    }
}
