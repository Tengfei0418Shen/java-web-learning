package com.example.comprehensiveexecise.web;

import com.example.comprehensiveexecise.entity.Brand;
import com.example.comprehensiveexecise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/updBrand")
public class UpdBrandServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Integer id = Integer.valueOf(request.getParameter("id"));
        String brandname = request.getParameter("brandname");
        String businessname = request.getParameter("businessname");
        Integer order1 = Integer.valueOf(request.getParameter("order1"));
        String detailinfo = request.getParameter("detailinfo");
        boolean  status = Boolean.parseBoolean(request.getParameter("status"));

        boolean isupd = brandService.updBrand(id, brandname, businessname, order1, detailinfo, status);
        if (isupd){
            response.getWriter().println("<html><script>alert(\"修改成功\");location=\"/index\"</script></html>");
        }

    }
}
