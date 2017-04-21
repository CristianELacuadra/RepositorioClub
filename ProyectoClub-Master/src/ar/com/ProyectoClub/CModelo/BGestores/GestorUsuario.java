package ar.com.ProyectoClub.CModelo.BGestores;


import java.util.ArrayList;
import java.util.List;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorUsuario;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IUsuarioDao;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.UsuarioDaoImplHibernate;

public class GestorUsuario implements IGestorUsuario {
    
	private IUsuarioDao isuariodao;
	
	public GestorUsuario() {
		try {
			isuariodao=new UsuarioDaoImplHibernate();
		}
		catch (Exception e) {
			throw new RuntimeException("Error al iniciar el gestor"+e.toString());
		}
	}
	@Override
	public void AgregarUsuario(Usuario nuevo) {
		try{
			isuariodao.GuardarEntity(nuevo);
		}
		 catch (Exception e) {
			throw new RuntimeException(e.toString());
		}
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
	@Override
	public Usuario VerificarUsuarioContraseña(String nick, String pass) {
		try {
			Usuario nom=isuariodao.crear() ;
			for(Usuario _Objusuario : isuariodao.Listar()) {
				if(_Objusuario.getNick().equals(nick) && _Objusuario.getPassword().equals(pass)) {
					nom=isuariodao.BuscarUno(_Objusuario.getIdusuario());
					//nom.setIdusuario(_Objusuario.getIdusuario());
					//nom.setNick(_Objusuario.getNick());
					//nom.setPassword(_Objusuario.getPassword());
					//nom.setTipousuario(_Objusuario.getTipousuario());
					break;
				}
				else 
					nom=null;
			}
			return nom;
		}
		catch (Exception e) {
			throw new RuntimeException("Se produjo un error a verificar el usuario"+e.toString());
		}
	}
	
	
	@Override
	public boolean ValidarNick(String nick) {
		if(isuariodao.VerificarNick(nick))
			return true;
		else
			return false;
	}
	public Usuario Crear() {
		try {
			return(isuariodao.crear());//->Devuelve nueva instancia de la entidad personas
		}
		catch (BussinessException e) {
			throw new RuntimeException("Error a instanciar el usuario"+e.getMessage());
		}
	}
	
	@Override
	public boolean ValidarUsuContra(String us, String contr) 
	{
		boolean validar=false;
		List<Usuario> listusuario=new ArrayList<Usuario>();
		try {
			listusuario=isuariodao.Listar();
			for(Usuario n : listusuario)
			{
				validar=(n.getNick().equals(us) && n.getPassword().equals(contr))?true: false ;	
			}
			return validar;
		}
		catch (Exception e) {
			throw new RuntimeException("Se produjo un error debido el siguiente error"+e.getMessage());
		}
	}

}
