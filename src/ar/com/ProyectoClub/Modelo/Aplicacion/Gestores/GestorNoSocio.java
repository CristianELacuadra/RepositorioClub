package ar.com.ProyectoClub.Modelo.Aplicacion.Gestores;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric;
import ar.com.ProyectoClub.Modelo.Dominio.Nosocio;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.INoSocioDAO;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.Impl.Hibernet.NoSocioDaoImplHibernate;

@SuppressWarnings("serial")
public class GestorNoSocio implements IGestorGeneric<Nosocio> {
    private Nosocio _Nosocio;
    private INoSocioDAO _INoSocio;
	private List<Nosocio> _Listanosocio;
//___________________________________________________________________________________	
	public GestorNoSocio() {
		try{
			_Nosocio=new Nosocio();
			_INoSocio=new NoSocioDaoImplHibernate(); //nuevo implementacion daosocio atraves de su interfaz
		}
		catch(Exception ex){
			throw new RuntimeException();
		}
	}
//___________________________________________________________________________________	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Guardar(java.lang.Object)
	 * Guarda un nuevo nosocio
	 */
	@Override
	public void Guardar(Nosocio entidad) throws BussinessException {
		try{
				_INoSocio.Insertar(entidad);// atributo unico de la entidad para no socio es dni por lo tanto no se actualiza,solo inserta
		}
		catch(Exception ex){
			 throw new RuntimeException(ex);
		}
		
	}
//___________________________________________________________________________________
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Habilitar(java.lang.Object)
	 * metodo habilita, el no socio esta habilitado para realizar tramites
	 */
	
	@Override
	public void Habilitar(Nosocio entidad) throws BussinessException {
		try{
			_Nosocio=_INoSocio.BuscarUno(entidad.getDniNoSocio());
			_Nosocio.setHabilitado(entidad.isHabilitado());
			_INoSocio.Actualizar(_Nosocio);
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
	}
//___________________________________________________________________________________
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Deshabilitar(java.lang.Object)
	 * metodo deshabilita al nosocio a realizar cualquier tramite 
	 */
	@Override
	public void Deshabilitar(Nosocio entidad) throws BussinessException {
		try{
			_Nosocio=_INoSocio.BuscarUno(entidad.getDniNoSocio());
			_Nosocio.setHabilitado(entidad.isHabilitado());
			_INoSocio.Actualizar(_Nosocio);
			
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	};
//___________________________________________________________________________________	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Validar(java.lang.Object)
	 */
	@Override
	public void Validar(Nosocio entidad) {
		throw new NotImplementedException("no se puede validar");
	};
//___________________________________________________________________________________	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Buscaruno(java.lang.Integer)
	 * busca en la DBB el dni del socio
	 */
	@Override
	public Nosocio Buscaruno(Integer id) throws BussinessException {
		
		try {
			_Nosocio=_INoSocio.BuscarUno(id);
			
		} 
		catch (Exception e) {
			throw new RuntimeException(e);	
		}
		return _Nosocio;
	}
//___________________________________________________________________________________
	@Override
	public List<Nosocio> listar() throws BussinessException {
		
		
		try {
			_Listanosocio=_INoSocio.Todos();
			
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return _Listanosocio;
	}	
}
