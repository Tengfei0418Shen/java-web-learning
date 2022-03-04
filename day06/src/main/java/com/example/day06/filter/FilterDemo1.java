package com.example.day06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FilterDemo1 implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("11111");
        //放行,放请求访问其本该访问的资源
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("333333");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器1销毁");
    }
}
