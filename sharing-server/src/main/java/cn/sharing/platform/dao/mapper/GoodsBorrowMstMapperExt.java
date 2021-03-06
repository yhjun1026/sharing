package cn.sharing.platform.dao.mapper;

import cn.sharing.platform.dao.entity.GoodsBorrowMst;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by zenglin on 2018/5/10.
 */
public interface GoodsBorrowMstMapperExt {
  int updatePayInfo(@Param("borrowId") String borrowId,
                    @Param("payId") String payId);
  int updateRefundInfo(@Param("borrowId") String borrowId,
                    @Param("refundId") String payId);

  int updateOrderState(@Param("borrowId") String borrowId,
                       @Param("state") String state);

  List<GoodsBorrowMst> queryGoodsBorrowMst(@Param("storeId") String storeId,
                                           @Param("beginTime") Date beginTime,
                                           @Param("endTime") Date endTime,
                                           @Param("goodsCode") String goodsCode,
                                           @Param("goodsName") String goodsName,
                                           @Param("mobile") String mobile,
                                           @Param("stats") List<String> stats);
}
