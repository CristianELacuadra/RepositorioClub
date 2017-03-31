package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICajaDAO;

public class CajaDaoImplHibernate extends GenericDAOImplHibernate<Caja, Integer> implements ICajaDAO {
	
	public CajaDaoImplHibernate() throws Exception {
		super();
	}
	private List<Caja> _listcaja=new ArrayList<Caja>();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaPoranio(Integer anio) {
		try {
			Setsession();
			SetTransaction();
			/*
			 * HQL lista de la caja por año
			 */
			_listcaja = _sessiondehilo.createQuery("SELECT s FROM Caja s WHERE YEAR(fecha) ="+anio.toString()).list();
			return _listcaja;
		}
		catch(RuntimeException ex){
			_sessiondehilo.close();
			throw ex;
		}
		catch (Exception e) {
			_sessiondehilo.close();
			throw new RuntimeException("Error a realizar la consulta"+e.toString());
		}
}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaPormes(Integer anio,Integer mes) {
		try {
			Setsession();
			SetTransaction();
			/*
			 * HQL lista de la caja por mes de un año
			 */
			_listcaja = _sessiondehilo.createQuery("SELECT s FROM Caja s WHERE MONTH(fecha)= "+mes.toString()+"AND YEAR(fecha) ="+anio.toString()).list();
			return _listcaja;
		}
		catch(RuntimeException ex){
			_sessiondehilo.close();
			throw ex;
		}
		catch (Exception e) {
			_sessiondehilo.close();
			throw new RuntimeException("Error a realizar la consulta"+e.toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaTotalEgresos() {
		try {
			Setsession();
			SetTransaction();
			/*
			 * HQL lista de la caja
			 * tipo=false es un Registro de egreso de la caja
			 */
			_listcaja = _sessiondehilo.createQuery("SELECT s FROM Caja s WHERE tipo="+false).list();
			return _listcaja;
		}
		catch(RuntimeException ex){
			_sessiondehilo.close();
			throw ex;
		}
		catch (Exception e) {
			_sessiondehilo.close();
			throw new RuntimeException("Error a realizar la consulta"+e.toString());
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaTotalIngreso() {
		try {
			/*
			 * HQL lista de la caja
			 * tipo=true es un Registro de ingreso de la caja
			 */
			_listcaja = _sessiondehilo.createQuery("SELECT s FROM Caja s WHERE tipo="+true).list();
			return _listcaja;
		}
		catch(RuntimeException ex){
			_sessiondehilo.close();
			throw ex;
		}
		catch (Exception e) {
			_sessiondehilo.close();
			throw new RuntimeException("Error a realizar la consulta"+e.toString());
		}
	}

}
