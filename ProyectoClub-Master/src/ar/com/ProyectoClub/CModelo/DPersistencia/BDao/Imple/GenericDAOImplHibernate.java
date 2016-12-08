/**
 * 
 */
package ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessMessage;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;
/**
 * implementacion de la clase generica que acceder a la base de datos
 * y de esta manera no se repita el codigo en las demas implementaciones.
 * De esta clase heredarán las implementaciones de cada interfaz DAO.
 *
 */
/*
 * CRUD(create,read,update,delete)
 */
public class GenericDAOImplHibernate<T,Id extends Serializable> implements IGenericDAO<T,Id> {
    
	protected SessionFactory sessionFactory;
	private Class classePersistente; 
    private EntityManager entitymanager;  
    private final static Logger LOGGER=Logger.getLogger(GenericDAOImplHibernate.class.getName());
	 

     public GenericDAOImplHibernate() {
    	 /*
    	  * guarda el tipo actual de la clase T
    	  */
		this.classePersistente = (Class) ((ParameterizedType) getClass()
			    .getGenericSuperclass()).getActualTypeArguments()[0];
		/*
		 * inicia la session
		 */
		sessionFactory=HibernateUtil.getSessionFactory();
	}
   
	
	@Override
	public T crear() throws BussinessException {
		try{
			return getEntityClass().newInstance();
		}
		catch (InstantiationException | IllegalAccessException ex){
			throw new RuntimeException(ex);
		} 
		catch (RuntimeException ex){
			throw ex;
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public void GuardarActualizar(T entity) throws BussinessException {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} 
		catch (javax.validation.ConstraintViolationException cve) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		} 
		catch (org.hibernate.exception.ConstraintViolationException cve) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		} 
		catch (RuntimeException ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw ex;
		} 
		catch (Exception ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new RuntimeException(ex);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T BuscarUno(Id id) throws BussinessException {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			T entity = (T) session.get(getEntityClass(),id);
			session.getTransaction().commit();
			return entity;
		}
		catch(javax.validation.ConstraintViolationException cve){
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
			}
			catch (Exception exc){
				LOGGER.log(Level.WARNING,"fallo al hacer un rollback",exc);
			}
			throw new BussinessException(cve);
		}
		catch(org.hibernate.exception.ConstraintViolationException cve){
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
			}
			catch (Exception exc){
				LOGGER.log(Level.WARNING,"Fallo al hacer un rollback", exc );
			}
			throw new BussinessException(cve);
		}
		catch (RuntimeException ex){
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
			}
			catch(Exception exc){
				LOGGER.log(Level.WARNING,"Fallo al hacer un rollbacak", exc);
			}
			throw ex;
		}
		catch(Exception ex){
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
			}
			catch(Exception exc){
				LOGGER.log(Level.WARNING,"Fallo al hacer un rollback", exc);
			}
			throw new RuntimeException(ex);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void Eliminar(Id id) throws BussinessException {
	  Session session=sessionFactory.getCurrentSession();
	  try{
		  session.beginTransaction();
		  T entity= (T) session.get(getEntityClass(), id);
		  if(entity == null){
			  throw new BussinessException(new BussinessMessage(null,"los datos a borrar ya no existen"));
		  }
		  session.delete(entity);
		  session.getTransaction().commit();
	  }
	  catch (javax.validation.ConstraintViolationException cve){
		  try{
			  if(session.getTransaction().isActive()){
				  session.getTransaction().rollback();
			  }
		  }
		  catch (Exception exc){
			  LOGGER.log(Level.WARNING,"fallo al haer un rollback",cve);
		  }
		  throw new BussinessException(cve);
	  }
	  catch(org.hibernate.exception.ConstraintViolationException cve){
		  try{
			  if(session.getTransaction().isActive()){
				  session.getTransaction().rollback();
			  }
		  }
		  catch (Exception exc){
			  LOGGER.log(Level.WARNING,"fallo al hacer un rollback", exc);
		  }
		  throw new BussinessException(cve);
	  }
	  catch (BussinessException ex){
		  try{
			  if(session.getTransaction().isActive()){
				  session.getTransaction().rollback();
			  }
		  }
		  catch(Exception exc){
			  LOGGER.log(Level.WARNING,"Fallo al hacer un rollback", exc);
		  }
		  throw ex;
	  }
	  catch (RuntimeException ex){
		  try {
			  if(session.getTransaction().isActive()){
				session.getTransaction().rollback();  
			  }
		  }
		  catch (Exception exc){
			  LOGGER.log(Level.WARNING,"Fallo al hacer un rollback",exc);
		  }
		  throw ex;
	  }
	  catch(Exception ex){
		  try{
			  if(session.getTransaction().isActive()){
				  session.getTransaction().rollback();
			  }
		  }
		  catch (Exception exc){
			  LOGGER.log(Level.WARNING,"Fallo al hacer un rollback", exc);
		  }
		  throw new RuntimeException(ex);
	  }
	}
	@Override
	public List<T> Listar() throws BussinessException {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			List<T> entities = session.createQuery("SELECT e FROM "+ getEntityClass().getName() +" e").list();
			return entities;
		} 
		catch (javax.validation.ConstraintViolationException cve) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		} 
		catch (org.hibernate.exception.ConstraintViolationException cve) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		}
		catch (RuntimeException ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw ex;
		} 
		catch (Exception ex) {
			try {
				if (session.getTransaction().isActive()) {
					session.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new RuntimeException(ex);
		}
	}

	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
				}
}