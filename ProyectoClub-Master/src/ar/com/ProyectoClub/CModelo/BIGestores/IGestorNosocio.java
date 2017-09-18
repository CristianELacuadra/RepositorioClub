package ar.com.ProyectoClub.CModelo.BIGestores;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

public interface IGestorNosocio extends IGestorGeneric<Personas> {
	public void HabilitarNoSocio(Personas id)throws Exception;
	public void InabilitarNoSocio(Personas id)throws Exception;
	public List<Personas> FiltrarNombeApellido(String nom, String ape);
}
