package com.example.cookietest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/decodeCookie")
@Slf4j
public class CookieDecodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Cookie[] cookies = request.getCookies();
      for (Cookie cookie:cookies){
          if(cookie.getName().equals("info")){
              String info = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
              log.info(cookie.getName()+"~~"+info);
          }
      }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
