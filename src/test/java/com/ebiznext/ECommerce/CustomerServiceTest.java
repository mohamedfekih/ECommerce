package com.ebiznext.ECommerce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ebiznext.business.service.impl.CustomerServiceImpl;
import com.ebiznext.ecommerce.dao.CustomerDao;
import com.ebiznext.ecommerce.model.Customer;

public class CustomerServiceTest {

	@InjectMocks
	CustomerServiceImpl customerService;

	@Mock
	CustomerDao customerDao;

	Map<Integer, Customer> customerHashtable;

	@Before
	public void initTest() throws Exception {

		List<Customer> allCustomers = this.getCustomersMock();
		MockitoAnnotations.initMocks(this);
		when(customerDao.findAll()).thenReturn(allCustomers);
	}

	@Test
	public void allCustomersHaveNames() {
		List<Customer> customers = customerService.getAllCustomers();
		customers.forEach(customer -> {
			assertNotNull(customer.getName());
		});
	}

	@Test
	public void searchCustomerByNumberOk() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Customer customer = new Customer(9, "FR890", "Francois", "Metiran", "19 Rue Jean Moulin 75017",
				"customer1@gmail.com", "0677500437", LocalDate.parse("1981-06-20", dtf), Instant.now());
		assertNotNull(customerService.findCustomerByNumber("FR890"));
		assertEquals(customer.getMail(), customerService.findCustomerByNumber("FR890").getMail());
	}

	@Test
	public void deleteCustomerOk() {
		Customer customer = customerService.findCustomerByNumber("FR894");
		assertNotNull(customer.getName());
		customerDao.delete(customer.getId());
	}

	@Test
	public void testUpdateCustomerOK() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Customer customer = new Customer(9, "FR900", "Francois2", "Metiran2", "19 Rue Jean Moulin 75017",
				"customer3@gmail.com", "0677500437", LocalDate.parse("1981-06-20", dtf), Instant.now());
		assertTrue(customerService.update(customer));
	}

	/**
	 * Mock customer
	 * 
	 * @return
	 */

	public List<Customer> getCustomersMock() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
		Customer customer3 = new Customer(9, "FR890", "Francois", "Metiran", "19 Rue Jean Moulin 75017",
				"customer1@gmail.com", "0677500437", LocalDate.parse("1981-06-20", dtf), Instant.now());

		Customer customer1 = new Customer(9, "FR892", "Francois", "Metiran", "19 Rue Jean Moulin 75017",
				"customer1@gmail.com", "0677500437", LocalDate.parse("1981-06-20", dtf), Instant.now());

		Customer customer2 = new Customer(9, "FR894", "Francois", "Metiran", "19 Rue Jean Moulin 75017",
				"customer1@gmail.com", "0677500437", LocalDate.parse("1981-06-20", dtf), Instant.now());

		Customer customer4 = new Customer(9, "FR900", "Francois", "Metiran", "19 Rue Jean Moulin 75017", "",
				"0677500437", LocalDate.parse("1981-06-20", dtf), Instant.now());

		return new ArrayList<Customer>(Arrays.asList(customer1, customer2, customer3, customer4));
	}

}
