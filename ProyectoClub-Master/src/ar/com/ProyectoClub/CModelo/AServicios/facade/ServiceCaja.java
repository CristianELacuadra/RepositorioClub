package ar.com.ProyectoClub.CModelo.AServicios.facade;

import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCaja;
import ar.com.ProyectoClub.CModelo.BGestores.GestorCaja;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorCaja;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;


public class ServiceCaja implements IServiceCaja{
	private IGestorCaja gestorcaja;
	
	public ServiceCaja() {
		gestorcaja=new GestorCaja();
	}
	@Override
	public List<Caja> listarRegistrosDeCaja() {
		try{
			return gestorcaja.Listar();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Caja UltimoRegistroCaja() {
		return gestorcaja.ObtenerUltimoRegistro();
	}
	@Override
	public List<Caja> ObtenerCajasPorParamatros(Date FechaDesde, Date FechaHasta, String Descripcion, boolean Ingreso,boolean Egreso) {
		try{
			return gestorcaja.ObtenerRegistroCajasPorParametros(FechaDesde, FechaHasta, Descripcion, Ingreso, Egreso);
		}
		catch (Exception e) {
			throw new RuntimeException(e); 
		}
	}
	@Override
	public Caja Crear() {
		try{
			return(gestorcaja.Crear());
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void GuardarIngresoEgreso(Caja registro) {
		try{
			gestorcaja.Guardar(registro);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
