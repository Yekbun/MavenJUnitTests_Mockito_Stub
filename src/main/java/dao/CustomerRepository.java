package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Customer;

public class CustomerRepository {

	public void add(Customer customer)
	{
		System.out.println("Add customer has been succeeded!");
	}
	
	public void update(Customer customer)
	{
		System.out.println("Updae customer has been succeeded!");
	}	

	public void delete(Integer customerId)
	{
		System.out.println("Then customer which number "+customerId+" was deleted!");
	}
	
	public Customer get(Integer customerId)
	{
		System.out.println("Are you looking to the customer which number "+customerId+"!");		
		return new Customer();
	}
	
	public List<Customer> getAll()
	{
		System.out.println("All customers !");
		List<Customer> list = new ArrayList<Customer>();		
		return list;					
	}
}
