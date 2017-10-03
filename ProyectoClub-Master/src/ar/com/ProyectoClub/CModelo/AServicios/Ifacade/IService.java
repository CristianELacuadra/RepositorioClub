package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;

public interface IService {
	//contrato caja
	Caja CrearInstanciaCaja();
	public List<Caja> ObtenerRegistrosDeCaja();
	public void GuardarRegistroCaja(Caja registro);
	public Caja UltimoRegistroCaja();
	public List<Caja> ObtenerCajasPorParamatros(Date FechaDesde, Date FechaHasta, String Descripcion,boolean Ingreso, boolean Egreso);
}
