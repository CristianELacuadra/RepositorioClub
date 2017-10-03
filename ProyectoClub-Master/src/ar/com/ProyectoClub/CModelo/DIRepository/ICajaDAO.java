package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;


import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

public interface ICajaDAO extends IGenericDAO<Caja, Integer> {
	public Integer DevolverCantiddad();
	public float Subtotal();
	public List<Caja>  ListaPoranio(Integer anio,boolean tipo);
	public List<Caja>  ListaPormes(Integer anio,Integer mes,boolean tipo);
	public List<Caja>  ListaPorRangoFecha(Date FechaDesde,Date FechaHasta,boolean Ingreso,boolean Egreso);
	public List<Caja>  ListaTotalIngreso();
	public List<Caja> BusquedaPorDescripcion(String Descripcion,boolean Ingreso,boolean egreso);
	public List<Caja>  ListaTotalEgresos();
	public Integer  ObtenerUltimoIdIngresado(); //Solo funciona para entidades con id autoincremental
}
