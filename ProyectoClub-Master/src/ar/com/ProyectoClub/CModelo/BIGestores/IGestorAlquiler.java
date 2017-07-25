package ar.com.ProyectoClub.CModelo.BIGestores;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public interface IGestorAlquiler extends IGestorGeneric<Alquiler> {
	public Alquiler Crear() throws BussinessException;
	public List<Alquiler> Listar_activos();
	public List<Alquiler> BusquedaXFecha(Date fechainicial,Date fechafin) throws Exception;
}
