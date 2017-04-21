package pruebas;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCategorias;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceSocio;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCategoria;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceCuota;
import ar.com.ProyectoClub.CModelo.AServicios.facade.ServiceSocios;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.DPersistencia.AHibernet.HibernateUtil;
import ar.com.ProyectoClub.CModelo.DPersistencia.BDao.BussinessException;

public class PruebaServiciosJUnit{
	IServiceCuota Cuotaservice;
	//@Before
	public void AntesQue(){
		
		Cuotaservice=new ServiceCuota();
	}
	
	//@Test 
	void PruebaenCuotas() {
		Cuota nuevo=new Cuota();		
		nuevo=Cuotaservice.Busqueda(1);
		nuevo.setDescripcion("HOLA MUNDO");
		//assertTrue(Cuotaservice.InsertOrUpdateCuota(nuevo));
	}
	
	
	
	//@Test
	public void pruebafecha(){
		//(FechaHora.DameFechaActual().getDate());
	}

	
	
	
    /*
	@Test
	public void InsercionSocio() {
		Date fechaingreso=new Date(111,03,07);
		Date fechanacimiento=new Date(91,05,18);
		//List<Sociosa> _list=new ArrayList<Sociosa>();
		_s=new Sociosa(_sercat.BuscarCategoria(1),30159357,"Florencia","Rojas","4387545","Laralde 121",fechanacimiento,1012,"Femenino","Activo","Argentina","Soltera",fechaingreso,true);
		//_list.add(_s);
		//Sociosa _d=_s=new Sociosa(_sercat.BuscarCategoria(2),36598745,"Bautista","Pereira","4359874","Galan 2140",fechanacimiento,1011,"Masculino","Activo","Argentina","Soltero",fechaingreso,true);
		//_list.add(_d);
		//Sociosa _t=new Sociosa(_sercat.BuscarCategoria(2),33595742,"Omar","Barovero","15487852","Gral Galan 112",fechanacimiento,1014,"Masculino","Activo","Argentina","Casado",fechaingreso,true);
		//_list.add(_t);
		//Sociosa _y=_s=new Sociosa(_sercat.BuscarCategoria(3),27598741,"Rosa","Caciague","4895263","Av Ejercito 200",fechanacimiento,1010,"Femenino","Activo","Argentina","Divorciada",fechaingreso,true);
		//_list.add(_y);
		try{
			//for(Sociosa R : _list){
				if(!_ser.validar(_s.getDni())){
					assertTrue(_ser.NuevoSocio(_s));
				}
				else{
					System.out.println("el socio esta moroso");
				}
			//}
		}
		catch(BussinessException ex){
			ex.printStackTrace();
			System.out.println("Error,no se puede insertar los datos"+ex.getMessage());
		}
		finally{
			Cerrar_conexion();
		}
	}
	
	@Test
	public void ActualizacionSocios(){
		Sociosa nuevo=new Sociosa();
		try{
			nuevo=_ser.UnSocio(6);
			nuevo.setNombre("Romina Fabiana");
			nuevo.setDni(25987456);
			nuevo.setDomicilio("Pelegrini 260");
			nuevo.setCategoria(_sercat.BuscarCategoria(1));
			assertTrue(_ser.ActulizarSocio(nuevo));
			System.out.println("Exito");
			
		}
		catch(BussinessException ex){
			ex.printStackTrace();
			System.out.println("Error,no se puede Actualizar los datos"+ex.getMessage());
		}
		finally{
			Cerrar_conexion();
		}
	}
	//@Test
	//public void 
	
	public void Cerrar_conexion(){
		HibernateUtil.closeSessionFactory();
	}
*/
}
