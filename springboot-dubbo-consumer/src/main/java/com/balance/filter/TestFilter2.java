package com.balance.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description: springboot整合filter方法二: 集成bean,需要创建FilterConfig
 * @Company: 爱用科技有限公司
 * @author: yunzhang.du
 * @date: 2019年08月14日
 * @version: v1.0
 * @since: JDK 1.8
 */
public class TestFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入filter：2..... ");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
