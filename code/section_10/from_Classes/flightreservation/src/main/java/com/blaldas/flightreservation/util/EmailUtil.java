package com.blaldas.flightreservation.util;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.blaldas.flightreservation.services.ReservationServiceImpl;

@Component
public class EmailUtil {
	
	@Value("${com.blaldas.flightreservation.itenerary.email.subject}")
	private String EMAIL_SUBJECT;
	
	@Value("${com.blaldas.flightreservation.itenerary.email.body}")
	private String EMAIL_BODY;

	@Autowired
	private JavaMailSender sender;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

	public void sendItenerary(String toAddress, String filePath) {
		LOGGER.info("inside sendItenerary");
		MimeMessage message = sender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(EMAIL_SUBJECT);
			messageHelper.setText(EMAIL_BODY);
			messageHelper.addAttachment("Itenerary", new File(filePath));
			LOGGER.info("Sending email to:\t" + toAddress);

			sender.send(message);

		} catch (MessagingException e) {
			LOGGER.error("ERROR: inside sendItenerary:\t" + e);

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
