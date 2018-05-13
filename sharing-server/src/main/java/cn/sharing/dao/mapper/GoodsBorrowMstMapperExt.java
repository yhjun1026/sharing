package cn.sharing.dao.mapper;

import cn.sharing.dao.entity.GoodsBorrowMst;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by zenglin on 2018/5/10.
 */
public interface GoodsBorrowMstMapperExt {

  List<GoodsBorrowMst> queryGoodsBorrowMst(@Param("storeId")String storeId,
                                           @Param("beginTime") Date beginTime,
                                           @Param("endTime") Date endTime,
                                           @Param("goodsCode") String goodsCode,
                                           @Param("goodsName") String goodsName,
                                           @Param("mobile") String mobile,
                                           @Param("stat") String stat);
}
