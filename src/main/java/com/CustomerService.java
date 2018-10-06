package com;

import java.util.List;

import entities.Customer;
import dao.CustomerRepository;

public class CustomerService {
	
	private CustomerRepository customerRepository ;

	public void addCustomer(Customer customer)
	{
		customerRepository.add(customer);	
	}
	
	public void updateCustomer(Customer customer)
	{
		customerRepository.update(customer);				
	}

	public void deleteCustomer(Integer customerId)
	{
		customerRepository.delete(customerId);				
	}
	
	public Customer getCustomer(Integer customerId)
	{
		return customerRepository.get(customerId);
	}
	
	public List<Customer> getAll()
	{
		return customerRepository.getAll();				
	}
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
}
