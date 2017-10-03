package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;

public class CajaDaoImplHibernate extends GenericDAOImplHibernate<Caja, Integer> implements IGenericDAO<Caja, Integer>{

	public CajaDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

}
