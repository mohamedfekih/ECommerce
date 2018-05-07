package com.ebiznext.ecommerce.dao;

import java.io.Serializable;
import java.util.List;



public interface CrudDao <T, ID extends Serializable> {
	/**
	 * Save entity
	 * 
	 * @author mohamed
	 * @param entity
	 *            : {@linkplain T} entity domain to persist
	 * @return {@link Boolean}
	 * @throws ApplicationException
	 * @throws Exception
	 */
	public boolean save(T entity); // throws Exception, ApplicationException;

	public boolean update(T entity); 
	/**
	 * Loads an entity using its Primary Key
	 * 
	 * @author mohamed
	 * @param entityId
	 *            : the id of the entity to find
	 * @return entity
	 * @throws ApplicationException
	 * @throws Exception
	 */
	public T findById(ID entityId); // throws Exception, ApplicationException;

	/**
	 * Loads all entity.
	 * 
	 * @author mohamed
	 * @return all entity
	 * @throws ApplicationException
	 * @throws Exception
	 */
	public List<T> findAll(); // throws Exception, ApplicationException;

	/**
	 * Deletes an entity using its Primary Key
	 * 
	 * @author mohamed
	 * @param entityId
	 *            : the id of the entity to delete
	 * @return {@link Boolean}
	 * @throws ApplicationException
	 * @throws Exception
	 */
	public boolean delete(ID entityId); // throws Exception,
										// ApplicationException;
}
