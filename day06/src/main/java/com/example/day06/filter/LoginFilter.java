package com.example.day06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/page/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 登录状态校验逻辑代码

        // 1. 将ServletRequset转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //2.取出Session对象
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        String msg="";
        //3.判断user是否为null
        if (user != null) {
            //登陆了,放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //没有登陆,直接跳到登陆了界面
            msg = "没有登录";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/login.jsp").forward(request,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
