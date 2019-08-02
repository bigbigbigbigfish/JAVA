
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show List Page</title>
</head>
<body>

     <table border="1" align="center">
         <tr>
             <td>UserID</td>
             <td>UserName</td>
             <td>UserPassword</td>
         </tr>

         <c:forEach items="${userList}" var="userlistVar">
             <tr>
                 <td>${userlistVar.userId}</td>
                 <td>${userlistVar.userName}</td>
                 <td>${userlistVar.password}</td>
             </tr>
         </c:forEach>
     </table>
</body>
</html>
