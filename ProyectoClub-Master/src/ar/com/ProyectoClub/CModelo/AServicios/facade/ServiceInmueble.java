package ar.com.ProyectoClub.CModelo.AServicios.facade;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceInmuebles;
import ar.com.ProyectoClub.CModelo.BGestores.GestorInmueble;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IinmueblesDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.InmueblesDaoImplHibernate;

public class ServiceInmueble implements IServiceInmuebles {
	private IinmueblesDAO _inmuebledao;
	private Inmuebles _Inmuebles;

	public ServiceInmueble() throws Exception{
			_inmuebledao=new InmueblesDaoImplHibernate();
			_Inmuebles=new Inmuebles();
	}
	@Override
	public void BusquedaInmueble(Integer id) {
		try {
			
		}
		
	}
	
	public Inmuebles CrearInmueble(){
		try{
			return (GestorInmueble.Crear());
		}catch(Exception e){
			throw new RuntimeException("No se pudo instanciar el servicio debido al siguiente error: "+e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	

}
