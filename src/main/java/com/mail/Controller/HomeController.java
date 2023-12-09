package com.mail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mail.Entity.ModelEm;
import com.mail.Service.EmailService;

@Controller
public class HomeController {

	@Autowired
	private EmailService es;
	@GetMapping("/")
	public String  index() {
		return "index";
	}
	@PostMapping("send")
	public String sendEmail(@ModelAttribute ModelEm email) {
		es.sendMail(email);
		System.out.print(email);
		return "redirect:/";
	}
}
