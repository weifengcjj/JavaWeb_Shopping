package com.ygj.Web;

import com.ygj.Model.Product;
import com.ygj.Model.Shoppingcar;
import com.ygj.Model.User;
import com.ygj.Service.ProService;
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
@WebServlet(name = "ShoppingCarWeb",urlPatterns = "/shoppingcar")
public class ShoppingCarWeb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Service ss=new Service();
        int id = Integer.parseInt (req.getParameter("pid"));
        int sum = Integer.parseInt (req.getParameter("c1"));
        User user = (User) req.getSession().getAttribute("user");//订单用户

        ProService ps=new ProService();
        Product getonepro = ps.getonepro(id);

        Shoppingcar shoppingcar=new Shoppingcar(getonepro,sum,user);//客户端加入生成的购物车对象
        System.out.println("生成的商品对象的id:"+shoppingcar.getP().getId());

        int s1 = ps.findcarofPid(shoppingcar);//判断购物车中是否有该商品

        if(s1!=0)//购物车有相同的商品
        {
            int i = ps.addcarSame(id, sum);
            if(i!=0)
            {
                req.getRequestDispatcher("addCarSusscs.jsp").forward(req,resp);
            }
            else{
                req.getRequestDispatcher("addCarfail.jsp").forward(req,resp);
            }
        }
        else{////新商品进入购物车
            int addcar = ps.addcar(shoppingcar);
            if(addcar!=0)
            {
                System.out.println("添加成功");
                req.getRequestDispatcher("addCarSusscs.jsp").forward(req,resp);
            }
            else{
                System.out.println("添加失败");
                req.getRequestDispatcher("addCarfail.jsp").forward(req,resp);
            }
        }
    }
}
