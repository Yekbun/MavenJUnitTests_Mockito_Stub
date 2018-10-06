package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entities.Customer;

public class CustomerServiceTestStub {
	private CustomerService customerService ;
	private CustomerRepositoryStub customerRepository = new CustomerRepositoryStub();
		
	@Before
	public void setUp()
	{ 
		customerService = new CustomerService();		
		customerService.setCustomerRepository(customerRepository);	
	}
	
	@After
	public void after()
	{
		customerRepository.ClearAll();
	}
	
	@Test
	public void testGetCustomer() {
		//Given
		Customer customer = new Customer(1,"Viyan","So");		
		//Then
		customerService.addCustomer(customer);
		//When
		assertNotNull(customerRepository.get(1));	
	}	
		
	@Test
	public void testAddCustomer() {
		//Given
		Customer customer = new Customer(1,"Helin","So");
		//When
		customerService.addCustomer(customer);
		//Then		
		assertEquals(customer, customerRepository.get(customer.getId()));			
	}	

	@Test
	public void testDeletCustomer() {
		//Given
		Customer customer = new Customer(2,"Avsin","So");
		customerService.addCustomer(customer);
		assertNotNull(customerRepository.get(2));
		//When
		customerService.deleteCustomer(2);
		//Then		
		assertNull( customerRepository.get(2));		
	}	
	
	@Test
	public void testUpdateCustomer() {
		//Given
		Customer customer = new Customer(3,"Heja","So");
		customerService.addCustomer(customer);
		assertNotNull(customerRepository.get(3));
		//When
		customer.setSurname("So123");
		customerService.updateCustomer(customer);
		//Then		
		System.out.println(customerRepository.get(3).getSurname() +"----" +customer.getSurname());
		assertEquals( customerRepository.get(3).getSurname(),customer.getSurname());		
	}	
		
	@Test
	public void testGetAllCustomer() {
		//Given
		ArrayList<Customer> custList = new ArrayList<Customer>();
		custList.add(new Customer(10,"Arya","So"));
		custList.add(new Customer(11,"Hevi","So"));
		custList.add(new Customer(12,"Havin","So"));		
		
		for(Customer item  : custList) {
			customerService.addCustomer(item);
		}
		System.out.println(customerRepository.getAll().size());
		assertEquals(customerRepository.getAll().size(),3);
	}
	
}
