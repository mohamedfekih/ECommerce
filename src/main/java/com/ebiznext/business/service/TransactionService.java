package com.ebiznext.business.service;

import com.ebiznext.ecommerce.model.Transaction;

public interface TransactionService {

	public boolean updateTransactionStatus(Transaction transaction);
	
}
