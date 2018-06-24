package cn.sharing.platform.dao.mapper;

import cn.sharing.dao.entity.SharingMenu;
import cn.sharing.dao.entity.SharingMenuExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SharingMenuMapper {
    long countByExample(SharingMenuExample example);

    int deleteByExample(SharingMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SharingMenu record);

    int insertSelective(SharingMenu record);

    List<SharingMenu> selectByExampleWithRowbounds(SharingMenuExample example, RowBounds rowBounds);

    List<SharingMenu> selectByExample(SharingMenuExample example);

    SharingMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SharingMenu record, @Param("example") SharingMenuExample example);

    int updateByExample(@Param("record") SharingMenu record, @Param("example") SharingMenuExample example);

    int updateByPrimaryKeySelective(SharingMenu record);

    int updateByPrimaryKey(SharingMenu record);

    Long sumByExample(SharingMenuExample example);

    void batchInsert(@Param("items") List<SharingMenu> items);
}