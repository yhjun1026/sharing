package cn.sharing.platform.service.serialnumber;

import cn.sharing.platform.dao.entity.SerialNumber;
import cn.sharing.platform.dao.mapper.SerialNumberMapper;
import cn.sharing.platform.dao.mapper.SerialNumberMapperExt;
import cn.sharing.platform.utils.DateUtil;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 序列号服务
 * 
 * @author Administrator
 *
 */
@Component
public class SerialNumberImpl {

	@Autowired
	SerialNumberMapper serialNumberMapper;
	@Autowired
	SerialNumberMapperExt serialNumberMapperExt;

	public void insert(String num, String businessCode, String day) {
		SerialNumber serialNumber = new SerialNumber();
		serialNumber.setBusinessCode(businessCode);
		serialNumber.setDay(DateUtil.getDateByPattern(day, DateUtil.DAY_FORMAT));
		serialNumber.setNum(Integer.valueOf(num));
		serialNumber.setUpdateTime(new Date());
		serialNumber.setCreateTime(new Date());
		serialNumberMapper.insert(serialNumber);
	}

	public Integer queryByCode(String businessCode, String day) {
		// TODO Auto-generated method stub
		return serialNumberMapperExt.queryByCode(businessCode, DateUtil.getDateByPattern(day, DateUtil.DAY_FORMAT));
	}

	public Long queryIdByCode(String businessCode, String day) {
		return serialNumberMapperExt.queryIdByCode(businessCode, DateUtil.getDateByPattern(day, DateUtil.DAY_FORMAT));
	}

	public Integer queryById(@Param("id") Long id) {
		return serialNumberMapperExt.queryById(id);
	}

	public int updateBySourceNum(String businessCode, Integer num, Integer sourceNum,
			String day) {
		// TODO Auto-generated method stub
		return serialNumberMapperExt.updateByCodeAndSourceNum(businessCode, num, sourceNum,
				DateUtil.getDateByPattern(day, DateUtil.DAY_FORMAT));
	}

}
