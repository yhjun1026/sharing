package cn.sharing.platform.dao.mapper;

import cn.sharing.dao.entity.PayInfo;
import cn.sharing.dao.entity.PayInfoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface PayInfoMapper {
    long countByExample(PayInfoExample example);

    int deleteByExample(PayInfoExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(PayInfo record);

    int insertSelective(PayInfo record);

    List<PayInfo> selectByExampleWithRowbounds(PayInfoExample example, RowBounds rowBounds);

    List<PayInfo> selectByExample(PayInfoExample example);

    PayInfo selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") PayInfo record, @Param("example") PayInfoExample example);

    int updateByExample(@Param("record") PayInfo record, @Param("example") PayInfoExample example);

    int updateByPrimaryKeySelective(PayInfo record);

    int updateByPrimaryKey(PayInfo record);

    Long sumByExample(PayInfoExample example);

    void batchInsert(@Param("items") List<PayInfo> items);
}