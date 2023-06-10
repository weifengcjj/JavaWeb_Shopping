package com.ygj.Web;

import com.ygj.Model.User;
import com.ygj.Service.Service;

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
@WebServlet(name = "PasswordUpdateServlet",urlPatterns = "/setpwd")
public class PasswordUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String oldpwd = req.getParameter("oldpwd");
        String newpwd = req.getParameter("newpwd");
        User user = (User) req.getSession().getAttribute("user");
        Service ss=new Service();
        if(!user.getPassword().equals(oldpwd))
        {
            req.setAttribute("setpwderror","原密码验证错误!!!");
            req.getRequestDispatcher("PasswordUpdate.jsp").forward(req,resp);
        }
        else{
            if(oldpwd.equals(newpwd))
            {
                req.setAttribute("setpwderror","原密码与新密码不能一致!!!");
                req.getRequestDispatcher("PasswordUpdate.jsp").forward(req,resp);
            }
            else{
                int i = ss.PasswordUpdate(user, newpwd);
                if(i!=0)
                {

                    req.getRequestDispatcher("PasswordUpdateSuccess.jsp").forward(req,resp);
                }
                else{
                    req.getRequestDispatcher("PasswordUpdatefail.jsp").forward(req,resp);
                }
            }
        }

    }
}
