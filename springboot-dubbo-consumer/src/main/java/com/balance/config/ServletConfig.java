package com.balance.config;

import com.balance.servlet.TestServlet2;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @Company: 爱用科技有限公司
 * @author: yunzhang.du
 * @date: 2019年08月14日
 * @version: v1.0
 * @since: JDK 1.8
 */
@Configuration
public class ServletConfig {

    /*
    * @Bean 等价于：
    * <bean="xxx" class="xxx"></bean>
    * */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new TestServlet2(),"/servletTest2");
        return registrationBean;
    }
}
