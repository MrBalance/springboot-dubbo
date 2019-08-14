package com.balance.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: springboot整合servlet方法二: 集成bean,需要创建ServletConfig
 * @Company: 爱用科技有限公司
 * @author: yunzhang.du
 * @date: 2019年08月14日
 * @version: v1.0
 * @since: JDK 1.8
 */
public class TestServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("servlet：2 hello world 中文");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
