package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICajaDAO;

public class CajaDaoImplHibernate extends GenericDAOImplHibernate<Caja, Integer> implements ICajaDAO {
	
	private List<Caja> _listcaja=new ArrayList<Caja>();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaPoranio(Integer anio) {
		Session _session = sessionFactory.getCurrentSession();
		try {
			_session.beginTransaction();
			/*
			 * HQL lista de la caja por a�o
			 */
			_listcaja = _session.createQuery("SELECT s FROM Caja s WHERE YEAR(fecha) ="+anio.toString()).list();
			return _listcaja;
		}
		catch(RuntimeException ex){
			throw ex;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally{
			_session.close();
		}
		
}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaPormes(Integer anio,Integer mes) {
		Session _session = sessionFactory.getCurrentSession();
		try {
			_session.beginTransaction();
			/*
			 * HQL lista de la caja por mes de un a�o
			 */
			_listcaja = _session.createQuery("SELECT s FROM Caja s WHERE MONTH(fecha)= "+mes.toString()+"AND YEAR(fecha) ="+anio.toString()).list();
			return _listcaja;
		}
		catch(RuntimeException ex){
			throw ex;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally{
			_session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
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
			return _listcaja;
		}
		catch(RuntimeException ex){
			throw ex;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally{
			_session.close();
		}
	}
	@SuppressWarnings("unchecked")
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
			return _listcaja;
		}
		catch(RuntimeException ex){
			throw ex;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally{
			_session.close();
		}
	}

}
