package com.ygj.Web;

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
@WebServlet(name = "ManageUserServlet",urlPatterns = "/manageuser")
public class ManageUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        int reuser = Integer.parseInt(req.getParameter("reuser"));
        System.out.println("reuser的值为："+reuser);
        Service ss=new Service();
        int i = ss.removeUser(reuser);
        if(i!=0){
            req.getRequestDispatcher("RemoveUserSusscs.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("RemoveUserfail.jsp").forward(req,resp);
        }
    }
}
