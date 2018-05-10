package cn.sharing.platform.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * MD5加密工具类
 */
public class MD5 {

  private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  private static MessageDigest messagedigest = null;

  static {
    try {
      messagedigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      System.err.println(MD5.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
      e.printStackTrace();
    }
  }

    /**
     * 签名字符
     * @param text 待名的字符串
     * @return 签名结果
     */
    public static String sign(String text) {
        return DigestUtils.md5Hex(getContentBytes(text, "UTF-8"));
    }
    
    /**
     * 签名字符验证
     * @param text 待签名的字符串
     * @param sign 签名结果
     * @return 签名结果
     */
    public static boolean verify(String text, String sign) {
    	String mysign = DigestUtils.md5Hex(getContentBytes(text, "UTF-8"));
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误," + e.getMessage());
        }
    }

  public static String getFileMD5String(File file) throws IOException {
    FileInputStream is = new FileInputStream(file);
    FileChannel ch = is.getChannel();
    MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
    messagedigest.update(byteBuffer);
    return bufferToHex(messagedigest.digest());
  }

  private static String bufferToHex(byte bytes[]) {
    return bufferToHex(bytes, 0, bytes.length);
  }

  private static String bufferToHex(byte bytes[], int m, int n) {
    StringBuffer stringbuffer = new StringBuffer(2 * n);
    int k = m + n;
    for (int l = m; l < k; l++) {
      appendHexPair(bytes[l], stringbuffer);
    }
    return stringbuffer.toString();
  }

  private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
    char c0 = hexDigits[(bt & 0xf0) >> 4];
    char c1 = hexDigits[bt & 0xf];
    stringbuffer.append(c0);
    stringbuffer.append(c1);
  }
}