/**
 * 
 */
package ar.com.ProyectoClub.Modelo.Persistencia.Dao.Imple;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.com.ProyectoClub.Modelo.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.BussinessMessage;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.IGenericDAO;
import ar.com.ProyectoClub.Modelo.Persistencia.Hibernet.HibernateUtil;
/**
 * implementacion de la clase generica que acceder a la base de datos
 * y de esta manera no se repita el codigo en las demas implementaciones.
 * De esta clase heredarán las implementaciones de cada interfaz DAO.
 *
 */
public class GenericDAOImplHibernate<T,Id extends Serializable> implements IGenericDAO<T,Id> {
     
	SessionFactory sessionFactory;
	
	private final static Logger LOGGER=	Logger.getLogger(GenericDAOImplHibernate.class.getName());
	
	public GenericDAOImplHibernate() {
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
	public void Insertar(T entity) throws BussinessException {
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
	@Override
	public void Actualizar(T entity) throws BussinessException {
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
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public List<T> Todos() throws BussinessException {
		Session session = sessionFactory.getCurrentSession();
		try{
			org.hibernate.query.Query query= session.createQuery("SELECT e FROM"+ getEntityClass().getName()+ "e" );
		    @SuppressWarnings("unchecked")
			List<T> entities=query.list();
		    return entities;
		}
		catch (javax.validation.ConstraintViolationException cve){
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
			}
			catch(Exception exc){
				LOGGER.log(Level.WARNING,"Fallo al Hacer un rollback",exc);
			}
			throw new BussinessException(cve);
		}
		catch (org.hibernate.exception.ConstraintViolationException cve){
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
			}
			catch(Exception exc){
				LOGGER.log(Level.WARNING,"Fallo al Hacer un rollback",exc);
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
				LOGGER.log(Level.WARNING,"Fallo al Hacer un rollback",exc);
			}
			throw ex;
		}
		catch (Exception ex){
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();
				}
			}
			catch(Exception exc){
				LOGGER.log(Level.WARNING,"Fallo al Hacer un rollback",exc);
			}
			throw new RuntimeException(ex);
		}
	}
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass(){
		return (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}