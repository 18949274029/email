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
        // ����debug����  
        props.setProperty("mail.debug", "true");  
        // ���ͷ�������Ҫ�����֤  
        props.setProperty("mail.smtp.auth", "true");  
        // �����ʼ�������������  
        props.setProperty("mail.host", "smtp.163.com");  
        // �����ʼ�Э������  
        props.setProperty("mail.transport.protocol", "smtp");  
        // ���û�����Ϣ  
        Session session = Session.getInstance(props, new Authenticator() {  
            // ��session�������˻���Ϣ��Transport�����ʼ�ʱ��ʹ��  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication("18949274029", "lifeifei521");  
            }  
        });  
        // �����ʼ�����  
        Message msg = new MimeMessage(session);  
        msg.setSubject("bbs");  
        // ���÷�����  
        msg.setFrom(new InternetAddress("18949274029@163.com"));  
        // ����ռ���  
        msg.setRecipients(RecipientType.TO, InternetAddress.parse("18949274029@163.com,379106482@qq.com"));  
        // ������  
        msg.setRecipient(RecipientType.CC, new InternetAddress("379106481@qq.com"));  
        // ������  
        msg.setRecipient(RecipientType.BCC, new InternetAddress("18221424157@163.com"));  
          
        // ����  
        msg.setSubject("��������");  
        // HTML����  
        msg.setContent("<div align=\"center\">��ð�<span style=\"color:red\">!!!!!!!!!!</span></div>", "text/html;charset=utf-8");  
          
        // �����ʼ��������������ʼ����ر����ӣ�ȫ����  
        Transport.send(msg);  
    }
}
