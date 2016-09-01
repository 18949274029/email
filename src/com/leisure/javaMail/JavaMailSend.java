package com.leisure.javaMail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSend {
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
        Session session = Session.getInstance(props);  
          
        // �����ʼ�����  
        Message msg = new MimeMessage(session);  
        msg.setSubject("bbs");  
        // �����ʼ�����  
        msg.setText("this bbs is quit!");  
        // ���÷�����  
        msg.setFrom(new InternetAddress("18949274029@163.com"));  
          
        Transport transport = session.getTransport();  
        // �����ʼ�������  
        transport.connect("18949274029", "lifeifei521");  
        // �����ʼ�  
        transport.sendMessage(msg, new Address[] {new InternetAddress("379106481@qq.com")});  
        // �ر�����  
        transport.close();  
    }
}
