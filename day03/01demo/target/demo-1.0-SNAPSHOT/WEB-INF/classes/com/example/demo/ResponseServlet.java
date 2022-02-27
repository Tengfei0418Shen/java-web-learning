package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/res")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1");
        // 设置状态码  302
//        response.setStatus(302);
        // 设置响应头
//        response.setHeader("location","/res2");
//        request.setAttribute("msg","hello");

        // 重定向
//        response.sendRedirect();
//        response.setHeader("msg","hello");
        request.setAttribute("msg","hello");
        request.getRequestDispatcher("res2").forward(request,response);
    }
}
