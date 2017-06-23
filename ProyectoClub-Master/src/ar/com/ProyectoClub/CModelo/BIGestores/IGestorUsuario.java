package ar.com.ProyectoClub.CModelo.BIGestores;


import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;


public interface IGestorUsuario {
	//Create,Insert,Delete,Update,Busqueda,listar
	Usuario Crear()throws Exception;
	public void AgregarUsuario(Usuario nuevo) throws Exception;
	public void BajaUsuario(Usuario usuario) throws Exception;
	public void ActualizarUsuario(Usuario usuario)throws Exception;
	public Usuario BuscarUsuario(Integer id) throws Exception;
	public List<Usuario> ListarUsuario()throws Exception;
	
	//siguientes metodos los trata el gestor
	boolean ValidarUsuContra(String us,String contr);
	boolean ValidarNick(String nick) ;
	public Usuario VerificarUsuarioContraseña(String nick,String pass);
	
}
