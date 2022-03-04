package com.example.comprehensiveexecise.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("111");
        System.out.println(request.getParameter("username"));

        Part part = request.getPart("file");// 原文件名
        System.out.println(part.getSubmittedFileName());
        String fileName = "";

        // 给文件改名
        fileName = new Date().toString();
        // 获取项目部署的绝对路径
        ServletContext context = this.getServletContext();
        // 文件上传最终的目录/文件名
        String realPath = context.getRealPath("upload/" + fileName);
        System.out.println(realPath);
        // 上传
        part.write(realPath);

        // 把上传图片的相对路径返回给客户端
        PrintWriter out = response.getWriter();
        out.write("wenjian上传成功");
        out.flush();
        out.close();
    }
}
