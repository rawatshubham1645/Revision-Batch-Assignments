package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo cDao;
	@Override
	public Customer registerCustomer(Customer customer) {
		return cDao.save(customer);
	}

	@Override
	public Customer getCustomerDetailByEmail(String email) throws CustomerException {
		return cDao.findByEmail(email).orElseThrow(()-> new CustomerException("No Customer Found"));
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		List<Customer> list =cDao.findAll();
		if(list.size()==0)throw new CustomerException("No Customer Present");
		else return list;
	}

}
