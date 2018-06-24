package cn.sharing.platform.dao.mapper;

import cn.sharing.platform.dao.entity.GoodsBorrowMst;
import cn.sharing.platform.dao.entity.GoodsBorrowMstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GoodsBorrowMstMapper {
    long countByExample(GoodsBorrowMstExample example);

    int deleteByExample(GoodsBorrowMstExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(GoodsBorrowMst record);

    int insertSelective(GoodsBorrowMst record);

    List<GoodsBorrowMst> selectByExampleWithRowbounds(GoodsBorrowMstExample example, RowBounds rowBounds);

    List<GoodsBorrowMst> selectByExample(GoodsBorrowMstExample example);

    GoodsBorrowMst selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") GoodsBorrowMst record, @Param("example") GoodsBorrowMstExample example);

    int updateByExample(@Param("record") GoodsBorrowMst record, @Param("example") GoodsBorrowMstExample example);

    int updateByPrimaryKeySelective(GoodsBorrowMst record);

    int updateByPrimaryKey(GoodsBorrowMst record);

    Long sumByExample(GoodsBorrowMstExample example);

    void batchInsert(@Param("items") List<GoodsBorrowMst> items);
}