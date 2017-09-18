package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

import java.util.List;

public interface IPersonaDAO extends IGenericDAO<Personas,Integer>{
	public List<Personas> FiltrarNomApe(String Nom,String Ape,boolean essocio)throws BussinessException;
	public long TotalPersonasRegistrados(boolean EsSocio) throws BussinessException;
	public List<Personas> HistoricoSocio() throws BussinessException;
	public List<Personas> HistoricoNoSocio() throws BussinessException;
	public List<Personas> ListaActivaSocios() throws BussinessException;
	public Integer MaxNroSocio() throws BussinessException;
}
