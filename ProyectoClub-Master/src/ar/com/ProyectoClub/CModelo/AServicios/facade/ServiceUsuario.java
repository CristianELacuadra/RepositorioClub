package ar.com.ProyectoClub.CModelo.AServicios.facade;




import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceUsuario;
import ar.com.ProyectoClub.CModelo.BGestores.GestorUsuario;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorUsuario;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IUsuarioDao;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.UsuarioDaoImplHibernate;

/**
 * Como los servicios de usuario no involucra otras entidades mas que el mismo usuario, 
 * los metodos los ejecutan los gestores.sin ninguna logica intermedia por parte de los servicios
 **/
public class ServiceUsuario implements IServiceUsuario {
	private IGestorUsuario gestorusuario;
	private List<Usuario> _list=new ArrayList<Usuario>();
	
	public ServiceUsuario(){
		try {
			gestorusuario=new GestorUsuario();
		}
		catch (Exception e) {
			 throw new RuntimeException("Error al iniciar el servicio de usuario"+e.toString());
		}
	}
	
	public Usuario newusuario() {
		return  gestorusuario.Crear();
	}
	
	@Override
	public boolean ValidarNick(String nick) {
		return gestorusuario.ValidarNick(nick);
	}
	
	@Override
	public boolean ValidarUsurioContraseņa(String nick, String pass) {
	     return gestorusuario.ValidarUsuContra(nick, pass); 
	}
	@Override
	public void AgregarUsuario(Usuario nuevo) { 
		try {
			gestorusuario.AgregarUsuario(nuevo);
		}
		catch (Exception e) {
			throw new RuntimeException("Error no se puede guardar el usuario. por favor ponganse en contacto con el administrador");
		}
	}
	@Override
	public Usuario DevolverUsuario(String nick, String pass) {
		return gestorusuario.VerificarUsuarioContraseņa(nick, pass);
	}
	@Override
	public boolean BajaUsuario(Usuario baja) {
		return gestorusuario.BajaUsuario(baja);
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
