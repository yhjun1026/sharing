package cn.sharing.dao.mapper;

import cn.sharing.dao.entity.GoodsBorrowDtl;
import cn.sharing.dao.entity.GoodsBorrowDtlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GoodsBorrowDtlMapper {
    long countByExample(GoodsBorrowDtlExample example);

    int deleteByExample(GoodsBorrowDtlExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(GoodsBorrowDtl record);

    int insertSelective(GoodsBorrowDtl record);

    List<GoodsBorrowDtl> selectByExampleWithRowbounds(GoodsBorrowDtlExample example, RowBounds rowBounds);

    List<GoodsBorrowDtl> selectByExample(GoodsBorrowDtlExample example);

    GoodsBorrowDtl selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") GoodsBorrowDtl record, @Param("example") GoodsBorrowDtlExample example);

    int updateByExample(@Param("record") GoodsBorrowDtl record, @Param("example") GoodsBorrowDtlExample example);

    int updateByPrimaryKeySelective(GoodsBorrowDtl record);

    int updateByPrimaryKey(GoodsBorrowDtl record);

    Long sumByExample(GoodsBorrowDtlExample example);

    void batchInsert(@Param("items") List<GoodsBorrowDtl> items);
}