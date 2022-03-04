package com.example.comprehensiveexecise.web;

import com.example.comprehensiveexecise.entity.User;
import com.example.comprehensiveexecise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login" +
        "")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 是否勾选了"记住我"
        String remember = request.getParameter("remember");
        System.out.println(remember);

        //2.调用Service登录
        User user = userService.login(username, password);

        // 3.判断
        if(user != null){
            //非空
            //判断是否勾选"记住我"
            if ("on".equals(remember)){
                // 1.创建Cookie对象
                Cookie cUserName = new Cookie("username", username);
                Cookie cPassWord = new Cookie("password", password);
                System.out.println("需要记入Cookie");
                // 2. 设置存活时间
                cUserName.setMaxAge(60 *60 *24);
                cPassWord.setMaxAge(60 *60 *24);
                // 3.发送
                response.addCookie(cPassWord);
                response.addCookie(cUserName);

            }else{
                // 1.创建Cookie对象
                Cookie cUserName = new Cookie("username", username);
                Cookie cPassWord = new Cookie("password", password);
                cUserName.setMaxAge(0);
                cPassWord.setMaxAge(0);
                // 3.发送
                response.addCookie(cPassWord);
                response.addCookie(cUserName);
            }


            // 将用户信息存入session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/index");
        }else{
            //登陆失败
            response.getWriter().println("<html><script>alert(\"用户名或密码错误!\");location=\"/login.html\"</script></html>");
        }
    }
}
