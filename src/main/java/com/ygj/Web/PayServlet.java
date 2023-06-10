package com.ygj.Web;

import com.ygj.Model.*;
import com.ygj.Service.ProService;
import com.ygj.Service.Service;
import com.ygj.utils.OrdersUUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
@WebServlet(name = "PayServlet",urlPatterns = "/pay")
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Service service=new Service();
        User user = (User) req.getSession().getAttribute("user");//订单用户
        UserDetails userDetails= (UserDetails) req.getSession().getAttribute("userdetails");//用户详情

        System.out.println("当前的用户id:"+user.getId());

        ProService ps=new ProService();

        List<Order> findorder = ps.findorder(user.getId());
        Order order1=new Order();
        if(findorder!=null)
        {
            for (Order order : findorder) {
                if(order.getOrderuser().getId()==user.getId())
                {
                    order1=order;
                }
            }
            System.out.println("当前有无订单:"+order1.getFlag().getId());
            if(order1.getFlag().getId()==1)
            {
                req.getRequestDispatcher("PayError.jsp").forward(req,resp);
            }
            else{
                String ordernum= OrdersUUID.getUUID();//唯一订单号
                System.out.println("生成的订单号为："+ordernum);
                double orderprice = 0;//总价钱
                List<Shoppingcar> getcar = ps.getcar(user.getId());
                for (Shoppingcar shoppingcar : getcar) {
                    orderprice+=shoppingcar.getP().getPrice()*shoppingcar.getSum();
                }
                Date date=new Date(System.currentTimeMillis());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//订单创建时间
                Flag flag=new Flag();

                Order order=new Order(ordernum,orderprice,user,formatter.format(date),flag,userDetails);
                int createOrder = ps.createOrder(order);
                //拿到创建订单过后的订单id
                if(createOrder!=0)
                {
                    int orderMaxid = ps.createOrderMaxid();//创建过后的订单当前id
                    int i = ps.insertToProInOrder(getcar, orderMaxid);
                    if(i!=0)
                    {
                        //先加入订单详情表，再删除购物车
                        int removecar = ps.removecar(user.getId());
                        if(removecar!=0){
                            req.getRequestDispatcher("createOrderSusscs.jsp").forward(req,resp);
                        }
                        else{
                            req.getRequestDispatcher("createOrderfail.jsp").forward(req,resp);
                        }
                    }
                }
                else{
                    req.getRequestDispatcher("createOrderfail.jsp").forward(req,resp);
                }
            }
        }
        else{
            String ordernum= OrdersUUID.getUUID();//唯一订单号
            System.out.println("生成的订单号为："+ordernum);
            double orderprice = 0;//总价钱
            List<Shoppingcar> getcar = ps.getcar(user.getId());
            for (Shoppingcar shoppingcar : getcar) {
                orderprice+=shoppingcar.getP().getPrice()*shoppingcar.getSum();
            }
            Date date=new Date(System.currentTimeMillis());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//订单创建时间
            Flag flag=new Flag();
            Order order=new Order(ordernum,orderprice,user,formatter.format(date),flag,userDetails);
            int createOrder = ps.createOrder(order);
            if(createOrder!=0)
            {
                int orderMaxid = ps.createOrderMaxid();//创建过后的订单当前id
                int i = ps.insertToProInOrder(getcar, orderMaxid);
                if(i!=0)
                {
                    int removecar = ps.removecar(user.getId());
                    if(removecar!=0){
                        req.getRequestDispatcher("createOrderSusscs.jsp").forward(req,resp);
                    }
                    else{
                        req.getRequestDispatcher("createOrderfail.jsp").forward(req,resp);
                    }
                }

            }
            else{
                req.getRequestDispatcher("createOrderfail.jsp").forward(req,resp);
            }
        }

    }
}
