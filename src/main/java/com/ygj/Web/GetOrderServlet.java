package com.ygj.Web;

import com.ygj.Model.Order;
import com.ygj.Model.User;
import com.ygj.Service.ProService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
@WebServlet(name = "GetOrderServlet",urlPatterns = "/getorder")
public class GetOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        User user = (User) req.getSession().getAttribute("user");//订单用户
        ProService ps=new ProService();

        List<Order> findorder = ps.findorder(user.getId());
        req.getSession().setAttribute("findorder",findorder);
        req.getRequestDispatcher("PayOrder.jsp").forward(req,resp);
    }
}
