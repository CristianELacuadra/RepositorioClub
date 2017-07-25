package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

public interface IServiceInmuebles {
	public Inmuebles BusquedaInmueble(Integer id);
	public Inmuebles CrearInmueble();
	public void GuardarInmueble(Inmuebles entity);
	public Integer UltimoIdInmueble();
	public List<Inmuebles> ListarInmueble();
	public List<Inmuebles> ListarInmuebleHabilitado();
	public List<Inmuebles> ListarInmuebleFiltrado(String text);
	
}
