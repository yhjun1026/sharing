/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2017，所有权利保留。
 * 项目名：gift
 * 文件名：QueryResult
 * 模块说明：
 * 修改历史：
 * 2017-08-08 - suizhe - 创建
 */
package cn.sharing.platform.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * QueryResult
 *
 * @author suizhe
 */
@ToString
@ApiModel(description = "查询结果")
public class QueryResult<T> {
  @ApiModelProperty(value = "记录数")
  private long totalCount;
  @ApiModelProperty(value = "当前页")
  private int page;
  @ApiModelProperty(value = "页记录数")
  private int pageSize;
  @ApiModelProperty(value = "记录列表")
  private List<T> item = new ArrayList<>();

  public long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(long totalCount) {
    this.totalCount = totalCount;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public List<T> getItem() {
    return item;
  }

  public void setItem(List<T> item) {
    this.item = item;
  }
}
