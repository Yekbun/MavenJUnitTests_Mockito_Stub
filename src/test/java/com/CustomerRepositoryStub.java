package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CustomerRepository;
import entities.Customer;

public class CustomerRepositoryStub extends CustomerRepository {
private Map<Integer, Customer> customerList= new HashMap<Integer, Customer>();
	
	@Override
	public void add(Customer customer) { 
		customerList.put(customer.getId(), customer);
	}
	
	@Override
	public void delete(Integer customerId) {
		customerList.remove(customerId);
	}
	
	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		super.update(customer);
	}
	@Override
	public Customer get(Integer customerId) {
		return customerList.get(customerId);
	}
	
	@Override
	public List<Customer> getAll() {		
		return new ArrayList<Customer>(customerList.values());		
	}

	public void ClearAll()
	{
		customerList.clear();
	}
	
}
