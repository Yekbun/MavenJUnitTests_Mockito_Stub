package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import entities.Customer;
import dao.CustomerRepository;

public class CustomerServiceTestMock {
	private CustomerService customerService ;
	private CustomerRepository customerRepository ;
		
	@Before
	public void setUp()
	{ 
		customerService = new CustomerService();			
		customerRepository =  Mockito.mock(CustomerRepository.class);
		customerService.setCustomerRepository(customerRepository);
	}
	
	@Test
	public void testGetCustomer() {		
		Customer customer = Mockito.mock(Customer.class);			
		Mockito.when(customer.getId()).thenReturn(1);				
        assertEquals(customer.getId(), 1);         
	}
	
	@Test
	public void testAddCustomer() {
		//Given
		Customer customer = new Customer();
		//When
		customerService.addCustomer(customer);		
		//Then		
		Mockito.verify(customerRepository).add(customer);
	}
	
	@Test
	public void testDeleteCustomer() {
		
		//Given
		Customer customer = new Customer(3,"Heja","So");
		customerService.addCustomer(customer);		
		Mockito.verify(customerRepository).add(customer);			
		//when	
		customerService.deleteCustomer(3);		
		Mockito.verify(customerRepository).delete(3);			
		//Then		
		assertNull( customerRepository.get(3));	
	}
	
	
	@Test
	public void testUpdateCustomer() {		
		//Given
		Customer customer = new Customer(3,"Heja","So");
		customerService.addCustomer(customer);		
		Mockito.verify(customerRepository).add(customer);		
		//when
		Mockito.when((customerRepository).get(3)).thenReturn(customer);		
		customer = new Customer(3,"Heja","So123");		
		//Then. call the main method you want to test
		customerService.updateCustomer(customer);		
		Mockito.verify(customerRepository).update(customer);
				
	}
	
	@Test
	 public void testGetAllCustomer() {
		
		//Given
		ArrayList<Customer> custList = new ArrayList<Customer>();
		custList.add(new Customer(10,"Arya","So"));
		custList.add(new Customer(11,"Hevi","So"));
		custList.add(new Customer(12,"Havin","So"));		
		//when
		Mockito.when(customerRepository.getAll()).thenReturn(custList); 		 
		 //Then. call the main method you want to test
		List result = customerService.getAll();		 
		//MOCK ALERT: verify the method was called
		Mockito.verify(customerRepository).getAll(); 
	 }
}
