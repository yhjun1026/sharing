/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：open-parent
 * 文件名：GuavaConfig
 * 模块说明：
 * 修改历史：
 * 2017/12/17 - yanghongjun - 创建
 */
package cn.sharing.platform.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author yanghongjun
 * @version 1.0
 */
@Configuration
@EnableCaching
public class GuavaConfig {
  private static final int DEFAULT_MAXSIZE = 1000;
  private static final int DEFAULT_TTL = 3600;

  /**
   * 定义cache名称、超时时长秒、最大个数
   * 每个cache缺省3600秒过期，最大个数1000
   */
  public enum Caches {
    user(60, 2),
    info(5),
    role;

    Caches() {
    }

    Caches(int ttl) {
      this.ttl = ttl;
    }

    Caches(int ttl, int maxSize) {
      this.ttl = ttl;
      this.maxSize = maxSize;
    }

    private int maxSize = DEFAULT_MAXSIZE;    //最大數量
    private int ttl = DEFAULT_TTL;        //过期时间（秒）

    public int getMaxSize() {
      return maxSize;
    }

    public void setMaxSize(int maxSize) {
      this.maxSize = maxSize;
    }

    public int getTtl() {
      return ttl;
    }

    public void setTtl(int ttl) {
      this.ttl = ttl;
    }
  }

  /**
   * 配置全局缓存参数，3600秒过期，最大个数1000
   */
  @Bean
  public CacheManager cacheManager() {
    GuavaCacheManager cacheManager = new GuavaCacheManager();
    cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(3600, TimeUnit.SECONDS).maximumSize(1000));
    return cacheManager;
  }
  /**
   * 个性化配置缓存
   */
//  @Bean
//  public CacheManager cacheManager() {
//    SimpleCacheManager manager = new SimpleCacheManager();
//    //把各个cache注册到cacheManager中，GuavaCache实现了org.springframework.cache.Cache接口
//    ArrayList<GuavaCache> caches = new ArrayList<>();
//    for (Caches c : Caches.values()) {
//      caches.add(new GuavaCache(c.name(), CacheBuilder.newBuilder().recordStats().expireAfterWrite(c.getTtl(), TimeUnit.SECONDS).maximumSize(c.getMaxSize()).build()));
//    }
//    manager.setCaches(caches);
//    return manager;
//  }
}
