package com.ebiznext.business.service.impl;

import com.ebiznext.business.service.CommandService;
import com.ebiznext.ecommerce.model.Command;
import com.ebiznext.ecommerce.model.Panier;
import com.ebiznext.ecommerce.model.Product;

public class CommandServiceImpl implements CommandService {

	@Override
	public void addCommand(Integer quantite, Integer prix, Product product, Command command, Panier panier) {

	}

	@Override
	public void deleteCommand(Integer commandId, Integer panierId) {
		// TODO Auto-generated method stub
		
	}

}
