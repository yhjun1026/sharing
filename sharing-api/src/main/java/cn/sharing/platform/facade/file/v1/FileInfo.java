package cn.sharing.platform.facade.file.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 文件信息
 */
@ApiModel(description = "文件信息")
@Data
public class FileInfo implements Serializable {

  private static final long serialVersionUID = -4562437665387757783L;
  /** 文件标识 */
  @ApiModelProperty(notes = "文件id")
  private String fileId;
  /** 文件大小，字节 */
  @ApiModelProperty(notes = "文件大小，字节")
  private long size;
  /** md5值 */
  @ApiModelProperty(notes = "文件md5值")
  private String md5;
}
