package com.codeeaze.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codeeaze.email.model.Mail;
import com.codeeaze.email.service.MailService;

@SpringBootApplication
public class EmailServiceApplication {

	public static void main(String[] args) {
		Mail mail = new Mail();
        mail.setMailFrom("sheikhparvez10@gmail.com");
        mail.setMailTo("sheikhparvez.oist@gmail.com");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nwww.codeeaze.com");
 
        ApplicationContext ctx = SpringApplication.run(EmailServiceApplication.class, args);
        MailService mailService = (MailService) ctx.getBean("mailService");
//        mailService.sendEmail(mail);
        mailService.sendEmailWithAttachment(mail);
	}

}
