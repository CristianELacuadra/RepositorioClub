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
	//constructor
	public GestorUsuario() throws Exception {
			isuariodao=new UsuarioDaoImplHibernate();
	}
	
	//Create,Insert,Delete,Update,Busqueda
	public Usuario Crear() throws Exception {
		return(isuariodao.crear());//->Devuelve nueva instancia de la entidad personas
	}
	
	@Override
	public void AgregarUsuario(Usuario nuevo) throws Exception {
			isuariodao.GuardarEntity(nuevo);
	}
	
	@Override
	public void BajaUsuario(Usuario usuario) throws Exception{
		if(usuario.getTipousuario().equals("Administrador"))
			isuariodao.Eliminar(usuario.getIdusuario());
		else
			throw new RuntimeException("Usted no tiene los permisos para realizar esta transaccion");
	}
	@Override
	public void ActualizarUsuario(Usuario usuarioNew) throws Exception {
		 Usuario usuario=this.Crear();
		 usuario.setNick(usuarioNew.getNick());
		 usuario.setPassword(usuarioNew.getPassword());
		 usuario.setTipousuario(usuarioNew.getTipousuario());
		this.AgregarUsuario(usuario);
	}
	@Override
	public Usuario BuscarUsuario(Integer id) throws Exception {
		Usuario usuario=this.Crear();
		usuario=isuariodao.BuscarUno(id);
		return usuario;
	}
	@Override
	public List<Usuario> ListarUsuario() throws Exception {
		List<Usuario> listaUsuario=new ArrayList<Usuario>();
		listaUsuario=isuariodao.Listar();
		return  listaUsuario;
	}
	
	//
	@Override
	public Usuario VerificarUsuarioContraseña(String nick, String pass){
		try{
			Usuario nom=this.Crear() ;
			for(Usuario _Objusuario : this.ListarUsuario()) {
				if(_Objusuario.getNick().equals(nick) && _Objusuario.getPassword().equals(pass)) {
					nom=this.BuscarUsuario(_Objusuario.getIdusuario());
					break;
				}
				else 
					nom=null;
			}
			return nom;
		}
		catch (Exception e) {
			throw new RuntimeException("Error al intentar verificar el usuario"+e.getMessage());
		}
	}
	
	
	@Override
	public boolean ValidarNick(String nick) {
		if(isuariodao.VerificarNick(nick))
			return true;
		else
			return false;
	}
	
	
	
	@Override
	public boolean ValidarUsuContra(String us, String contr){
		try{
			boolean validar=false;
			List<Usuario> listusuario=new ArrayList<Usuario>();
			listusuario=isuariodao.Listar();
			for(Usuario n : listusuario)
			{
				validar=(n.getNick().equals(us) && n.getPassword().equals(contr))?true: false ;	
			}
			return validar;
		}
		catch (Exception e) {
			throw new RuntimeException("No se pudo verificar la contraseña o el usuario debido al siguiente error: "+e.getMessage());
		}
	}
}

