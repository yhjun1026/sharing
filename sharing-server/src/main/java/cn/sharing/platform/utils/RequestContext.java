package cn.sharing.platform.utils;

import lombok.Data;

import java.util.Date;

/**
 * 请求上下文
 * @author yanghongjun
 * @email yanghongjun@hd123.com
 * @time 2017年12月12日 下午4:59:58
 * @description 
 */
@Data
public class RequestContext {

	private String appId;

	private long timestamp;

	private String sign;
	
	private String orgCode;

	private String traceId;

	private Date beginTime = new Date();

	private Date endTime;

	private String url;

}
