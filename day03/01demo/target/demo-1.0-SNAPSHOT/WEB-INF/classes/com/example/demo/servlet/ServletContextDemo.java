package com.example.demo.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/sc")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 得到servletcontext对象
        ServletContext sc = this.getServletContext();
        // web目录 资源访问
        String bpath = sc.getRealPath("/b");
        System.out.println(bpath);
        //webinfo目录 资源访问
        String cpath = sc.getRealPath("/WEB-INF/c");
        System.out.println(cpath);
        //src目录
        String apath = sc.getRealPath("/WEB-INF/classes/com/example/demo/servlet/a");
        System.out.println(apath);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
