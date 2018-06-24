package cn.sharing.platform.service.customer.v1;

import cn.sharing.dao.entity.GoodsBorrowDtl;
import cn.sharing.dao.entity.GoodsBorrowDtlExample;
import cn.sharing.dao.entity.GoodsBorrowMst;
import cn.sharing.dao.entity.PayInfo;
import cn.sharing.platform.dao.entity.Customer;
import cn.sharing.platform.dao.mapper.CustomerMapper;
import cn.sharing.platform.dao.mapper.CustomerMapperExt;
import cn.sharing.platform.facade.borrow.v1.BorrowDetailInfoDto;
import cn.sharing.platform.facade.borrow.v1.SBorrowDtl;
import cn.sharing.platform.facade.customer.v1.SCustomer;
import cn.sharing.platform.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 2018/6/24.
 */
@Component
@Slf4j
public class CustomerDao {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerMapperExt customerMapperExt;


    @Transactional
    public String saveCustomer(SCustomer sCustomer) {
        Customer customer = new Customer();
        customer.setToken(sCustomer.getToken());
        customer.setCode(sCustomer.getCode());
        customer.setUnionId(sCustomer.getUnionId());
        customer.setOpenid(sCustomer.getOpenId());
        customer.setCountry(sCustomer.getCountry());
        customer.setProvince(sCustomer.getProvince());
        customer.setCity(sCustomer.getCity());
        customer.setAppid(sCustomer.getAppId());
        customer.setCreatetime(sCustomer.getCreateTime());
        customer.setIcon(sCustomer.getIcon());
        customer.setMemo(sCustomer.getMemo());
        customer.setPhoneNumber(sCustomer.getPhoneNumber());
        customer.setWechatid(sCustomer.getWechatId());
        customerMapper.insert(customer);
        return customer.getCode();
    }


    public Customer get(String openid, String phoneNumber) {
        List<Customer> customers = customerMapperExt.queryGoodsBorrowMst(openid, phoneNumber);
        if (customers == null ) {
            return null;
        }
        return customers.get(0);
    }
}
