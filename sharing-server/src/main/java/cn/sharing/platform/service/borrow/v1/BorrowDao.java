package cn.sharing.platform.service.borrow.v1;

import cn.sharing.dao.entity.GoodsBorrowDtlExample;
import cn.sharing.dao.mapper.GoodsBorrowMstMapperExt;
import cn.sharing.platform.common.BorrowStatEnum;
import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.facade.borrow.v1.BorrowDetailInfoDto;
import cn.sharing.platform.facade.borrow.v1.BorrowParam;
import cn.sharing.platform.facade.borrow.v1.BorrowQuery;
import cn.sharing.platform.facade.borrow.v1.BorrowSummaryDto;
import cn.sharing.platform.facade.borrow.v1.Custom;
import cn.sharing.platform.facade.borrow.v1.PreCompensateGoodsParam;
import cn.sharing.platform.facade.borrow.v1.PreCompensateParam;
import cn.sharing.platform.facade.borrow.v1.SBorrowDtl;
import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import cn.sharing.platform.utils.DateUtil;
import cn.sharing.platform.utils.SerialNumberUtil;
import cn.sharing.dao.entity.GoodsBorrowDtl;
import cn.sharing.dao.entity.GoodsBorrowMst;
import cn.sharing.dao.entity.PayInfo;
import cn.sharing.dao.mapper.GoodsBorrowDtlMapper;
import cn.sharing.dao.mapper.GoodsBorrowMstMapper;
import cn.sharing.dao.mapper.PayInfoMapper;
import cn.sharing.platform.utils.StringUtils;
import cn.sharing.platform.utils.UUIDGenerator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.xml.internal.rngom.digested.DAttributePattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zenglin on 2018/5/6.
 */
@Component
@Slf4j
public class BorrowDao {

  @Autowired
  private PayInfoMapper payInfoMapper;

  @Autowired
  private GoodsBorrowDtlMapper goodsBorrowDtlMapper;

  @Autowired
  private GoodsBorrowMstMapper goodsBorrowMstMapper;

  @Autowired
  private SerialNumberUtil serialNumberUtil;

  @Autowired
  private GoodsBorrowMstMapperExt goodsBorrowMstMapperExt;

  @Transactional
  public String saveBorrow(BorrowParam param) {
    //1.更新物品状态
    //2.记录支付信息
    //3.记录借用单表
    String mstUuid = UUIDGenerator.getUUID();
    for (SBorrowDtl dtl : param.getGoodsDtl()) {
      //更新物品状态
      // TODO: 2018/5/10

      GoodsBorrowDtl borrowDtl = convertFromBorrowDtl(dtl);
      borrowDtl.setBorrowUuid(mstUuid);

      goodsBorrowDtlMapper.insert(borrowDtl);
    }

    //记录支付信息
    String payUuid = null;
    if (param.getPayInfo() != null) {
      payUuid = UUIDGenerator.getUUID();
      PayInfo payInfo = convertFromPayInfoParam(param.getPayInfo());
      payInfo.setUuid(payUuid);
      payInfoMapper.insert(payInfo);
    }
    List<String> billNumbers = null;
    try {
      billNumbers = serialNumberUtil.generateNumber("JY", 6, 1);
    } catch (Exception e) {
      log.error("【新增租用单】生成单据号异常，" + e.getMessage());
      throw new RuntimeException("生成单据号异常，" + e.getMessage());
    }
    if (billNumbers == null || billNumbers.size() == 0) {
      throw new RuntimeException("生成单据号失败");
    }

    GoodsBorrowMst borrowMst = convertFromBorrowParam(param);
    borrowMst.setUuid(mstUuid);
    borrowMst.setStat(BorrowStatEnum.NEW.getCode());
    borrowMst.setBillNumber(billNumbers.get(0));
    borrowMst.setLstUpdTime(new Date());
    goodsBorrowMstMapper.insert(borrowMst);

    return mstUuid;
  }

  @Transactional
  public void collar(String borrowId, String dealer){
    //1.更新物品状态
    // TODO: 2018/5/10  
    //2.更新领用单领用受理人，领用受理时间，最后修改时间
    GoodsBorrowMst goodsBorrowMst = goodsBorrowMstMapper.selectByPrimaryKey(borrowId);
    goodsBorrowMst.setStat(BorrowStatEnum.USING.getCode());
    goodsBorrowMst.setLstUpdTime(new Date());
    goodsBorrowMst.setBorrowDealer(dealer);
    goodsBorrowMst.setBorrowDealTime(new Date());
    goodsBorrowMstMapper.updateByPrimaryKeySelective(goodsBorrowMst);
  }

  @Transactional
  public void preCompensate(PreCompensateParam compensateParam) {
    for (PreCompensateGoodsParam item : compensateParam.getCompensateGoods()) {
      GoodsBorrowDtlExample example = new GoodsBorrowDtlExample();
      GoodsBorrowDtlExample.Criteria criteria = example.createCriteria();
      criteria.andBorrowUuidEqualTo(compensateParam.getBorrowId());
      criteria.andGoodsUuidEqualTo(item.getGoodsUuid());
      List<GoodsBorrowDtl> borrowDtls = goodsBorrowDtlMapper.selectByExample(example);
      if (borrowDtls == null || borrowDtls.size() == 0) {
        throw new RuntimeException("未找到对应的物品借用信息.");
      }
      GoodsBorrowDtl borrowDtl = borrowDtls.get(0);
      borrowDtl.setCompensateAmt(item.getAmt());
      goodsBorrowDtlMapper.updateByPrimaryKeySelective(borrowDtl);
    }
  }

  @Transactional
  public void back(String borrowId, String backDealer, PayInfoParam payInfoParam) {
    //更新物品状态
    // TODO: 2018/5/10  
    String uuid = null;
    if (payInfoParam != null) {
      PayInfo payInfo = convertFromPayInfoParam(payInfoParam);
      uuid = UUIDGenerator.getUUID();
      payInfo.setUuid(uuid);
      payInfoMapper.insert(payInfo);
    }
    GoodsBorrowMst goodsBorrowMst = goodsBorrowMstMapper.selectByPrimaryKey(borrowId);
    goodsBorrowMst.setStat(BorrowStatEnum.BACKED.getCode());
    goodsBorrowMst.setBackDealer(backDealer);
    goodsBorrowMst.setBackDealTime(new Date());
    goodsBorrowMst.setLstUpdTime(new Date());
    goodsBorrowMst.setBackPayUuid(uuid);
    goodsBorrowMstMapper.updateByPrimaryKeySelective(goodsBorrowMst);
  }

  @Transactional
  public void compensate(String borrowId, PayInfoParam payInfoParam) {
    //更新物品状态
    // TODO: 2018/5/10
    String uuid = UUIDGenerator.getUUID();
    PayInfo payInfo = convertFromPayInfoParam(payInfoParam);
    payInfo.setUuid(uuid);
    payInfoMapper.insert(payInfo);

    GoodsBorrowMst goodsBorrowMst = goodsBorrowMstMapper.selectByPrimaryKey(borrowId);
    goodsBorrowMst.setStat(BorrowStatEnum.COMPENSATED.getCode());
    goodsBorrowMst.setLstUpdTime(new Date());
    goodsBorrowMst.setCompensatePayUuid(uuid);
    goodsBorrowMstMapper.updateByPrimaryKeySelective(goodsBorrowMst);
  }

  public BorrowDetailInfoDto get(String uuid) {
    GoodsBorrowMst goodsBorrowMst = goodsBorrowMstMapper.selectByPrimaryKey(uuid);
    if (goodsBorrowMst == null) {
      return null;
    }
    BorrowDetailInfoDto detailInfoDto = convertDetailDtoFromMst(goodsBorrowMst);

    //明细信息
    GoodsBorrowDtlExample example = new GoodsBorrowDtlExample();
    GoodsBorrowDtlExample.Criteria criteria = example.createCriteria();
    criteria.andBorrowUuidEqualTo(uuid);
    List<GoodsBorrowDtl> dtls = goodsBorrowDtlMapper.selectByExample(example);
    List<SBorrowDtl> goodsDtl = new ArrayList<>();
    for (GoodsBorrowDtl dtl : dtls) {
      goodsDtl.add(convertSBorrowDtlFromDtl(dtl));
    }
    detailInfoDto.setGoodsDtl(goodsDtl);

    //租用付款信息
    if (!StringUtils.isEmpty(goodsBorrowMst.getBorrowPayUuid())) {
      PayInfo borrowPayInfo = payInfoMapper.selectByPrimaryKey(goodsBorrowMst.getBorrowPayUuid());
      detailInfoDto.setBorrowPayInfo(converPayInfoParamFromPayInfo(borrowPayInfo));
    }
    //押金退还付款信息
    if (!StringUtils.isEmpty(goodsBorrowMst.getBackPayUuid())) {
      PayInfo backPayInfo = payInfoMapper.selectByPrimaryKey(goodsBorrowMst.getBackPayUuid());
      detailInfoDto.setBackPayInfo(converPayInfoParamFromPayInfo(backPayInfo));
    }
    //赔偿付款信息
    if (!StringUtils.isEmpty(goodsBorrowMst.getCompensatePayUuid())) {
      PayInfo compensatePayInfo = payInfoMapper.selectByPrimaryKey(goodsBorrowMst.getCompensatePayUuid());
      detailInfoDto.setCompensatePayInfo(converPayInfoParamFromPayInfo(compensatePayInfo));
    }

    return detailInfoDto;
  }

  public QueryResult<BorrowSummaryDto> query(BorrowQuery param) {
    Page<GoodsBorrowMst> page = pageBorrowGoodsMst(param);
    List<GoodsBorrowMst> goodsBorrowMsts = page.getResult();
    List<BorrowSummaryDto> lstDto = new ArrayList<>();
    for (GoodsBorrowMst item : goodsBorrowMsts) {
      BorrowSummaryDto summaryDto = convertDetailDtoFromMst(item);
      //明细信息
      GoodsBorrowDtlExample example = new GoodsBorrowDtlExample();
      GoodsBorrowDtlExample.Criteria criteria = example.createCriteria();
      criteria.andBorrowUuidEqualTo(item.getUuid());
      List<GoodsBorrowDtl> dtls = goodsBorrowDtlMapper.selectByExample(example);
      List<SBorrowDtl> goodsDtl = new ArrayList<>();
      for (GoodsBorrowDtl dtl : dtls) {
        goodsDtl.add(convertSBorrowDtlFromDtl(dtl));
      }
      summaryDto.setGoodsDtl(goodsDtl);

      lstDto.add(summaryDto);
    }

    QueryResult<BorrowSummaryDto> result = new QueryResult<>();
    result.setItem(lstDto);
    result.setPage(page.getPageNum());
    result.setPageSize(page.getPageSize());
    result.setTotalCount(page.getTotal());

    return result;
  }

  //将参数的物品明细转换成数据库对象
  private GoodsBorrowDtl convertFromBorrowDtl(SBorrowDtl param) {
    if (param == null) {
      return null;
    }

    GoodsBorrowDtl borrowDtl = new GoodsBorrowDtl();
    BeanUtils.copyProperties(param, borrowDtl);
    borrowDtl.setUuid(UUIDGenerator.getUUID());

    return borrowDtl;
  }

  //将参数的付款信息转化成数据库对象
  private PayInfo convertFromPayInfoParam(PayInfoParam payInfoParam) {
    if (payInfoParam == null) {
      return null;
    }

    PayInfo payInfo = new PayInfo();
    BeanUtils.copyProperties(payInfoParam, payInfo);
    payInfo.setPayTime(DateUtil.getDateByPattern(payInfoParam.getPayTime(), DateUtil.DEFAULT_FORMAT));

    return payInfo;
  }

  //将参数的租用单信息转换成数据库对象
  private GoodsBorrowMst convertFromBorrowParam(BorrowParam borrowParam) {
    if (borrowParam == null) {
      return null;
    }
//    GoodsBorrowMst borrowMst = new GoodsBorrowMst();
//    borrowMst.setStat(BorrowStatEnum.NEW.getCode());
//    borrowMst.setBorrower(borrowParam.getCustom().getNick());
//    borrowMst.setMobile(borrowParam.getCustom().getPhoneNumber());
//    borrowMst.setAddress(borrowParam.getCustom().getAddress());
//    borrowMst.setPlanReturnTime(DateUtil.getDateByPattern(borrowParam.getReturnTime(), DateUtil.DEFAULT_FORMAT));
//    borrowMst.setCreateTime(new Date());
//    borrowMst.setLstUpdTime(new Date());
//    borrowMst.setMemo(borrowParam.getMemo());

    return null;
  }

  //将数据库的租用单转换成输出对象
  private BorrowDetailInfoDto convertDetailDtoFromMst(GoodsBorrowMst mst) {
    if (mst == null) {
      return null;
    }

    BorrowDetailInfoDto detailInfoDto = new BorrowDetailInfoDto();
    BeanUtils.copyProperties(mst, detailInfoDto);
    if (mst.getPlanBackTime() != null) {
      detailInfoDto.setPlanBackTime(DateUtil.dateToString(mst.getPlanBackTime(), DateUtil.DEFAULT_FORMAT));
    }
    if (mst.getRealBackTime() != null) {
      detailInfoDto.setRealBackTime(DateUtil.dateToString(mst.getRealBackTime(), DateUtil.DEFAULT_FORMAT));
    }
    if (mst.getBorrowDealTime() != null) {
      detailInfoDto.setBorrowDealTime(DateUtil.dateToString(mst.getBorrowDealTime(), DateUtil.DEFAULT_FORMAT));
    }
    if (mst.getBackDealTime() != null) {
      detailInfoDto.setBackDealTime(DateUtil.dateToString(mst.getBackDealTime(), DateUtil.DEFAULT_FORMAT));
    }
    if (mst.getCreateTime() != null) {
      detailInfoDto.setCreateTime(DateUtil.dateToString(mst.getCreateTime(), DateUtil.DEFAULT_FORMAT));
    }
    if (mst.getLstUpdTime() != null) {
      detailInfoDto.setLstUpdTime(DateUtil.dateToString(mst.getLstUpdTime(), DateUtil.DEFAULT_FORMAT));
    }
    Custom custom = new Custom();
    custom.setAddress(mst.getAddress());
    custom.setMobile(mst.getMobile());
    custom.setNick(mst.getBorrower());
    detailInfoDto.setCustom(custom);

    return detailInfoDto;
  }

  //将数据库的租用单物品明细转换成输出对象
  private SBorrowDtl convertSBorrowDtlFromDtl(GoodsBorrowDtl dtl) {
    if (dtl == null) {
      return null;
    }
    SBorrowDtl borrowDtl = new SBorrowDtl();
    BeanUtils.copyProperties(dtl, borrowDtl);

    return borrowDtl;
  }

  //将数据库的付款对象转换成输出对象
  private PayInfoParam converPayInfoParamFromPayInfo(PayInfo payInfo) {
    if (payInfo == null) {
      return null;
    }

    PayInfoParam payInfoParam = new PayInfoParam();
    BeanUtils.copyProperties(payInfo, payInfoParam);
    if (payInfo.getPayTime() != null) {
      payInfoParam.setPayTime(DateUtil.dateToString(payInfo.getPayTime(), DateUtil.DEFAULT_FORMAT));
    }

    return payInfoParam;
  }

  private Page<GoodsBorrowMst> pageBorrowGoodsMst(BorrowQuery param) {
    Date beginTime = null;
    Date endTime = null;
    if (!StringUtils.isEmpty(param.getBeginTime())) {
      beginTime = DateUtil.getDateByPattern(param.getBeginTime(), DateUtil.DEFAULT_FORMAT);
    }
    if (!StringUtils.isEmpty(param.getEndTime())) {
      endTime = DateUtil.getDateByPattern(param.getEndTime(), DateUtil.DEFAULT_FORMAT);
    }
    String stat = null;
    if (param.getBorrowType() == 1) {
      stat = BorrowStatEnum.NEW.getCode();
    } else if (param.getBorrowType() == 2) {
      stat = BorrowStatEnum.USING.getCode();
    } else if (param.getBorrowType() == 3) {
      stat = BorrowStatEnum.BACKED.getCode();
    } else if (param.getBorrowType() == 4) {
      stat = BorrowStatEnum.COMPENSATED.getCode();
    }
    Page<GoodsBorrowMst> page = PageHelper.startPage((param.getPage() - 1) * param.getPageSize(), param.getPageSize(), true);
    goodsBorrowMstMapperExt.queryGoodsBorrowMst(param.getStoreId(), beginTime, endTime, param.getGoodsName(), stat);
    return page;
  }
}
