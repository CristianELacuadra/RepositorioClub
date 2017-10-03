package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;

public class InmueblesDaoImplHibernate extends GenericDAOImplHibernate<Inmuebles, Integer> implements IGenericDAO<Inmuebles, Integer>{

	public InmueblesDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}


}
