package com.ygj.Web;

import com.ygj.Model.Product;
import com.ygj.Service.ProService;

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
@WebServlet(name = "SoleServlet",urlPatterns = "/soletest.do")
public class SoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String queryString =req.getQueryString() ;
        System.out.println("参数："+queryString);//name=1

        int nameid =Integer.parseInt(queryString.substring(5)) ;
        System.out.println("截取过后的："+nameid);//获取点击商品的id
        ProService ps=new ProService();
        Product getonepro = ps.getonepro(nameid);
        req.getSession().setAttribute("getonepro",getonepro);
        req.getRequestDispatcher("shoppingonepro.jsp").forward(req,resp);
    }
}
