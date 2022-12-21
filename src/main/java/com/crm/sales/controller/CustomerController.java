package com.crm.sales.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.crm.sales.entity.Customer;
import com.crm.sales.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("/insert")
	public Customer insert(@Validated @RequestBody Customer customer) throws MethodArgumentNotValidException, Exception {
		if ( customer == null ) {
			throw new MethodArgumentNotValidException(null, null);
		}

		customer = this.customerService.insert(customer);

		return customer;
	}

	@PatchMapping("/update")
	public Customer update(@Validated @RequestBody Customer customer) throws MethodArgumentNotValidException, Exception {
		if ( customer == null ) {
			throw new MethodArgumentNotValidException(null, null);
		}

		customer = this.customerService.update(customer);

		return customer;
	}

	@GetMapping("/find/{zipcode}")
	public List<Customer> customers(@PathVariable String zipcode) {
		List<Customer> customers = this.customerService.findByZipcode(zipcode);
		return customers;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
		String message = this.customerService.delete(id);
		if ( message == null) {
		return ResponseEntity.status(HttpStatus.OK)
		        .body("{ \"message\": \"Customer "+ id +" successfully deleted\" }");
		} else {
			return ResponseEntity.status(HttpStatus.OK)
			        .body("{ \"message\": \"" + message + "\" }");
		}
	}

	@GetMapping("/list")
	public List<Customer> list() {
		List<Customer> customers = this.customerService.list();
		return customers; 
	}


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleValidationExceptions(Exception ex) {
		Map<String, String> errors = new HashMap<String, String>();
		FieldError error = new FieldError("Exception", "Exception", ex.getMessage());
		String fieldName = ((FieldError) error).getField();
		String errorMessage = error.getDefaultMessage();
		errors.put(fieldName, errorMessage);
	    return errors;
	}

}
