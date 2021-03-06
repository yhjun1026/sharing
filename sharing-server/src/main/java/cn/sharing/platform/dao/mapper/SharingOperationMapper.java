package cn.sharing.platform.dao.mapper;

import cn.sharing.platform.dao.entity.SharingOperation;
import cn.sharing.platform.dao.entity.SharingOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SharingOperationMapper {
    long countByExample(SharingOperationExample example);

    int deleteByExample(SharingOperationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SharingOperation record);

    int insertSelective(SharingOperation record);

    List<SharingOperation> selectByExampleWithRowbounds(SharingOperationExample example, RowBounds rowBounds);

    List<SharingOperation> selectByExample(SharingOperationExample example);

    SharingOperation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SharingOperation record, @Param("example") SharingOperationExample example);

    int updateByExample(@Param("record") SharingOperation record, @Param("example") SharingOperationExample example);

    int updateByPrimaryKeySelective(SharingOperation record);

    int updateByPrimaryKey(SharingOperation record);

    Long sumByExample(SharingOperationExample example);

    void batchInsert(@Param("items") List<SharingOperation> items);
}