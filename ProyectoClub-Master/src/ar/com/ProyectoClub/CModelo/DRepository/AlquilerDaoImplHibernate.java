package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IAlquilerDAO;

public class AlquilerDaoImplHibernate extends GenericDAOImplHibernate<Alquiler, Integer> implements IAlquilerDAO {
	
    /**
     *  public AlquilerDaoImplHibernate() Constructor inheriting from parent class 
     * @throws Exception
     */
	public AlquilerDaoImplHibernate() throws Exception {
		super();
	}
	/**
	 * public List<Alquiler> BusquedaXFecha(Date fecha) : realiza una consulta sobre la base de dato
	 * para buscar todos los alquiler que se hicieron en una fecha particular(fecha de reserva)
	 * devuelve lista de alquileres
	 **/
	@SuppressWarnings("unchecked")
	@Override
	public List<Alquiler> BusquedaXFecha(Date fechainicial,Date fechafin) {
		try {
			Setsession(); // si hay sessiones activas
			SetTransaction(); //si hay transacciones activas
			@SuppressWarnings("unchecked")
			String HQL_QUERY = "SELECT a from Alquiler a where a.fechaReserva between :start and :end "; //Query rango de fecha
			Query _query = _sessiondehilo.createQuery(HQL_QUERY);
			_query.setParameter("start", fechainicial); //parametro inicial
			_query.setParameter("end", fechafin); //parametro final
			_sessiondehilo.getTransaction().commit();
			return _query.list(); //return lista alquileres		
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
		}
	}
	
}
