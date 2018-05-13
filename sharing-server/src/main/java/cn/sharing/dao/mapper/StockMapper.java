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
     * 更新物品库存信息
     * @param stock 物品库存
     * @return
     */
    int update(Stock stock);

    /**
     * 删除物品库存信息
     * @param stock 物品库存
     * @return
     */
    int delete(Stock stock);

    /**
     * 根据主键删除
     * @param uuid uuid
     * @return
     */
    int deleteByPrimaryKey(@Param("uuid") String uuid);

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
    List<Stock> getByCondition(Stock condition);

    /**
     * 根据UUID获取物品库存信息
     * @param uuid uuid
     * @return
     */
    Stock getByPrimaryKey(@Param("uuid") String uuid);

    /**
     * 获取物品库存数量
     * @param goodsUuid 商品UUID
     * @return
     */
    int getMaxNo(@Param("goodsUuid") String goodsUuid);
}