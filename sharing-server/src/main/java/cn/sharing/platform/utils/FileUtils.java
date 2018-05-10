package cn.sharing.platform.utils;

import cn.sharing.platform.service.file.v1.FSConstants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

  /**
   * 将流转换为字节
   * @param in 输入流
   * @return
   * @throws IOException
   */
  public static byte[] readStreamBytes(InputStream in) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    byte[] b = new byte[128];
    int bytesRead = -1;
    while (-1 != (bytesRead = in.read(b, 0, b.length))) {
      out.write(b, 0, bytesRead);
    }
    out.flush();
    byte[] result = out.toByteArray().clone();
    in.close();
    out.close();
    return result;
  }

  /**
   * 根据文件名生成fileId
   * @param fileName 文件名
   * @return
   */
  public static String newFileId(String fileName) {
    StringBuilder sb = new StringBuilder();
    sb.append(DateUtil.getCurrentDateByPattern(FSConstants.FILE_PREFIX));
    String uuid = UUIDGenerator.getUUID();
    sb.append(uuid.substring(0, 2));
    sb.append(FSConstants.FILE_SP);
    sb.append(uuid.substring(2));
    String ext = FileUtils.getFileExt(fileName);
    if (ext != null && !"".endsWith(ext)) {
      sb.append(FSConstants.FILE_DOT);
      sb.append(ext);
    }
    return sb.toString();
  }

  /**
   * 获取文件扩展名，不含.
   *
   * @param fileName
   *         文件名
   * @return 扩展名
   */
  public static String getFileExt(String fileName) {
    if (fileName == null) {
      return "";
    }
    File f = new File(fileName);
    String name = f.getName();
    if (name == null) {
      return "";
    }
    int idx = name.lastIndexOf(".");
    if (idx <= 0) {
      return "";
    } else {
      return name.substring(idx + 1);
    }
  }

  /**
   * 保存文件，遇到文件已存在则覆盖
   *
   * @param fileStream
   *         文件流
   * @param savePath
   *         保存路径，如：c:\temp\图片.jpg
   * @return 是否保存成功
   */
  public static boolean saveFile(byte[] fileStream, String savePath) throws Exception {
    if (fileStream == null || fileStream.length == 0)
      return false;
    if (savePath == null || "".equals(savePath.trim()))
      return false;

    File file = new File(savePath);
    // 遇到文件已存在则覆盖
    if (file.exists()) {
      file.delete();
    }
    if (!file.getParentFile().exists()) {
      file.getParentFile().mkdirs();
    }
    try {
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(fileStream);
      fos.flush();
      fos.close();
      //fos.getFD().sync();
      return true;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

}
