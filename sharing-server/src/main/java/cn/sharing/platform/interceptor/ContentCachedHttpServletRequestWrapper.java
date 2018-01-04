package cn.sharing.platform.interceptor;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 缓存content的request包装类
 * 
 * @author caohaihong
 * @time 2017年5月6日 下午4:57:47
 * @description
 */
public class ContentCachedHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private byte[] requestBody = null;

	public ContentCachedHttpServletRequestWrapper(HttpServletRequest request) {

		super(request);

		try {
			requestBody = StreamUtils.copyToByteArray(request.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		if (requestBody == null) {
			requestBody = new byte[0];
		}
		final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
		return new ServletInputStream() {
			@Override
			public int read() throws IOException {
				return bais.read();
			}

			@Override
			public boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isReady() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setReadListener(ReadListener readListener) {
				// TODO Auto-generated method stub
				
			}
		};
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	/**
	 * 组装request header
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, String> getRequestHeader() {
		Enumeration<String> headerNames = this.getHeaderNames();
		Map<String, String> headerMap = new HashMap<>();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			headerMap.put(headerName, this.getHeader(headerName));
		}
		return headerMap;
	}

	/**
	 * 组装request attribute
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, Object> getRequestAttr() {
		Enumeration<String> attributeNames = this.getAttributeNames();
		Map<String, Object> attrMap = new HashMap<>();
		while (attributeNames.hasMoreElements()) {
			String headerName = (String) attributeNames.nextElement();
			attrMap.put(headerName, this.getAttribute(headerName));
		}
		return attrMap;
	}

	/**
	 * 组装request param
	 * 
	 * @param request
	 * @return
	 */
	private Map<String, String> getRequestParam() {
		Map<String, String> paramMap = new HashMap<>();
		Map<String, String[]> map = this.getParameterMap();
		Iterator<Map.Entry<String, String[]>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String[]> entry = iterator.next();
			paramMap.put(entry.getKey(), Arrays.asList(entry.getValue()).toString());
		}
		return paramMap;
	}

	/**
	 * 组装request body
	 * 
	 * @param request
	 * @return
	 */
	private String getRequestBody() {
		BufferedReader in;
		StringBuffer buffer = new StringBuffer();
		try {
			in = getReader();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/* 
	 * 重写toString(),方便日志输出
	 */
	@Override
	public String toString() {
		StringBuffer requestBuffer = new StringBuffer();
		requestBuffer.append("requestUrl:").append(getRequestURL()).append("header:").append(getRequestHeader())
				.append("param:").append(getRequestParam()).append("attributes:").append(getRequestAttr())
				.append("body:").append(getRequestBody());

		return requestBuffer.toString();
	}

}
