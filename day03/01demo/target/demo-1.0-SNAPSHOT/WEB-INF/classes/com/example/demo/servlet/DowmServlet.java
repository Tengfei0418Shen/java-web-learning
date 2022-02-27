package com.example.demo.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/down")
public class DowmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数  文件名
        String filename = request.getParameter("filename");
        // 使用字节输入流,加载文件到内存
        // 获取文件路径
        ServletContext sc = this.getServletContext();
        String realPath = sc.getRealPath(filename);
        // 字节流读入
        FileInputStream fis = new FileInputStream(realPath);
        //设置响应头的打开方式
        response.setHeader("content-disposition","attachment;filename="+filename);

        // 将输入流的数据写到输出流
        ServletOutputStream out = response.getOutputStream();
        byte[] bytes = new byte[1024*8];
        int len;
        while((len = fis.read(bytes)) !=-1){
            out.write(bytes,0,len);
        }
        fis.close();
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
