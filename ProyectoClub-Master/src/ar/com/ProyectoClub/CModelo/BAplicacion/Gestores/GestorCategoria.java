package ar.com.ProyectoClub.Modelo.Aplicacion.Gestores;



import java.util.List;

import ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorCategoria;
import ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric;
import ar.com.ProyectoClub.Modelo.Entidades.Categoria;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.ICategoriaDAO;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.Impl.Hibernet.CategoriaDaoImplHibernate;


@SuppressWarnings("serial")
public class GestorCategoria implements IGestorCategoria{
	
	private ICategoriaDAO IDaoCategoria;
	private Categoria gestorcategoria;
	private List<Categoria> CategoriaTodos; 
//___________________________________________________________________________________	
	public GestorCategoria() {
		try{
           IDaoCategoria=new CategoriaDaoImplHibernate();
           gestorcategoria=new Categoria();
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
//___________________________________________________________________________________	
	@Override
	public void Guardar(Categoria entidad) throws BussinessException {
		Categoria DBEntidad=new Categoria();
		try{
			gestorcategoria= IDaoCategoria.BuscarUno(entidad.getIdCategoria());
				if(gestorcategoria!=null){
					this.actualizarcategoria(entidad, gestorcategoria);   //Actualiza datos de la entidad
					IDaoCategoria.GuardarActualizar(gestorcategoria); // Guarda la entidad
				}
				else
					IDaoCategoria.GuardarActualizar(entidad);  //inserta la entidad como nueva				
		}
		catch(BussinessException ex){
			 throw ex;
		}
		
	}
//___________________________________________________________________________________
	@Override
	public void Habilitar(Categoria entidad) throws BussinessException {
		
	}
//___________________________________________________________________________________
	@Override
	public void Deshabilitar(Categoria entidad) throws BussinessException {
		
	}
//___________________________________________________________________________________	
	@Override
	public void Validar(Categoria entidad) {
		
		
	}
//___________________________________________________________________________________	
	@Override
	public List<Categoria> listar() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}
//___________________________________________________________________________________
    @Override
    	public Categoria Buscaruno(Integer id) throws BussinessException {
    	Categoria UnaCategoria=new Categoria();	
    	try{
    		UnaCategoria=IDaoCategoria.BuscarUno(id);	
    		}
    		catch(Exception ex){
    			throw ex;
    		}
    	return UnaCategoria;
    	}	
	
//___________________________________________________________________________________	
	private void actualizarcategoria(Categoria AEntidad, Categoria NEntidad) {
		NEntidad.setDescuento(AEntidad.getDescuento());
		NEntidad.setDescripcion(AEntidad.getDescripcion());
		NEntidad.setNombre(AEntidad.getNombre());
	}
}
