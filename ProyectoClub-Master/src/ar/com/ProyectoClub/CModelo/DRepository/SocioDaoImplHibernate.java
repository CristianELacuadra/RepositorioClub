package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IPersonaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SocioDaoImplHibernate extends GenericDAOImplHibernate<Personas, Integer> implements ISociosDAO {
	private List<Personas> socios = new ArrayList<Personas>();

	public SocioDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Personas> ListarSocioOrderbyMatricula() throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			socios.clear();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			List<Personas> _lista= _sessiondehilo.createQuery("SELECT s FROM Socios s ORDER BY s.matricula").list();	
			_sessiondehilo.getTransaction().commit();
			return _lista;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
		}
	}
	//la implementacion de este metodo se debe realizar en el gestor ya que el campo habilitado se encuentra en 
	//la entidad persona
/*
	@Override
	public List<Personas> ListaActivaSocios() throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			Query q= _sessiondehilo.createQuery("SELECT s FROM Socios s WHERE s.essocio=true ORDER BY s.nroSocio");
			//q.setMaxResults(100); //Devuelve un maximo de 100	
			List<Personas> lista=q.list();
			_sessiondehilo.getTransaction().commit();
			return lista;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException(e);
		}
	}
*/
	//este metodo se utilizaba para sacar el mayor de los numero de socios y asi poder asinar uno mas cuando se agrege
	//desestimar,ya que el nro de socio no se utiliza mas
	/*
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
	*/

}
