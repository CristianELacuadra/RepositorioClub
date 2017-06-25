package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


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
     @Override
    public List<Personas> FiltrarNomApe(String Nom, String Ape) throws BussinessException {
    	 try {
    		 Setsession();
    		 SetTransaction();
    		 String consulta=new String();

    		 if(!Nom.isEmpty() && Ape.isEmpty())
    			 consulta="SELECT p FROM Personas p WHERE nombre LIKE '%"+Nom+"%' AND p.essocio=true"; //filtro por nombre
    		 if(Nom.isEmpty() && !Ape.isEmpty())
    			 consulta="SELECT p FROM Personas p WHERE apellido LIKE '%"+Ape+"%' AND p.essocio=true"; //filtro por apellido
    		 if(!Nom.isEmpty() && !Ape.isEmpty())
    			 consulta="SELECT p FROM Personas p WHERE nombre LIKE '%"+Nom+"%' OR apellido LIKE '%"+Ape+"%' AND p.essocio=true"; //filtro por nombre y apellido

    		 Query query=_sessiondehilo.createQuery(consulta);
    		 List<Personas> lista=query.list();
    		 _sessiondehilo.getTransaction().commit();
    		 return lista;
    	 }
    	 catch (Exception e) {
    		 _sessiondehilo.beginTransaction().rollback();
    		 _sessiondehilo.close();
    		 throw new RuntimeException(e);
    	 }
     }
	@SuppressWarnings("unchecked")
	@Override
	public List<Personas> ListaActivaSocios() throws BussinessException {
		try {
			Setsession();
			SetTransaction();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			//List<Personas> lista=_sessiondehilo.createQuery("SELECT s FROM Personas s WHERE s.essocio=true AND s.habilitado=true").list();
			Query q= _sessiondehilo.createQuery("SELECT s FROM Personas s WHERE s.essocio=true");
			q.setMaxResults(100); //Devuelve un maximo de 100	
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
