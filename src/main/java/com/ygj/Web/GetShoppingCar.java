package com.ygj.Web;

import com.ygj.Model.Shoppingcar;
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
@WebServlet(name = "GetShoppingCar",urlPatterns = "/getcar")
public class GetShoppingCar  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        ProService ps=new ProService();

        User user = (User) req.getSession().getAttribute("user");
        System.out.println("getcar页面的用户id"+user.getId());

        List<Shoppingcar> getcar = ps.getcar(user.getId());

        req.getSession().setAttribute("getcar",getcar);
        req.getRequestDispatcher("ShppingCar.jsp").forward(req,resp);
    }
}
