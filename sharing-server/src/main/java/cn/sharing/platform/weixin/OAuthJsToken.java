package cn.sharing.platform.weixin;

import lombok.Data;

/**
 * Created by MSI on 2018/6/10.
 */
@Data
public class OAuthJsToken {
    private String openid;              //用户唯一标识
    private int expires_in = 7200;      //凭证有效时间，单位：秒
    private String session_key;         //会话密匙
    private long exprexpiredTime;           //过期时间

    /**
     * 判断用户凭证是否过期
     *
     * @return 过期返回 true,否则返回false
     */
    public boolean isExprexpired() {
        return System.currentTimeMillis() >= this.exprexpiredTime;
    }
}
