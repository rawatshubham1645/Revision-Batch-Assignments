package com.masai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String Hello() {
		return "Hello";
	}
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer c1 = cService.registerCustomer(customer);
		return new ResponseEntity<Customer>(c1,HttpStatus.CREATED);
	}
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getByEmail(@PathVariable("email") String email){
		Customer c1 = cService.getCustomerDetailByEmail(email);
		return new ResponseEntity<Customer>(c1,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		List<Customer> list = cService.getAllCustomerDetails();
		return new ResponseEntity<List<Customer>>(list,HttpStatus.ACCEPTED);
	}
}
