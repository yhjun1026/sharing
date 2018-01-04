/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：open-parent
 * 文件名：FilterConfig
 * 模块说明：
 * 修改历史：
 * 2017/12/17 - yanghongjun - 创建
 */
package cn.sharing.platform.config;

import com.qianfan123.sailing.open.server.filter.SignatureFilter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanghongjun
 * @version 1.0
 */

@Configuration
@Getter
public class SignFilterConfig {
  //是否开启filter 签名验证
  @Value("${spring.filter.enable: false}")
  private boolean enable;

  @Bean
  public SignatureFilter getFilter(){
    return new SignatureFilter();
  }
  @Bean
  public FilterRegistrationBean registrationBean() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(getFilter());
    List<String> urlPatterns = new ArrayList<String>();
    urlPatterns.add("/api/*");
    registrationBean.setUrlPatterns(urlPatterns);
    registrationBean.setOrder(1);
    return registrationBean;
  }
}
