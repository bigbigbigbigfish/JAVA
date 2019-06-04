package com.cao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset = UTF-8");
        PrintWriter writer =resp.getWriter();
        writer.append("<html>").append("<head>").append("</head>").append("<body>")
                .append("<h1>").append("hello java web power by servlet")
                .append(new SimpleDateFormat("yyy-MM-dd:mm:ss").format(new Date())).append("</h1>")
                .append("</body>");
    }
}
