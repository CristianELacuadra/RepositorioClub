package ar.com.ProyectoClub.Modelo.Aplicacion.IGestor;

import java.util.List;

import ar.com.ProyectoClub.Modelo.Dominio.Alquiler;

public interface IAlquilerGestor extends IGestorGeneric<Alquiler> {
	public List<Alquiler> AlquileresActivos();

}
