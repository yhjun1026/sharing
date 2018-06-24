package cn.sharing.platform.utils;

import cn.sharing.platform.service.serialnumber.SerialNumberImpl;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangjun on 2017/3/24.
 */
@Component
@Slf4j
public class SerialNumberUtil {

  @Autowired
  SerialNumberImpl serialNumberService;

  private static int retryCounts = 3;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public List<String> generateNumber(@ApiParam(value = "业务code") String businessCode, @ApiParam(value = "序列位数") Integer
					bitNum, @ApiParam(value = "生成序列个数") Integer num) throws InterruptedException {

    List<String> numbers = new ArrayList<>();

/*		Integer dbNum = serialNumberService.queryByCode(tenantId, orgCode, businessCode,
				DateUtil.getCurrentDateByPattern(DateUtil.DAY_FORMAT));*/

    Long id = serialNumberService.queryIdByCode(businessCode, DateUtil.getCurrentDateByPattern(DateUtil.DAY_FORMAT));

    Integer dbNum = null;
    if (id != null) {
      dbNum = serialNumberService.queryById(id);
    }


    if (dbNum == null) {
      int currentNum = 0;
      for (int i = 1; i <= num; i++) {
        if (hasExceed(bitNum, currentNum, i)) {
          log.error("生成序列号失败，数字超过范围");
          return null;
        }
        numbers.add(DateUtil.getTodayStr() + getPrefix2(bitNum, currentNum, i));
      }

      try {
        serialNumberService.insert(num + "", businessCode, DateUtil.getCurrentDateByPattern(DateUtil.DAY_FORMAT));
      } catch (Exception e) {
        log.error("生成序列号失败，" + e.getMessage());
        return null;
      }
      return numbers;
    } else {
      for (int i = 1; i <= num; i++) {
        if (hasExceed(bitNum, dbNum, i)) {
          log.error("生成序列号失败，数字超过范围");
          return null;
        }
        numbers.add(DateUtil.getTodayStr() + getPrefix2(bitNum, dbNum, i));
      }

      int count = serialNumberService.updateBySourceNum(businessCode, dbNum + num, dbNum, DateUtil
							.getCurrentDateByPattern(DateUtil.DAY_FORMAT));
      if (count == 0) {
        // 失败重试
        for (int times = 0; times < retryCounts; times++) {
          Thread.sleep(50);
          Integer dbNumAgain = serialNumberService.queryByCode(businessCode, DateUtil.getCurrentDateByPattern(DateUtil.DAY_FORMAT));
          for (int i = 1; i <= num; i++) {
            if (hasExceed(bitNum, dbNumAgain, i)) {
              log.error("生成序列号失败，数字超过范围");
              return null;
            }
            numbers.add(DateUtil.getTodayStr() + getPrefix2(bitNum, dbNumAgain, i));
          }

          int countAgain = serialNumberService.updateBySourceNum(businessCode, dbNumAgain + num,
									dbNumAgain, DateUtil.getCurrentDateByPattern(DateUtil.DAY_FORMAT));
          if (countAgain == 1) {
            break;
          } else {
            if (times == 2) {
              log.error("生成序列号失败");
              return null;
            }
          }
        }

      }
    }
    return numbers;
  }

  private boolean hasExceed(Integer bitNum, Integer currentNum, Integer addNum) {
    boolean hasExceed = false;
    String strCurrent = "" + currentNum;
    if (strCurrent.length() > bitNum) {
      hasExceed = true;
    } else {
      strCurrent = (currentNum + addNum) + "";
      if (strCurrent.length() > bitNum) {
        hasExceed = true;
      }
    }
    return hasExceed;
  }

  private String getPrefix(Integer bitNum, Integer currentNum, Integer addNum) {
    StringBuffer result = new StringBuffer("");
    String strCurrent = "" + currentNum;
    Integer sum = currentNum % 10 + addNum;
    Integer mold = sum / 10;
    Integer length = strCurrent.length();
    if ((length + mold) == bitNum) {
    } else {
      for (int j = 0; j < (bitNum - length - mold); j++) {
        result.append("0");
      }
      result.append((currentNum + addNum));
    }
    return result.toString();

  }

  private String getPrefix2(Integer bitNum, Integer currentNum, Integer addNum) {
    StringBuffer result = new StringBuffer("");
    Integer sum = currentNum + addNum;
    Integer length = sum.toString().length();
    if (length.floatValue() >= bitNum.floatValue()) {
      result.append(sum);
    } else {
      for (int j = 0; j < (bitNum - length); j++) {
        result.append("0");
      }
      result.append(sum);
    }
    return result.toString();

  }

}
