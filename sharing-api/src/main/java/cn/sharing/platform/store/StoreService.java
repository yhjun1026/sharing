package cn.sharing.platform.store;

import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 组织服务接口
 *
 * Created by guotao on 2018.01.18.
 */
@RequestMapping("/api/store")
@Api(tags = "组织接口")
public interface StoreService {
  /**
   * 组织更新
   * @param storeUpdate 组织更新信息对象
   * @return 是否更新成功
   */
  @RequestMapping(value = "/save" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "更新")
  public ResponseResult<Void> save (@RequestBody SStore storeUpdate);
  /**
   * 组织查询
   * @param storeUuid 组织uuid
   * @return 组织信息
   */
  @RequestMapping(value = "/query" +
          "", method = RequestMethod.POST)
  @ApiOperation(value = "查询")
  public ResponseResult<SStore> query (@RequestBody String storeUuid);
}
