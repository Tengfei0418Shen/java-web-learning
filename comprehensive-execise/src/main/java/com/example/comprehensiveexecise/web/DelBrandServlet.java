package com.example.comprehensiveexecise.web;

import com.example.comprehensiveexecise.entity.Brand;
import com.example.comprehensiveexecise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/delBrand")
public class DelBrandServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Integer id = Integer.valueOf(request.getParameter("id"));
        boolean isdel = brandService.delBrand(id);
        if (isdel){
            response.getWriter().println("<html><script>alert(\"删除成功\");location=\"/index\"</script></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
