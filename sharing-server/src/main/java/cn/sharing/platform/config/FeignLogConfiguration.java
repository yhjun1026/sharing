/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2017，所有权利保留。
 * 项目名：member-inf
 * 文件名：FeignLogConfiguration
 * 模块说明：
 * 修改历史：
 * 2017-09-29 - suizhe - 创建
 */
package cn.sharing.platform.config;

import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignLogConfiguration
 *
 * @author suizhe
 */
@Configuration
public class FeignLogConfiguration {
  @Value("${logging.feignClient.level:BASIC}")
  private Logger.Level level;
  @Bean
  public Logger.Level feignLoggerLevel() {
    return level;
  }
}
