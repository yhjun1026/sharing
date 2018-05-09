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
//    @ApiModelProperty(value = "项目Id(必须)", required = true)
//    @NotBlank(message ="项目Id[storeId]不能为空")
//    private String storeId;
    @ApiModelProperty(value = "当前页号，默认1", required = false)
    private int page = 1;
    @ApiModelProperty(value = "每页大小，默认50，不超过200", required = false)
    private int pageSize = 50;
    @ApiModelProperty(value = "租用单类型，1=租借，2=归还，3=赔偿，0=全部， 默认0", required = false)
    private int borrowType = 0;

}
