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
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(urlPatterns = "/upload1")
@MultipartConfig
public class Upload1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取提交数据中的account
        String username = request.getParameter("username");
        System.out.println(username);

        Part part = request.getPart("file");
        //源文件名
        System.out.println(part.getSubmittedFileName());
        String fileName = "";
        if (part.getContentType() != null) {
            //给文件改名
            fileName = UUID.randomUUID() + part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
            //获取项目的绝对路径
            ServletContext context = this.getServletContext();
            //文件上传的最终目录/文件名
            String realPath = context.getRealPath("upload/" + fileName);
//            上传
            part.write(realPath);
        }
        //把上传的图片的相对路径返回给客户端
        PrintWriter out = response.getWriter();
        out.write("./upload/" + fileName);
        out.flush();
        out.close();
    }
}
