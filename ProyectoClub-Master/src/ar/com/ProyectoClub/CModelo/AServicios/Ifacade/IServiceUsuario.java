package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;

public interface IServiceUsuario {
	public Usuario newusuario();
	public boolean ValidarUsurioContraseña(String nick,String pass);
	public boolean ValidarNick(String nick);
	public void AgregarUsuario(Usuario nuevo);
	public Usuario  DevolverUsuario(String nick,String pass);
	public void BajaUsuario(Usuario baja); 
	//public Usuario DevolverUsuario(Integer id);

}
