package cn.sharing.dao.mapper;

import cn.sharing.dao.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

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
    List<Goods> getAllRentGoods(Goods goods, RowBounds rowBounds);

    /**
     * 所有可租用物品的数量
     * @parm goods 物品信息
     * @return
     */
    int getAllRentGoodsCount(Goods goods);

    /**
     * 根据主键获取物品信息
     * @param uuid UUID
     * @return 物品信息
     */
    Goods getByPrimaryKey(@Param("uuid") String uuid);


}