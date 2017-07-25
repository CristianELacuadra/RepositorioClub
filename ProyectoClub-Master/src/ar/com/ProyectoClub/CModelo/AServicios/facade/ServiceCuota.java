package ar.com.ProyectoClub.CModelo.AServicios.facade;

import java.util.Date;
import java.util.List;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCuota;
import ar.com.ProyectoClub.CModelo.BGestores.GestorCuota;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
	
	public class ServiceCuota implements IServiceCuota {
	private IGestorCuota gestorcuota;
	
	public ServiceCuota() {
		gestorcuota= new GestorCuota();
	}
	
	@Override
	public Cuota CrearInstanciaCuota() {
		try{
			return gestorcuota.Crear();
		}
		catch (Exception e) {
		    throw new RuntimeException(e);
		}
		
	}
	
	@Override
	public void RegistrarPagoCuota(Cuota nueva) {
		try{
			gestorcuota.RegistrarPagoCuota(nueva);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void GuardarCuota(Cuota cuota) {
		try{
			gestorcuota.Guardar(cuota);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}


	@Override
	public Cuota BuscarCuota(Integer Id) {
		try{
			return gestorcuota.Busqueda(Id);
		}
		catch (Exception e) {
		    throw new RuntimeException(e);
		}
	}


	@Override
	public List<Cuota> ListarCuotasHabilitadas() {
		try{
			return gestorcuota.Listar();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void GeneracionCuota(Date fechaActual,List<Personas> PersonasActivas) {
		try{
			gestorcuota.GeneracionDeCuotas(fechaActual, PersonasActivas);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Cuota ObtenerUltimaCuota() {
		try{
			return(gestorcuota.ObtenerUltimaCuotaIngresado());
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Cuota> ObtenerCuotasImpagas() {
		try{
			return(gestorcuota.ObtenerCuotasImpagas());
		}
		catch (Exception e) {
			throw new RuntimeException(e); 
		}
	}

	@Override
	public List<Cuota> ObtenerCuotas(Personas persona) {
		try{
			return(gestorcuota.ObtenerCuotasSocio(persona.getDni()));
		}
		catch (Exception e) {
			throw new RuntimeException(e); 

		}
	}

	

}
