package ar.com.ProyectoClub.Aplicacion.Gestores;

import ar.com.ProyectoClub.Aplicacion.IGestor.IGestorGeneric;
import ar.com.ProyectoClub.Aplicacion.IGestor.IPersonasGestor;
import ar.com.ProyectoClub.Dominio.Personas;
import ar.com.ProyectoClub.Persistencia.IDao.Impl.Hibernet.PersonasDaoImplHibernet;


public class PersonasGestor implements IPersonasGestor{
	private Personas persona;
	private PersonasDaoImplHibernet implpersona;
	
	public PersonasGestor() {
	    implpersona=new PersonasDaoImplHibernet();
	    persona=new Personas();
	}
	
	@Override
	public void Guardar(Personas entidad) {
		  try{
			  
		  }
		  catch{
			  
		  }
		
	}

}
