package com.ektdinero.bitacora.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.shq.entities.Usuario;

@Transactional
public abstract class BaseDAO<T> {
	
	private static final String PERSISTENCE_UNIT_NAME = "jdbc/EktdinBitacora";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	
	public BaseDAO() {
	
	 }
	 
	 private Class<T> type;
	 
	/**
	 * Default constructor
	 *
	 * @param type entity class
	 */
	 public BaseDAO(Class<T> type) {
		
	 this.type = type;
	 }
	 
	 /**
	 * Stores an instance of the entity class in the database
	 * @param T Object
	 * @return
	 */
	 public T create(T t) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(t);
		 em.getTransaction().commit();
		 em.close();   
		 return t;
	 }
	 
	 
	//Remember to effective handler errors
	 public void saveAll(List<T> list) throws Exception{
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 for(Object obj : list) em.persist(obj);
		 	 em.getTransaction().commit();
			 em.close();  
		 }
		 
	 
	 
	/**
	 * Retrieves an entity instance that was previously persisted to the database
	 * @param T Object
	 * @param id
	 * @return
	 */
	 public T find(Object id) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 T result = em.find(this.type, id);
		 em.getTransaction().commit();
		 em.close();   
		 return result;

	 }
	 
	/**
	 * Removes the record that is associated with the entity instance
	 * @param type
	 * @param id
	 */
	 public void delete(Object id) {
	    EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 Object ref = em.getReference(this.type, id);
		 em.remove(ref);
		 em.getTransaction().commit();
		 em.close();
	 }
	 
	/**
	 * Removes the number of entries from a table
	 * @param <T>
	 * @param items
	 * @return boolean
	 */
	 public boolean deleteItems(T[] items) {
		 for (T item : items) {
			 if( item instanceof Usuario){
				 Usuario user = (Usuario)item;
			 }			 
			 EntityManager em = factory.createEntityManager();
			 em.getTransaction().begin();
			 em.remove(em.merge(item));
			 em.getTransaction().commit();
			 em.close();
			 
		 }
		 return true;
	 }
	 
	/**
	 * Updates the entity instance
	 * @param <T>
	 * @param t
	 * @return the object that is updated
	 */
	 public T update(T item) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 T result = em.merge(item);
		 em.getTransaction().commit();
		 em.close();   
		 return result;
	 }
	 
	 
	 public void updateAll(List<T> list) throws Exception{
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 for(Object obj : list) em.merge(obj);
		 	 em.getTransaction().commit();
			 em.close();  
		 }
	 
	/**
	 * Returns the number of records that meet the criteria
	 * @param namedQueryName
	 * @return List
	 */
	 public List findWithNamedQuery(String namedQueryName) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 List result = em.createNamedQuery(namedQueryName).getResultList();
		 em.getTransaction().commit();
		 em.close();   
		 return result;		 
	 }
	 
	/**
	 * Returns the number of records that meet the criteria
	 * @param namedQueryName
	 * @param parameters
	 * @return List
	 */
	 public List findWithNamedQuery(String namedQueryName, Map parameters) {
		 return findWithNamedQuery(namedQueryName, parameters, 0);
	 }
	 
	/**
	 * Returns the number of records with result limit
	 * @param queryName
	 * @param resultLimit
	 * @return List
	 */
	 public List findWithNamedQuery(String queryName, int resultLimit) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 List result = em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
		 em.getTransaction().commit();
		 em.close();
		 return result;
	 }
	 
	/**
	 * Returns the number of records that meet the criteria
	 * @param <T>
	 * @param sql
	 * @param type
	 * @return List
	 */
	 @SuppressWarnings("unchecked")
	public List<T> findByNativeQuery(String sql) {
		 List<T> result = null;
		 EntityManager em = factory.createEntityManager();
		 try {
			 em.getTransaction().begin();
			 result = em.createNativeQuery(sql, type).getResultList();
			 em.getTransaction().commit();
			 em.close();
			 return result;
			} catch (Exception ex) {
				em.getTransaction().rollback();
			    throw ex;
			}
	 }
	 

	 @SuppressWarnings("unchecked")
		public List<Object> findAnythingByNativeQuery(String sql) {
		 List<Object> result = null;
		 EntityManager em = factory.createEntityManager();
		 try {
			 em.getTransaction().begin();
			 result = em.createNativeQuery(sql).getResultList();
			 em.getTransaction().commit();
			 em.close();
			 return result;
			} catch (Exception ex) {
				em.getTransaction().rollback();
			    throw ex;
			}		 
		 }
	 
	 
	/**
	 * Returns the number of total records
	 * @param namedQueryName
	 * @return int
	 */
	 public int countTotalRecord(String namedQueryName) {
		 EntityManager em = factory.createEntityManager();
		 Query query = em.createNamedQuery(namedQueryName);
		 try {
			 em.getTransaction().begin();
			 Number result = (Number) query.getSingleResult();
			 em.getTransaction().commit();
			 em.close();
			 return result.intValue();
			} catch (Exception ex) {
				em.getTransaction().rollback();
			    throw ex;
			}
	 }
	 
	/**
	 * Returns the number of records that meet the criteria with parameter map and
	 * result limit
	 * @param namedQueryName
	 * @param parameters
	 * @param resultLimit
	 * @return List
	 */
	 public List findWithNamedQuery(String namedQueryName, Map parameters, int resultLimit) {
		 Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 Query query = em.createNamedQuery(namedQueryName);
		 if (resultLimit > 0) {
			 query.setMaxResults(resultLimit);
		 }
		 for (Map.Entry<String, Object> entry : rawParameters) {
			 query.setParameter(entry.getKey(), entry.getValue());
		 }
		 List result = query.getResultList();
		 em.getTransaction().commit();
		 em.close();
		 return result;
	 }
	 
	 /**
	 * Returns the number of records that will be used with lazy loading / pagination
	 * @param namedQueryName
	 * @param start
	 * @param end
	 * @return List
	 */
	 public List findWithNamedQuery(String namedQueryName, int start, int end) {
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 Query query = em.createNamedQuery(namedQueryName);
		 query.setMaxResults(end - start);
		 query.setFirstResult(start);
		 List result = query.getResultList();
		 em.getTransaction().commit();
		 em.close();
		 return result;
	 }
	 
	 
	
}
