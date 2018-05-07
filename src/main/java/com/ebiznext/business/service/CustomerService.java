package com.ebiznext.business.service;

import java.util.List;
import com.ebiznext.ecommerce.model.Customer;

public interface CustomerService {
	
	public Customer findCustomerByNumber(String customerNumber);

	public void save(Customer customer);

	public boolean update(Customer customer);

	public boolean delete(Customer customer);

	public List<Customer> getAllCustomers()  ;
}
