package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import ar.com.ProyectoClub.CModelo.CEntidades.Nosocio;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.INoSocioDAO;

public class NoSocioDaoImplHibernate extends GenericDAOImplHibernate<Nosocio,Integer> implements INoSocioDAO{
	
	private List<Nosocio> _Todos = new ArrayList<Nosocio>();
 
	@SuppressWarnings("unchecked")
	@Override
	public List<Nosocio> ListaNoSociosInhabilitados() {
		Session _session = sessionFactory.getCurrentSession();
			try {
				_session.beginTransaction();
				/*
				 * HQL Lista de socios sancionados
				 */
				_Todos = _session.createQuery("SELECT s FROM Nosocio s WHERE habilitado=false").list();
				return _Todos;
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
