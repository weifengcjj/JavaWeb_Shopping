package com.ygj.Web;

import com.ygj.Model.Product;
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
@WebServlet(name = "ZhuYeAdminServlet",urlPatterns = "/zhuyeadmin")
public class ZhuYeAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        ProService ps=new ProService();
        List<Product> list=ps.getallpro();
        req.getSession().setAttribute("allpro",list); //保存
        req.getRequestDispatcher("adminlog.jsp").forward(req,resp);
    }
}
