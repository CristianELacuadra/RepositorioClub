package ar.com.ProyectoClub.CModelo.AServicios.facade;




import java.util.ArrayList;
import java.util.List;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceUsuario;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IUsuarioDao;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.UsuarioDaoImplHibernate;


public class ServiceUsuario implements IServiceUsuario {
	private IUsuarioDao _usua;
	private List<Usuario> _list=new ArrayList<Usuario>();
	
	public ServiceUsuario(){
		try {
			_usua=new UsuarioDaoImplHibernate();
		}
		catch (Exception e) {
			 throw new RuntimeException("Error al iniciar el servicio de usuario"+e.toString());
		}
	}
	
	public Usuario newusuario() {
		try {
		return  _usua.crear();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public boolean ValidarNick(String nick) {
			if(_usua.VerificarNick(nick))
				return true;
			else
				return false;
	}
	
	@Override
	public void AgregarUsuario(Usuario nuevo) { 
		try{
			_usua.GuardarEntity(nuevo);
		}
		 catch (Exception e) {
			throw new RuntimeException(e.toString());
		}
	}
	
	@Override
	public String acceder_Administrador(String nick,String pass) {
		String nom=new String();
		nom=null;
		try {
			for(Usuario _Objusuario : _usua.Listar()) {
				if(_Objusuario.getNick().equals(nick) && _Objusuario.getPassword().equals(pass)) {
					nom=_Objusuario.getTipousuario();
					return nom;
				}
				else 
					nom=null;
			}
		}
		catch (Exception e) {
			throw new RuntimeException("Se produjo un error a verificar el usuario"+e.toString());
		}
		return nom;
	}
	
	@Override
	public boolean BajaUsuario(Usuario baja) {
		try {
			return false;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	@Override
	public Usuario DevolverUsuario(Integer id) {
		try {
			_usua.BuscarUno(id);
		}
	}
	*/
	
}
