package cn.sharing.platform.utils;

import cn.sharing.platform.facade.file.v1.FSConstants;

import java.io.File;

public class FileIdUtils {

  private static final int DIR_DEEP = 5;
  private static final int SUB_LENGTH = 2;

  /** 根据fileId获取文件相对路径 */
  public static String getFilePath(String fileId) {
    if (fileId == null) {
      return "";
    }
    int idx = fileId.indexOf(FSConstants.FILE_SP);
    if (idx < 0) {
      return "";
    }
    String yy = fileId.substring(0, idx);
    if (yy.length() < (DIR_DEEP * SUB_LENGTH)) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= DIR_DEEP; i++) {
      sb.append(yy.substring((i - 1) * SUB_LENGTH, i * SUB_LENGTH));
      sb.append(File.separator);
    }
    return sb.toString();
  }

  /** 根据fileId获取文件名 */
  public static String getFileName(String fileId) {
    if (fileId == null) {
      return "";
    }
    int idx = fileId.indexOf(FSConstants.FILE_SP);
    if (idx < 0) {
      return fileId;
    } else {
      return fileId.substring(idx + 1);
    }
  }

  public static String generateFileName(String fileId) throws RuntimeException {
    //todo 图片路径，需要配置
    String path = "C:\\sharing";
    if (path == null) {
      throw new RuntimeException("未正确配置文件根路径。");

    }
    StringBuilder sb = new StringBuilder();
    sb.append(path);
    if (!path.endsWith("/") && !path.endsWith("\\")) {
      sb.append(File.separator);
    }
    sb.append(FileIdUtils.getFilePath(fileId));

    sb.append(FileIdUtils.getFileName(fileId));
    return sb.toString();
  }
}
