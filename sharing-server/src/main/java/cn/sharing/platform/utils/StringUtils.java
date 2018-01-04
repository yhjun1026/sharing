/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：open-parent
 * 文件名：StringUtils
 * 模块说明：
 * 修改历史：
 * 2017/12/12 - yanghongjun - 创建
 */
package cn.sharing.platform.utils;

/**
 * @author yanghongjun
 * @version 1.0
 */
public class StringUtils {
  /**
   * 字符串是否为空
   * @param str
   * @return
   */
  public static boolean isEmpty(String str){
    if(str == null || str.length() <= 0){
      return  true;
    }else{
      return false;
    }
  }

  public static boolean isNotEmpty(String str) {
    return str != null && str.length() > 0;
  }


}
