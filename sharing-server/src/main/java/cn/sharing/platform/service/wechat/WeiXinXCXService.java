package cn.sharing.platform.service.wechat;

import cn.sharing.platform.config.WxPayConfig;
import cn.sharing.platform.exception.WeiXinException;
import com.alibaba.fastjson.JSON;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jolokia.util.Base64Util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.*;

/**
 * Created by MSI on 2018/6/10.
 */
public class WeiXinXCXService {

    /**
     * 获取微信小程序 session_key 和 openid
     *
     * @param code 调用微信登陆返回的Code
     * @return
     */
    public static com.alibaba.fastjson.JSONObject getSessionKeyOropenid(String code, String appId, String appSecret) {
        //微信端登录code值
        String wxCode = code;
        Locale locale = new Locale("en", "US");
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";  //请求地址
        Map<String, String> requestUrlParam = new HashMap<String, String>();
        requestUrlParam.put("appid", appId);  //开发者设置中的appId
        requestUrlParam.put("secret", appSecret); //开发者设置中的appSecret
        requestUrlParam.put("js_code", wxCode); //小程序调用wx.login返回的code
        requestUrlParam.put("grant_type", WxPayConfig.grantType);    //默认参数 authorization_code

        //发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(sendPost(requestUrl, requestUrlParam));
        return jsonObject;
    }

//    public static AccessToken getToken() throws WeixinException, JsonParseException, JsonMappingException, IOException{
//        if(token == null || token.getExpires_in() < System.currentTimeMillis()){
//            //拼接参数
//            String param = "?grant_type=" + grantType + "&appid=" + appId + "&secret=" + secret;
//            //创建请求对象
//            HttpsClient http = new HttpsClient();
//            //调用获取access_token接口
//            Response res = http.get("https://api.weixin.qq.com/cgi-bin/token" + param);
//            System.out.println(res.asString());
//            ObjectMapper mapper = new ObjectMapper();
//            token = mapper.readValue(res.asString(),AccessToken.class);
//        }
//        return token;
//    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String, ?> paramMap) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String param = "";
        Iterator<String> it = paramMap.keySet().iterator();

        while (it.hasNext()) {
            String key = it.next();
            param += key + "=" + paramMap.get(key) + "&";
        }

        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            throw new WeiXinException(500, "使用finally块来关闭输出流、输入流");
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 解密用户敏感数据获取用户信息
     *
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param sessionKey    数据进行加密签名的密钥
     * @param iv            加密算法的初始向量
     * @return
     * */
    public static com.alibaba.fastjson.JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64Util.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64Util.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64Util.decode(iv);
        try {

            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSON.parseObject(result);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new WeiXinException(500, e.getMessage());
        } catch (NoSuchPaddingException e) {
            throw new WeiXinException(500, e.getMessage());
        } catch (InvalidParameterSpecException e) {
            throw new WeiXinException(500, e.getMessage());
        } catch (IllegalBlockSizeException e) {
            throw new WeiXinException(500, e.getMessage());
        } catch (BadPaddingException e) {
            throw new WeiXinException(500, e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new WeiXinException(500, e.getMessage());
        } catch (InvalidKeyException e) {
            throw new WeiXinException(500, e.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            throw new WeiXinException(500, e.getMessage());
        } catch (NoSuchProviderException e) {
            throw new WeiXinException(500, e.getMessage());
        }
        return null;
    }
}
