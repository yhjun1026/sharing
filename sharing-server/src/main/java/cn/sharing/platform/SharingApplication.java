/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：SharingApplication
 * 模块说明：
 * 修改历史：
 * 2018/1/4 - yanghongjun - 创建
 */
package cn.sharing.platform;

import javax.annotation.PostConstruct;

/**
 * @author yanghongjun
 * @version 1.0
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableSwagger2
@EnableScheduling
@ComponentScan(basePackages = {"com.qianfan123.sailing.open"})
@MapperScan(basePackages = {"com.qianfan123.sailing.open.server.mapper"})
@EnableCaching
@EnableFeignClients(basePackages = {"com.qianfan123.sailing.open.server.client"})
public class SharingApplication {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  public static void main(String[] args) throws Exception {
    SpringApplication springApplication = new SpringApplication(OpenApiServer.class);
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
            .apis(RequestHandlerSelectors.basePackage("com.qianfan123.sailing"))
            .paths(paths())
            .build();
  }

  private Predicate<String> paths(){
    return Predicates.and(PathSelectors.regex("/api/v1/.*"), Predicates.not(PathSelectors.regex("/error")));
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("印力集成系统")
            .description("")
            .termsOfServiceUrl("")
            .version("1.0")
            .build();
  }
}
