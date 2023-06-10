package com.ygj.Web;

import com.ygj.Model.Order;
import com.ygj.Model.Product;
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
@WebServlet(name = "GetProByOrderServlet",urlPatterns = "/getprobyorder")
public class GetProByOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String queryString =req.getQueryString() ;
        System.out.println("参数："+queryString);//orderid=1

        int orderid =Integer.parseInt(queryString.substring(8)) ;
        System.out.println("截取过后的订单id："+orderid);//

        ProService ps=new ProService();
        List<Shoppingcar> shoppingcars = ps.selectProByOrder(orderid);
        req.getSession().setAttribute("probyorderlist",shoppingcars);
        req.getRequestDispatcher("ProductShowByOrder.jsp").forward(req,resp);

    }
}
