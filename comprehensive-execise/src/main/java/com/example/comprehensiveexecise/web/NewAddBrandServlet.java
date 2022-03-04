package com.example.comprehensiveexecise.web;

import com.example.comprehensiveexecise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add1")
public class NewAddBrandServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String brandname = request.getParameter("brandname");
        String businessname = request.getParameter("businessname");
        Integer order1 = Integer.valueOf(request.getParameter("order1"));
        String detailinfo = request.getParameter("detailinfo");
        boolean  status = Boolean.parseBoolean(request.getParameter("status"));


        boolean isAdd = brandService.addBrand(brandname, businessname, order1, detailinfo, status);
        response.getWriter().write(String.valueOf(isAdd));
    }
}
