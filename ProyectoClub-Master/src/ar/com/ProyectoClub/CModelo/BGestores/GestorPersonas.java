package ar.com.ProyectoClub.CModelo.BGestores;

import java.util.List;

import ar.com.ProyectoClub.CModelo.BIGestores.IGestorPersonas;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IPersonaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.PersonaImplHibernate;

public class GestorPersonas implements IGestorPersonas {

	private IPersonaDAO personasDao;
	
	public GestorPersonas() throws Exception {
		personasDao=new PersonaImplHibernate();
	}
	
	@Override
	public Personas Crear() throws Exception {
		return personasDao.crear();
	}
	
	@Override
	public void Guardar(Personas entity) throws Exception {
		personasDao.GuardarEntity(entity);
	}

	@Override
	public Personas Busqueda(Integer id) throws Exception {
		Personas persona=this.Crear();
		persona=personasDao.BuscarUno(id);
		if(persona != null)
			return persona;
		return null;
	}

	@Override
	public List<Personas> Listar() throws Exception {
		personasDao.
	}

	@Override
	public void Inhabilitar(Personas entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void habilitar(Personas entity) throws Exception {
		// TODO Auto-generated method stub

	}

}
