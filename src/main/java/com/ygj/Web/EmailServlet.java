package com.ygj.Web;
import com.ygj.utils.JavaMailUtil;
import com.ygj.utils.RandomUtil;
import com.ygj.utils.htmlText;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.Properties;


/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
@WebServlet(name = "EmailServlet",urlPatterns = "/email.action")
public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String email = req.getParameter("email");
        req.getSession().setAttribute("em",email);

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        //验证码
        //发件人的邮箱 密码
        //发件人邮箱的SMTP
        // 收件人邮箱
        //Properties properties = new Properties();
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        final Properties properties = System.getProperties() ;//参数配置

        properties.setProperty("mail.transport.protocol", "smtp");// 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.smtp.host", "smtp.qq.com");//发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.auth", "true");// 需要请求认证


        //根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(properties);
        // 设置为debug模式, 可以查看详细的发送log
        session.setDebug(true);

        //创建邮件
        String code = RandomUtil.getRandom();
        System.out.println("邮箱验证码：" + code);
        String i = htmlText.html(code);

        MimeMessage message = JavaMailUtil.createMimeMessage(session, "smtp.qq.com", email,i);
        Transport transport = null;
        try {
            //根据 Session 获取邮件传输对象
            transport = session.getTransport();
            //使用邮箱账号和密码连接邮件服务器
            transport.connect("3448589962@qq.com", "caavteyqffpydabi");
            message.setFrom(new InternetAddress("3448589962@qq.com"));
            //发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            //关闭连接
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
            if (transport != null) {
                try {
                    transport.close();//关闭连接
                    //  写入session
                    req.getSession().setAttribute("code1", code);
//                    /*将实体类转成json*/
//                    String result = new Gson().toJson(code);
//                    System.out.println("返回的结果：" + result);
//
//
//                    resp.setCharacterEncoding("utf-8");
//                    resp.setContentType("application/json;charset=utf-8");
//                    /*返回数据*/
//                    resp.getWriter().write(result);
                } catch (MessagingException e) {
                    e.printStackTrace();
                    req.getSession().setAttribute("error", "邮件发送失败");
                }
            }
        }
    }
}
