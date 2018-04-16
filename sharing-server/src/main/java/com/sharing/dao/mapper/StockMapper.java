package com.sharing.dao.mapper;

import com.sharing.dao.entity.Stock;
import com.sharing.dao.entity.StockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StockMapper {
    long countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExampleWithRowbounds(StockExample example, RowBounds rowBounds);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

    Long sumByExample(StockExample example);

    void batchInsert(@Param("items") List<Stock> items);
}