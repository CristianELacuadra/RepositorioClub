package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;

public class AlquilerDaoImplHibernate extends GenericDAOImplHibernate<Alquiler, Integer> implements IGenericDAO<Alquiler, Integer>{

	public AlquilerDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
}
