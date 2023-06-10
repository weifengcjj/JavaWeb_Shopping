package com.ygj.utils;

import com.ygj.Model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取资源请求路径
        String uri = request.getRequestURI();
        if (uri.contains(".search")||uri.contains(".css")||uri.contains(".js")||uri.contains(".jpg")||uri.contains("/login")||uri.contains("zhuye1")||uri.contains("/zhuye")||uri.contains("/pro1.do")|| uri.contains("/pro.do")||uri.contains("/addpro") ||uri.contains("/LoginWeb")||uri.contains("shoppingdemo1.jsp")|| uri.contains("shoppingdemo.jsp") || uri.contains("/email.action") ||uri.contains("/register") || uri.contains("/exitlogin") ||uri.contains("shoppingSusscs.jsp")) {
            //包含，用户就是想登录。放行
            chain.doFilter(req, resp);
        }
        else{
            User user = (User) request.getSession().getAttribute("user");
            System.out.println(user.getUser());
            if(user != null){
                //登录了。放行
                chain.doFilter(req, resp);
            }else{
                //没有登录。跳转登录页面
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("login.jsp").forward(request,resp);
            }
        }
    }
    @Override
    public void destroy() {

    }
}
