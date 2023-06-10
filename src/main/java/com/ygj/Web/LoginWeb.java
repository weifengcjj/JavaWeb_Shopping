package com.ygj.Web;
import com.ygj.Model.Product;
import com.ygj.Model.Type;
import com.ygj.Model.User;
import com.ygj.Model.UserDetails;
import com.ygj.Service.ProService;
import com.ygj.Service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 * @Author 微风
 * @Version 1.0.1
 * @StartTime Start
 * @EndTime End
 */
@WebServlet(name = "LoginWeb",urlPatterns = "/login")
public class LoginWeb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //System.out.println("come on");
        PrintWriter out= resp.getWriter();
        Enumeration<String> parameterNames = req.getParameterNames();
        Service ss=new Service();
        ProService ps=new ProService();
        List<Product> list=new ArrayList<>();
        list=ps.getallpro();

        Service service=new Service();
        List<Type> getalltype = service.getalltype();

        while (parameterNames.hasMoreElements()) {

            String s = parameterNames.nextElement();
            String value = req.getParameter(s);
            System.out.println(s + "          " + value);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(username+"----"+password);
            int type = Integer.parseInt(req.getParameter("type"));
            System.out.println("登录类型为："+type);
            req.getSession().setAttribute("type",type);//登录类型，方便退出
            switch (type)
            {
                case 0: {
                    User adminuser = new User();
                    adminuser.setUser(username);
                    adminuser.setPassword(password);
                    User admin = ss.admlogin(adminuser);

                    if (admin != null) {
                        req.getSession().setAttribute("user",admin);
                        //req.getSession().setAttribute("allpro",ps.getallpro());
                        //req.getRequestDispatcher("log.jsp").forward(req,resp);
                        //out.println("<script>location.href='WEB-INF/log.jsp';</script>");
                        System.out.println("管理员登录123");
                        req.getSession().setAttribute("alluser", ss.getalluser());
                        req.getSession().setAttribute("allpro", list);
                        req.getRequestDispatcher("adminlog.jsp").forward(req, resp);
                    } else {
                        req.getSession().setAttribute("msg", "管理员账号或密码错误！！！");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                        //out.println("<script>location.href='index.jsp';</script>");
                    }
                    break;
                }
                default:{
                    User autouser=new User();
                    autouser.setUser(username);
                    autouser.setPassword(password);
                    User a=ss.userlogin(autouser);
                    if(a!=null) {
                        req.getSession().setAttribute("allpro", list);
                        req.getSession().setAttribute("user", a);
                        req.getSession().setAttribute("getalltype", getalltype);
                        UserDetails userDetails = service.PersonMessageShow(a);
                        req.getSession().setAttribute("userdetails",userDetails);
                        System.out.println("用户登录123");
                        req.getRequestDispatcher("shoppingSusscs.jsp").forward(req, resp);

                    }
                    else{
                        req.getSession().setAttribute("msg","用户账号或密码错误！！！");
                        req.getRequestDispatcher("login.jsp").forward(req,resp);
                        //out.println("<script>location.href='index.jsp';</script>");
                    }
                    break;
                }
            }
        }
    }
}
