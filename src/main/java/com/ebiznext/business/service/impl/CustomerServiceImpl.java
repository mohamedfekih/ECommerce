package com.ebiznext.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.ebiznext.business.service.CustomerService;
import com.ebiznext.ecommerce.dao.CustomerDao;
import com.ebiznext.ecommerce.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Inject
	CustomerDao customerDao;

	@Override
	public Customer findCustomerByNumber(String customerNumber) {
		List<Customer> customersList = customerDao.findAll();
		Customer customer = customersList.stream()
				.filter(accountItem -> customerNumber.equals(accountItem.getCustomerNumber())).findFirst().orElse(null);

		if (customer == null)
			throw new IllegalStateException("No Customer found.");

		return customer;
	}

	@Override
	public void save(Customer customer) {
		List<Customer> customersList = customerDao.findAll();
		List<Customer> customerExits = customersList.stream()
				.filter(iterator -> customer.getMail().equals(iterator.getMail())).collect(Collectors.toList());
		if (!customerExits.isEmpty())
			throw new IllegalStateException("Custmer Mail already exists.");
		customerDao.save(customer);
	}

	@Override
	public boolean update(Customer customer) {
		customerDao.update(customer);
		return true;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean delete(Customer customer) {
		// Custome= customerDao.findById(customer.getId().toString());
		if (customerDao.findById(customer.getId()) == null)
			throw new IllegalStateException("Custmer does not exist.");
		customerDao.delete(customer.getId());
		return true;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customersList = customerDao.findAll();
		if (customersList == null || customersList.isEmpty())
			throw new NullPointerException();
		return customersList;
	}

}
