package ar.com.ProyectoClub.CModelo.BIGestores;

import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;

public interface IGestorCaja extends IGestorGeneric<Caja> {
	public List<Caja> FiltrarEgresos();
	public List<Caja> FiltrarIngresos();
	public List<Caja> ListarEgresoAnio(Integer anio);
	public List<Caja> ListaringresoAnio(Integer anio);
	public List<Caja> ListarEgresoMesAnio(Integer anio,Integer mes);
	public List<Caja> ListaringresoMesAño(Integer anio,Integer mes);
	public List<Caja> ListarEgresoFecha(Integer anio,Integer mes,Integer dia);
	public List<Caja> ListaringresoFecha(Integer anio,Integer mes,Integer dia);
	public float DevolverSubtotal();
	public Caja ObtenerUltimoRegistro();
	public List<Caja> ObtenerRegistroCajasPorParametros(Date FechaDesde,Date FechaHasta,String Descripcion,boolean Ingreso,boolean Egreso) throws Exception;
}
