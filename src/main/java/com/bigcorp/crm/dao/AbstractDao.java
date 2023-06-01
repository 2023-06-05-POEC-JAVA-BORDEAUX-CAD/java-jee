package com.bigcorp.crm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Base Abstract DAO
 * @author bigcorp
 *
 * @param <T>
 */
public abstract class AbstractDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * @see EntityManager#find(Class, Object)
	 * @param entity
	 */
	public T findById(Class<T> clazz, Long id) {
		return this.entityManager.find(clazz, id);
	}

	/**
	 * @see EntityManager#merge(Object)
	 * @param entity
	 */
	public T merge(T entity) {
		return this.entityManager.merge(entity);
	}

	/**
	 * @see EntityManager#persist(Object)
	 * @param entity
	 */
	public void persist(T entity) {
		this.entityManager.persist(entity);
	}

	/**
	 * @see EntityManager#remove(Object)
	 * @param entity
	 */
	public void remove(T entity) {
		this.entityManager.remove(entity);
	}

}
