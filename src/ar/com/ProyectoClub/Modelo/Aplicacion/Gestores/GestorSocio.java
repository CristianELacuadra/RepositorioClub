package ar.com.ProyectoClub.Modelo.Aplicacion.Gestores;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric;
import ar.com.ProyectoClub.Modelo.Dominio.Socios;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.ISociosDAO;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.Impl.Hibernet.SociosDaoImplHibernate;

@SuppressWarnings("serial")
public class GestorSocio implements IGestorGeneric<Socios> {
	private Socios Gscoio;
	private ISociosDAO _iSocioImpl;
	private List<Socios> SocioTodos;

	public GestorSocio() {
		try{
			_iSocioImpl=new SociosDaoImplHibernate();
			Gscoio=new Socios();
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	@Override
	public void Guardar(Socios entidad) throws BussinessException {
		try{
			if(entidad.getDniSocios()>0){
				Gscoio= _iSocioImpl.BuscarUno(entidad.getDniSocios());
				_iSocioImpl.Actualizar(Gscoio);
			}
			else
				_iSocioImpl.Insertar(entidad);
		}
		catch(Exception ex){
			 throw new RuntimeException(ex);
		}
		
	}
	
@Override
	public Socios Buscaruno(Integer id) throws BussinessException {
		try {
			Gscoio=_iSocioImpl.BuscarUno(id);
			
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return Gscoio;
	}

@Override
    public void Habilitar(Socios entidad) throws BussinessException {
	    throw new NotImplementedException("no implementar");
	}
@Override
	public void Deshabilitar(Socios entidad) throws BussinessException {
			throw new NotImplementedException("no implementado");
	}
@Override
	public List<Socios> listar() throws BussinessException {
	    
	    try {
	    	SocioTodos=_iSocioImpl.Todos();
			
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	    return SocioTodos;
	}
@Override
	public void Validar(Socios entidad) {
		throw new NotImplementedException("No implementado");
		
	}


}
