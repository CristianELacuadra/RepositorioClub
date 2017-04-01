package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;

import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

public interface IAlquilerDAO extends IGenericDAO<Alquiler, Integer> {
	public List<Alquiler> BusquedaXFecha(Date fechainicial,Date fechafin);
}
