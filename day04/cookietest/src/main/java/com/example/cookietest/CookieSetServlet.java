package com.example.cookietest;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/setCookie")
public class CookieSetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送Cookie
        // 创建Cookie对象
        Cookie cookie = new Cookie("userName","zhangsan");
        // Cookie持久化
        cookie.setMaxAge(60 * 60 * 24 * 7);
        // 响应发送Cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
