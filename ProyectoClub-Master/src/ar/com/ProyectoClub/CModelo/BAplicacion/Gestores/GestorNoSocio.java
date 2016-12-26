package ar.com.ProyectoClub.CModelo.BAplicacion.Gestores;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;

import ar.com.ProyectoClub.CModelo.BAplicacion.IGestor.IGestorNoSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Nosocio;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.INoSocioDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.NoSocioDaoImplHibernate;


@SuppressWarnings("serial")
public class GestorNoSocio implements IGestorNoSocio {
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
	public void Guardar(Nosocio entidad){
		try{
				_INoSocio.GuardarEntity(entidad);// atributo unico de la entidad para no socio es dni por lo tanto no se actualiza,solo inserta
		}
		catch(RuntimeException ex){
			throw ex;
		}
		
		catch(Exception e){
			 throw new RuntimeException(e);
		}
		
	}
//___________________________________________________________________________________
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Habilitar(java.lang.Object)
	 * metodo habilita, el no socio esta habilitado para realizar tramites
	 */
	
	@Override
	public void Habilitar(Nosocio entidad){
		try{
			_Nosocio=_INoSocio.BuscarUno(entidad.getDni());
			_Nosocio.setHabilitado(entidad.isHabilitado());
			_INoSocio.GuardarEntity(_Nosocio);
		}
		catch(RuntimeException e){
			throw e;
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
	public void Deshabilitar(Nosocio entidad){
		try{
			_Nosocio=_INoSocio.BuscarUno(entidad.getDni());
			_Nosocio.setHabilitado(entidad.isHabilitado());
			_INoSocio.GuardarEntity(_Nosocio);
		}
		catch(RuntimeException e){
			throw e;
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
		throw new NotImplementedException();
	};
//___________________________________________________________________________________	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.Modelo.Aplicacion.IGestor.IGestorGeneric#Buscaruno(java.lang.Integer)
	 * busca en la DBB el dni del socio
	 */
	@Override
	public Nosocio Buscaruno(Integer id){
		
		try {
			_Nosocio=_INoSocio.BuscarUno(id);
			return _Nosocio;
			
		} 
		catch (RuntimeException ex){
			throw ex;
		}
		catch (Exception e) {
			throw new RuntimeException(e);	
		}
		
	}
//___________________________________________________________________________________
	@Override
	public List<Nosocio> listar(){
		
		
		try {
			_Listanosocio=_INoSocio.Listar();
			return _Listanosocio;
			
		} 
		catch (RuntimeException ex){
			throw ex;
		}
		catch (Exception e) {
			throw new RuntimeException(e);	
		}
		
	}	
	@Override
	public List<Nosocio> NoSociosInhabilitados() {
		try {
			_Listanosocio=_INoSocio.ListaNoSociosInhabilitados();
			return _Listanosocio;
			
		} 
		catch (RuntimeException ex){
			throw ex;
		}
		catch (Exception e) {
			throw new RuntimeException(e);	
		}
	}
}
