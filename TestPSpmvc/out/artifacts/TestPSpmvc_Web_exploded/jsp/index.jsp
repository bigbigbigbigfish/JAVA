<jsp:useBean id="datetime" scope="request" type="com.cao.springmvc.control.HelloWorldCoroller"/>

<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2019/8/12
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    当前时间: ${datetime}
</h1>

</body>
</html>
