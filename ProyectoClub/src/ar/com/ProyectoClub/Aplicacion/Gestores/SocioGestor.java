package ar.com.ProyectoClub.Aplicacion.Gestores;


import java.io.Console;
import java.nio.ReadOnlyBufferException;

import ar.com.ProyectoClub.Aplicacion.IGestor.IGestor;
import ar.com.ProyectoClub.Aplicacion.IGestor.ISocioGestor;
import ar.com.ProyectoClub.Dominio.Socios;
import ar.com.ProyectoClub.Persistencia.Dao.BussinessException;
import ar.com.ProyectoClub.Persistencia.Dao.Imple.GenericDAOImplHibernate;
import ar.com.ProyectoClub.Persistencia.IDao.ISociosDAO;
import ar.com.ProyectoClub.Persistencia.IDao.Impl.Hibernet.SociosDaoImplHibernate;

public class SocioGestor implements ISocioGestor {
      
	private SociosDaoImplHibernate GestorSocio;
	private Socios socio;
	
	public SocioGestor(){
        try{
        	GestorSocio=new SociosDaoImplHibernate();
        }
        catch(Exception ex){
        	throw new RuntimeException(ex);
        }
    }
	
	@Override
	public void Crear(Socios entidad) {
		 try{
			 
		 }
		
	}
	
	private void ActualizaSocio(Socios _SMod, Socios _Socio)
    {
       
        _Socio.setDniSocios(_SMod.getDniSocios());
        _Socio.setEstado(_SMod.getEstado());
        _Socio.setEstadocivil(_SMod.getEstadocivil());
        _Socio.setFechaingreso(_SMod.getFechaingreso());
        _Socio.setMatricula(_SMod.getMatricula());
        _Socio.setNacionalidad(_SMod.getNacionalidad());
        _Socio.setNroSocio(_SMod.getNroSocio());
        _Socio.setSexo(_SMod.getSexo());
        
    }
}
