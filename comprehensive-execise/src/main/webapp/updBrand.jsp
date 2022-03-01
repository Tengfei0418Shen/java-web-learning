<%@ page import="com.example.comprehensiveexecise.entity.Brand" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">
    <style>
        #success_message{ display: none;}
    </style>
</head>
<body>
<% Brand brand = (Brand) request.getAttribute("brand");
    pageContext.setAttribute("brand",brand);%>
<div class="container">

    <form class="well form-horizontal" action="${pageContext.request.contextPath}/updBrand" method="post"  id="contact_form">
        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input  name="id"  hidden="hidden" class="form-control"  type="text" value="${brand.id}">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">品牌名称</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input  name="brandname"  class="form-control"  type="text" value="${brand.brandname}">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label">企业名称</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input  name="businessname" class="form-control"  type="text" value="${brand.businessname}">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label">排序</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input  name="order1" class="form-control"  type="text" value="${brand.order1}">
                    </div>
                </div>
            </div>

            <!-- Text area -->

            <div class="form-group">
                <label class="col-md-4 control-label">描述信息</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                        <textarea class="form-control" name="detailinfo">${brand.detailinfo}</textarea>
                    </div>
                </div>
            </div>

            <%
                if (brand.isStatus()){
            %>
            <div class="form-group">
                <label class="col-md-4 control-label">状态</label>
                <div class="col-md-4">
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" value="false"/> 禁用
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" value="true" checked="checked"/> 启用
                        </label>
                    </div>
                </div>
            </div>
            <%    }else{ %>
            <div class="form-group">
                <label class="col-md-4 control-label">状态</label>
                <div class="col-md-4">
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" value="false" checked="checked"/> 禁用
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="status" value="true" /> 启用
                        </label>
                    </div>
                </div>
            </div>
            <%     }
            %>



            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-warning" >修改 <span class="glyphicon glyphicon-send"></span></button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
