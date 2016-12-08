package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICajaDAO;

public class CajaDaoImplHibernate extends GenericDAOImplHibernate<Caja, Integer> implements ICajaDAO {
	
	private List<Caja> _listcaja=new ArrayList<Caja>();
	
	@Override
	public List<Caja> ListaPoranio(Integer anio) {
		Session _session = sessionFactory.getCurrentSession();
		try {
			_session.beginTransaction();
			/*
			 * HQL lista de la caja por año
			 */
			_listcaja = _session.createQuery("SELECT s FROM Caja s WHERE YEAR(fecha) ="+anio.toString()).list();
			
		}
		catch (Exception e) {
			if (_session.getTransaction().isActive()) {
				_session.getTransaction().rollback();
				e.printStackTrace();
				}
			throw new RuntimeException(e);
			} 
		return _listcaja;
}

	@Override
	public List<Caja> ListaPormes(Integer anio,Integer mes) {
		Session _session = sessionFactory.getCurrentSession();
		try {
			_session.beginTransaction();
			/*
			 * HQL lista de la caja por mes de un año
			 */
			_listcaja = _session.createQuery("SELECT s FROM Caja s WHERE MONTH(fecha)= "+mes.toString()+"AND YEAR(fecha) ="+anio.toString()).list();
			
		}
		catch (Exception e) {
			if (_session.getTransaction().isActive()) {
				_session.getTransaction().rollback();
				e.printStackTrace();
				}
			throw new RuntimeException(e);
			} 
		return _listcaja;
	}
	
	@Override
	public List<Caja> ListaTotalEgresos() {
		Session _session = sessionFactory.getCurrentSession();
		try {
			_session.beginTransaction();
			/*
			 * HQL lista de la caja
			 * tipo=false es un Registro de egreso de la caja
			 */
			_listcaja = _session.createQuery("SELECT s FROM Caja s WHERE tipo="+false).list();
			
		}
		catch (Exception e) {
			if (_session.getTransaction().isActive()) {
				_session.getTransaction().rollback();
				e.printStackTrace();
				}
			throw new RuntimeException(e);
			} 
		return _listcaja;
	}
	@Override
	public List<Caja> ListaTotalIngreso() {
		Session _session = sessionFactory.getCurrentSession();
		try {
			_session.beginTransaction();
			/*
			 * HQL lista de la caja
			 * tipo=true es un Registro de ingreso de la caja
			 */
			_listcaja = _session.createQuery("SELECT s FROM Caja s WHERE tipo="+true).list();
			
		}
		catch (Exception e) {
			if (_session.getTransaction().isActive()) {
				_session.getTransaction().rollback();
				e.printStackTrace();
				}
			throw new RuntimeException(e);
			} 
		return _listcaja;
	}

}
