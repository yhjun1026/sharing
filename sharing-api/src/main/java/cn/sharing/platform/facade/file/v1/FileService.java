package cn.sharing.platform.facade.file.v1;

import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件服务接口，用于上传下载物品的图片
 */
public interface FileService {

  /** 用于在Spring容器的默认ID。 */
  String DEFAULT_CONTEXT_ID = "sharing-spi.fileService";

  /**
   * 获取文件信息
   * @param fileId 文件ID
   * @return 文件信息
   */
  @RequestMapping(value = "info", method = RequestMethod.GET)
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
  @RequestMapping(value = "delete", method = RequestMethod.DELETE)
  @ApiOperation(value = "删除文件", httpMethod = "DELETE")
  public
  @ResponseBody
  ResponseResult<Void> delete(@ApiParam(required = true, name = "fileId", value = "文件id") @RequestParam(value = "fileId")
                            String fileId);

  /**
   * 上传文件
   * @param request
   * @return
   */
  @RequestMapping(value = "upload", method = RequestMethod.POST)
  @ApiOperation(value = "上传文件", httpMethod = "POST")
  public
  @ResponseBody
  ResponseResult<FileInfo> upload(HttpServletRequest request);

  /**
   * 下载文件
   * @param request
   * @param response
   */
  @RequestMapping(value = "download", method = RequestMethod.GET)
  @ApiOperation(value = "下载文件", httpMethod = "GET")
  public void download(HttpServletRequest request, HttpServletResponse response);
}
