package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;


public class PersonaImplHibernate extends GenericDAOImplHibernate<Personas, Integer> implements IGenericDAO<Personas, Integer>{

	public PersonaImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
