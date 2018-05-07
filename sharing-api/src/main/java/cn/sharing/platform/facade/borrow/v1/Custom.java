/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：Custom
 * 模块说明：
 * 修改历史：
 * 2018/4/29 - yanghongjun - 创建
 */
package cn.sharing.platform.facade.borrow.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanghongjun
 * @version 1.0
 */
@Data
public class Custom {
    private String nick;
    @ApiModelProperty(value = "手机号", required = true)
    private String phoneNumber;
    private String wechat;
    private String address;
}
