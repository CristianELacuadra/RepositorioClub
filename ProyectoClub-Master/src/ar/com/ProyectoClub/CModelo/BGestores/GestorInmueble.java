package ar.com.ProyectoClub.CModelo.BGestores;

import java.util.ArrayList;
import java.util.List;

import ar.com.ProyectoClub.CModelo.BIGestores.IGestorInmueble;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IinmueblesDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.InmueblesDaoImplHibernate;



public class GestorInmueble implements IGestorInmueble {
	private IinmueblesDAO _InmueblesDAO;
	
	public GestorInmueble() throws Exception{
		try {
			_InmueblesDAO=new InmueblesDaoImplHibernate();
			}catch (Exception e) {
				 throw new RuntimeException("Reintente Para Crear El Contructor");
			}
	}

	@Override
	public Inmuebles Crear() throws BussinessException {
		return (_InmueblesDAO.crear());
	}

	@Override
	public void Guardar(Inmuebles entity) throws Exception {
		try{
			Inmuebles _uno=this.Crear();
			_uno=entity;
			_InmueblesDAO.GuardarEntity(_uno);
		
			}
		catch (BussinessException e) {
			throw new Exception("No se puede guardar los datos debido al siguiente error: "+e.toString());
		}
	}

	public Integer ObtenerSiguienteIdInmueble(){
		Integer aux=0;
	
		List<Inmuebles> _list=new ArrayList<Inmuebles>();
		try {
			_list=this.Listar();
			if(!_list.isEmpty()){
				for(Inmuebles inm:_list){
					if(inm.getIdInmueble()>aux){
					aux=inm.getIdInmueble();
					}
				}
			}
			return aux++;
		
		} catch (Exception e) {
				throw new RuntimeException("ERROR :"+e.toString());
		}
		
		
	}

	
	@Override
	public Inmuebles Busqueda(Integer id) throws Exception {
		Inmuebles _uno=this.Crear();
		_uno=_InmueblesDAO.BuscarUno(id);
		return _uno;
	}

	@Override
	public List<Inmuebles> Listar() throws Exception {
		List<Inmuebles> _list=new ArrayList<Inmuebles>();
		_list=_InmueblesDAO.Listar();
		return _list;
	}

	@Override
	public void Inhabilitar(Inmuebles entity) throws Exception {
		Inmuebles _e=this.Crear();
		_e=this.Busqueda(entity.getIdInmueble());
		_e.setHabilitado(false);
		this.Guardar(_e);
		
	}

	@Override
	public void habilitar(Inmuebles entity) throws Exception {
		Inmuebles _e=this.Crear();
		_e=this.Busqueda(entity.getIdInmueble());
		_e.setHabilitado(true);
		this.Guardar(_e);
	}

}
