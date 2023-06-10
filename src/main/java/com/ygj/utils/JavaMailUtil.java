package com.ygj.utils;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public class JavaMailUtil {

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String i) {

        //创建一封邮件
        MimeMessage message = new MimeMessage(session);
        try {
            //发件人
            message.setFrom(new InternetAddress(sendMail));

            //收件人
            message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMail));

            //Subject: 邮件主题
            message.setSubject("微风注册验证码如下", "UTF-8");

            //Content: 邮件正文
//            int i = (int) ((Math.random() * 9 + 1) * 100000);
            message.setContent(i, "text/html;charset=UTF-8");
            //设置发件时间
            message.setSentDate(new Date());

            //保存设置
            message.saveChanges();

            // 8、将该邮件保存在本地
            OutputStream out = new FileOutputStream("H://MyEmail" + UUID.randomUUID().toString() + ".eml");
            message.writeTo(out);
            out.flush();
            out.close();
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}
