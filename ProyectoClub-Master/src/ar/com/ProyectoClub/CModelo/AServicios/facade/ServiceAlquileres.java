package ar.com.ProyectoClub.CModelo.AServicios.facade;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceAlquileres;
import ar.com.ProyectoClub.CModelo.BGestores.GestorAlquiler;
import ar.com.ProyectoClub.CModelo.BGestores.GestorInmueble;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorAlquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IAlquilerDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.AlquilerDaoImplHibernate;

public class ServiceAlquileres implements IServiceAlquileres {
	private IAlquilerDAO _AlquilerDao;
	private  Alquiler _Alquiler;
	private IGestorAlquiler gestoralquiler;
	

	public ServiceAlquileres() {
		try{
			gestoralquiler=new GestorAlquiler();
			_AlquilerDao=new AlquilerDaoImplHibernate();
			}
			catch (Exception e) {
			    throw new RuntimeException("No se pudo iniciar el servicio debido al siguiente error:"+e.getMessage());
			}				
	}
	
	@Override
	public void AltaAlquiler(Alquiler nuevo) {
		_Alquiler=this.Actualizardatos(nuevo);
		try {
			if(_Alquiler.getPersonas()!=null)
				_AlquilerDao.GuardarEntity(nuevo);
			else {
				if(_Alquiler.getPersonas()==null) 
					throw new RuntimeException("Error,socio o no socio igual a null");
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e.toString());
		}
	}
	@Override
	public void ActualizarAlquiler(Alquiler nuevo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void InhabilitarAlquiler(Alquiler nuevo) {
		// TODO Auto-generated method stub
		
	}
	
	private Alquiler Actualizardatos(Alquiler datos) {
		Alquiler _Alquiler=new Alquiler();
		_Alquiler.setInmuebles(datos.getInmuebles());
		_Alquiler.setFechaActual(datos.getFechaActual());
		_Alquiler.setHoraActual(datos.getHoraActual());
		_Alquiler.setFechaReserva(datos.getFechaReserva());
		_Alquiler.setHoraReserva(datos.getHoraReserva());
		_Alquiler.setPrecioTotal(datos.getPrecioTotal());
		_Alquiler.setCantidadHora(datos.getCantidadHora());
		_Alquiler.setActivo(datos.isActivo());
		return _Alquiler;
	}
	public Alquiler CrearAlquiler(){
		try{
			return gestoralquiler.Crear();
		}catch(Exception e){
			throw new RuntimeException("No se pudo instanciar el servicio debido al siguiente error: "+e.getMessage());
		}
	}
	public void GuardarAlquiler(Alquiler alqui){
		try {
			gestoralquiler.Guardar(alqui);
		} catch (Exception e) {
			throw new RuntimeException("No se pudo instanciar el servicio debido al siguiente error: "+e.getMessage());
		}
	}
	
}
