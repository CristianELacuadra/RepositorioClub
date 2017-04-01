package ar.com.ProyectoClub.CModelo.AServicios.facade;


import java.util.logging.Logger;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCategorias;
import ar.com.ProyectoClub.CModelo.BGestores.GestorCategoria;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCategoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICategoriaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CategoriaDaoImplHibernate;

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
