package com.ygj.Web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
@WebServlet(name = "ExitLogin",urlPatterns = "/exitlogin")
public class ExitLogin  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        int type = (int) req.getSession().getAttribute("type");
        if(type!=0)
        {
            req.getSession().removeAttribute("user");
            System.out.println("用户已经退出登录了！！！");
            req.getSession().removeAttribute("msg");
            req.getRequestDispatcher("shoppingdemo.jsp").forward(req,resp);
        }
        else{
            req.getSession().removeAttribute("user");
            System.out.println("管理员已经退出登录了！！！");
            req.getSession().removeAttribute("msg");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
