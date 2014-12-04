package net.mas0061.springboot.kaptcha

import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.web.filter.CharacterEncodingFilter

import com.google.code.kaptcha.servlet.KaptchaServlet

@Configuration
public class AppConfig {
  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  CharacterEncodingFilter characterEncodingFilter() {
    def filter = new CharacterEncodingFilter()
    filter.setEncoding("UTF-8")
    filter
  }
  
  @Bean
  public ServletRegistrationBean kaptcha() {
    new ServletRegistrationBean(new KaptchaServlet(), "/kaptcha.jpg")
  }

}
