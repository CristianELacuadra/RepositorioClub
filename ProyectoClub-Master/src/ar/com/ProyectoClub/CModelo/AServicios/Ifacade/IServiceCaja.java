package ar.com.ProyectoClub.CModelo.AServicios.Ifacade;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.*;

public interface IServiceCaja{
	public Caja CrearInstanciaCaja();
	public List<Caja> listarRegistrosDeCaja();
	public void GuardarIngresoEgreso(Caja registro);
	public Caja UltimoRegistroCaja();
	public List<Caja> ObtenerCajasPorParamatros(Date FechaDesde, Date FechaHasta, String Descripcion,boolean Ingreso, boolean Egreso);

}
