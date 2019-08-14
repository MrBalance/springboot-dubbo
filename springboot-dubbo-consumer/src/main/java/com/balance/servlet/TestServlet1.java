package com.balance.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: springboot整合servlet方法一: 注解,需要在启动类上增加：@ServletComponentScan(basePackages = "com.balance.servlet")
 * @Company: 爱用科技有限公司
 * @author: yunzhang.du
 * @date: 2019年08月14日
 * @version: v1.0
 * @since: JDK 1.8
 */
@WebServlet(urlPatterns = "/servletTest")
public class TestServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 因为不同浏览器的默认返回编码不是UTF-8
        resp.setContentType("text/html;charset=UTf-8");
        resp.getWriter().print("servlet：1 hello world 中文检查");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
