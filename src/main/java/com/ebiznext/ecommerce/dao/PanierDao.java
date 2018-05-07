package com.ebiznext.ecommerce.dao;

import com.ebiznext.ecommerce.model.Customer;
import com.ebiznext.ecommerce.model.Panier;

public interface PanierDao extends CrudDao<Panier, Integer> {
	
	Panier findPanierByCustomer(Customer customer);


	
}
