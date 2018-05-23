package cn.sharing.platform.service.file.v1;

import cn.sharing.platform.BaseImpl;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.file.v1.FileInfo;
import cn.sharing.platform.facade.file.v1.FileService;
import cn.sharing.platform.utils.FileIdUtils;
import cn.sharing.platform.utils.FileUtils;
import cn.sharing.platform.utils.MD5;
import cn.sharing.platform.utils.RequestUtils;
import cn.sharing.platform.utils.StringUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class FileServiceImpl extends BaseImpl implements FileService {
    /**
     * 获取文件信息
     *
     * @param fileId 文件ID
     * @return 文件信息
     */
    @Override
    public ResponseResult<FileInfo> getFileInfo(String fileId) {
        return null;
    }

    /**
     * 删除文件
     *
     * @param fileId 文件ID
     * @return
     */
    @Override
    public ResponseResult<Void> delete(String fileId) {
        return null;
    }

    /**
     * 上传文件
     *
     * @param file``
     * @return
     */
    //文件上传相关代码
    @Override
    public ResponseResult<FileInfo> upload(MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseResult.failed("上传文件格式不合法.");
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;

        try {
            //上传操作

            byte[] content = file.getBytes();
            String id = FileUtils.newFileId(fileName);
            FileInfo info = null;
            info = uploadFile(content, fileName, id);
            return new ResponseResult<FileInfo>(info);
        } catch (IllegalStateException e) {
            return ResponseResult.failed("文件保存异常1，" + e.getMessage());
        } catch (IOException e) {
            return ResponseResult.failed("文件保存异常2，" + e.getMessage());
        } catch (Exception e) {
            return ResponseResult.failed("文件保存异常3，" + e.getMessage());
        }

//
//    try{
//      //构建上传对象
//      DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
//      fileItemFactory.setSizeThreshold(1024 * 1024);   //设定1M的缓冲区
//      fileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir"))); //设置上传文件的临时目录
//      ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
//      upload.setHeaderEncoding("utf-8");  //支持中文文件名
//      List<FileItem> list = upload.parseRequest(request);
//      InputStream inputStream = null;
//      String fileName = "";  //文件名，带后缀
//      String fileId = null;
//      for (int i = 0; i < list.size(); i++) {
//        FileItem item = (FileItem) list.get(i);
//        if (item.isFormField()) {    //判断一个参数域是普通的表单输入域，还是文件上传域
//          if (item.getFieldName().equals("fileName")) {
//            fileName = item.getString();
//          } else if (item.getFieldName().equals("fileId")) {
//            fileId = item.getString();
//          }
//        } else {
//          inputStream = item.getInputStream();
//        }
//      }
//      //上传操作
//      if (inputStream != null) {
//        byte[] content = FileUtils.readStreamBytes(inputStream);
//        String id = fileId == null ? FileUtils.newFileId(fileName) : fileId;
//        FileInfo info = uploadFile(content, fileName, id);
//        return new ResponseResult<FileInfo>(info);
//      } else {
//        return ResponseResult.failed("未指定文件内容");
//      }
//    }catch (Exception e){
//
//    }
//    return null;
    }

    /**
     * 下载文件
     */
    @Override
    public ResponseEntity<byte[]> download(@RequestParam("fileId") String fileId) {
        try {
            if (StringUtils.isEmpty(fileId)) {
                logger.error("未指定文件id");
                return null;
            }
            byte[] content = getFile(fileId);
            if (content == null) {
                logger.error("文件不存在, fileId=" + fileId);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            // 当文件名中有中文时，会出现乱码，通过new String(fileName.getBytes("utf-8"),"ISO8859-1")转换
            headers.setContentDispositionFormData("attchement", new String(fileId.getBytes("UTF-8"), "ISO-8859-1"));
            if (content == null || content.length == 0) {
                return null;
            } else {
                return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);  //HttpStatus.CREATED
            }
        } catch (Exception e) {
            logger.error("download error:" + e.getMessage(), e);
            return null;
        }
    }


    @Override
    public ResponseEntity<byte[]> file(@PathVariable("fileId") String fileId) {
        try {
            if (StringUtils.isEmpty(fileId)) {
                logger.error("未指定文件id");
                return null;
            }
            byte[] content = getFile(fileId);
            if (content == null) {
                logger.error("文件不存在, fileId=" + fileId);
            }

            HttpHeaders headers = new HttpHeaders();
            if(fileId.contains(".jpg") || fileId.contains(".JEPG")){
                headers.setContentType(MediaType.IMAGE_JPEG);
            }else if(fileId.contains(".png")){
                headers.setContentType(MediaType.IMAGE_PNG);
            }else if(fileId.contains(".gif")){
                headers.setContentType(MediaType.IMAGE_GIF);
            }else{
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                // 当文件名中有中文时，会出现乱码，通过new String(fileName.getBytes("utf-8"),"ISO8859-1")转换
                headers.setContentDispositionFormData("attchement", new String(fileId.getBytes("UTF-8"), "ISO-8859-1"));
            }

            // 当文件名中有中文时，会出现乱码，通过new String(fileName.getBytes("utf-8"),"ISO8859-1")转换
//            headers.setContentDispositionFormData("attchement", new String(fileId.getBytes("UTF-8"), "ISO-8859-1"));
            if (content == null || content.length == 0) {
                return null;
            } else {
                return new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);  //HttpStatus.CREATED
            }
        } catch (Exception e) {
            logger.error("download error:" + e.getMessage(), e);
            return null;
        }
    }

    private FileInfo uploadFile(byte[] fileStream, String fileName, String fileId) throws Exception {
        if (fileId == null) {
            throw new Exception("未指定文件id.");
        }
        try {
            String file = FileIdUtils.generateFileName(fileId);
            FileUtils.saveFile(fileStream, file);

            return getFileInfoById(fileId);
        } catch (Exception e) {
            logger.error("getFileInfo error:" + e.getMessage(), e);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 根据FileId获取文件信息
     *
     * @param fileId 文件id
     * @return
     * @throws Exception
     */
    private FileInfo getFileInfoById(String fileId) throws Exception {
        if (fileId == null) {
            return null;
        }
        try {
            String fileName = FileIdUtils.generateFileName(fileId);
            File file = new File(fileName);
            if (!file.exists() || !file.isFile()) {
                return null;
            }
            FileInfo info = new FileInfo();
            info.setFileId(fileId);
            info.setSize(file.length());
            info.setMd5(MD5.getFileMD5String(file));
            return info;
        } catch (Exception e) {
            logger.error("getFileInfo error:" + e.getMessage(), e);
            throw new Exception(e.getMessage());
        }
    }

    private byte[] getFile(String fileId) throws Exception {
        if (fileId == null) {
            throw new Exception("未指定文件id.");
        }

        String fileName = FileIdUtils.generateFileName(fileId);
        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            throw new Exception("文件" + fileId + "不存在.");
        }
        try {
            return FileUtils.readStreamBytes(new FileInputStream(file));
        } catch (Exception e) {
            logger.error("getFile error:" + e.getMessage(), e);
            throw new Exception(e.getMessage());
        }
    }
}
