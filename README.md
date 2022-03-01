# JavaWeb学习

# day04

## 学习目标

1. ###  理解什么是会话跟踪技术

2. ### 掌握Cookie的使用

3. ### 掌握Session的使用

4. ### 用户登录注册综合实例

## 学习内容

1. ### 会话跟踪技术的概述

   1. 会话:用户打开浏览器,访问web服务器的资源,会话建立,知道有一方断开连接,会话结束.在一次会话中可以包含多次请求和响应

   2. 会话跟踪:一种维护浏览器状态的方法,服务器需要识别多次请求是否来自于同一个浏览器,以便在同一次会话的多次请求间共享数据.

      * 服务器会收到多个请求,这多个请求可能来自多个浏览器.

      * 服务器需要识别请求是否来自同一个浏览器

      * 服务器用来识别浏览器过程,这个过程就是**会话技术**

      * 服务器识别浏览器候就可以在同一个会话中多次请求之间共享数据

        

      c.如何实现会话跟踪技术?

2. ### Cookie

   > 		Cookie:客户端会话技术,将数据保存到客户端,以后每次请求都携带Cookie数据进行访问.

   1. Cookie的基本使用

      1. 发送Cookie

         * 创建cookie对象,并设置数据
           	Cookie cookie = new Cookie("key","value");

           ```java
           	Cookie cookie = new Cookie("key","value");
           ```

         * 发送到Cookie到客户端:使用**response**对象

           ```Java
           response.addCookie(cookie);
           ```

      2. Java\获取Cookie

         * 获取cookie对象

              Cookie[] cookies = request.getCookies();

         * 通过for循环遍历取值

           ```java
           for (Cookie cookie:cookies){
                       String name = cookie.getName();
                       if (name.equals("userName")){
                           String value = cookie.getValue();
                       }
                   }
           ```

   2. Cookie的原理分析

   3. Cookie的存活时间

      > Void setMaxAge(int seconds);

      1. 正数:将Cookie写入浏览器所在电脑的硬盘,持久化存储.到时间自动删除.
      2. 负数:默认值,Cookie在当前浏览器内存中
      3. 零:删除对应Cookie

3. ### Session

   1. Session的基本使用
      	1. Session的概念:服务端会话跟踪技术,将数据存在服务端.
           		2. Session的工作流程:
              		3. Session的基本使用

   2. Session的原理分析

     > 前提条件:必须保证多次请求的session对象是同一个 

       1.  session是基于cookie来实现的
       2.  session要想实现一次会话多次请求之间共享数据，就必须保证多次请求获取session的对象
       3.  session是如何保证在一次会话中获取的session是同一个呢?

     4.  Session的使用细节
       5.  session的钝化与活化
       6.  session的摧毁

     7.  小结:

     * session数据存储在服务端,服务端重启后,session数据会被保存
     * 浏览器被关闭启动后,重新建立的连接已经是一个全新的会话,获取session数据也是一个新的对象
     * session的数据想要共享,浏览器不能关闭,所以session数据不能创奇保存数据
     * cookie是存储在客户端,是可以长期保存的

   

