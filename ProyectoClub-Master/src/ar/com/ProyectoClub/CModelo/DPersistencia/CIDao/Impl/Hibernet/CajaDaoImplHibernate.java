package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metamodel.relational.IllegalIdentifierException;

import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
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
		
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Caja> ListaPorRangoFecha(Date FechaDesde,Date FechaHasta,boolean Ingreso,boolean Egreso) {		
		try {
			listcaja.clear();
			//listcaja=null;
			Setsession();
			SetTransaction();
			String consulta=new String(); 
			String Desde=new String();
			String Hasta=new String();
			int dd=01;
			int mmDesde=FechaDesde.getMonth()+1;
			int aaaaDesde=FechaDesde.getYear()+1900;
			int mmHasta=FechaHasta.getMonth()+1;
			int aaaaHasta=FechaHasta.getYear()+1900;
			Desde=aaaaDesde+"-"+mmDesde+"-"+dd;
			Hasta=aaaaHasta+"-"+mmHasta+"-"+dd;
			if(Egreso && Ingreso)
				consulta="SELECT c FROM Caja c WHERE c.fecha BETWEEN "+"'"+Desde+"'"+" AND "+"'"+Hasta+"'"; //filtro por descripcion
			if(Egreso && !Ingreso)
				consulta="SELECT c FROM Caja c WHERE c.tipo ="+ !Egreso +" AND c.fecha BETWEEN "+"'"+Desde+"'"+" AND "+"'"+Hasta+"'";;
			if(!Egreso && Ingreso)
				consulta="SELECT c FROM Caja c WHERE c.tipo ="+ Ingreso +" AND c.fecha BETWEEN "+"'"+Desde+"'"+" AND "+"'"+Hasta+"'";;	
			
			listcaja= _sessiondehilo.createQuery(consulta).list();
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
			throw new RuntimeException(e.toString());
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
			
			String consulta=new String();
			listcaja.clear();
			Setsession();
			SetTransaction();
			consulta="SELECT s FROM Caja s WHERE s.tipo="+false; //retorna historial de engreso	
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
	@Override
	public Integer ObtenerUltimoIdIngresado() {
		try {
			Setsession();
			SetTransaction();
			Integer IdCaja= (Integer) _sessiondehilo.createQuery("SELECT MAX (q.idCaja) FROM Caja q").uniqueResult();
			return IdCaja;
		}
		catch(Exception ex){
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(ex);
		}
	}
	@Override
	public List<Caja> BusquedaPorDescripcion(String Descripcion,boolean Ingreso,boolean Egreso) {
		try {
			Setsession();
			SetTransaction();
			String consulta=new String();
			
			//Distintas consultas
			if(!Descripcion.isEmpty() && (Egreso && Ingreso))
				consulta="SELECT c FROM Caja c WHERE c.descripcion LIKE '%"+Descripcion+"%'"; //filtro por descripcion
			if(!Descripcion.isEmpty() && (!Egreso && Ingreso))
				consulta="SELECT c FROM Caja c WHERE c.descripcion LIKE '%"+Descripcion+"%'"+" AND tipo="+Ingreso; //filtro por descripcion y ingreso
			if(!Descripcion.isEmpty() && (Egreso && !Ingreso))
				consulta="SELECT c FROM Caja c WHERE c.descripcion LIKE '%"+Descripcion+"%'"+" AND tipo="+!Egreso; //filtro por descripcion e egreso
			
			Query query=_sessiondehilo.createQuery(consulta);
			List<Caja> lista=query.list();
			_sessiondehilo.getTransaction().commit();
			return lista;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
		}
	}
}
