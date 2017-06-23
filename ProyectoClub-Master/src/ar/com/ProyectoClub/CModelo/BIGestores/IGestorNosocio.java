package ar.com.ProyectoClub.CModelo.BIGestores;

import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

public interface IGestorNosocio extends IGestorGeneric<NoSocioDTO> {
	public void HabilitarNoSocio(Integer id)throws Exception;
	public void InabilitarNoSocio(Integer id)throws Exception;
}
