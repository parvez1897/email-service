package com.codeeaze.email.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.codeeaze.email.model.Mail;

@Service("mailService")
public class MailServiceImpl implements MailService {
	@Autowired
	JavaMailSender mailSender;

	@Override
	public void sendEmail(Mail mail) {

		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setTo("sheikhparvez.oist@gmail.com", "codeeaze@gmail.com", "sheikhparvez10@gmail.com");

		msg.setSubject("Testing from Spring Boot Application");
		msg.setText(
				"Hello Parvez, \nThis is an Email from Spring Boot application.\nThanks & Regards\nSheikh Parvez\n8109956241");

		mailSender.send(msg);

//		 MimeMessage mimeMessage = mailSender.createMimeMessage();
//		 
//	        try {
//	 
//	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//	 
//	            mimeMessageHelper.setSubject(mail.getMailSubject());
////	            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "technicalkeeda.com"));
//	            mimeMessageHelper.setTo(mail.getMailTo());
//	            mimeMessageHelper.setText(mail.getMailContent());
//	 
//	            mailSender.send(mimeMessageHelper.getMimeMessage());
//	 
//	        } catch (MessagingException e) {
//	            e.printStackTrace();
//	        } 

	}

	@Override
	public void sendEmailWithAttachment(Mail mail) {
		MimeMessage msg = mailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(msg, true);

			helper.setTo("sheikhparvez.oist@gmail.com");

			helper.setSubject("Testing from Spring Boot with attachment");

			// default = text/plain
			// helper.setText("Check attachment for image!");

			// true = text/html
			helper.setText("<h1>Email eith attachment</h1>"
					+ "<p>Please find attachment for logo.</p>", true);

			// hard coded a file path
			// FileSystemResource file = new FileSystemResource(new
			// File("path/android.png"));
			FileSystemResource file = new FileSystemResource(new File("classpath:logo-Copy.png"));
			helper.addAttachment("james.png", file);
//			helper.addAttachment("my_photo.png", new ClassPathResource("logo-Copy.png"));

			mailSender.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
