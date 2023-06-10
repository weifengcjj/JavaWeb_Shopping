package com.ygj.Web;

import com.ygj.Model.Order;
import com.ygj.Model.User;
import com.ygj.Service.ProService;
import com.ygj.Service.Service;

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
@WebServlet(name = "ZhiFuServlet",urlPatterns = "/zhifu")
public class ZhiFuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //User user = (User) req.getSession().getAttribute("user");//订单用户
        int zhifu = Integer.parseInt(req.getParameter("zhifu"));
        int flagid=Integer.parseInt(req.getParameter("flagid"));
        System.out.println("当前支付的订单id："+zhifu);
        System.out.println("当前支付的订单状态："+flagid);
        if(flagid>1&&flagid<3)
        {
            req.getRequestDispatcher("ZhiFuError.jsp").forward(req,resp);
        }
//        else if(flagid==4)
//        {
//            req.getRequestDispatcher("ZhiFuFa.jsp").forward(req,resp);
//        }
        else if(flagid==3)
        {
            Service ss=new Service();
            int i = ss.updateFlag(zhifu);
            if(i!=0)
            {
                req.getRequestDispatcher("ZhifuWan.jsp").forward(req,resp);
            }
            else{
                req.getRequestDispatcher("ZhiFuFa.jsp").forward(req,resp);
            }
        }
        else if(flagid==4)
        {
            req.getRequestDispatcher("ZhifuWan.jsp").forward(req,resp);
        }
        else{
            Service ss=new Service();
            int i = ss.updateFlag(zhifu);
            if(i!=0)
            {
                req.getRequestDispatcher("zhiFuSuccess.jsp").forward(req,resp);
            }
            else{
                req.getRequestDispatcher("ZhiFuFa.jsp").forward(req,resp);
            }
        }

    }
}
