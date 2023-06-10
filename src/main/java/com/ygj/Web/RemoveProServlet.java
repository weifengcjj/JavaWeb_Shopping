package com.ygj.Web;

import com.ygj.Service.ProService;

import javax.servlet.HttpConstraintElement;
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
@WebServlet(name = "RemoveProServlet",urlPatterns = "/removepro")
public class RemoveProServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        int hidden = Integer.parseInt(req.getParameter("hidden"));
        ProService ps=new ProService();
        int i = ps.removePro(hidden);
        if(i!=0){
            req.getRequestDispatcher("removeProSusscs.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("removeProfail.jsp").forward(req,resp);
        }
    }
}
