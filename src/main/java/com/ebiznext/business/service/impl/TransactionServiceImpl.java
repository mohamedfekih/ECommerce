package com.ebiznext.business.service.impl;


import javax.inject.Inject;

import com.ebiznext.business.service.TransactionService;
import com.ebiznext.ecommerce.dao.TransactionDao;
import com.ebiznext.ecommerce.model.Transaction;

public class TransactionServiceImpl implements TransactionService {

	@Inject
	TransactionDao transactionDao;
	
	@Override
	public boolean updateTransactionStatus(Transaction transaction) {
		transactionDao.update(transaction);
		return true;
	}

}
