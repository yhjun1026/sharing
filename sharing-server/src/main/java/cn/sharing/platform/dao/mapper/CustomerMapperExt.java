package cn.sharing.platform.dao.mapper;

import cn.sharing.platform.dao.entity.GoodsBorrowMst;
import cn.sharing.platform.dao.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by zenglin on 2018/5/10.
 */
public interface CustomerMapperExt {

  List<Customer> queryGoodsBorrowMst(@Param("openid") String openid,
                                     @Param("phoneNumber") String phoneNumber);
}
