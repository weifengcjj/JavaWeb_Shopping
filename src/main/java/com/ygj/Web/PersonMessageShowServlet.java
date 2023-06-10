package com.ygj.Web;

import com.ygj.Model.User;
import com.ygj.Model.UserDetails;
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
@WebServlet(name="PersonMessageShowServlet",urlPatterns = "/showper")
public class PersonMessageShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Service service=new Service();
        User user = (User) req.getSession().getAttribute("user");
        UserDetails userDetails = service.PersonMessageShow(user);
        if(userDetails!=null)
        {
            req.getSession().setAttribute("userdetails",userDetails);
            req.getRequestDispatcher("PersonMessage.jsp").forward(req,resp);
        }
    }
}
