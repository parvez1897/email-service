package com.codeeaze.email.service;

import com.codeeaze.email.model.Mail;

public interface MailService {
	public void sendEmail(Mail mail);
	public void sendEmailWithAttachment(Mail mail);
}
