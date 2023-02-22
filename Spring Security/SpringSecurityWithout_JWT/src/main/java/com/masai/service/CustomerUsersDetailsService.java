package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;

@Service
public class CustomerUsersDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerRepo cDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> opt = cDao.findByEmail(username);
		
		if(opt.isPresent()) {
			Customer customer = opt.get();
			List<GrantedAuthority> authorities = new ArrayList<>();
			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
			return new User(customer.getEmail(),customer.getPassword(),authorities);
		}else throw new BadCredentialsException("User Detail not found");
		
	}

}
