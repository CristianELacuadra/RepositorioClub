package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.INoSocioDAO;

public class NoSocioDaoImplHibernate extends GenericDAOImplHibernate<Personas,Integer> implements INoSocioDAO{
	
	//constructor de la super clase
	public NoSocioDaoImplHibernate() throws Exception {
		super();
	}
	/**
	 * Realiza la busqueda en persona y devuelve un DTO personalizado de no socio
	 * esta busqueda es unicamente para el no socio,ya que el socio posee la busqueda generica  
	 */
	/*
	public NoSocioDTO BusquedaXDni(Integer dni) throws BussinessException{
		NoSocioDTO Objnosocio=new NoSocioDTO();
		try{
			Setsession();
			SetTransaction();
			Personas _nuevo=(Personas) _sessiondehilo.createQuery("SELECT query FROM Personas query WHERE Dni="+dni.toString()).uniqueResult();
			if(_nuevo!=null){
				Objnosocio.setDni(_nuevo.getDni());
				Objnosocio.setNombre(_nuevo.getNombre());
				Objnosocio.setApellido(_nuevo.getApellido());
				Objnosocio.setDomicilio(_nuevo.getDomicilio());
				Objnosocio.setTelefono(_nuevo.getTelefono());
				Objnosocio.setFecNacimiento(_nuevo.getFecNacimiento());
				Objnosocio.setEssocio(_nuevo.isEssocio());
				Objnosocio.setHabilitado(_nuevo.isHabilitado());
			}
			else{
				Objnosocio=null;
			}
			_sessiondehilo.getTransaction().commit();
			return Objnosocio;
		}
		catch(Exception e){
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException("Error al realizar la consulta"+e.toString());
		}
	}
	*/
	//-----------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<NoSocioDTO> ListaNosocio() {
		List<NoSocioDTO> _todos=new ArrayList<NoSocioDTO>();
		NoSocioDTO Objnosocio=new NoSocioDTO();
		try {
			Setsession();
			SetTransaction();
			List<Personas> _list =_sessiondehilo.createQuery("SELECT query FROM Personas query WHERE essocio=false").list();
			_sessiondehilo.getTransaction().commit();
			for(Personas _sDto : _list) {
				Objnosocio.setDni(_sDto.getDni());
				Objnosocio.setNombre(_sDto.getNombre());
				Objnosocio.setApellido(_sDto.getApellido());
				Objnosocio.setDomicilio(_sDto.getDomicilio());
				Objnosocio.setTelefono(_sDto.getTelefono());
				Objnosocio.setFecNacimiento(_sDto.getFecNacimiento());
				_todos.add(Objnosocio);
			}
			return _todos;
		}
		catch (Exception e) {
			_sessiondehilo.beginTransaction().rollback();
			_sessiondehilo.close();
			throw new RuntimeException("Error al realizar la consulta"+e.toString());
		}
		
	}
}
