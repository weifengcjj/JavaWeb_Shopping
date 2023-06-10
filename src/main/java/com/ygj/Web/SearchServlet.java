package com.ygj.Web;

import com.ygj.Model.Product;
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
@WebServlet(name = "SearchServlet",urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        ProService ps=new ProService();
        String search = req.getParameter("search");
        User user = (User) req.getSession().getAttribute("user");
        if(search!=null)
        {
            List<Product> list = ps.searchPro(search);
            if(list==null)
            {
                List<Product> getallpro = ps.getallpro();
                req.getSession().setAttribute("allpro", getallpro);
                req.getRequestDispatcher("shoppingdemo1.jsp").forward(req, resp);
            }
            if(user!=null)
            {
                req.getSession().setAttribute("allpro", list);
                req.getRequestDispatcher("shoppingSusscs.jsp").forward(req, resp);
            }
            else{
                req.getSession().setAttribute("allpro", list);
                req.getRequestDispatcher("shoppingdemo1.jsp").forward(req, resp);
            }

        }
        else{
            List<Product> getallpro = ps.getallpro();
            req.getSession().setAttribute("allpro", getallpro);
            req.getRequestDispatcher("shoppingdemo1.jsp").forward(req, resp);
        }

    }
}
