package org.dance.genericDao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDaoImpl<T, ID extends Serializable> {
	
	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;

	
	public AbstractDaoImpl(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}
	
	public T findOne(ID id) {
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T update(T entity) {
		return entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(ID entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}
