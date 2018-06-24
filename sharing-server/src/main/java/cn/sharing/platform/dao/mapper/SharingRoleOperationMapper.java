package cn.sharing.platform.dao.mapper;

import cn.sharing.dao.entity.SharingRoleOperation;
import cn.sharing.dao.entity.SharingRoleOperationExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SharingRoleOperationMapper {
    long countByExample(SharingRoleOperationExample example);

    int deleteByExample(SharingRoleOperationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SharingRoleOperation record);

    int insertSelective(SharingRoleOperation record);

    List<SharingRoleOperation> selectByExampleWithRowbounds(SharingRoleOperationExample example, RowBounds rowBounds);

    List<SharingRoleOperation> selectByExample(SharingRoleOperationExample example);

    SharingRoleOperation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SharingRoleOperation record, @Param("example") SharingRoleOperationExample example);

    int updateByExample(@Param("record") SharingRoleOperation record, @Param("example") SharingRoleOperationExample example);

    int updateByPrimaryKeySelective(SharingRoleOperation record);

    int updateByPrimaryKey(SharingRoleOperation record);

    Long sumByExample(SharingRoleOperationExample example);

    void batchInsert(@Param("items") List<SharingRoleOperation> items);
}