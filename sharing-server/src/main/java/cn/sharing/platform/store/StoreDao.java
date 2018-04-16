package cn.sharing.platform.store;

import com.sharing.dao.entity.Store;
import com.sharing.dao.entity.StoreExample;
import com.sharing.dao.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 组织信息操作
 * Created by guotao on 2018.01.18.
 */
@Component
public class StoreDao {
  @Autowired
   StoreMapper storeMapper;
  /**
   * 根据代码判断用户是否存在
   *
   * @param uuid 用户uuid
   * @return 存在返回True 否则返回false
   */
  public Boolean isExistStoreByUuid(String uuid){
    if (uuid == null || uuid.equals(""))
      return false;
    StoreExample example = new StoreExample();
    StoreExample.Criteria criteria= example.createCriteria();
    criteria.andUuidEqualTo(uuid);
    long count = storeMapper.countByExample(example);
    return count > 0;
  }
  /**
   * 根据uuid获取组织信息
   * @param uuid 组织uuid
   * @return 返回组织信息
   */
  public Store getStoreByUuid(String uuid){
    StoreExample example = new StoreExample();
    StoreExample.Criteria criteria= example.createCriteria();
    criteria.andUuidEqualTo(uuid);
    List<Store> stores = storeMapper.selectByExample(example);
    return (stores == null || stores.isEmpty()) ? null : stores.get(0);
  }
  /**
   * 根据uuid获取组织信息
   * @param code 组织code
   * @return 返回组织信息
   */
  public Store getStoreByCode(String code){
    StoreExample example = new StoreExample();
    StoreExample.Criteria criteria= example.createCriteria();
    criteria.andCodeEqualTo(code);
    List<Store> stores = storeMapper.selectByExample(example);
    return (stores == null || stores.isEmpty()) ? null : stores.get(0);
  }
  /**
   * 更新组织数据
   * @param store  组织
   * @return 插入是否成功
   */

  public Boolean insertStore(Store store){
    /** 判断组织是否存在 */
    if (getStoreByUuid(store.getUuid()) == null){
      /** 不存在 */
      int count = storeMapper.insertSelective(store);
      return count > 0;
    } else{
      /** 存在 按主键更新*/
      int count = storeMapper.updateByPrimaryKey(store);
      return count > 0;
    }
  }
}
