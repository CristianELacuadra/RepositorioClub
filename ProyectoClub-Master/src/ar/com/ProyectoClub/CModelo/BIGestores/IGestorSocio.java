package ar.com.ProyectoClub.CModelo.BIGestores;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface IGestorSocio extends IGestorGeneric<Personas> {
	public Integer DevolverUltimoNroSocio();
	public List<Personas> ListaActivaSocio()throws BussinessException;
}
