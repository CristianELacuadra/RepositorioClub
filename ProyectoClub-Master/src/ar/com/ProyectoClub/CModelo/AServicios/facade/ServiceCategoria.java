package ar.com.ProyectoClub.CModelo.AServicios.facade;


import java.util.List;
import java.util.logging.Logger;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCategorias;
import ar.com.ProyectoClub.CModelo.BGestores.GestorCategoria;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCategoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.DIRepository.ICategoriaDAO;
import ar.com.ProyectoClub.CModelo.DRepository.CategoriaDaoImplHibernate;

public class ServiceCategoria implements IServiceCategorias {
    private IGestorCategoria gestorcategoria;
	
	public ServiceCategoria() {
		try {
		gestorcategoria =new GestorCategoria();
		}
		catch (Exception e) {
			Logger.getLogger("Error al generar una instacia de categoria");
		}
	}
	//contructor para cargar la categria
	
	@Override
	public Categoria CrearCategoria() {
		try{
			return gestorcategoria.Crear();
		}
		catch (Exception e) {
			throw new RuntimeException("No se pudo instanciar el serivicio debido al siguiente error: "+e.getMessage());
		}
	}
	
	public ServiceCategoria(Categoria categoria){
		//this._categoria=categoria;
	}
	
	@Override
	public boolean RegistrarCategoria(Categoria categoria) {
		try{
			//_categoria=categoria;
			//_DaoCategoria.GuardarEntity(_categoria);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
		
	}
	
	@Override
	public List<Categoria> ListarCategorias() {
		try{
			return gestorcategoria.Listar();
		}
		catch (Exception e) {
			throw new RuntimeException("Service Categoria"+e.getMessage());
		}
	}

	@Override
	public Categoria BuscarCategoria(Integer id) {
		Categoria nueva=new Categoria();
		try{
			nueva=gestorcategoria.Busqueda(id);
			return nueva;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}
}
