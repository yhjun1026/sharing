/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：SharingApplication
 * 模块说明：
 * 修改历史：
 * 2018/1/4 - yanghongjun - 创建
 */
package cn.sharing.platform;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Predicates;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @author yanghongjun
 * @version 1.0
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableSwagger2
@EnableScheduling
@ComponentScan(basePackages = {"cn.sharing.platform"})
@MapperScan(basePackages = {"cn.sharing.dao.mapper"})
@EnableCaching
@EnableFeignClients(basePackages = {"cn.sharing.platform.client"})
public class SharingApplication {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  public static void main(String[] args) throws Exception {
    SpringApplication springApplication = new SpringApplication(SharingApplication.class);
    springApplication.run(args);
  }

  @PostConstruct
  private void init() {
  }

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("cn.sharing.platform"))
            .paths(paths())
            .build();
  }

  //配置mybatis的分页插件pageHelper
  @Bean
  public PageHelper pageHelper(){
    PageHelper pageHelper = new PageHelper();
    Properties properties = new Properties();
    properties.setProperty("offsetAsPageNum","true");
    properties.setProperty("rowBoundsWithCount","true");
    properties.setProperty("reasonable","true");
    properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
    pageHelper.setProperties(properties);
    return pageHelper;
  }

  private com.google.common.base.Predicate<String> paths(){
    return Predicates.and(PathSelectors.regex("/api/.*"), Predicates.not(PathSelectors.regex("/error")));
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("xx管理系统")
            .description("")
            .termsOfServiceUrl("")
            .version("1.0")
            .build();
  }
}
