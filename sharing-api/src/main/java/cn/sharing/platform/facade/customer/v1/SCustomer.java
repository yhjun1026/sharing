/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：SCustomer
 * 模块说明：
 * 修改历史：
 * 2018/5/20 - yanghongjun - 创建
 */
package cn.sharing.platform.facade.customer.v1;

import cn.sharing.platform.facade.borrow.v1.Custom;
import cn.sharing.platform.facade.borrow.v1.SBorrowDtl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yanghongjun
 * @version 1.0
 */
@Data
@ApiModel(description = "顾客信息")
public class SCustomer {
    @ApiModelProperty(value = "微信联合Id")
    private String unionId;

    @ApiModelProperty(value = "用户账户")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "微信号")
    private String wechatId;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "小程序app Id")
    private String appId;

    @ApiModelProperty(value = "小程序openId")
    private String openId;

    @ApiModelProperty(value = "小程序token")
    private String token;

    @ApiModelProperty(value = "微信头像")
    private String icon;

    @ApiModelProperty(value = "注册时间(yyyy-MM-dd hh:mm:ss)")
    private String createTime;

    @ApiModelProperty(value = "备注")
    private String memo;




}
