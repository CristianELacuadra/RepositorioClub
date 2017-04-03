package ar.com.ProyectoClub.CModelo.BIGestores;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;

public interface IGestorAlquiler extends IGestorGeneric<Alquiler> {
	public List<Alquiler> Listar_activos();
	public List<Alquiler> BusquedaXFecha(Date fechainicial,Date fechafin) throws Exception;
}
