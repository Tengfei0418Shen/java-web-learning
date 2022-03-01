package com.example.comprehensiveexecise.web;

import java.io.*;

import com.example.comprehensiveexecise.entity.Brand;
import com.example.comprehensiveexecise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

@WebServlet("/index")
@Slf4j
public class IndexServlet extends HttpServlet {

    private BrandService brandService = new BrandService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Brand[] allBrands = brandService.getAllBrands();
        request.setAttribute("brands",allBrands);
        request.getRequestDispatcher(request.getContextPath()+"/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}