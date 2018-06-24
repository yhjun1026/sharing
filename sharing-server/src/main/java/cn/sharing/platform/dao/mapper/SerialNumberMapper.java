package cn.sharing.platform.dao.mapper;

import cn.sharing.dao.entity.SerialNumber;
import cn.sharing.dao.entity.SerialNumberExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface SerialNumberMapper {
    long countByExample(SerialNumberExample example);

    int deleteByExample(SerialNumberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SerialNumber record);

    int insertSelective(SerialNumber record);

    List<SerialNumber> selectByExampleWithRowbounds(SerialNumberExample example, RowBounds rowBounds);

    List<SerialNumber> selectByExample(SerialNumberExample example);

    SerialNumber selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SerialNumber record, @Param("example") SerialNumberExample example);

    int updateByExample(@Param("record") SerialNumber record, @Param("example") SerialNumberExample example);

    int updateByPrimaryKeySelective(SerialNumber record);

    int updateByPrimaryKey(SerialNumber record);

    Long sumByExample(SerialNumberExample example);

    void batchInsert(@Param("items") List<SerialNumber> items);
}