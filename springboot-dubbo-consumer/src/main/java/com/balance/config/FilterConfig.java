package com.balance.config;

import com.balance.filter.TestFilter2;
import com.balance.servlet.TestServlet2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @description:
 * @Company: 爱用科技有限公司
 * @author: yunzhang.du
 * @date: 2019年08月14日
 * @version: v1.0
 * @since: JDK 1.8
 */
@Configuration
public class FilterConfig {

    /**
    * @Bean 等价于：
    * <bean="xxx" class="xxx"></bean>
    * */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new TestFilter2());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }


    /**
     * 字符编码过滤
     * 等价于web.xml中配置CharacterEncodingFilter
     * 只有在配置文件中配置：
     *
     *  spring.http.encoding.enabled=false
     *
     *  过滤器才能生效
     *
     * */
    @Bean
    public FilterRegistrationBean filterEncodeRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
