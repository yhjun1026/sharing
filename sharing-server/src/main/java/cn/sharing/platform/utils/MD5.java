package cn.sharing.platform.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

/**
 * MD5加密工具类
 */
public class MD5 {

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

}