package com.example.comprehensiveexecise.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/code")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //规定验证码的大小
        int width = 120;
        int height = 40;
        //创建一个在内春中存放验证码图片的对象
        BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        // 绘制图片
        Graphics pen = image.getGraphics();
        pen.setFont(new Font("黑体", Font.BOLD,25));
        pen.setColor(Color.pink);
        pen.fillRect(0,0,width,height);


        // 绘制边框
        pen.setColor(Color.BLACK);
        pen.drawRect(0,0,width-1,height-1);
        //生成随机验证码
        String str = "qwertyuiopasdfghjklzxcvbnm123456789QWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();
        // 验证码
        String code="";
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(str.length());
            char s = str.charAt(index);
            code += s;
            pen.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            pen.drawString(String.valueOf(s), width/5*(i+1), height/3+random.nextInt(height/3));
        }
        // 画线
        for (int i = 0; i < 10; i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(height);
            int x3=random.nextInt(width);
            int x4=random.nextInt(height);
            pen.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            pen.drawLine(x1,x2,x3,x4);
        }
        ImageIO.write(image,"jpg",response.getOutputStream());
        //获取session对象
        HttpSession session = request.getSession();
        //清除失效的code
        session.removeAttribute("code");
        //将code存session
        session.setAttribute("code",code);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
