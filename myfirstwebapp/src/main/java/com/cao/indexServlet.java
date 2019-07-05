package com.cao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class indexServlet extends HttpServlet {
    //get  post put delete head
    // public default protected private
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        //浏览器(html,css js)
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>");
        writer.write("<Servlet程序>");
        writer.write("</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.append("<h1>").append("当前时间").append("</h2>");
        writer.append("<p>").append(LocalDateTime.now().toString()).append("</p>");
        writer.write("</body>");

        writer.write("</html>");
        writer.flush();
    }
}
