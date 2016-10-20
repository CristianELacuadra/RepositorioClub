package ar.com.ProyectoClub.Presentacion;

import ar.com.ProyectoClub.Dominio.Personas;
import ar.com.ProyectoClub.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Persistencia.IDao.IPersonasDAO;
import ar.com.ProyectoClub.Persistencia.IDao.Impl.Hibernet.PersonaDaoImplHibernate;

public class PersonasController {
	IPersonasDAO PersonaDAO;

    public PersonasController() {
        PersonaDAO=new PersonaDaoImplHibernate();
    }

    public void guardar(Personas persona) throws BussinessException {

            PersonaDAO.GuardarActualizar(persona);
    }
}
