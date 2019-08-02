<%--
  Created by IntelliJ IDEA.
  User: 比特科技
  Date: 2019/7/30
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <td>userID</td>
        <td>userName</td>
    </tr>

    <c:forEach items="${userInfoList}" var="myItems">
       <tr>
           <td>${myItems.userid}</td>
           <td>${myItems.username}</td>
       </tr>
    </c:forEach>

</table>
</body>
</html>
