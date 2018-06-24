package cn.sharing.platform.dao.mapper;

import cn.sharing.platform.dao.entity.SharingMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zenglin on 2018/5/16.
 */
public interface SharingMenuMapperExt {
  List<SharingMenu> selectMenuByUserType(@Param("userType") String userType);

  List<String> selectOptionByUserType(@Param("userType") String userType);
}
