package pruebas;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Nosocio;
import ar.com.ProyectoClub.CModelo.CEntidades.Sociosa;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IAlquilerDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICajaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICategoriaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ICuotaDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.INoSocioDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.ISociosDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IinmueblesDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.AlquilerDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CajaDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CategoriaDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.CuotaDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.InmueblesDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.NoSocioDaoImplHibernate;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.SociosDaoImplHibernate;



public class DaoPrueba {

	public static void main(String[] args) throws BussinessException {
		/*
		IPersonaDAO personaDAO=new PersonasDaoImplHibernet();
	//	ICategoriaDAO sociodao=new CategoriaDaoImplHibernate();
----------------		//busqueda de socio ¡¡¡¡OK!!!//  -------------
		ISociosDAO sociodao=new SociosDaoImplHibernate();
		Socios nuevo=new Socios();
		try{
		nuevo=sociodao.BuscarUno(40673760);
		nuevo.setPersonas(personaDAO.BuscarUno(nuevo.getDniSocios()));
		System.out.print("nombre: "+nuevo.getPersonas().getNombre()+"\n");
		System.out.print("Apellido: "+nuevo.getPersonas().getApellido());
		System.out.print("Sexo:"+nuevo.getSexo());
		System.out.print("Sexo:"+nuevo.getPersonas().getTelefono());
		}
		catch(BussinessException ex ){
			throw new RuntimeException(ex);
		}
		
------------------		/*listar socio OK ------------------
*/
		/*
		ISociosDAO sociodao=new SociosDaoImplHibernate();
		List<Socios> lp = new ArrayList<Socios>();
		try{
			lp=sociodao.ListarSocios();
			for(Socios elemento:lp){
			System.out.println("Nombre: "+elemento.getDniSocios()+"\n");
			}
		}
		catch(BussinessException ex){
			throw new RuntimeException(ex);
		}
	}
	*/
		
		/*prueba de insercion de un nuevo socio y no socio --OK--
		IPersonaDAO personaDAO=new PersonasDaoImplHibernet();
	    ISociosDAO sociodao=new SociosDaoImplHibernate();
		INoSocioDAO Nosociodao=new NoSocioDaoImplHibernate();
	    ICategoriaDAO categoriadao=new CategoriaDaoImplHibernate();
	 	Categoria unacategoria=new Categoria();
		Date fechaingreso= new Date(110,4,1);
		Date fechanacimiento =new Date(45,11,1);
		
		 * tener en cuenta que en el manejo de date no permite ingresar years 1999 sino 99 
		 * y a partir del 2000 seria 112
		 * ejemplo fechanacimiento =new Date(112,11,1);->seria 1 de diciembre 2012
		 
		Date fechanacimineto2=new Date(55,0,25);
		Personas Psocio=new Personas(23958641,"Ignacio","Altamirano","0343-155024126","Selva de montiel 1213",fechanacimiento);
		Personas Pnosocio=new Personas(44526987,"Patricia","Zapienza","0343-4372566","Villaguay 125",fechanacimineto2);
		//agrego el socio
		try{
		unacategoria=categoriadao.BuscarUno(2);
		Socios nuevo=new Socios(unacategoria,Psocio,1018,"Masculino","activo","Argentina","Casado",fechaingreso,true);
		personaDAO.Insertar(Psocio);//->inserto primero la entidad persona el socio
		sociodao.Insertar(nuevo); //->inserto en socio
		}
		catch(Exception ex){
			throw ex;
		}
		//agrego el nosocio
		try{
			Nosocio pnuevonosocio=new Nosocio(Pnosocio,true);
			personaDAO.Insertar(Pnosocio);//->inserto en la entidad persona el no socio
			Nosociodao.Insertar(pnuevonosocio); //->inserto el no socio
			
		}
		catch(BussinessException ex){
			throw ex;
		}
		*/
		//---prueba del gestorsocio--
		//no Socio
		//Insercion OK!
		//Actualizacion OK!
		
		
		Date fechanacimineto2=new Date(91,6,3);
		Date fechadeingreso=new Date(111,8,4);
		ICajaDAO Nosociodao=new CajaDaoImplHibernate();
		//Nosocio entity=new Nosocio(35709368,"Cristian Emanuel Ceferino","Lacuadra","154640914","Cuyas y San perez 1664", fechanacimineto2,true);
		//Nosociodao.GuardarActualizar(entity);
		List<Caja> lp = new ArrayList<Caja>();
		try{
			lp=Nosociodao.ListaTotalEgresos();
			for(Caja elemento:lp){
			System.out.println("Nombre: "+elemento.getDescripcion()+"\n");
			}
		}
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
		//socio
		//insercion OK
		//Actualizacion OK
		// listar OK
		//listaractiva-> habilitado=true ok
		//busqueda de uno OK
		ICategoriaDAO categoriadao= new CategoriaDaoImplHibernate();
		ISociosDAO sociodao=new SociosDaoImplHibernate();
		Categoria categoria=new Categoria();
		categoria=categoriadao.BuscarUno(1);
		Sociosa entity2=new Sociosa();
		entity2=sociodao.BuscarUno(3254987);
		sociodao.GuardarActualizar(entity2);
		List<Sociosa> lpa = new ArrayList<Sociosa>();
		lpa=sociodao.ListaActivaSocios();
		for(Sociosa elemento:lpa){
		System.out.println("Nombre: "+elemento.getNombre()+"\n");
		}
		
		
		//caja
		//insercion OK
		//actualizacion
		Date fechacaja=new Date(106,8,1);
		ICajaDAO cajadao=new CajaDaoImplHibernate();
		Caja caja=new Caja(fechacaja,"pago de la cuota socio n 12",170,1500,true);
		cajadao.GuardarActualizar(caja);
		
	
		//Alquiler
		//insercion OK
		//actualizacion
		IAlquilerDAO alquilerdao=new  AlquilerDaoImplHibernate();
		IinmueblesDAO inmuebledao=new InmueblesDaoImplHibernate();
		FechaHora T=new FechaHora();
		Date fechaal=new Date(117,3,1);
		Time horaal=new Time(11,12,00);
		Alquiler alquiler=new Alquiler(inmuebledao.BuscarUno(1),T.FechaSistema(),T.HoraSistema(),fechaal,horaal,1900,true);
		alquilerdao.GuardarActualizar(alquiler);
		
		//cuota
		//insercion
		ICuotaDAO cuotadao=new CuotaDaoImplHibernate();
		Cuota cuota=new Cuota(sociodao.BuscarUno(32789654),fechaal,450,"moroso");
		cuotadao.GuardarActualizar(cuota);

	}

}
