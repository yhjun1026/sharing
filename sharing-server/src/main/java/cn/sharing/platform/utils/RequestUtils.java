package cn.sharing.platform.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestUtils {

  private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

  /**
   * 设置返回消息
   * @param response 返回对象
   * @param message 返回消息
   */
  public static void writeMessage(HttpServletResponse response, String message) {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    PrintWriter out = null;
    try {
      out = response.getWriter();
      out.append(message);
    } catch (IOException e) {
      logger.error("writeMessage error:" + e.getMessage(), e);
    } finally {
      if (out != null) {
        out.close();
      }
    }
  }
}
