package com.example.demo1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/req")
public class ReqServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getProtocol:"+request.getProtocol());
        System.out.println("getContextPath:"+request.getContextPath());
        System.out.println("getServletPath:"+request.getServletPath());
        System.out.println("getQueryString:"+request.getQueryString());
        System.out.println(request.getParameter("name"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getProtocol:"+request.getProtocol());
        System.out.println("getContextPath:"+request.getContextPath());
        System.out.println("getServletPath:"+request.getServletPath());
        System.out.println("getQueryString:"+request.getQueryString());
    }
}
  