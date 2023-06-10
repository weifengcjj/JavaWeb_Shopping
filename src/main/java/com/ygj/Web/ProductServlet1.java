package com.ygj.Web;

import com.ygj.Model.Product;
import com.ygj.Service.ProService;
import com.ygj.Service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
@WebServlet(name = "ProductServlet1",urlPatterns = "/pro1.do")
public class ProductServlet1 extends HttpServlet {
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
        System.out.println("截取过后的："+nameid);//

        ProService ps=new ProService();
        List<Product> list=new ArrayList<>();
        Product product=new Product();
        product.setTypeid(nameid);
        if(nameid==0)
        {
            list=ps.getallpro();
        }
        else {
            list=ps.getproBytype(product);
        }
        req.getSession().setAttribute("allpro",list); //保存
        req.getRequestDispatcher("shoppingdemo1.jsp").forward(req,resp);
    }
}
