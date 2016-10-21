package ar.com.ProyectoClub.Aplicacion.Gestores;

import ar.com.ProyectoClub.Aplicacion.IGestor.ISocioGestor;
import ar.com.ProyectoClub.Dominio.Personas;
import ar.com.ProyectoClub.Dominio.Socios;
import ar.com.ProyectoClub.Persistencia.IDao.Impl.Hibernet.PersonasDaoImplHibernet;
import ar.com.ProyectoClub.Persistencia.IDao.Impl.Hibernet.SociosDaoImplHibernate;

public class SocioGestor implements ISocioGestor {
	
    private Socios socio;
    private SociosDaoImplHibernate implSocio;
    private PersonasDaoImplHibernet implPers;
    
    
    public SocioGestor() {
		try{
			implPers=new PersonasDaoImplHibernet();
			implSocio=new SociosDaoImplHibernate();
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
    
    public void Guardar(Socios entidad) {
    	
    	try{
    		
    		implSocio.GuardarActualizar(entidad);
    	}
        catch (Exception ex) {
		   throw new RuntimeException(ex);	
		}
    	
}

}
