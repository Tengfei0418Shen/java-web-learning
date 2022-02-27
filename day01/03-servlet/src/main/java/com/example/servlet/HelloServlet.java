package com.example.servlet;

import java.io.*;
import java.util.Scanner;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "冬奥会加油!";
        System.out.println("inited...");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        System.out.println("get...");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        String path = this.getServletContext().getRealPath("image/1.jpg");
        out.println("<img src=\"image/1.jpg\" width=\"100px\" height=\"100px\" />");
        out.println("</body></html>");



    }

    public void destroy() {
        System.out.println("destroyed...");
    }
}