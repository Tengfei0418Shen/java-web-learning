<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/4
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<h2>登录</h2>
<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("user","user");
%>
<h3>
  <%=request.getAttribute("msg")%>
</h3>
</body>
</html>
