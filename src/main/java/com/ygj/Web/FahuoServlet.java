package com.ygj.Web;

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
@WebServlet(name = "FahuoServlet",urlPatterns = "/fahuo")
public class FahuoServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");
            //User user = (User) req.getSession().getAttribute("user");//订单用户
            int fahuo = Integer.parseInt(req.getParameter("fahuo"));
            int flagid=Integer.parseInt(req.getParameter("flagid"));
            System.out.println("当前支付的订单id："+fahuo);
            System.out.println("当前支付的订单状态："+flagid);
            if(flagid==1)
            {
                req.getRequestDispatcher("FahuoErrorZhiFu.jsp").forward(req,resp);
            }
            else if(flagid==3)
            {
                req.getRequestDispatcher("FahuoError.jsp").forward(req,resp);
            }
            else if(flagid>3)
            {
                req.getRequestDispatcher("ZhifuWanAdmin.jsp").forward(req,resp);
            }
            else{
                Service ss=new Service();
                int i = ss.updateFlag(fahuo);
                if(i!=0)
                {
                    req.getRequestDispatcher("FahuoSuccess.jsp").forward(req,resp);
                }
                else{
                    req.getRequestDispatcher("Fahuofail.jsp").forward(req,resp);
                }
            }
        }
}
