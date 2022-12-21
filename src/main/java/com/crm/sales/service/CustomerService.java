package com.crm.sales.service;

import java.util.List;
import java.util.Optional;

import com.crm.sales.entity.Customer;

public interface CustomerService {
	
    public Customer insert( Customer customer) throws Exception;
    public Customer update( Customer customer) throws Exception;

	public String delete(Long id)  throws Exception;
	
    public Optional<Customer> find(Long id);

    public List<Customer> findByZipcode(String zipcode);
	
	public List<Customer> list();
}
