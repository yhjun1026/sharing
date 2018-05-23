package cn.sharing.platform.facade.file.v1;

import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件服务接口，用于上传下载物品的图片
 */
@RequestMapping("/api/v1/file")
@Api(tags = "文件服务接口")
public interface FileService {

  /** 用于在Spring容器的默认ID。 */
  String DEFAULT_CONTEXT_ID = "sharing-spi.fileService";

  /**
   * 获取文件信息
   * @param fileId 文件ID
   * @return 文件信息
   */
  @RequestMapping(value = "/info", method = RequestMethod.GET)
  @ApiOperation(value = "获取文件信息", httpMethod = "GET")
  public
  @ResponseBody
  ResponseResult<FileInfo> getFileInfo(@ApiParam(required = true, name = "fileId", value = "文件id") @RequestParam(value =
          "fileId") String fileId);

  /**
   * 删除文件
   * @param fileId 文件ID
   * @return
   */
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  @ApiOperation(value = "删除文件", httpMethod = "DELETE")
  public
  @ResponseBody
  ResponseResult<Void> delete(@ApiParam(required = true, name = "fileId", value = "文件id") @RequestParam(value = "fileId")
                            String fileId);

  /**
   * 上传文件
   * @param file
   * @return
   */
  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  @ApiOperation(value = "上传文件")
  public
  @ResponseBody
  ResponseResult<FileInfo> upload(@RequestParam("file") MultipartFile file);

  /**
   * 下载文件
   */
  @RequestMapping(value = "/download", method = RequestMethod.GET)
  @ApiOperation(value = "下载文件", httpMethod = "GET")
  public ResponseEntity<byte[]> download(@RequestParam("fileId") String fileId);
//  public void download(HttpServletRequest request, HttpServletResponse response);

  @RequestMapping(value = "/{fileId}/", method = RequestMethod.GET)
  @ApiOperation(value = "文件", httpMethod = "GET")
  public ResponseEntity<byte[]> file(@PathVariable("fileId") String fileId);
}
