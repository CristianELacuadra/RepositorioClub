package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


public class SociosDaoImplHibernate extends GenericDAOImplHibernate<Sociosa, Integer> implements ISociosDAO {
	private List<Sociosa> socios = new ArrayList<Sociosa>();
	
	public SociosDaoImplHibernate() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sociosa> ListaActivaSocios() {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			/*
			 * HQL para recuperar solo datos habilitados
			 */
			socios = session.createQuery("SELECT s FROM Sociosa s WHERE habilitado=true").list();	
			return socios;
		
		}
		catch (RuntimeException ex) {
			throw ex;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean ValidarSocio(Sociosa socio) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			List<Integer> ListaNro=session.createQuery("SELECT s.nroSocio FROM Sociosa s").list();
			
			for(Integer Nro : ListaNro) {
				if(socio.getNroSocio()== Nro.intValue())
					return true;
			}
			return false;
		}
		catch (RuntimeException ex) {
			ex.printStackTrace();
			throw ex;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
	}
	
	
}
