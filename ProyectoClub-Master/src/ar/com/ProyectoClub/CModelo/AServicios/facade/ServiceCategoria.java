package ar.com.ProyectoClub.CModelo.AServicios.facade;


import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCategorias;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICategoriaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CategoriaDaoImplHibernate;

public class ServiceCategoria implements IServiceCategorias {
	private Categoria _categoria;
	private ICategoriaDAO _DaoCategoria; 
	
	public ServiceCategoria() {
		try {
		_categoria=new Categoria();
		_DaoCategoria=new CategoriaDaoImplHibernate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	//contructor para cargar la categria
	
	public ServiceCategoria(Categoria categoria){
		this._categoria=categoria;
	}
	
	@Override
	public boolean RegistrarCategoria(Categoria categoria) {
		try{
			_categoria=categoria;
			_DaoCategoria.GuardarEntity(_categoria);
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
			nueva=_DaoCategoria.BuscarUno(id);
			return nueva;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}
}
