package ar.com.ProyectoClub.Modelo.Aplicacion.Gestores;


import java.io.Console;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric;
import ar.com.ProyectoClub.Modelo.Dominio.Categoria;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.ICategoriaDAO;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.Impl.Hibernet.CategoriaDaoImplHibernate;


@SuppressWarnings("serial")
public class GestorCategoria implements IGestorGeneric<Categoria> {
	
	private ICategoriaDAO _icategoria;
	private Categoria categoria;
	private List<Categoria> CategoriaTodos; 
	
	public GestorCategoria() {
		try{
           _icategoria=new CategoriaDaoImplHibernate();
           categoria=new Categoria();
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public void Guardar(Categoria entidad) throws BussinessException {
		try{
			if(entidad.getIdCategoria()>0){
				categoria=_icategoria.BuscarUno(entidad.getIdCategoria());
				actualizarcategoria(entidad, categoria); // actualiza los datos de categoria de la BDD con los de entidad
				_icategoria.Actualizar(entidad);
			}
			else
				_icategoria.Insertar(entidad);
		}
		catch(Exception ex){
			 throw new RuntimeException(ex);
		}
		
	}
	@Override
	public void Habilitar(Categoria entidad) throws BussinessException {
		try{
			categoria=_icategoria.BuscarUno(entidad.getIdCategoria());
			categoria.setHabilitado(entidad.isHabilitado());
			_icategoria.Actualizar(categoria);
			
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	@Override
	public void Deshabilitar(Categoria entidad) throws BussinessException {
		try{
			categoria=_icategoria.BuscarUno(entidad.getIdCategoria());
			categoria.setHabilitado(entidad.isHabilitado());
			_icategoria.Actualizar(categoria);
			
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
	}
	
	@Override
	public void Validar(Categoria entidad) {
		throw new NotImplementedException("no se puede validar");
		
	}
	
	@Override
	public Categoria Buscaruno(Integer id) throws BussinessException {
		
		try {
			categoria=_icategoria.BuscarUno(id);
			
		} 
		catch (Exception e) {
			throw new RuntimeException(e);	
		}
		return categoria;
	}

	@Override
	public List<Categoria> listar() throws BussinessException {
		
		
		try {
			CategoriaTodos=_icategoria.Todos();
			
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return CategoriaTodos;
	}
	
	public void actualizarcategoria(Categoria cat1, Categoria categoria) {
		categoria.setDescuento(cat1.getDescuento());
		categoria.setDescripcion(cat1.getDescripcion());
		categoria.setNombre(cat1.getNombre());
	}
}
