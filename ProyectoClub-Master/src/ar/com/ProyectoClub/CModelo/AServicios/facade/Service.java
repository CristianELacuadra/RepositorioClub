package ar.com.ProyectoClub.CModelo.AServicios.facade;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IService;
import ar.com.ProyectoClub.CModelo.BNegocio.Gestor;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;

public class Service implements IService {
private  Gestor gestor;

public Service() {
	try {
		gestor= new Gestor();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	@Override
	public Caja CrearInstanciaCaja() {
		try {
			return (gestor.CrearCaja());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Caja> ObtenerRegistrosDeCaja() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void GuardarRegistroCaja(Caja registro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caja UltimoRegistroCaja() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caja> ObtenerCajasPorParamatros(Date FechaDesde, Date FechaHasta, String Descripcion, boolean Ingreso,
			boolean Egreso) {
		// TODO Auto-generated method stub
		return null;
	}

}
