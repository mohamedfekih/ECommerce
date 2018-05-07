package com.ebiznext.business.service;

import com.ebiznext.ecommerce.model.Command;
import com.ebiznext.ecommerce.model.Customer;
import com.ebiznext.ecommerce.model.Panier;
import com.ebiznext.ecommerce.model.Product;

public interface PanierService {

	public Panier getPanierByCustomerNumber(Customer customer);
	
	public void addProductToPanier(Product product,Long price, int qte, Command command);

	public boolean deleteProductFromPanier(Product product, Customer customer);

	public double calculatePanier(Customer customer);

	public long getPanierSizeByCustomer(Customer customer);
}
