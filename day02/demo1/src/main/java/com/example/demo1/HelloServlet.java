package com.example.demo1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(urlPatterns = "/ahei")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        getServletInfo();
        message = "Hello World!";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>你好啊</h1>");
        out.println("<h1>你好啊</h1>");
        out.println("<h1>你好啊</h1>");
        out.println("</body></html>");


//        request.getRequestDispatcher("know/yes.html").forward(request,response);
//        response.sendRedirect("know/yes.html");
    }

    public void destroy() {
    }

    @Override
    public String getServletInfo() {
        System.out.println(super.getServletInfo());
        return super.getServletInfo();
    }

}