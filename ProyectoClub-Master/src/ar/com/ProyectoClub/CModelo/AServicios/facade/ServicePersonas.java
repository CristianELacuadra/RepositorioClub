package ar.com.ProyectoClub.CModelo.AServicios.facade;

import java.util.List;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServicePersonas;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.IGenericDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.Imple.GenericDAOImplHibernate;

public class ServicePersonas extends GenericDAOImplHibernate<Personas, Integer> implements IServicePersonas {

	public ServicePersonas() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	private 
	
	@Override
	public void CrearPersonas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GuardarPersonas(Personas personas) {
		lis
		
	}

	@Override
	public void EliminarPersona(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personas BuscarPersona(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personas> ListarPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

}
