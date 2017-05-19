package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;


public class SociosDaoImplHibernate extends GenericDAOImplHibernate<Personas, Integer> implements ISociosDAO {
	private List<Personas> socios = new ArrayList<Personas>();

	public SociosDaoImplHibernate() throws Exception {
		super();
	}
	/**
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO#ListaActivaSocios()
	 * ListaActivaSocios() Devuelve la lista activa de los socios
	 **/

	@SuppressWarnings("unchecked")
	@Override
	public List<Personas> ListaActivaSocios() throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			socios.clear();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			socios = _sessiondehilo.createQuery("SELECT s FROM Personas s WHERE essocio=true AND habilitado=true").list();	
			_sessiondehilo.getTransaction().commit();
			return socios;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Personas> HistoricoSocio() throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			socios.clear();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			List<Personas> _lista= _sessiondehilo.createQuery("SELECT s FROM Personas s WHERE essocio=true").list();	
			_sessiondehilo.getTransaction().commit();
			return _lista;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Integer MaxNroSocio() throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			socios.clear();
			Integer _query= (Integer) _sessiondehilo.createQuery("SELECT MAX(s.nroSocio) From Personas s").uniqueResult();
			_sessiondehilo.getTransaction().commit();
			return _query;
			
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new BussinessException(e);
		}
	}
	
}
