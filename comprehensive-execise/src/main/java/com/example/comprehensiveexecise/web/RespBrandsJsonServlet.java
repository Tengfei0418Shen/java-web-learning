package com.example.comprehensiveexecise.web;

import com.alibaba.fastjson.JSON;
import com.example.comprehensiveexecise.entity.Brand;
import com.example.comprehensiveexecise.service.BrandService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/getBrands")
public class RespBrandsJsonServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Brand[] allBrands = brandService.getAllBrands();
        String s = JSON.toJSONString(allBrands);
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
