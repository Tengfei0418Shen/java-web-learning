package com.example.sessiontest;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet("/sessionSet")
@Slf4j
public class SessionSetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取Session对象
        HttpSession session = request.getSession();
        // 获取数据
        System.out.println(session);
        session.setAttribute("username","Yours Friend");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
