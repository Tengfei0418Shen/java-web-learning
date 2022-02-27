package com.example.demoresponse;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/responseServlet")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1");
        // 设置状态码  302
        response.setStatus(302);
        // 设置响应头
        response.setHeader("location","https://www.baidu.com");
        response.setHeader("msg","hello");
        // 重定向
//        response.sendRedirect();
    }
}
