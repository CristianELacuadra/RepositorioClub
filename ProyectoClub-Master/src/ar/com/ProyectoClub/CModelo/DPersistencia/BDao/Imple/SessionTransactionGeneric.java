package ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.ISessionTransaccionGeneric;

public abstract class SessionTransactionGeneric implements ISessionTransaccionGeneric{
	private final static Logger LOGGER = Logger.getLogger(SessionTransactionGeneric.class .getName());
	protected Session _sessiondehilo; //-> objeto que hibernet mantine para determinar el contexto
	
	public SessionTransactionGeneric() throws Exception{
		try {
		Setsession();
		SetTransaction();
		}
		catch (Exception e) {
			_sessiondehilo.close();
			throw new RuntimeException("Communications link failure");
		}
	}
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.BDao.ISessionTransaccionGeneric#Setession()
	 */

	@Override
	public void Setsession() throws BussinessException {
		try {
			if((_sessiondehilo==null) || (! _sessiondehilo.isOpen()))
				_sessiondehilo=HibernateUtil.getSessionFactory().getCurrentSession(); //->si la secion no se inicializo, la inicializa
		}
		catch (javax.validation.ConstraintViolationException cv) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					_sessiondehilo.close();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cv);
		}
		catch (org.hibernate.exception.ConstraintViolationException ce) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					_sessiondehilo.close();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(ce);
		}
		catch (RuntimeException re) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					_sessiondehilo.close();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw re;
		}
		catch (Exception e) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					_sessiondehilo.close();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new RuntimeException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.BDao.ISessionTransaccionGeneric#SetTransaction()
	 */
	
	@Override
	public void SetTransaction() throws BussinessException {
		try {
			if(!_sessiondehilo.getTransaction().isActive())
				_sessiondehilo.beginTransaction(); //
		}
		catch (javax.validation.ConstraintViolationException cv) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					_sessiondehilo.close();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(cv);
		}
		catch (org.hibernate.exception.ConstraintViolationException ce) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					_sessiondehilo.close();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new BussinessException(ce);
		}
		catch (RuntimeException re) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					_sessiondehilo.close();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw re;
		}
		catch (Exception e) {
			try {
				if (_sessiondehilo.getTransaction().isActive()) {
					_sessiondehilo.getTransaction().rollback();
					_sessiondehilo.close();
				}
			} catch (Exception exc) {
				LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
			}
			throw new RuntimeException(e);
		}

	}
}
