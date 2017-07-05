package ar.com.ProyectoClub.CModelo.AServicios.facade;

import java.util.List;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceNoSocio;
import ar.com.ProyectoClub.CModelo.BGestores.GestorNoSocio;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorNosocio;
import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;

public class ServiceNoSocio implements IServiceNoSocio {
	
	private IGestorNosocio Igestornosocio;

	public ServiceNoSocio() {
		try{
			Igestornosocio=new GestorNoSocio();
		}
		catch (Exception e) {
			throw new RuntimeException("Error al iniciar el servicio "+e.getMessage());
		}
	}
	@Override
	public NoSocioDTO Crear() {
		try{
			return(Igestornosocio.Crear());
		}
		catch (Exception e) {
			throw new RuntimeException("Error al crear"+e.getMessage());
		}
	}

	@Override
	public void GuardarNoSocio(NoSocioDTO noSocio) {
		try{
			Igestornosocio.Guardar(noSocio);
		}
		catch (Exception e) {
			throw new RuntimeException("ERROR, no se pudo realizar la transaccion debido al siguiente error: "+e.getMessage());
		}

	}

	@Override
	public void DeshabilitarNoSocio(Integer dni) {
		try{
			Igestornosocio.InabilitarNoSocio(dni);
		}
		catch (Exception e) {
			throw new RuntimeException("ERROR, no se pudo realizar la transaccion debido al siguiente error; "+e.getMessage());
		}
	}

	@Override
	public void HabilitarNoSocio(Integer dni) {
		try{
			Igestornosocio.HabilitarNoSocio(dni);
		}
		catch (Exception e) {
			throw new RuntimeException("ERROR, no se pudo realizar la transaccion debido al siguiente error: "+e.getMessage());
		}
	}

	@Override
	public List<NoSocioDTO> ListarNoSocios() {
		try{
			return Igestornosocio.Listar();
		}
		catch (Exception e) {
			throw new RuntimeException("ERROR, no se pudo realizar la transaccion debido al siguiente error"+e.getMessage());
		}
	}

	@Override
	public NoSocioDTO BuscarNoSocio(Integer dni) {
		try{
			return Igestornosocio.Busqueda(dni);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
