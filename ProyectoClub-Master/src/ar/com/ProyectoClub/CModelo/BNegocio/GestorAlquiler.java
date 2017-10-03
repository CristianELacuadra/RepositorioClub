package ar.com.ProyectoClub.CModelo.BNegocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.BIGestores.IGestorAlquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DIRepository.IAlquilerDAO;
import ar.com.ProyectoClub.CModelo.DRepository.AlquilerDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.BussinessException;

public class GestorAlquiler implements IGestorAlquiler {
	private  IAlquilerDAO _AlquilerDao;

	public GestorAlquiler() {
		try {
		 _AlquilerDao=new  AlquilerDaoImplHibernate();
		}
		catch (Exception e) {
			 throw new RuntimeException("Error al crear el contructor"+e.getMessage());
		}
	}

	@Override
	public Alquiler Crear() throws BussinessException {
		return(_AlquilerDao.crear());//->Devuelve nueva instancia de la entidad Alquiler
	}
	
	private Date Tomarhora() {
		return(FechaHora.HoraActual().getTime());
	}
	
	private Date TomarFecha() {
		return(FechaHora.FechaActual());
	}
	

	@Override
	public void Guardar(Alquiler entity) throws Exception {
		try {
			if(entity.getFechaReserva().compareTo(this.TomarFecha())>0 || entity.getFechaReserva().compareTo(this.TomarFecha())==0){
				if(entity.getNroAlquiler()==null)
					entity.setActivo(true); //si es un insert si o si activo tiene que ser true
				entity.setFechaActual(this.TomarFecha());
				entity.setHoraActual(this.Tomarhora());
				_AlquilerDao.GuardarEntity(entity);
			}
			else {
				throw new RuntimeException("¡¡ERROR!!,la fecha de reserva no puede ser menor a la fecha actual");
			}
		}
		catch (BussinessException e) {
			throw new Exception("No se puede guardar los datos debido al siguiente error: "+e.toString());
		}

	}

	@Override
	public Alquiler Busqueda(Integer id) throws Exception {
			Alquiler _uno=this.Crear();
			_uno=_AlquilerDao.BuscarUno(id);
			return _uno;
	}
	
	/**
	 * public List<Alquiler> Listar() 
	 * lista historicos de alquileres ya sea activos e inactivos;
	 **/

	@Override
	public List<Alquiler> Listar() throws Exception {   
		List<Alquiler> _list=new ArrayList<Alquiler>();
		_list=_AlquilerDao.Listar();
		return _list;

	}
	/**
	 * public List<Alquiler> Lista_activo
	 * metodo publico lista todos los alquileres activos  
	 **/
	@Override
	public List<Alquiler> Listar_activos() {
		List<Alquiler> _list=new ArrayList<Alquiler>();
		try {
			for(Alquiler _ObjAlquiler: _AlquilerDao.Listar()) {
				if(_ObjAlquiler.isActivo())
					_list.add(_ObjAlquiler);
		}
			return _list;
		}
		catch (BussinessException e) {
			throw new RuntimeException("No se pudo realizar la consulta debido al siguiente error"+e.getMessage());
		}
	}
	/**
	 * Public List<Alquiler> BusquedaXFecha();
	 */
	@SuppressWarnings("null")
	@Override
	public List<Alquiler> BusquedaXFecha(Date fechainicial,Date fechafin) throws Exception {
		List<Alquiler> _list=new ArrayList<Alquiler>();
		_list.clear();
		//_list=null;
		for(Alquiler _alq : _AlquilerDao.BusquedaXFecha(fechainicial,fechafin)) { //llama al dao que contiene una Query de rango de fecha
			if(_alq.isActivo())
				_list.add(_alq);
		}

		return _list;
	}
	
	@Override
	public void Inhabilitar(Alquiler entity) throws Exception {
			Alquiler _uno=this.Crear();
			_uno=this.Busqueda(entity.getNroAlquiler());
			_uno.setActivo(entity.isActivo());//el alquiler pasa a estado inactivo
			this.Guardar(_uno);//guarda los datos
	}

	@Override
	public void habilitar(Alquiler entity) throws Exception {
			Alquiler _uno=this.Crear();
			_uno=this.Busqueda(entity.getNroAlquiler());
			_uno.setActivo(entity.isActivo());//el alquiler pasa a estado activo
			this.Guardar(_uno);//guarda los datos
	}
	
	public Integer ObtenerSiguienteIdAlquiler(){
		Integer aux=0;
		List<Alquiler> _list=new ArrayList<Alquiler>();
		try {
			_list=this.Listar();
			if(!_list.isEmpty()){
				for(Alquiler inm:_list){
					if(inm.getNroAlquiler()>aux){
					aux=(inm.getNroAlquiler()+1);
					}
				}
			}
		
		} catch (Exception e) {
			}
		return aux;
		
	}

	
}
