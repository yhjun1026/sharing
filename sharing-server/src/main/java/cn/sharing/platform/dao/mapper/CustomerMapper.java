package cn.sharing.platform.dao.mapper;

import cn.sharing.platform.dao.entity.Customer;
import cn.sharing.platform.dao.entity.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CustomerMapper {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExampleWithRowbounds(CustomerExample example, RowBounds rowBounds);

    List<Customer> selectByExample(CustomerExample example);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    Long sumByExample(CustomerExample example);

    void batchInsert(@Param("items") List<Customer> items);
}