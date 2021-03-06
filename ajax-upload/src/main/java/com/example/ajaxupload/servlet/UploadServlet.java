package com.example.ajaxupload.servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@MultipartConfig
@WebServlet(urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("file");
        //获取文件上传的字节流
        InputStream inputStream = part.getInputStream();
        //给文件改名
        String fileName = UUID.randomUUID() + part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
        //路径转换
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("upload/" + fileName);
        part.write(realPath);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("文件上传成功");
        out.flush();
        out.close();
    }
}
