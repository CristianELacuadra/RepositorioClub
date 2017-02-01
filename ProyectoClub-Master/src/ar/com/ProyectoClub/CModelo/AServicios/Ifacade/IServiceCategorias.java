package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;

public interface IServiceCategorias {
	public boolean RegistrarCategoria(Categoria categoria);
	public Categoria BuscarCategoria(Integer id);

}
