package com.ebiznext.ecommerce.dao.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.ebiznext.ecommerce.dao.TransactionDao;
import com.ebiznext.ecommerce.model.Transaction;

public class TransactionDaoImpl implements TransactionDao {
	
	Map<Integer, Transaction> transactionHashtable = new Hashtable<Integer, Transaction>();
	
	@Override
	public boolean save(Transaction entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			transactionHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean update(Transaction entity) {
		// TODO Auto-generated method stub
		if (entity != null &&  transactionHashtable.get(entity.getId())!=null) {
			transactionHashtable.remove(entity.getId());
			transactionHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}

	@Override
	public Transaction findById(Integer entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer entityId) {
		// TODO Auto-generated method stub
		return false;
	}

}
