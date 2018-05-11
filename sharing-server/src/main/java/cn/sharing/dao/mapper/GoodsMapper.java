package cn.sharing.dao.mapper;

import cn.sharing.dao.entity.Goods;
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
     * @param goods 物品信息
     * @return
     */
    int delete(Goods goods);

    /**
     * 分页查询所有可租用的物品
     * @param rowBounds 分页信息
     * @return
     */
    List<Goods> getAllRentGoods(RowBounds rowBounds);

    /**
     * 所有可租用物品的数量
     * @return
     */
    int getAllRentGoodsCount();

}