package ar.com.ProyectoClub.CModelo.BAplicacion.IGestor;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Nosocio;

public interface IGestorNoSocio extends IGestorGeneric<Nosocio>{
	public List<Nosocio> NoSociosInhabilitados();
}
