package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;

public class UsuarioDaoImplHibernate extends GenericDAOImplHibernate<Usuario, Integer> implements IGenericDAO<Usuario,Integer>{

	public UsuarioDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
