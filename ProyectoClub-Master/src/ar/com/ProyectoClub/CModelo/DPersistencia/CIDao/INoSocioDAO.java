package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;




import java.util.List;

import ar.com.ProyectoClub.CModelo.CEntidades.Nosocio;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;

public interface INoSocioDAO extends IGenericDAO<Nosocio , Integer> {
	public List<Nosocio> ListaNoSociosInhabilitados();   //lista de personas que por alguna razon no puede realizar alquiler

}
