package org.hackathon.packapp.containerbank.rest;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Customer;
import org.hackathon.packapp.containerbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerRest")
public class CustomerRestController {
	
    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @RequestMapping("/findCustomerById")
	public Customer findCustomerById(@RequestParam(value="id") int id) throws DataAccessException {
		return customerService.findCustomerById(id);
	}

    @RequestMapping("/findCustomerByLastName")
	public Collection<Customer> findCustomerByLastName(@RequestParam(value="lastName") String lastName) throws DataAccessException {
		return customerService.findCustomerByLastName(lastName);
	}

    @RequestMapping("/saveCustomer")
	public void saveCustomer(@RequestParam(value="customer") Customer customer) throws DataAccessException {
    	customerService.saveCustomer(customer);
	}
}
