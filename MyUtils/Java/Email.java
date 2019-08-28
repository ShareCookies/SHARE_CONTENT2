/**
 * 
 */
package com.hecaigui.EAS.utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Administrator
 *
 */
public class Email {
	public static void sendEmail(String toEmail,String emailTitle,String emailBody){
		// TODO Auto-generated method stub
	    // 收件人电子邮箱

	    String to = toEmail;

	    // 发件人电子邮箱
	    String from = "zc58xuejia@163.com";

	    // 指定发送邮件的主机为 
	    String host = "smtp.163.com";  

	    // 获取系统属性
	    Properties properties = System.getProperties();
	  
	    // 设置邮件服务器
	    properties.setProperty("mail.smtp.host",host);

	    properties.put("mail.smtp.auth", "true");
	    // 获取默认session对象
	    Session session = Session.getDefaultInstance(properties,new Authenticator(){
	      public PasswordAuthentication getPasswordAuthentication()
	      {
	       return new PasswordAuthentication("zc58xuejia", "cl85913214"); //�������ʼ��û�������Ȩ��
	      }
	     });

	    try{
	    	// 创建默认的 MimeMessage 对象
	       Message message = new MimeMessage(session);
	       // Set From: 头部头字段
	       message.setFrom(new InternetAddress(from));

	       // Set To: 头部头字段
	       message.addRecipient(Message.RecipientType.TO,
	                                new InternetAddress(to));

	       // Set Subject: 头部头字段
	       message.setSubject(emailTitle);
	       
	       // 设置消息体
	       message.setText(emailBody);
	       // 发送消息
	       Transport.send(message);
	       System.out.println("Sent message successfully");
	    }catch (MessagingException mex) {
	       mex.printStackTrace();
	    }
	}
}
