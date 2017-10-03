package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;

public class CategoriaDaoImplHibernate extends GenericDAOImplHibernate<Categoria, Integer> implements IGenericDAO<Categoria,Integer> {

	public CategoriaDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}


}
