package cn.sharing.platform.store;

import cn.sharing.platform.BaseImpl;
import cn.sharing.platform.common.ResponseResult;
import com.sharing.dao.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 组织服务实现
 *
 * Created by guotao on 2018.01.18.
 */
public class StoreServiceImpl extends BaseImpl implements StoreService {
  @Autowired
  StoreDao storeDao;
  /**
   * 组织更新
   *
   * @param storeUpdate
   *         组织更新信息对象
   * @return 是否更新成功
   */
  @Override
  public ResponseResult<Void> save(@RequestBody SStore storeUpdate) {
    if (storeUpdate == null) {
      return ResponseResult.failed("参数解析错误.");
    }
    if (storeUpdate.getUuid() == "" || storeUpdate.getUuid() == null) {
      return ResponseResult.failed("组织UUID未指定.");
    }
    if (storeUpdate.getCode() == "" || storeUpdate.getCode() == null) {
      return ResponseResult.failed("组织代码不能为空.");
    }
    if (storeUpdate.getName() == "" || storeUpdate.getName() == null) {
      return ResponseResult.failed("组织名称不能为空.");
    }
    try{
      if (storeUpdate.getUpperuuid() != null && !storeDao.isExistStoreByUuid(storeUpdate.getUpperuuid())){
        return ResponseResult.failed("上级组织UUID不正确.");
      }
      /** 更新组织信息*/
      if (!storeDao.insertStore(converStore(storeUpdate))){
        return ResponseResult.failed("更新失败.");
      }
      return ResponseResult.failed("更新成功.");
    } catch (Exception e) {
      logger.info("update store error, storeCode=" + storeUpdate.getCode() + e.getMessage(), e);
      return ResponseResult.failed("更新异常.");
    }
  }

  /**
   * 组织查询
   *
   * @param storeUuid
   *         组织uuid
   * @return 组织信息
   */
  @Override
  public ResponseResult<SStore> query(@RequestBody String storeUuid) {
    ResponseResult<SStore> response;
    if (storeUuid == null || storeUuid.equals("")) {
      return ResponseResult.failed("组织UUID为空.");
    }
    try{
      /** 判断组织信息是否存在 */
      if (!storeDao.isExistStoreByUuid(storeUuid)){
        return ResponseResult.failed("组织UUID不正确.");
      }
      /** 获取组织信息*/
      Store store = storeDao.getStoreByUuid(storeUuid);
      response = ResponseResult.failed("更新成功.");
      response.setData(converSStore(store));
      return response;
    } catch (Exception e) {
      logger.info("query store error, storeUuid=" + storeUuid + e.getMessage(), e);
      return ResponseResult.failed("更新异常.");
    }
  }

  /**
   * 组织对象转换 S对象转换为P对象
   *
   * @param   storeUpdate 组织信息
   * @return  组织对象
   */
  private Store converStore(SStore storeUpdate){
    Store store = new Store();
    store.setUuid(storeUpdate.getUuid());
    store.setCode(storeUpdate.getCode());
    store.setName(storeUpdate.getName());
    store.setLicence(storeUpdate.getLicence());
    store.setMemo(storeUpdate.getMemo());
    store.setUpperuuid(storeUpdate.getUpperuuid());
    return store;
  }
  /**
   * 组织对象转换 P对象转换为S对象
   *
   * @param   store 组织信息
   * @return  组织对象
   */
  private SStore converSStore(Store store){
    SStore sstore = new SStore();
    sstore.setUuid(store.getUuid());
    sstore.setCode(store.getCode());
    sstore.setName(store.getName());
    sstore.setLicence(store.getLicence());
    sstore.setMemo(store.getMemo());
    sstore.setUpperuuid(store.getUpperuuid());
    return sstore;
  }
}
