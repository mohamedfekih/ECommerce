package com.ebiznext.ecommerce.dao.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.ebiznext.ecommerce.dao.CommandDao;
import com.ebiznext.ecommerce.model.Command;

public class CommandDaoImpl implements CommandDao {
	
	Map<Integer, Command> commandHashtable = new Hashtable<Integer, Command>();
	
	@Override
	public boolean save(Command entity) {
		// TODO Auto-generated method stub
		if (entity != null) {
			commandHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Command entity) {
		// TODO Auto-generated method stub
		if (entity != null &&  commandHashtable.get(entity.getId())!=null) {
			commandHashtable.remove(entity.getId());
			commandHashtable.put(entity.getId(), entity);
			return true;
		}
		return false;
	}
	
	@Override
	public Command findById(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null)
			return commandHashtable.get(entityId);
		return null;
	}

	@Override
	public List<Command> findAll() {
		// TODO Auto-generated method stub
		if (commandHashtable.size() != 0)
			return (List<Command>) commandHashtable.values();
		return null;
	}

	@Override
	public boolean delete(Integer entityId) {
		// TODO Auto-generated method stub
		if (entityId != null && commandHashtable.containsKey(entityId)) {
			commandHashtable.remove(entityId);
			return true;
		}
		return false;
	}

}
