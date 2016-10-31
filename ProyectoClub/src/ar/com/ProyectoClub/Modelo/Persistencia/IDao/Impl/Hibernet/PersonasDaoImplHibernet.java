package ar.com.ProyectoClub.Modelo.Persistencia.IDao.Impl.Hibernet;

import java.io.Serializable;

import ar.com.ProyectoClub.Modelo.Dominio.Personas;
import ar.com.ProyectoClub.Modelo.Persistencia.Dao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.Modelo.Persistencia.IDao.IPersonaDAO;

public class PersonasDaoImplHibernet extends GenericDAOImplHibernate<Personas, Serializable> implements IPersonaDAO{

}
