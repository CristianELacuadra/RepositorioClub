package ar.com.ProyectoClub.CModelo.AServicios.facade;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.DTOPersonalisadoSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.SociosDaoImplHibernate;

public class ServiceSocios implements IServiceSocio {
	private Sociosa _socio;
	private ISociosDAO _socioDao;
	
	
	public ServiceSocios(){
		_socio=new Sociosa();
		_socioDao=new SociosDaoImplHibernate();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio#NuevoSocio(ar.com.ProyectoClub.CModelo.CEntidades.Sociosa)
	 * Servicio de insercion de Socio
	 */
	@Override
	public boolean NuevoSocio(Sociosa socio) throws BussinessException{
		try{
			_socioDao.GuardarEntity(socio);
			return true;
		}
		catch(BussinessException ex){
			throw ex;
		}
	}
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio#DeshabilitarSocio(ar.com.ProyectoClub.CModelo.CEntidades.Sociosa)
	 * Servicio para deshabilitar un socio
	 * Nota: no se implementa eliminacion fisica,sino logica
	 */
	@Override
	public String DeshabilitarSocio(Sociosa socio) throws BussinessException {
		try{
		_socio=_socioDao.BuscarUno(socio.getNroSocio());
		_socio.setHabilitado(socio.isHabilitado());
		_socioDao.GuardarEntity(_socio);
		return ("Socio: "+_socio.getNombre()+" "+_socio.getApellido()+"se deshabilitado");
		}
		catch(BussinessException e){
			throw e;
		}
	}


	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio#ActulizarSocio(ar.com.ProyectoClub.CModelo.CEntidades.Sociosa)
	 * Servicio de modificacion del socio
	 * Nota: se actulizan todos los atributos exepto el numero de socio y dni
	 */
	
	@Override
	public boolean ActulizarSocio(Sociosa socio )throws BussinessException {
		 try {
			_socio=_socioDao.BuscarUno(socio.getNroSocio());
			this.ActualizarEntidad(socio);
			_socioDao.GuardarEntity(_socio);
			return true;
			
		} catch (BussinessException e) {
			throw e;
		}
		
	}
	@Override
	public Sociosa UnSocio(Integer id) throws BussinessException {
		Sociosa nuevo=new Sociosa();
		try{
			nuevo=_socioDao.BuscarUno(id);
			return nuevo;
		}
		catch(BussinessException be){
			throw be;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio#ListarSocio()
	 * Servicio de lista de socio
	 */
	@Override
	public List<Sociosa> ListarSocio()throws BussinessException {
		List<Sociosa> _lista=new ArrayList<Sociosa>();
		try{
			_lista=_socioDao.Listar();
			return _lista;
		}
		catch(BussinessException ex){
			throw ex;
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio#ListaSociosActivo()
	 */
	@Override
	public List<Sociosa> ListaSociosActivo()throws BussinessException {
		List<Sociosa> _lista=new ArrayList<Sociosa>();
		try{
			_lista=_socioDao.ListaActivaSocios();
			return _lista;
		}
		catch(BussinessException ex){
			throw ex;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio#validar(java.lang.Integer)
	 * Servicio de validacion verifica si el dni del un socio esta estado moroso 
	 */
	@Override
	public boolean validar(Integer dni) throws BussinessException {
		try{
			for(DTOPersonalisadoSocio _dto : _socioDao.ListaMorosos()){ //Forech para recorrer la lista de morosos
				if(_dto.getDni().equals(dni))  //si el dni es igual el socio es moroso
					return true;
			}
			return false;
		}
		catch(BussinessException ex){
			throw ex;
		}
	}
	
	

	@SuppressWarnings("unused")
	private static boolean Verificar_edad(Date fechanacimiento){
		Calendar fecnac=Calendar.getInstance();
		//crea un objeto de la fecha actual
		Calendar FechaActual=Calendar.getInstance();

		//asigna la fecha recibida a la fecha de nacimiento
		fecnac.setTime(fechanacimiento);
		//resta las fechas
		int anio=FechaActual.get(Calendar.YEAR)-fecnac.get(Calendar.YEAR);
		int mes=FechaActual.get(Calendar.MONTH)-fecnac.get(Calendar.MONTH);
		int dia=FechaActual.get(Calendar.DATE)-fecnac.get(Calendar.DATE);
		//ajusta la edad dependiendo del mes y dia
		if(mes < 0 || (mes==0 && dia<0)){
			anio--;
		}
		//verifica si es mayor a 18
		if(anio>18)
			return false;
		else 
			return true;
	}
	
	@Override
	public void ControlEstadoMorosos(int mes, int anio) {
		IServiceCuota _serviceCuota=new ServiceCuota();
		try{
			Sociosa _socio=new Sociosa();
			for (Sociosa lista:_serviceCuota.ListaMorososMes(mes,anio)) {	
				_socio=_socioDao.BuscarUno(lista.getNroSocio());
				if(_socio.isHabilitado()){
					_socio.setEstado("Moroso");
					_socio.setHabilitado(false);
					_socioDao.GuardarEntity(_socio);
				}
			}
		}
		catch(Exception ex){
			throw new RuntimeException(ex.toString());
		}
	}
	
	@Override
	public void ControlEstadoDeudor(int mes, int anio) {
		IServiceCuota _servicecuota=new ServiceCuota();
		List<Sociosa> Listadeudor=_servicecuota.ListaDeudorMes(mes,anio);
		
		try{
			for(Sociosa _lista: Listadeudor){
				Sociosa _uno=new Sociosa();
				_uno=_socioDao.BuscarUno(_lista.getNroSocio());
				if(_uno.isHabilitado()){
					_uno.setEstado("Deudor"); //cambia su estado a deudor
					_socioDao.GuardarEntity(_uno);
				}
			}
		}
		catch(Exception ex){
			throw new RuntimeException(ex.toString());
		}
	}


	private void ActualizarEntidad(Sociosa entidad){
		_socio.setNombre(entidad.getNombre());
		_socio.setApellido(entidad.getApellido());
		_socio.setCategoria(entidad.getCategoria());
		_socio.setDomicilio(entidad.getDomicilio());
		_socio.setEstado(entidad.getEstado());
		_socio.setEstadoCivil(entidad.getEstadoCivil());
		_socio.setFechaIngreso(entidad.getFechaIngreso());
		_socio.setFechaNacimiento(entidad.getFechaNacimiento());
		_socio.setHabilitado(entidad.isHabilitado());
		_socio.setMatricula(entidad.getMatricula());
		_socio.setNacionalidad(entidad.getNacionalidad());
		_socio.setSexo(entidad.getSexo());
		_socio.setTelefono(entidad.getTelefono());
	}
}
