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

# day05 Ajax

## 学习目标

1. 能够使用原生的Ajax请求
2. 能够使用axios发送Ajax请求
3. 熟悉JSON格式,并能使用Fastjson完成Java对象和JSON串的相互转换
4. 使用Axios+json完成综合案例

## 学习内容

1. Ajax描述:

   * Ajax :异步的Javascript和XMl  Asynchronous Javascript and XML

   * 作用:

     1. 异步交互,不需要加载整个页面且与服务器交换数据,然后更新部分网页

     2. 与数据库进行数据交换

        ajax+html 替换 jsp

   * 同步和异步


     1. 同步:浏览器页面在发送请求给浏览器,在服务器处理请求的过程中,浏览器页面不能做其他的操作.只能等到服务器响应结束,浏览器页面才能做其他操作
     2. 异步:浏览器页面发送是那个请求给浏览器,在服务器处理请求的过程中,浏览器还可以做其他的操作

2. 快速入门

   * Ajax的起步联系

     1. 服务端返回数据

     2. 前端通过XMLHttpRequest对象发起异步请求

        ```javascript
        // 1.创建核心对象
        let xHttp = new XMLHttpRequset();
        // 2.发送请求
        xHttp.open("GET","http://localhost:8080/getData");
        xHttp.send();
        // 3.获取响应
        xHttp.onreadystatechange = function () {
            // 4.回调函数处理响应
            if(this.readystate == 4 && this.status==200){
                console.log(this.responceText);
            }
        }
        ```

        

     3. 在回调函数中做页面渲染处理

3. 案例

   1. 需求:在完成用户组测试,当用户输入框失去焦点时,校验用户名是否已存在

   2. 分析

      1. 前端完成的逻辑

         1. 给用户名输入框绑定光标失去焦点事件`onblur`

         2. 发送ajax请求,携带username参数

            > `/check?username` + username

         3. 处理响应:是否显示提示信息

      2. 后端完成的罗技

         1.  接收username用户名
         2. 调用service查询user
         3. 返回提示信息

4. Axios

   1. Axios 对原生的Ajax进行封装,简化了Ajax请求的步骤书写.

      > axios官网  https://www.axios-http.cn

   2. 基本使用

      * 导入axios的js包
      * 使用axios发送请求,并获取响应结果

   3. 说明

      * `axios()`是用来发送异步请求的,小括号中使用js对象传递请求相关的参数
      * `then()`需要传递一个匿名函数,传递的匿名函数称为回调函数,意思是该匿名函数在发送请求时不会被调用,而是在成功响应候调用的函数.而该回调函数中的`resp`参数是对响应的数据进行封装的对象,通过`resp.data`可以获取到响应的数据

5. JSON

   1. JSON规定
      * key必须是字符串
      * value
        1. 数字
        2. 字符串
        3. 布尔值 
        4. 数组 []
        5. 对象 {}
   
   # day06 Filter&Listener

## 学习目标

1. 理解掌握如何编写一个Filter(过滤器)
2. 理解并掌握Filter的各项配置
3. 理解并完成登录验证案例和过滤敏感词汇
4. 理解并掌握动态代理增强某个方法
5. 理解并掌握ServletContextListener监听器
6. 了解Session监听和Request监听
7. 综合案例

## 学习内容

1. Filter快速入门

   * Filter概述

   * Filter快速入门

   * Filter_web.xml配置方式

   * Filter_注解方式

     > ```java
     > @WebFilter(urlPatterns = "/page/*")
     > ```

2. Filter执行流程及详细配置

   * filter_细节执行流程&生命周期

     1. 执行`filter1`的放行前代码
     2. 执行`filter1`的放行代码
     3. 执行`filter2`的放行前代码
     4. 执行`filter2`的放行代码
     5. 访问资源
     6. 执行`filter2`的放行后代码
     7. 执行`filter1`的放行后代码

   * filter拦截路径配置

     1. 精确拦截 "/img/1.jpg"
     2. 目录拦截  "/user/*"
     3. 后缀名拦截 "/*.do"
     4. 拦截所有 "/*"

   * Filter_细节_过滤拦截方式配置

     ```xml
         <filter>
             <filter-name>filterdemo1</filter-name>
             <filter-class>com.example.day06.filter.FilterDemo1</filter-class>
         </filter>
         <filter-mapping>
             <filter-name>filterdemo1</filter-name>
             <url-pattern>/*</url-pattern>
         </filter-mapping>
     ```

     

3. 登录验证案例

   1. 需求:访问服务器资源时,需要先进行登陆验证,如果没有登陆,自动跳转到登陆页面
   2. 分析:

4. 过滤敏感词汇案例及动态代理

   1. Filter_案例2_过滤敏感词汇_分析
   2. 动态代理1_基本实现步骤
   3. 动态代理2_增强方法
   4. Filter_案例2_过滤敏感词汇_实现

5. Listener

   1. Listener的概述

      * web三大组件

      * 事件监听机制

        > 事件
        >
        > 事件源
        >
        > 监听器
        >
        > 注册监听

   2. Listener_servletContextListener的使用

   3. SessionListener

   4. RequestListener

   5. 在线用户案例

   6. javaweb监听器

6. 综合案例

