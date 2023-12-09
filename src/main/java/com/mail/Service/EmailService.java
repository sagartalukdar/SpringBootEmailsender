package com.mail.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mail.Entity.ModelEm;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender jms;
	
	public void sendMail(ModelEm modelemail) {
		try {
			MimeMessage mm=jms.createMimeMessage();
			MimeMessageHelper mmh=new MimeMessageHelper(mm);
		
			mmh.setFrom("sagartalukdar0123456789@gmail.com");
			mmh.setTo(modelemail.getEmail());
			mmh.setSubject(modelemail.getSubject());
            mmh.setText(modelemail.getMessage());
             
            jms.send(mm);
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
