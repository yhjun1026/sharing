package com.sharing.dao.mapper;

import com.sharing.dao.entity.Store;
import com.sharing.dao.entity.StoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StoreMapper {
    long countByExample(StoreExample example);

    int deleteByExample(StoreExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(Store record);

    int insertSelective(Store record);

    List<Store> selectByExampleWithRowbounds(StoreExample example, RowBounds rowBounds);

    List<Store> selectByExample(StoreExample example);

    Store selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    Long sumByExample(StoreExample example);

    void batchInsert(@Param("items") List<Store> items);
}