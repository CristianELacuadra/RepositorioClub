package ar.com.ProyectoClub.CModelo.BAplicacion.Gestores;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;

import ar.com.ProyectoClub.CModelo.BAplicacion.ExceptionAplicacion.NroSocioErronea;
import ar.com.ProyectoClub.CModelo.BAplicacion.IGestor.IGestorSocios;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.SociosDaoImplHibernate;


@SuppressWarnings("serial")
public class GestorSocio implements IGestorSocios {
	private Sociosa _socio;
	private ISociosDAO _iSocioImpl;
	private List<Sociosa> SocioTodos;

	/*constructor*/
	public GestorSocio() {
		try{
			_iSocioImpl=new SociosDaoImplHibernate();
			_socio=new Sociosa();
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void ActualizarSocio(Sociosa socio) {
		try{
			_socio=_iSocioImpl.BuscarUno(socio.getDni());
			this.Actualizar(socio, _socio);
			_iSocioImpl.GuardarEntity(_socio);

		}
		catch(RuntimeException er){
			er.printStackTrace();
			throw er;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void InsertarSocio(Sociosa socio) throws NroSocioErronea {
		try{
			if(!_iSocioImpl.ValidarSocio(socio))//valida si existe el nro de socio 
				_iSocioImpl.GuardarEntity(socio);
			else
				throw new NroSocioErronea("El numero de socio ya se encuentra registrada");
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

    @Override
	public Sociosa Buscaruno(Integer id){
		try {
			_socio=_iSocioImpl.BuscarUno(id);

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return _socio;
	}
	
	@Override
	public void Guardar(Sociosa entidad) {
		throw new NotImplementedException();

	}

	@Override
	public List<Sociosa> listar() {
		try{
			SocioTodos=_iSocioImpl.Listar();
			return SocioTodos;
		}
		catch(RuntimeException ex){
			throw ex;		}
		catch(Exception e){
			throw new RuntimeException(e);
		}

	}
	@Override
	public List<Sociosa> ListaActivaSocios() {
		try{
			SocioTodos=_iSocioImpl.ListaActivaSocios();
			return SocioTodos;
		}
		catch (RuntimeException ex) {
			throw ex;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	@Override
	public void Validar(Sociosa entidad) {
		throw new NotImplementedException();

	}
	
	@Override
	public void Habilitar(Sociosa entidad){
		try{
			_socio=_iSocioImpl.BuscarUno(entidad.getDni());
			_socio.setHabilitado(entidad.isHabilitado());
			_iSocioImpl.GuardarEntity(_socio);

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

	@Override
	public void Deshabilitar(Sociosa entidad) {
		try{
			_socio=_iSocioImpl.BuscarUno(entidad.getDni());
			_socio.setHabilitado(entidad.isHabilitado());
			_iSocioImpl.GuardarEntity(_socio);

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
	private void Actualizar(Sociosa _EntidadNueva,Sociosa _EntidadDB){
		if(_EntidadDB!= null){
			_EntidadDB.setNombre(_EntidadNueva.getNombre());
			_EntidadDB.setApellido(_EntidadNueva.getApellido());
			_EntidadDB.setTelefono(_EntidadNueva.getTelefono());
			_EntidadDB.setDomicilio(_EntidadNueva.getDomicilio());
			_EntidadDB.setMatricula(_EntidadNueva.getMatricula());
			_EntidadDB.setSexo(_EntidadNueva.getSexo());
			_EntidadDB.setEstado(_EntidadNueva.getEstado());
			_EntidadDB.setNacionalidad(_EntidadNueva.getNacionalidad());
			_EntidadDB.setEstadoCivil(_EntidadNueva.getEstadoCivil());
			_EntidadDB.setFechaIngreso(_EntidadNueva.getFechaIngreso());
			_EntidadDB.setHabilitado(_EntidadNueva.isHabilitado());
			_EntidadDB.setCategoria(_EntidadNueva.getCategoria());
		}
	}
}
