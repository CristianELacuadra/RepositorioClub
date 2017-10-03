package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Conceptos;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;

public class ConceptosDaoImplHibernate extends GenericDAOImplHibernate<Conceptos, Integer> implements IGenericDAO<Conceptos,Integer> {

	public ConceptosDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

}
