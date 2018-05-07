package com.ebiznext.business.service.impl;

import javax.inject.Inject;

import com.ebiznext.business.service.PanierService;
import com.ebiznext.ecommerce.dao.LinePanierDao;
import com.ebiznext.ecommerce.dao.PanierDao;
import com.ebiznext.ecommerce.model.Command;
import com.ebiznext.ecommerce.model.Customer;
import com.ebiznext.ecommerce.model.LinePanier;
import com.ebiznext.ecommerce.model.Panier;
import com.ebiznext.ecommerce.model.Product;

public class PanierServiceImpl implements PanierService {

	@Inject
	PanierDao panierDAO;

	@Inject
	LinePanierDao linePanierDAO;

	Panier panier;


	public boolean deleteProductFromPanier(Product product, Customer customer) {

		panier = panierDAO.findPanierByCustomer(customer);
		if (panier == null)
			throw new IllegalStateException("Panier Not found.");
		panier.getLinesPanier().forEach(linePanier -> {
			if (linePanier.getProduct().getId() == product.getId()) {
				panierDAO.delete(product.getId());
				return;
			}
		});
		return true;
	}

	public double calculatePanier(Customer customer) {

		panier = panierDAO.findPanierByCustomer(customer);
		if (panier == null)
			throw new IllegalStateException("Panier Not found.");
		return panier.getLinesPanier().stream().mapToDouble(LinePanier::getPrice).sum();

	}

	@Override
	public Panier getPanierByCustomerNumber(Customer customer) {
		panier = panierDAO.findPanierByCustomer(customer);
		if (panier == null)
			throw new IllegalStateException("Panier Not found.");
		return panier;
	}

	@Override
	public long getPanierSizeByCustomer(Customer customer) {
		panier = panierDAO.findPanierByCustomer(customer);
		if (panier == null)
			return 0;
		return panier.getLinesPanier().size();
	}

	@Override
	public void addProductToPanier(Product product, Long price, int qte, Command command) {
		// recuperer lines panier that belongs to customer
		panier = panierDAO.findPanierByCustomer(command.getCustomer());
		panier.getLinesPanier().forEach(linePanier -> {
			if (linePanier.getProduct().getId() == product.getId()) {
				linePanier.setQuantite(linePanier.getQuantite() + 1);
				return;
			}

			linePanierDAO.save(new LinePanier(qte, price, product, command, panier));
		});
		
	}
	
	

}
