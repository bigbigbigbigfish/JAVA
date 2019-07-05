package com.cao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class MavenListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String repository = "D:" + File.separator+"java";

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        File directory = new File(repository);
        File[] files = directory.listFiles();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<head>");
        stringBuffer.append("<title>").append("<呵呵仓库>").append("</title>");
        stringBuffer.append("</body>");
        if(files != null) {
            for(File file:files) {
                stringBuffer.append("<a href='>").append(file.getName()).append(file.getName()).append("</a>");
            }
        } else {
            stringBuffer.append("暂无数据");

        }
        stringBuffer.append("</body>").append("</html>");

        PrintWriter printWriter = resp.getWriter();
        printWriter.write(stringBuffer.toString());
        printWriter.flush();
    }
}
