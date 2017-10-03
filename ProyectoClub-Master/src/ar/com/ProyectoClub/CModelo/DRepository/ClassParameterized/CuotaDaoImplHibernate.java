package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;

public class CuotaDaoImplHibernate extends GenericDAOImplHibernate<Cuota, Integer> implements IGenericDAO<Cuota, Integer>{

	public CuotaDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

}
