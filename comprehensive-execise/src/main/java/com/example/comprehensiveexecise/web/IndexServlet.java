package com.example.comprehensiveexecise.web;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

@WebServlet("/index")
@Slf4j
public class IndexServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        response.getWriter().write(user.toString());
        log.info((String) user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }
}