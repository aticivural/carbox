package com.carbox.contact;

import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean
@RequestScoped
public class Mail {
	
	public  String opinion;
	public  String fullName;
	public  String mailAddress;
	
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	public  void sendMail(){
        final String username = "aticivural@gmail.com";
        final String password = "cgqiaflrdxqlbemo";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                      new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(username, password);
               }
        }); 
        try {

               Message message = new MimeMessage(session);
               message.setFrom(new InternetAddress(mailAddress));
               message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(username));
               message.setSubject("About CARBOX.COM Opinions ");
               message.setText(fullName+"\n"+opinion); 
               Transport.send(message);

        } catch (MessagingException ex) {
               throw new RuntimeException(ex);
        }
  }

}
