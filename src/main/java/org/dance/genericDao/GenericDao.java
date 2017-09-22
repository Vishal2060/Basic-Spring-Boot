package org.dance.genericDao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T , ID extends Serializable> {
	   T findOne(final ID id);
	   
	   List<T> findAll();
	 
	   void save(final T entity);
	 
	   T update(final T entity);
	 
	   void delete(final T entity);
	 
	   void deleteById(final ID entityId);
}
