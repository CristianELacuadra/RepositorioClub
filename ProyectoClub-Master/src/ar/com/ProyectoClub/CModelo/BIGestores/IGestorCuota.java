package ar.com.ProyectoClub.CModelo.BIGestores;


import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

public interface IGestorCuota extends IGestorGeneric<Cuota> {
	public void RegistrarPagoCuota(Cuota cuota)throws Exception;
	public void GeneracionDeCuotas(Date fechaActual,List<Personas> PersonasActivas) throws Exception;
	public Cuota ObtenerUltimaCuotaIngresado() throws Exception;
	public List<Cuota> ObtenerCuotasImpagas();
	public List<Cuota> ObtenerCuotasSocio(Integer dni);
}
