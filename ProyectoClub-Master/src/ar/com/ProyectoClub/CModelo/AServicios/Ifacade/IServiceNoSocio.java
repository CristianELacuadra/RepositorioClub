package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;

public interface IServiceNoSocio {
     public NoSocioDTO Crear();
     public void GuardarNoSocio(NoSocioDTO noSocio);
     public void DeshabilitarNoSocio(Integer dni);
     public void HabilitarNoSocio(Integer dni);
     public List<NoSocioDTO> ListarNoSocios();
     public NoSocioDTO BuscarNoSocio(Integer dni);
}