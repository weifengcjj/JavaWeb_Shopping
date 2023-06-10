package com.ygj.Web;

import com.ygj.Service.ProService;
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
@WebServlet(name = "AddTypeServlet",urlPatterns = "/addtype")
public class AddTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String parameter = req.getParameter("typename");
        Service ss=new Service();
        int i = ss.insertType(parameter);
        if(i!=0){
            req.getRequestDispatcher("addTypeSusscs.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("addTypefail.jsp").forward(req,resp);
        }
    }
}
