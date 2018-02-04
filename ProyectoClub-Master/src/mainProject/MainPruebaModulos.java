package mainProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.omg.CORBA.RepositoryIdHelper;

import ar.com.ProyectoClub.CModelo.AServicios.facade.Service;
import ar.com.ProyectoClub.CModelo.BNegocio.Gestor;
import ar.com.ProyectoClub.CModelo.CEntidades.*;
import ar.com.ProyectoClub.CModelo.DRepository.IRepository.IRepository;
import ar.com.ProyectoClub.CModelo.DRepository.Repository.Repository;

public class MainPruebaModulos {


	public static void main(String[] args) throws Exception {
		IRepository repositorioprueba; 
		repositorioprueba = new Repository();
		Service service=new Service();
		//service.ListarMorososDeudores();
		Alquiler alquiler=repositorioprueba.BuscarAlquiler(1);
		List<Alquiler> llalal=repositorioprueba.ObtenerAlquileres();
		List<Socios> socios= repositorioprueba.ObtenerSocios();
		List<Caja> caja=repositorioprueba.ObtenerCajas();
		List<Categoria> caa=repositorioprueba.ObtenerCategorias();
		//Socios socio= repositorioprueba.BuscarSocio(7664645);
//		Date fecha=repositorioprueba.ObtenerUltimoFechaActividad(7664645);
//		Gestor gestor=new Gestor();
//		List<Socios> listaSocio=gestor.ListarSocio();
//		gestor.ValidarCuotasSocio(listaSocio);
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
//		try{
//			Personas persona=repositorioprueba.CrearPersona();
//			Socios socio=repositorioprueba.CrearSocio();
//			Categoria nuevaCategoria=repositorioprueba.CrearCategoria();
//			persona.setDni(1548752);
//			persona.setNombre("lalalla");
//			persona.setApellido("lalalla");
//			persona.setFechanac(new Date());
//			persona.setDomicilio("lalalal");
//			persona.setTelefono("34234");
//			persona.setNacionalidad("sdsd");
//			persona.setEstadocivil("dsdasd");
//			persona.setSexo("M");
//			persona.setHabilitado(true);
//			socio.setEstado("Activo");
//			socio.setFechaingreso(new Date());
//			socio.setBaja(false);
//			socio.setMatricula(1245);
//			nuevaCategoria= repositorioprueba.BuscarCategoria(1);
//			socio.setCategoria(nuevaCategoria);
//			socio.setPersonas(persona);
//			persona.setSocios(socio);
//			repositorioprueba.GuardarPersona(persona);
//		}
//		catch (Exception e) 
//		{
//			throw new RuntimeException(e);
//		}



//		List<Socios> socios= repositorioprueba.ObtenerSocios();      
//		Personas persona=repositorioprueba.CrearPersona();
//		Categoria categoria=repositorioprueba.CrearCategoria();
//		List<Caja> caja =new ArrayList<Caja>();
//		caja=repositorioprueba.ObtenerCajas();
//		try{
//			Conceptos conceptos=new Conceptos();
//			for(Caja cjs : caja){
//				conceptos=cjs.getConceptos();
//				System.out.println(cjs.getConceptos().getTipo());
//			}
//		}
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		categoria=repositorioprueba.BuscarCategoria(1);
//		List<Personas> personasdd =new ArrayList<Personas>();
//		personasdd=repositorioprueba.ObtenerPersonas();
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
