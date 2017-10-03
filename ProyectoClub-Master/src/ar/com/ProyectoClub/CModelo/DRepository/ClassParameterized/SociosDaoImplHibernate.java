package ar.com.ProyectoClub.CModelo.DRepository.ClassParameterized;

import ar.com.ProyectoClub.CModelo.CEntidades.Socios;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DRepository.GenericDaoAndSession.GenericDAOImplHibernate;

public class SociosDaoImplHibernate  extends GenericDAOImplHibernate<Socios, Integer> implements IGenericDAO<Socios,Integer> {

	public SociosDaoImplHibernate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

}
