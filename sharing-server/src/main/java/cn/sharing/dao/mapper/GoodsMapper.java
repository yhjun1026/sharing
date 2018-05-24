package cn.sharing.dao.mapper;

import cn.sharing.dao.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {

    /**
     * 插入物品信息
     * @param goods 物品信息
     * @return
     */
    int insert(Goods goods);

    /**
     * 修改物品信息
     * @param goods 物品信息
     * @return
     */
    int update(Goods goods);

    /**
     * 删除物品信息
     * @param condition 删除条件
     * @return
     */
    int deleteByCondition(Goods condition);

    /**
     * 根据主键删除
     * @param uuid UUID
     * @return
     */
    int deleteByPrimaryKey(@Param("uuid") String uuid);

    /**
     * 分页查询所有可租用的物品
     * @parm goods 物品信息
     * @param rowBounds 分页信息
     * @return
     */
    List<Goods> getAllRentGoods(@Param("storeId")String storeId,
                                @Param("code")String code,
                                @Param("name")String name,
                                @Param("queryType")int queryType,
                                RowBounds rowBounds);

    /**
     * 所有可租用物品的数量
     * @parm goods 物品信息
     * @return
     */
    int getAllRentGoodsCount(@Param("storeId")String storeId,
                             @Param("code")String code,
                             @Param("name")String name,
                             @Param("queryType")int queryType);

    /**
     * 根据主键获取物品信息
     * @param uuid UUID
     * @return 物品信息
     */
    List<Map<String, Object>> getByPrimaryKey(@Param("uuid") String uuid);

    /**
     * 根据查询条件获取物品信息,不返回库存信息
     * @param condition 查询条件
     * @return 物品信息
     */
    List<Goods> getByCondition(Goods condition);

}