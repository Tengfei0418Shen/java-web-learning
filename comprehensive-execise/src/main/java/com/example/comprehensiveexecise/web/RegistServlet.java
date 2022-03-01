package com.example.comprehensiveexecise.web;

import com.example.comprehensiveexecise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String rCode = request.getParameter("code");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        if (!repassword.equals(password)){
            response.getWriter().println("<html><script>alert(\"密码两次不一致\");location=\"/regist.html\"</script></html>");
        }else{
            HttpSession session = request.getSession();
            String code = (String) session.getAttribute("code");
            if (!code.equalsIgnoreCase(rCode)){
                response.getWriter().println("<html><script>alert(\"验证码输入错误\");location=\"/regist.html\"</script></html>");
            }else{
                boolean regist = userService.regist(username, password);
                if (regist){
                    response.getWriter().println("<html><script>alert(\"注册成功\");location=\"/login.html\"</script></html>");
                }else{
                    response.getWriter().println("<html><script>alert(\"用户名已存在\");location=\"/regist.html\"</script></html>");
                }
            }

        }


    }
}
