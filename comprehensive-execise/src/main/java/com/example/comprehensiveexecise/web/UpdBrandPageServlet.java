package com.example.comprehensiveexecise.web;

import com.example.comprehensiveexecise.entity.Brand;
import com.example.comprehensiveexecise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/upd")
public class UpdBrandPageServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Brand brand = brandService.getBrandById(id);
        request.setAttribute("brand",brand);
        request.getRequestDispatcher(request.getContextPath()+"/updBrand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
