package com.MdinaBus.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
	
	 @RequestMapping("/success")
	    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

		 String role =  authResult.getAuthorities().toString();


	        if(role.contains("E_CONSOMMATION")){
	         response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/consomation"));                            
	         }
	         else if(role.contains("E_ROULEMENT")) {
	             response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/roulement"));
	         }
	         else if(role.contains("ADMIN") || role.contains("DESSINEUR") ) {
	             response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/entites"));
	         }
	         
	         
	        
	    }
	
		

}
