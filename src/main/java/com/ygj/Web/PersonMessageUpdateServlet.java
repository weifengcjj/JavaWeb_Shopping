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
@WebServlet(name="PersonMessageUpdateServlet",urlPatterns = "/setper")
public class PersonMessageUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String address = req.getParameter("address");
        User user=(User) req.getSession().getAttribute("user");
        Service service=new Service();
        int i = service.PersonMessageUpdata(user, address);
        if(i!=0)
        {
            req.getRequestDispatcher("PersonMessageUpdateSuccess.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("PersonMessageUpdatefail.jsp").forward(req,resp);
        }
    }
}
