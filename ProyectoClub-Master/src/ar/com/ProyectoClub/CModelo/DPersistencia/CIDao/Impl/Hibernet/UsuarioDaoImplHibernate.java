package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;

import org.hibernate.Session;

import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IUsuarioDao;

public class UsuarioDaoImplHibernate extends GenericDAOImplHibernate<Usuario, Integer> implements IUsuarioDao {
	public UsuarioDaoImplHibernate() {
		super();
	}
	
	@Override
	public Usuario Acceder(String usuario, String pass) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			Usuario _nuevo=(Usuario) session.createQuery("SELECT _query FROM Usuario _query WHERE nick="+usuario+"&& Password="+pass);
			return _nuevo;
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			session.close();
		}
	}

}
