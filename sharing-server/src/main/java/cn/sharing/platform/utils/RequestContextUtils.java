package cn.sharing.platform.utils;

/**
 * 请求上下文工具类
 * @author yanghongjun
 * @email yanghongjun@hd123.com
 * @time 2017年12月12日 下午4:59:58
 * @description
 */
public class RequestContextUtils {

	private final static ThreadLocal<RequestContext> requestContextThreadLocal = new ThreadLocal<>();

	/**
	 * 设置请求上下文
	 * @param requestContext
	 */
	public static void setRequestContext(RequestContext requestContext) {
		requestContextThreadLocal.set(requestContext);
	}
	
	/**
	 * 获取请求上下文, 过滤NullPointerException
	 * @return
	 */
	public static RequestContext getRequestContext() {
		RequestContext requestContext = requestContextThreadLocal.get();
		return null != requestContext ? requestContext : new RequestContext();
	}

	public static String getTraceId() {
		return getRequestContext().getTraceId();
	}

	public static void setTraceId(String traceId) {
		getRequestContext().setTraceId(traceId);
	}


	public static String getOrgCode() {
		return getRequestContext().getOrgCode();
	}

	public static void setOrgCode(String orgCode) {
		getRequestContext().setOrgCode(orgCode);
	}

	
	public static String getAppId() {
		return getRequestContext().getAppId();
	}
	
	public static void setAppId(String appId) {
		getRequestContext().setAppId(appId);
	}

	public static long getTimestamp() {
		return getRequestContext().getTimestamp();
	}

	public static void setTimestamp(long timestamp) {
		getRequestContext().setTimestamp(timestamp);
	}

	public static String getSign() {
		return getRequestContext().getSign();
	}

	public static void setSign(String token) {
		getRequestContext().setSign(token);
	}
	public static void remove() {
		requestContextThreadLocal.remove();
	}

}
