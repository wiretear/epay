package com.era.erapay.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PasswordRecoveryController {
	
	@RequestMapping(value= "/passwordrecoverysetting")
	public String passwordrecoverysetting(Model model, HttpServletRequest request, HttpServletResponse response) {
		 HttpSession session = request.getSession(true);
	     session.setAttribute("PasswordRecovery"," ");
		 return "users/PasswordRecovery";
	}
	
}
