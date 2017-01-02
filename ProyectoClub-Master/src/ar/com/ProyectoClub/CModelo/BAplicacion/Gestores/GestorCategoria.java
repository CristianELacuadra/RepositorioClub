package ar.com.ProyectoClub.CModelo.BAplicacion.Gestores;



import java.util.List;

import ar.com.ProyectoClub.CModelo.BAplicacion.IGestor.IGestorCategoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICategoriaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CategoriaDaoImplHibernate;


@SuppressWarnings("serial")
public class GestorCategoria implements IGestorCategoria{
	
	private ICategoriaDAO _categoriadao;
	private Categoria _categoria;
	private List<Categoria> _categoriatodos; 
//___________________________________________________________________________________	
	public GestorCategoria() {
		try{
           _categoriadao=new CategoriaDaoImplHibernate();
           _categoria=new Categoria();
		}
		catch(RuntimeException e){
			throw e;
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
	}
	@Override
	public void insertar(Categoria entidad) throws BussinessException {
		_categoriadao.GuardarEntity(entidad);
	}
	
	@Override
	public void Actualizar(Categoria entidad) throws BussinessException {
		_categoria=_categoriadao.BuscarUno(entidad.getIdCategoria());
		this.actualizarcategoria(entidad,_categoria );
		_categoriadao.GuardarEntity(_categoria);
	}
	
	@Override
	public void eliminar(Categoria entidad) throws BussinessException{
			_categoriadao.Eliminar(entidad.getIdCategoria());
			System.out.print("Datos eliminados");
	}
	//___________________________________________________________________________________
	@Override
	public void Habilitar(Categoria entidad){
		try{
			_categoria=_categoriadao.BuscarUno(entidad.getIdCategoria());
			_categoria.setHabilitado(entidad.isHabilitado());
			_categoriadao.GuardarEntity(_categoria);

		}
		catch(RuntimeException ex){
			ex.printStackTrace();
			throw ex;
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
//___________________________________________________________________________________
	@Override
	public void Deshabilitar(Categoria entidad){
		try{	
			_categoria=_categoriadao.BuscarUno(entidad.getIdCategoria());
			_categoria.setHabilitado(entidad.isHabilitado());
			_categoriadao.GuardarEntity(_categoria);

		}
		catch(RuntimeException ex){
			ex.printStackTrace();
			throw ex;
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
//___________________________________________________________________________________	
	@Override
	public List<Categoria> listar(){
		try{
			_categoriatodos=_categoriadao.Listar();
			return _categoriatodos;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
//___________________________________________________________________________________
	@Override
	public Categoria Buscaruno(Integer id){	
		try{
			_categoria=_categoriadao.BuscarUno(id);
			return _categoria;	
		}
		catch(RuntimeException Re){
			throw Re;
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}	
//___________________________________________________________________________________	
	private void actualizarcategoria(Categoria AEntidad, Categoria NEntidad) {
		NEntidad.setIdCategoria(NEntidad.getIdCategoria());
		NEntidad.setNombre(AEntidad.getNombre());
		NEntidad.setDescripcion(AEntidad.getDescripcion());
		NEntidad.setDescuento(AEntidad.getDescuento());
		NEntidad.setHabilitado(AEntidad.isHabilitado());
		
	}
}
