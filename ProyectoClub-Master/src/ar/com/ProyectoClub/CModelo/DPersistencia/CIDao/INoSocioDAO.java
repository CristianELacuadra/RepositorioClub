package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;

import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.NoSocioDTO;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

public interface INoSocioDAO extends IGenericDAO<Personas , Integer> {
	//public NoSocioDTO BusquedaXDni(Integer dni) throws BussinessException;
	public List<NoSocioDTO> ListaNosocio();

}
