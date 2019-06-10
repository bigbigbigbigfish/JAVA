package com.cao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方式
        //获取请求url
        //获取协议
        String method = req.getMethod();
        System.out.println(method);
        String url = req.getRequestURI();
        System.out.println(url);
    }
}
