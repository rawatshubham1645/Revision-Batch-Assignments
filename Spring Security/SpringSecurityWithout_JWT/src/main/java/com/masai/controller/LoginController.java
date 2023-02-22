package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerRepo cService;
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailHandler(Authentication authentication){
		System.out.println(authentication);
		Customer customer = cService.findByEmail(authentication.getName()).orElseThrow(()->new BadCredentialsException("Invalid Username or password"));
		return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
	}
}
