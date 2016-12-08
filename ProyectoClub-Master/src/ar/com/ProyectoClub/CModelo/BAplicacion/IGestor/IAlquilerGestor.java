package ar.com.ProyectoClub.CModelo.BAplicacion.IGestor;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;



public interface IAlquilerGestor extends IGestorGeneric<Alquiler> {
	public List<Alquiler> AlquileresActivos();

}
