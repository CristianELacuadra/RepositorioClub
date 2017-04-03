package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IUsuarioDao;

public class UsuarioDaoImplHibernate extends GenericDAOImplHibernate<Usuario, Integer> implements IUsuarioDao {
	
	
	public UsuarioDaoImplHibernate() throws Exception {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean VerificarNick(String usuario) {
		try{
			boolean dev=false;
			Setsession();
			SetTransaction();
			List<Usuario> _nuevo= _sessiondehilo.createQuery("SELECT _query FROM Usuario _query").list();
			for(Usuario _us:_nuevo) {
				if(_us.getNick().equals(usuario)) {
					dev=true;
				    break;
				}
				else
					dev=false;
			}
			 return dev;
		}
		catch(Exception e){
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException("Error a realizar la consulta"+e.toString());
		}
	}
}
