package mainProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.RepositoryIdHelper;

import ar.com.ProyectoClub.CModelo.BNegocio.Gestor;
import ar.com.ProyectoClub.CModelo.CEntidades.*;
import ar.com.ProyectoClub.CModelo.DRepository.IRepository.IRepository;
import ar.com.ProyectoClub.CModelo.DRepository.Repository.Repository;

public class MainPruebaModulos {
   
	
    public static void main(String[] args) throws Exception {
    	 IRepository repositorioprueba; 
	     repositorioprueba = new Repository();
	     Gestor gestor=new Gestor();
//	     long i= repositorioprueba.DevolverTotalRegistrosCaja();
//	     System.out.println(i);
//	     List<Caja> lista= repositorioprueba.BusquedaPorDescripcionCaja("Ingreso");
//	   //  System.out.println(lista.size());
//	     List<Caja> lista2= repositorioprueba.ListaTotalEgresos();
//	     System.out.println(lista2.size());
//	     long ii= repositorioprueba.NoSociosRegistrados();
//	     System.out.println(ii);
//	     Categoria categoria= gestor.BuscarCategoria(1);
//	     List<Caja> cajas=gestor.ObtenerRegistrosCaja();
//	     for(Caja u: cajas)
//	     System.out.println(u.getDescripcion());
	     
       List<Socios> socios= repositorioprueba.ObtenerSocios();      
       Personas persona=repositorioprueba.CrearPersona();
       Categoria categoria=repositorioprueba.CrearCategoria();
       List<Caja> caja =new ArrayList<Caja>();
    	caja=repositorioprueba.ObtenerCajas();
    	try{
    		Conceptos conceptos=new Conceptos();
    		for(Caja cjs : caja){
    			conceptos=cjs.getConceptos();
    			System.out.println(cjs.getConceptos().getTipo());
    		}
    	}
    	catch (Exception e)
    	{
			System.out.println(e.getMessage());
		}
       categoria=repositorioprueba.BuscarCategoria(1);
       List<Personas> personasdd =new ArrayList<Personas>();
    		   personasdd=repositorioprueba.ObtenerPersonas();
//       if(!persona.getSocios().equals(null)){
//    	   persona.setSocios(null);
//    	   repositorioprueba.GuardarPersona(persona);
//       }
	     
       
//       //persona.setDni(39874562);
//         Socios socio=repositorioprueba.CrearSocio();
//         socio=repositorioprueba.BuscarSocio(36545658);
//         if(!socio.getCuotas().isEmpty()){
//        	 System.out.println("hola");
//         }
	     
	    // for(Personas persona: gestor.ObtenerNoSocios()){
	    //	 System.out.println(persona.getDni());
	     //}
//   
//       socio.setEstado("Activo");
//       socio.setFechaingreso(new Date());
//       socio.setMatricula(1013);
//       socio.setCategoria(categoria);
//       socio.setPersonas(persona);
//       persona.setSocios(socio);
//       repositorioprueba.GuardarPersona(persona);
//       //repositorioprueba.GuardarPersona(persona);
	}

}
