package ar.com.ProyectoClub.Modelo.Aplicacion.Gestores;

import java.util.List;









import com.mysql.jdbc.NotImplemented;

import ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric;
import ar.com.ProyectoClub.Modelo.Entidades.Socios;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.ISociosDAO;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.Impl.Hibernet.SociosDaoImplHibernate;

@SuppressWarnings("serial")
public class GestorSocio implements IGestorGeneric<Socios> {
	private Socios GestorSocio;
	private ISociosDAO _iSocioImpl;
	private List<Socios> SocioTodos;

	public GestorSocio() {
		try{
			_iSocioImpl=new SociosDaoImplHibernate();
			GestorSocio=new Socios();
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	@Override
	public void Guardar(Socios entidad) throws BussinessException {
		try{
			GestorSocio=_iSocioImpl.BuscarUno(entidad.getDni());
				if(GestorSocio!=null){
					this.Actualizar(entidad);
				_iSocioImpl.GuardarActualizar(GestorSocio);
				}
				else
					_iSocioImpl.GuardarActualizar(entidad);
				
		}
		catch(BussinessException ex){
			 throw new RuntimeException (ex);
		}
		
	}
	
@Override
	public Socios Buscaruno(Integer id) throws BussinessException {
		try {
			GestorSocio=_iSocioImpl.BuscarUno(id);
			
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return GestorSocio;
	}

@Override
    public void Habilitar(Socios entidad) throws BussinessException {
	    //throw new NotImplementedException("no implementar");
	}
@Override
	public void Deshabilitar(Socios entidad) throws BussinessException {
			//throw new NotImplementedException("no implementado");
	}
@Override
	public List<Socios> listar() throws BussinessException {
	    
	    try {
	    	SocioTodos=_iSocioImpl.ListarSocios();
	    	return SocioTodos;
			
		} 
	    catch (Exception e) {
			 throw new BussinessException(e);
		}
	    
	}
@Override
	public void Validar(Socios entidad) {
		//throw new NotImplemented("No implementado");
		
	}
private void Actualizar(Socios AEntidad){
	GestorSocio.setCategoria(AEntidad.getCategoria());
	GestorSocio.setEstado(AEntidad.getEstado());
	GestorSocio.setEstadoCivil(AEntidad.getEstadoCivil());
	GestorSocio.setFechaIngreso(AEntidad.getFechaIngreso());
	GestorSocio.setHabilitado(AEntidad.isHabilitado());
	GestorSocio.setMatricula(AEntidad.getMatricula());
	GestorSocio.setNacionalidad(AEntidad.getNacionalidad());
	GestorSocio.setNroSocio(AEntidad.getNroSocio());
	GestorSocio.setSexo(AEntidad.getSexo());
	}

}
