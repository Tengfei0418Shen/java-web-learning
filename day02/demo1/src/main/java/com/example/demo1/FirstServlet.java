package com.example.demo1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet"
        , urlPatterns = {"/FirstServlet"}
        , initParams = {
        @WebInitParam(name="site",value="https://hawuay.com"),
        @WebInitParam(name="name",value="helloA"),
}
)
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String site = this.getInitParameter("site");
        String name = this.getInitParameter("name");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(name);
        out.println(site);
        out.println("</body></html>");
        out.flush();
        out.close();
    }

}
