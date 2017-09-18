/**
 * 
 */
package ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessMessage;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

/**
 * implementacion de la clase generica que acceder a la base de datos
 * y de esta manera no se repita el codigo en las demas implementaciones.
 * De esta clase heredarán las implementaciones de cada interfaz DAO.
 *
 */
/*
 * CRUD(create,read,update,delete)
 */
public class GenericDAOImplHibernate<T,Id extends Serializable> extends SessionTransactionGeneric implements IGenericDAO<T,Id> {
    
    private final static Logger LOGGER = Logger.getLogger(GenericDAOImplHibernate.class.getName());
    
	public GenericDAOImplHibernate() throws Exception {
		super();
	}
   
	
     @Override
     public T crear() throws BussinessException {
    	 try {
    		 return getEntityClass().newInstance();
    	 } catch (InstantiationException | IllegalAccessException ex) {
    		 throw new RuntimeException(ex);
    	 } catch (RuntimeException ex) {
    		 throw ex;
    	 } catch (Exception ex) {
    		 throw new RuntimeException(ex);
    	 }
     }
	
    @Override
	public void GuardarEntity(T entity) throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			_sessiondehilo.saveOrUpdate(entity);
			_sessiondehilo.getTransaction().commit();
		} 
		catch (javax.validation.ConstraintViolationException cve) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo .getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		} 
		catch (org.hibernate.exception.ConstraintViolationException cve) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		} 
		catch (RuntimeException ex) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw ex;
		} 
		catch (Exception ex) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
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
		try{
			Setsession();
			SetTransaction();
			T entity = (T) _sessiondehilo.get(getEntityClass(),id);
			_sessiondehilo.getTransaction().commit();
			return entity;
		}
		catch(javax.validation.ConstraintViolationException cve){
			try{
				if(_sessiondehilo.getTransaction().isActive()){
					_sessiondehilo.getTransaction().rollback();
				}
			}
			catch (Exception exc){
				LOGGER.log(Level.WARNING,"fallo al hacer un rollback",exc);
			}
			throw new BussinessException(cve);
		}
		catch(org.hibernate.exception.ConstraintViolationException cve){
			try{
				if(_sessiondehilo.getTransaction().isActive()){
					_sessiondehilo.getTransaction().rollback();
				}
			}
			catch (Exception exc){
				LOGGER.log(Level.WARNING,"Fallo al hacer un rollback", exc );
			}
			throw new BussinessException(cve);
		}
		catch (RuntimeException ex){
			try{
				if(_sessiondehilo.getTransaction().isActive()){
					_sessiondehilo.getTransaction().rollback();
				}
			}
			catch(Exception exc){
				LOGGER.log(Level.WARNING,"Fallo al hacer un rollbacak", exc);
			}
			throw ex;
		}
		catch(Exception ex){
			try{
				if(_sessiondehilo.getTransaction().isActive()){
					_sessiondehilo.getTransaction().rollback();
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
	  try{
		  Setsession();
		  SetTransaction();
		  T entity= (T) _sessiondehilo.get(getEntityClass(), id);
		  if(entity == null){
			  throw new BussinessException(new BussinessMessage(null,"los datos a borrar ya no existen"));
		  }
		  _sessiondehilo.delete(entity);
		  _sessiondehilo.getTransaction().commit();
	  }
	  catch (javax.validation.ConstraintViolationException cve){
		  try{
			  if(_sessiondehilo.getTransaction().isActive()){
				  _sessiondehilo.getTransaction().rollback();
			  }
		  }
		  catch (Exception exc){
			  LOGGER.log(Level.WARNING,"fallo al haer un rollback",cve);
		  }
		  throw new BussinessException(cve);
	  }
	  catch(org.hibernate.exception.ConstraintViolationException cve){
		  try{
			  if(_sessiondehilo.getTransaction().isActive()){
				  _sessiondehilo.getTransaction().rollback();
			  }
		  }
		  catch (Exception exc){
			  LOGGER.log(Level.WARNING,"fallo al hacer un rollback", exc);
		  }
		  throw new BussinessException(cve);
	  }
	  catch (BussinessException ex){
		  try{
			  if(_sessiondehilo.getTransaction().isActive()){
				  _sessiondehilo.getTransaction().rollback();
			  }
		  }
		  catch(Exception exc){
			  LOGGER.log(Level.WARNING,"Fallo al hacer un rollback", exc);
		  }
		  throw ex;
	  }
	  catch (RuntimeException ex){
		  try {
			  if(_sessiondehilo.getTransaction().isActive()){
				  _sessiondehilo.getTransaction().rollback();  
			  }
		  }
		  catch (Exception exc){
			  LOGGER.log(Level.WARNING,"Fallo al hacer un rollback",exc);
		  }
		  throw ex;
	  }
	  catch(Exception ex){
		  try{
			  if(_sessiondehilo.getTransaction().isActive()){
				  _sessiondehilo.getTransaction().rollback();
			  }
		  }
		  catch (Exception exc){
			  LOGGER.log(Level.WARNING,"Fallo al hacer un rollback", exc);
		  }
		  throw new RuntimeException(ex);
	  }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> Listar() throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			List<T> entities = _sessiondehilo.createQuery("SELECT e FROM "+ getEntityClass().getName() +" e").list();
			_sessiondehilo.getTransaction().commit();
			return entities;
		} 
		catch (javax.validation.ConstraintViolationException cve) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		} 
		catch (org.hibernate.exception.ConstraintViolationException cve) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		}
		catch (RuntimeException ex) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw ex;
		} 
		catch (Exception ex) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new RuntimeException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}


	@Override
	public int CantidadRegistros(T entity) throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			String total = _sessiondehilo.createQuery("COUNT(i) FROM "+ getEntityClass().getName() +" i").toString();
			_sessiondehilo.getTransaction().commit();
			return Integer.parseInt(total);
		} 
		catch (javax.validation.ConstraintViolationException cve) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		} 
		catch (org.hibernate.exception.ConstraintViolationException cve) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cve);
		}
		catch (RuntimeException ex) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					}
				} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw ex;
		} 
		catch (Exception ex) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
				}
			} 
			catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new RuntimeException(ex);
		}

	}
}