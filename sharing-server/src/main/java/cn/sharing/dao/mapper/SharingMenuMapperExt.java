package cn.sharing.dao.mapper;

import cn.sharing.dao.entity.SharingMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zenglin on 2018/5/16.
 */
public interface SharingMenuMapperExt {
  List<SharingMenu> selectMenuByUserType(@Param("userType") String userType);
}