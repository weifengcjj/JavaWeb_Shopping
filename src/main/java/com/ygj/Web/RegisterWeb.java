package com.ygj.Web;

import com.ygj.Model.User;
import com.ygj.Service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */

public class RegisterWeb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Service servce=new Service();
        String sessionCode = (String) req.getSession().getAttribute("code1");
        System.out.println("sessionCode生成的验证码:"+sessionCode);
        String username1 = req.getParameter("username1");
        String password1 = req.getParameter("password1");
        String email = (String) req.getSession().getAttribute("em");
        String code = req.getParameter("code");
        System.out.println("页面提交的用户:" + username1);
        System.out.println("页面提交的密码:" + password1);
        System.out.println("页面提交的验证码:" + code);
        User user=new User(username1,password1,email);
        try {
            if(code!=null)
            {
                if(sessionCode.toLowerCase().equals(code.toLowerCase()))
                {
                    if(servce.insertuser(user)==1)
                    {
                        User userlogin = servce.userlogin(user);
                        System.out.println("新注册用户的id"+userlogin.getId());
                        int i = servce.insetPersonMessage(userlogin);
                        if(i!=0)
                        {
                            req.getSession().setAttribute("user",userlogin);//新注册用户
                            req.getSession().setAttribute("type",1);
                            req.getRequestDispatcher("Showregister.jsp").forward(req, resp);
                        }
                    }
                    else{
                        //writer.println("添加失败！！！");
                        req.getSession().setAttribute("logonmsg","注册失败！！！");
                        System.out.println("注册失败");
                        req.getRequestDispatcher("register.jsp").forward(req, resp);
                    }
                }
                else {
                    //  验证失败
                    //writer.println("验证失败！！！");
                    req.getSession().setAttribute("logonmsg","验证码有误！！！");
                    req.getRequestDispatcher("register.jsp").forward(req, resp);
                    //req.getRequestDispatcher("fail.jsp").forward(req, resp);
                }
            }
            else {
                //writer.println("验证码不能为空！！！");
                 req.getSession().setAttribute("logonmsg","验证码不能为空！！！");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                //req.getRequestDispatcher("fail.jsp").forward(req, resp);
            }
            req.removeAttribute("code");
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
