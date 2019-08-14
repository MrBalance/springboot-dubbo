package com.balance.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description: springboot整合filter方法一: 注解,需要在启动类上增加：@ServletComponentScan(basePackages = "com.balance.filter")
 * @Company: 爱用科技有限公司
 * @author: yunzhang.du
 * @date: 2019年08月14日
 * @version: v1.0
 * @since: JDK 1.8
 */
@WebFilter(urlPatterns = "/*")
public class TestFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURL = req.getRequestURL().toString();
        System.out.println(requestURL);
        // 解决浏览器360,chrome,火狐
        // 会自己主动的又请求了一次图标静态资源
        if (requestURL.contains("favicon.ico")) {
            return;
        }
        System.out.println("进入filter：1.....");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
