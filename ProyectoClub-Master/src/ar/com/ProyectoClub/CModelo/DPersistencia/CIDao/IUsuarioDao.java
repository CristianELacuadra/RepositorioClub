package ar.com.ProyectoClub.CModelo.DPersistencia.CIDao;

import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;


public interface IUsuarioDao extends IGenericDAO<Usuario,Integer> {
	public Usuario Acceder(String usuario,String pass);

}
