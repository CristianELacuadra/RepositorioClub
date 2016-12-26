package ar.com.ProyectoClub.CModelo.BAplicacion.IGestor;


import java.util.List;

import ar.com.ProyectoClub.CModelo.BAplicacion.ExceptionAplicacion.NroSocioErronea;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;

public interface IGestorSocios extends IGestorGeneric<Sociosa>  {
	public void InsertarSocio(Sociosa socio) throws NroSocioErronea ;
	public void ActualizarSocio(Sociosa socio);
	public List<Sociosa> ListaActivaSocios();
}
