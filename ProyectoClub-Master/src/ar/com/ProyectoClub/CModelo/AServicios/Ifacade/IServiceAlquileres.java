package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;

public interface IServiceAlquileres{
	public void AltaAlquiler(Alquiler nuevo);
	public void InhabilitarAlquiler(Alquiler nuevo);
	public void ActualizarAlquiler(Alquiler nuevo);
	
}
