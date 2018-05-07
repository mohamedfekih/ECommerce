package com.ebiznext.business.service;

import com.ebiznext.ecommerce.model.Product;
import com.ebiznext.ecommerce.model.Command;
import com.ebiznext.ecommerce.model.Panier;

public interface CommandService {
	
	public void addCommand(Integer quantite, Integer prix, Product product, Command command, Panier panier);

	public void deleteCommand(Integer commandId, Integer panierId);
}
