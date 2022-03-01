<%@ page import="com.example.comprehensiveexecise.entity.Brand" %>
<%@ page import="com.example.comprehensiveexecise.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        table{
            border: 1px  solid #000;
        }
        tr{
            height: 20px;
        }
        tr td{
            width: 100px;
        }
    </style>
</head>
<body>
<% Brand[] brands = (Brand[]) request.getAttribute("brands");
    User user = (User) request.getSession().getAttribute("user");
    pageContext.setAttribute("user",user);
%>

<h1> ${user.username}欢迎您
</h1>
<input type="button" onclick="location='${pageContext.request.contextPath}/addBrand.jsp'" value="新增">
<hr>
<br>
<table>
    <tr>
        <td>序号</td>
        <td>品牌名称</td>
        <td>企业名称</td>
        <td>排序</td>
        <td>品牌介绍</td>
        <td>状态</td>
        <td>操作</td>
    </tr>

        <%
            for (Brand brand:brands){
                pageContext.setAttribute("brand",brand);
        %>
        <tr>
            <td>${brand.id}</td>
            <td>${brand.brandname}</td>
            <td>${brand.businessname}</td>
            <td>${brand.order1}</td>
            <td>${brand.detailinfo}</td>
            <td>${brand.status?1:0}</td>
            <td>
                <a href="${pageContext.request.contextPath}/upd?id=${brand.id}">修改</a>&nbsp;
                <a href="${pageContext.request.contextPath}/delBrand?id=${brand.id}">删除</a>
            </td>
        </tr>
        <%
            }
        %>
</table>
<br/>
</body>
</html>