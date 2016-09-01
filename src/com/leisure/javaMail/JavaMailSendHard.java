package com.leisure.javaMail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSendHard {
	public static void main(String[] args) throws MessagingException {  
        Properties props = new Properties();  
        // 开启debug调试  
        props.setProperty("mail.debug", "true");  
        // 发送服务器需要身份验证  
        props.setProperty("mail.smtp.auth", "true");  
        // 设置邮件服务器主机名  
        props.setProperty("mail.host", "smtp.163.com");  
        // 发送邮件协议名称  
        props.setProperty("mail.transport.protocol", "smtp");  
        // 设置环境信息  
        Session session = Session.getInstance(props, new Authenticator() {  
            // 在session中设置账户信息，Transport发送邮件时会使用  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication("18949274029", "lifeifei521");  
            }  
        });  
        // 创建邮件对象  
        Message msg = new MimeMessage(session);  
        msg.setSubject("bbs");  
        // 设置发件人  
        msg.setFrom(new InternetAddress("18949274029@163.com"));  
        // 多个收件人  
        msg.setRecipients(RecipientType.TO, InternetAddress.parse("18949274029@163.com,379106482@qq.com"));  
        // 抄送人  
        msg.setRecipient(RecipientType.CC, new InternetAddress("379106481@qq.com"));  
        // 暗送人  
        msg.setRecipient(RecipientType.BCC, new InternetAddress("18221424157@163.com"));  
          
        // 主题  
        msg.setSubject("中文主题");  
        // HTML内容  
        msg.setContent("<div align=\"center\">你好啊<span style=\"color:red\">!!!!!!!!!!</span></div>", "text/html;charset=utf-8");  
          
        // 连接邮件服务器、发送邮件、关闭连接，全干了  
        Transport.send(msg);  
    }
}
