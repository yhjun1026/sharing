package cn.sharing.platform.service.wechat;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by MSI on 2018/6/10.
 */
@Data
@ApiModel
public class AccessToken extends BaseResponse {
    private String access_token;
    private long expires_in;
}
