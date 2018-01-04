package cn.sharing.platform.exception;

import com.qianfan123.sailing.open.api.ResponseResult;
import com.qianfan123.sailing.open.api.ReturnCodeEnum;
import com.qianfan123.sailing.open.server.utils.JsonHelper;
import com.qianfan123.sailing.open.server.utils.RequestContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Terence on 2017/3/24.
 */
@ControllerAdvice
public class DefaultExceptionHandler {

	private static final String UTF8 = "UTF-8";
	private static final String RESPONSE_CONTENT_TYPE = "text/json;charset=UTF-8";

	private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);


	@ExceptionHandler(OpenApiException.class)
	public void procesOpenApiException(HttpServletResponse response, OpenApiException se) {
		response.setCharacterEncoding(UTF8);
		response.setContentType(RESPONSE_CONTENT_TYPE);
		response.setStatus(HttpStatus.OK.value());
		PrintWriter writer = null;
		try {
			ResponseResult<String> resp = new ResponseResult<String>();
			resp.setStatus(se.getCode());
			resp.setMessage(se.getMessage());
			writer = response.getWriter();
			writer.write(JsonHelper.toJsonWithoutNull(resp));
			log.error(" error msg:{}, exception:{}", se.getMessage(), se);
		} catch (IOException e) {
			log.error("exception:{}", e);
		} finally {
			if (null != writer) {
				writer.close();
			}
		}
	}


	@ExceptionHandler(BindException.class)
	public void processValidationError(HttpServletResponse response, BindException ex) {
		response.setCharacterEncoding(UTF8);
		response.setContentType(RESPONSE_CONTENT_TYPE);
		response.setStatus(HttpStatus.OK.value());
		BindingResult result = ex.getBindingResult();
		HashMap<String, String> fieldErrors = processFieldErrors(result.getFieldErrors());
		PrintWriter writer = null;
		try {
			ResponseResult<String> resp = new ResponseResult<String>();
			resp.setStatus(ReturnCodeEnum.BAD_REQUEST.value());
			resp.setMessage(JsonHelper.toJson(fieldErrors));
			writer = response.getWriter();
			writer.write(JsonHelper.toJsonWithoutNull(resp));
			log.error("traceId:{}, error msg:{}, exception:{}", 0, ex.getMessage(), ex);
		} catch (IOException e) {
			log.error("traceId:{}, exception:{}", 0, e);
		} finally {
			if (null != writer) {
				writer.close();
			}
		}
	}

	@ExceptionHandler(ParamInvalidException.class)
	public void processParamInvalidError(HttpServletResponse response, ParamInvalidException pe) {
		response.setCharacterEncoding(UTF8);
		response.setContentType(RESPONSE_CONTENT_TYPE);
		response.setStatus(HttpStatus.OK.value());
		PrintWriter writer = null;
		try {
			ResponseResult<String> resp = new ResponseResult<String>();
			resp.setStatus(pe.getCode());
			resp.setMessage(pe.getDesc());
			writer = response.getWriter();
			writer.write(JsonHelper.toJsonWithoutNull(resp));
			log.error("traceId:{}, error msg:{}, exception:{}",0, pe.getMessage(), pe);
		} catch (IOException e) {
			log.error("traceId:{}, exception:{}", 0, e);
		} finally {
			if (null != writer) {
				writer.close();
			}
		}
	}

	@ExceptionHandler(AuthenticationException.class)
	public void processAuthError(HttpServletResponse response, AuthenticationException ae) {
		response.setCharacterEncoding(UTF8);
		response.setContentType(RESPONSE_CONTENT_TYPE);
		response.setStatus(200);
		PrintWriter writer = null;
		try {
			ResponseResult<String> resp = new ResponseResult<String>();
			resp.setStatus(ae.getCode());
			resp.setMessage(ae.getDesc());
			writer = response.getWriter();
			writer.write(JsonHelper.toJsonWithoutNull(resp));
			log.error("traceId:{}, error msg:{}, exception:{}", RequestContextUtils.getTraceId(), ae.getMessage(), ae);
		} catch (IOException e) {
			log.error("traceId:{}, exception:{}", RequestContextUtils.getTraceId(), e);
		} finally {
			if (null != writer) {
				writer.close();
			}
		}
	}

	@ExceptionHandler(Exception.class)
	public void processError(HttpServletResponse response, Exception ex) {
        log.error("异常堆栈信息：{}", ex);
		response.setCharacterEncoding(UTF8);
		response.setContentType(RESPONSE_CONTENT_TYPE);
		response.setStatus(HttpStatus.OK.value());
		PrintWriter writer = null;
		try {
			ResponseResult<String> resp = new ResponseResult<String>();
			resp.setStatus(ReturnCodeEnum.SERVER_ERROR.value());
			resp.setMessage(ReturnCodeEnum.SERVER_ERROR.getDesc());
			if(ex instanceof MethodArgumentNotValidException){
				MethodArgumentNotValidException e=(MethodArgumentNotValidException)ex;
				Iterator var2 = e.getBindingResult().getAllErrors().iterator();

				while(var2.hasNext()) {
					ObjectError error = (ObjectError)var2.next();
					resp.setStatus(ReturnCodeEnum.BAD_REQUEST.value());
					resp.setMessage(error.getDefaultMessage());
				}
			}
//			异常输出信息【可以输出具体异常信息】
//			resp.setMessage(ex.toString());
			writer = response.getWriter();
			writer.write(JsonHelper.toJsonWithoutNull(resp));
			log.error("traceId:{}, error msg:{}, exception:{}", RequestContextUtils.getTraceId(), ex.getMessage(), ex);
		} catch (IOException e) {
			log.error("traceId:{}, exception:{}", RequestContextUtils.getTraceId(), e);
		} finally {
			if (null != writer) {
				writer.close();
			}
		}
	}

	private HashMap<String, String> processFieldErrors(List<FieldError> fieldErrors) {
		HashMap<String, String> fieldErrorsMap = new HashMap<>();
		for (FieldError fieldError : fieldErrors) {
			fieldErrorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return fieldErrorsMap;
	}
}
