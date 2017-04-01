package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metamodel.relational.IllegalIdentifierException;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICajaDAO;

public class CajaDaoImplHibernate extends GenericDAOImplHibernate<Caja, Integer> implements ICajaDAO {
	private List<Caja> listcaja=new ArrayList<Caja>();
	
	public CajaDaoImplHibernate() throws Exception {
		super();
	}
	@Override
	public float Subtotal() {
		try {
		Setsession();
		SetTransaction();
		Integer i=(Integer) _sessiondehilo.createQuery("SELECT count(caja) from Caja caja").uniqueResult(); //-> consulta si esta vacia la tabla
		if(i!=0) {
			Integer id=(Integer) _sessiondehilo.createSQLQuery("SELECT max(caja) from Caja caja").uniqueResult();
			String consulta="SELECT caja.subTotal FROM Caja caja WHERE caja.idCaja="+id;
			return (float) _sessiondehilo.createQuery(consulta).uniqueResult();
		}
		else
			return 0;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Integer DevolverCantiddad() {
		try {
			Setsession();
			SetTransaction();
			String consulta="SELECT count(caja) from Caja caja";
			return (Integer) _sessiondehilo.createQuery(consulta).uniqueResult();
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
		}
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaFecha(Integer anio, Integer mes, Integer dia,boolean tipo) {
		try {
			listcaja.clear();
			//listcaja=null;
			Setsession();
			SetTransaction();
			String query="SELECT c FROM Caja c WHERE day(c.fecha)="+dia.toString()+"and  month(c.fecha)="+mes.toString()+"and YEAR(c.fecha)="+anio.toString()+"and c.tipo="+tipo;
			listcaja= _sessiondehilo.createQuery(query).list();
			return listcaja;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
			
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaPoranio(Integer anio,boolean tipo) {
		try {
			listcaja.clear();
			//listcaja=null;
			Setsession();
			SetTransaction();
			String query="SELECT c FROM Caja c WHERE YEAR(c.fecha)="+anio.toString()+"and c.tipo="+tipo;
			listcaja = _sessiondehilo.createQuery(query).list();
			return listcaja;
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
	public List<Caja> ListaPormes(Integer anio,Integer mes,boolean tipo) {
		try {
			listcaja.clear();
			//listcaja=null;
			Setsession();
			SetTransaction();
			String query="SELECT c FROM Caja c WHERE month(c.fecha)="+mes.toString()+"and YEAR(c.fecha)="+anio.toString()+"and c.tipo="+tipo;
			listcaja = _sessiondehilo.createQuery(query).list();
			return listcaja;
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
	/**
	 * @return lista total de egresos
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICajaDAO#ListaTotalEgresos(java.lang.Integer, java.lang.Integer)
	 **/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaTotalEgresos() {
		try {
			listcaja.clear();
			//listcaja=null;
			String consulta=new String();
			Setsession();
			consulta="SELECT s FROM Caja s WHERE s.tipo="+false; //retorna historial de ingreso	
			listcaja= _sessiondehilo.createQuery(consulta).list();		
			return listcaja;
		}
		catch(Exception ex){
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(ex);
		}
	}
	/**
	 * @return lista total de ingresos
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICajaDAO#ListaTotalEgresos(java.lang.Integer, java.lang.Integer)
	 **/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> ListaTotalIngreso() {
		try {
			listcaja.clear();
			//listcaja=null;
			String consulta=new String();
			Setsession();
			SetTransaction();
			/*
			 * HQL lista de la caja
			 * tipo=true es un Registro de ingreso de la caja
			 */
			consulta="SELECT s FROM Caja s WHERE s.tipo="+true; //retorna historial de ingreso	
			listcaja= _sessiondehilo.createQuery(consulta).list();		
			return listcaja;
		}
		catch(Exception ex){
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(ex);
		}
	}
}
