package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

public interface IServiceNoSocio {
     public NoSocioDTO Crear();
     public void GuardarNoSocio(NoSocioDTO noSocio);
     public void DeshabilitarNoSocio(NoSocioDTO dni);
     public void HabilitarNoSocio(NoSocioDTO dni);
     public List<NoSocioDTO> ListarNoSocios();
     public NoSocioDTO BuscarNoSocio(Integer dni);
     public List<NoSocioDTO> FiltrarNombreApellido(String nom, String ape); 
}
