package ar.com.ProyectoClub.Persistencia.IDao.Impl.Hibernet;

import java.io.Serializable;

import ar.com.ProyectoClub.Dominio.Personas;
import ar.com.ProyectoClub.Persistencia.Dao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.Persistencia.IDao.IPersonaDAO;

public class PersonasDaoImplHibernet extends GenericDAOImplHibernate<Personas, Serializable> implements IPersonaDAO{

}
