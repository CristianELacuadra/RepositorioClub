package ar.com.ProyectoClub.CModelo.BAplicacion.IGestor;

import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;

public interface IGestorCategoria extends IGestorGeneric<Categoria> {
	public void Eliminar(Integer id);

}
