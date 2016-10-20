package ar.com.ProyectoClub.Presentacion;

import ar.com.ProyectoClub.Dominio.Categoria;
import ar.com.ProyectoClub.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Persistencia.IDao.ICategoriaDAO;
import ar.com.ProyectoClub.Persistencia.IDao.Impl.Hibernet.CategoriaDaoImplHibernate;


public class CategoriaController {
		ICategoriaDAO categoriaDAO;
		
		public CategoriaController() {
			categoriaDAO=new CategoriaDaoImplHibernate();
		}
		
	    public void guardar(Categoria categoria) throws BussinessException {

	            categoriaDAO.GuardarActualizar(categoria);
	    }
}
