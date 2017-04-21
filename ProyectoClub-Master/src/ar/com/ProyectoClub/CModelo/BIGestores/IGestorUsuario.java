package ar.com.ProyectoClub.CModelo.BIGestores;


import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;


public interface IGestorUsuario {
	Usuario Crear();
	boolean ValidarUsuContra(String us,String contr);
	boolean ValidarNick(String nick);
	public void AgregarUsuario(Usuario nuevo); 
	public Usuario VerificarUsuarioContraseña(String nick,String pass);
	public boolean BajaUsuario(Usuario baja); 
}
