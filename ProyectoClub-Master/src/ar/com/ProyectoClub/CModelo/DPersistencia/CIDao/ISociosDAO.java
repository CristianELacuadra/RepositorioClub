package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;

import ar.com.ProyectoClub.CModelo.CEntidades.DTOPersonalisadoSocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

import java.util.List;

public interface ISociosDAO extends IGenericDAO<Sociosa,Integer>{
	public List<Sociosa> ListaActivaSocios() throws BussinessException;
	public List<DTOPersonalisadoSocio> ListaMorosos() throws BussinessException;
	public Sociosa BusquedaXDni(Integer dni) throws BussinessException;
}
