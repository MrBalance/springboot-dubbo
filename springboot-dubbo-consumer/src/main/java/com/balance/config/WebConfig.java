package com.balance.config;

import com.balance.inteceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @Company: 爱用科技有限公司
 * @author: yunzhang.du
 * @date: 2019年08月14日
 * @version: v1.0
 * @since: JDK 1.8
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 需要拦截的路径
        String[] addPathPatterns = {
            "/usrTable/**"
        };
        // 不需要拦截的路径
        String[] excludePathPatterns = {
            "/usrTable/getCurrentUsr"
        };


        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
