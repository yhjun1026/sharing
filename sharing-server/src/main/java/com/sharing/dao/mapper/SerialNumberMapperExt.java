package com.sharing.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SerialNumberMapperExt {

	int updateByCodeAndSourceNum(@Param("businessCode") String businessCode, @Param("num") Integer num, @Param("sourceNum") Integer sourceNum,
															 @Param("day") Date day);

	Integer queryByCode(@Param("businessCode") String businessCode, @Param("day") Date day);

	/**
	 * 获取主键id
	 * @param businessCode	业务编码
	 * @param day		日期
	 * @return	主键id
   */
	Long queryIdByCode(@Param("businessCode") String businessCode, @Param("day") Date day);

	/**
	 * 根据id查询单据号条数，为了加锁用
	 * @param id  主键id
	 * @return	单据号条数
   */
	Integer queryById(@Param("id") Long id);

}