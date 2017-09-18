package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

public interface IServicePersonas {
	 public void CrearPersonas();
	 public void GuardarPersonas(Personas personas);
	 public void EliminarPersona(Integer id);
	 public Personas BuscarPersona(Integer id); 
	 public List<Personas> ListarPersonas(); 
}
