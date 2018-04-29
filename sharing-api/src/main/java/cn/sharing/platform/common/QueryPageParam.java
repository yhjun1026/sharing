/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2017，所有权利保留。
 * 项目名：gift
 * 文件名：QueryPageParam
 * 模块说明：
 * 修改历史：
 * 2017-08-08 - suizhe - 创建
 */
package cn.sharing.platform.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询参数
 *
 * @author suizhe
 */
public class QueryPageParam {
  @ApiModelProperty(value = "每页条数")
  private int pageSize = 50;
  @ApiModelProperty(value = "分页")
  private int page = 0;

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }
}
