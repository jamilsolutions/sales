package com.crm.sales.service;

import com.crm.sales.entity.Customer;
import com.crm.sales.repository.CustomerRepository;
import com.crm.sales.util.IDUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer insert(Customer customer) throws Exception {
		if ( IDUtil.isValid(customer.getId()) == false) {
			//throw new Exception("O ID provided is invalid.");
		}
		Date date = new Date(System.currentTimeMillis());
		customer.setRegistration(date);
		customer.setLastUpdate(date);
		customer = customerRepository.save(customer);

		return customer;
	}

	@Override
	public Customer update(Customer customer) throws Exception {
		if ( IDUtil.isValid(customer.getId()) == false) {
			 new Exception("O ID provided is invalid.");
		}
		Optional<Customer> customerById = customerRepository.findById(customer.getId());
		Date date = new Date(System.currentTimeMillis());
		if ( customerById.isPresent() ) {
			Customer customerUpdt = customerById.get();
			customer.setId(customerUpdt.getId());
			customer.setLastUpdate(date);
			customer = customerRepository.saveAndFlush(customer);
		}

		return customer;
	}
	
	public List<Customer> findByZipcode(String zipcode) {
		return customerRepository.findCustomerByZipCode(zipcode);
	}

	private String convertToJson(Customer customer) throws JsonProcessingException {
		//Object mapper instance
		ObjectMapper mapper = new ObjectMapper();
		//Convert POJO to JSON
		return mapper.writeValueAsString(customer);
	}

	@Override
	public String delete(Long id) throws Exception {
		if ( id != null ) {
			Optional<Customer> customer = customerRepository.findById(id);
			if ( customer.isPresent() ) {
			    customerRepository.delete(customer.get());
			} else {
				throw new Exception("Customer not found by id");
			}
		}
		return null;
	}

	@Override
	public Optional<Customer> find(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer;
	}

	@Override
	public List<Customer> list() {
	    Iterable<Customer> customers = customerRepository.findAll();
	    return mapToList(customers);
	}

	private List<Customer> mapToList(Iterable<Customer> customers) {
	    List<Customer> listOfCustomers = new ArrayList<>();
	    for (Customer student : customers) {
	    	listOfCustomers.add(student);
	    }
	    return listOfCustomers;
	}
}
