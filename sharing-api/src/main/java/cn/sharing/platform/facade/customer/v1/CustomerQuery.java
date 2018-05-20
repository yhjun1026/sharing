/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：CustomerQuery
 * 模块说明：
 * 修改历史：
 * 2018/5/20 - yanghongjun - 创建
 */
package cn.sharing.platform.facade.customer.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yanghongjun
 * @version 1.0
 */
@Data
@ApiModel(description = "小程序用户查询参数")
public class CustomerQuery {
    @ApiModelProperty(value = "项目Id")
    private String storeId;
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "当前页号，默认1", required = false)
    private int page = 1;
    @ApiModelProperty(value = "每页大小，默认20，不超过200", required = false)
    private int pageSize = 20;
}
