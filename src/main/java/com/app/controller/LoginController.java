package com.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.request.Login;
import com.app.service.LoginService;

@RestController
@RequestMapping("/login/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Validated
public class LoginController {

@Autowired
private LoginService loginService;


	@RequestMapping(value = "/doLogin")
	public Map<String, Object> createAuthenticationToken( @RequestBody Login login) throws Exception {
		return loginService.login(login);		
	}

	
}