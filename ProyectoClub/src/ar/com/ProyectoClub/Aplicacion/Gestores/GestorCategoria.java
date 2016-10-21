package ar.com.ProyectoClub.Aplicacion.Gestores;

import ar.com.ProyectoClub.Aplicacion.IGestor.ICategoriaGestor;
import ar.com.ProyectoClub.Dominio.Categoria;
import ar.com.ProyectoClub.Persistencia.IDao.Impl.Hibernet.CategoriaDaoImplHibernate;

public class GestorCategoria implements ICategoriaGestor {
	
	private CategoriaDaoImplHibernate categoriaimpl;
	private Categoria categoria;
	
	
	public GestorCategoria() {
		try{
			categoriaimpl=new CategoriaDaoImplHibernate();
			categoria=new Categoria();
		}
		catch(Exception ex){
			throw new RuntimeException(ex); 
		}
	}
	
	@Override
	public void Guardar(Categoria entidad) {
		try{
			categoriaimpl.Insertar(entidad);
		}
		catch(Exception ex){
		  throw new RuntimeException(ex);
		}
	}
	
	@Override
	public void actualizar(Categoria entidad) {
		try {
			if(entidad.getIdCategoria() > 0){
				categoria=categoriaimpl.BuscarUno(entidad.getIdCategoria());
				
			}
			
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		
	}
	

}
