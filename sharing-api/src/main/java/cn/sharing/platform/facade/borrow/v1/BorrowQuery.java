/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：BorrowQuery
 * 模块说明：
 * 修改历史：
 * 2018/4/29 - yanghongjun - 创建
 */
package cn.sharing.platform.facade.borrow.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yanghongjun
 * @version 1.0
 */
@Data
@ApiModel(description = "物品租用记录查询参数")
public class BorrowQuery {
    @ApiModelProperty(value = "项目Id")
    private String storeId;
    @ApiModelProperty(value = "查询开始时间(yyyy-MM-dd hh:mm:ss)")
    private String beginTime;
    @ApiModelProperty(value = "查询结束时间(yyyy-MM-dd hh:mm:ss)")
    private String endTime;
    @ApiModelProperty(value = "物品代码")
    private String goodsCode;
    @ApiModelProperty(value = "物品名称")
    private String goodsName;
    @ApiModelProperty(value = "借用人联系方式")
    private String mobile;
    @ApiModelProperty(value = "当前页号，默认1", required = false)
    private int page = 1;
    @ApiModelProperty(value = "每页大小，默认20，不超过200", required = false)
    private int pageSize = 20;
    @ApiModelProperty(value = "租用单类型，1=租借，2=已领取，3=归还，4=赔偿，0=全部， 默认0", required = false)
    private int borrowType = 0;

}
