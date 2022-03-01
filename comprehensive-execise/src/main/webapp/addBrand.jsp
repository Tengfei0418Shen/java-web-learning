<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/1
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .form{
            width: 350px;
            height: 300px;
            /*text-align: center;*/
        }
        .form input{
            /*display: block;*/
            font-size: 14px;
        }
    </style>
</head>
<body>
<form class="form" action="${pageContext.request.contextPath}/add" method="post">
    <label for="">
        序号: <input type="text" name="id" height="true" value="">
    </label><br>
    <label for="">
        品牌名称: <input type="text" name="brandname" height="true" value="">
    </label><br>
    <label for="">
        企业名称: <input type="text" name="businessname" height="true" value="">
    </label><br>
    <label for="">
        排序: <input type="text" name="order1" height="true" value="">
    </label><br>
    <label for="">
        描述信息: <textarea name="detailinfo"  cols="30" rows="5"></textarea>
    </label><br>
    <label for="">
        状态: 禁用<input type="radio" name="status" value="false">
        启用<input type="radio" name="status" value="true">
    </label><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
