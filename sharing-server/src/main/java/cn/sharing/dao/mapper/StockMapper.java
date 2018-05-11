package cn.sharing.dao.mapper;

import cn.sharing.dao.entity.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {
    /**
     * 插入物品库存
     * @param stock 物品库存
     * @return
     */
    int insert(Stock stock);

    /**
     * 批量插入物品库存信息
     * @param stocks 物品库存
     */
    void batchInsert(@Param("stocks") List<Stock> stocks);

    /**
     * 根据查询条件查询物品库存信息
     * @param condition 查询条件
     * @return
     */
    Stock getByCondition(Stock condition);
}