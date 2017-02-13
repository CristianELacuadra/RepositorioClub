package ar.com.ProyectoClub.CModelo.AServicios.facade;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceUsuario;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IUsuarioDao;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.UsuarioDaoImplHibernate;

public class ServiceUsuario implements IServiceUsuario {
	private IUsuarioDao _usua;
	private Usuario _usuario;
	
	public ServiceUsuario() {
		_usua=new UsuarioDaoImplHibernate();
		_usuario=new Usuario();

	}
	
	@Override
	public String acceder_Administrador(String usuario, String pass) {
		String nom=new String();
		try {
			for(Usuario _usuario2:_usua.Listar()) {
				if(_usuario2.getNick().equals(usuario) && _usuario2.getPassword().equals(pass))
					nom=_usuario2.getTipousuario();
				else 
					nom=null;
			}
			return nom;
		}
		catch (Exception e) {
			throw new RuntimeException(e.toString());
		}
	}
}
