package ar.com.ProyectoClub.CModelo.AServicios.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IService;
import ar.com.ProyectoClub.CModelo.BNegocio.Gestor;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.CEntidades.Socios;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;
import ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate.BussinessException;

public class Service implements IService {
	private  Gestor gestor;

	public Service() {
		try {
			gestor= new Gestor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Se propaga la excepcion para que la capa de presentacion la muestre al usuario
	 */
	@Override
	public Caja CrearInstanciaCaja(){
		try {
			return gestor.CrearCaja();
		}
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, e);
			throw new RuntimeException("Error al crear la instancia",e.getCause());
		}
	}

	
	@Override
	public List<Caja> ObtenerRegistrosDeCaja() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void GuardarRegistroCaja(Caja registro) {
		// TODO Auto-generated method stub

	}

	@Override
	public Caja UltimoRegistroCaja() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caja> ObtenerCajasPorParamatros(Date FechaDesde, Date FechaHasta, String Descripcion, boolean Ingreso,
			boolean Egreso) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	//Contrato usuario
	@Override
	public Usuario CrearUsuario() {
		try{
			return gestor.CrearUsuario();
		}
		catch (Exception e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
	
	@Override
	public Usuario ValidarUsuario(String nombreUsuario, String PassUsuario) {
		try{
			return gestor.VerificarUsuario(nombreUsuario, PassUsuario);
		}
		catch (Exception ex) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex.getCause());
			throw new RuntimeException(ex.getMessage());
		}
	}
	@Override
	public Usuario ObtenerUsuarioPorNombre(String nombreUsuario) {
		return ObtenerUsuarioPorNombre(nombreUsuario);
	}
	
    //Contrato Perosna
	/**
	 * ValidarPersona valida si el dni ingredo se encuentra registrado en la
	 * base de datos, si esta lo devuelta si no null
	 * @throws
	 */
	@Override
	public void GuardarPersona(Personas personas) {
		try {
			gestor.GuardarPersona(personas);
		} 
		catch (Exception e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al insertar el dato: "+e.getMessage());
		}
		
	}
	@Override
	public Personas ValidarPersona(int dni) {
		try {
			return gestor.ValidarPersona(dni);
		} 
		catch (BussinessException e) {
			
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al buscar el dato:",e.getCause());
		}
		
	}
	@Override
	public void GuardarNoSocio(Personas persona) {
		try {
			gestor.GuardarPersona(persona);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al buscar el dato:",e.getCause());
		}
		
	}
	@Override
	public Personas CrearInstanciaPersona() {
		try {
			return gestor.CrearPersona();
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al crear la instancia",e.getCause());
		}
	}
	@Override
	public Personas BuscarPersona(Integer dni) {
		try {
			return gestor.BuscarPersona(dni);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al buscar el dato:",e.getCause());
		}
	}
	@Override
	public List<Personas> ListarPersonas() {
		try {
			return gestor.ObtenerPersonas();
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al buscar el dato:",e.getCause());
		}
	}
	//Gestion Socio
	@Override
	public List<Cuota> ObtenerCuotasSocio(Integer dni) {
		return	gestor.ObtenerCuotasDelSocio(dni);
	}

	
	@Override
	public List<Socios> ListarSocios() {
		try {
			return gestor.ListarSocio();
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e.getMessage());
			throw new RuntimeException("Error al buscar el dato:",e.getCause());
		}
		
	}
	
	@Override
	public void InhabilitarPersona(Integer dni) {
		try {
			gestor.InhabilitarPersona(dni);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e.getMessage());
			throw new RuntimeException("Error :",e.getCause());
		}
		
	}
	
	@Override
	public Socios CrearInstanciaSocio() {
		try {
			return gestor.CrearSocio();
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al Guardar el socio",e.getCause());
		}
	}
	@Override
	public void GuardarSocio(Socios socio) {
		try {
			gestor.GuardarSocio(socio);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al Guardar el socio",e.getCause());
		}
	}
	
	@Override
	public Socios BuscarSocio(Integer dni) {
		try {
			return gestor.ObtenerSocio(dni);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Se produjo el siguiente error: ",e.getCause());
		}
	}
    //contrato Categoria
	@Override
	public Categoria CrearInstanciaCategoria() {
		try {
			return gestor.CrearRegistroCategoria();
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("ERROR: ",e.getCause());
		}
	}

	@Override
	public Categoria BuscarCategoria(Integer IdCategoria) {
		try {
			return gestor.BuscarCategoria(IdCategoria);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("ERROR: ",e.getCause());
		}
	}

	@Override
	public List<Categoria> DevolverListaCategoria() {
		try {
			return gestor.ObtenerCategorias();
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE,"Mensaje Critico", e);
			throw new RuntimeException("ERROR: ",e.getCause());
		}
		
	}


	//contrato inmueble
	@Override
	public void GuardarInmueble(Inmuebles entity) {
		try {
			gestor.GuardarInmueble(entity);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al Guardar el socio",e.getCause());
		}
	}
	
	@Override
	public Inmuebles BuscarInmueble(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Inmuebles CrearInstanciaInmueble() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inmuebles> ListarInmuebleHabilitado() {
		try {
			java.util.List<Inmuebles> listaH =new ArrayList<Inmuebles>();
			java.util.List<Inmuebles> lista =new ArrayList<Inmuebles>();
			lista=gestor.ObtenerInmuebles();
			int num=lista.size();
			for(int i=0;i<num;i++){
				if((lista.get(i).isHabilitado())==true){
					listaH.add(lista.get(i));
				}
				
			}
			return listaH;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("No se pudo instanciar el servicio debido a un error: ");
		}
	}

	@Override
	public List<Inmuebles> ListarInmueble() {
		try {
			return gestor.ObtenerInmuebles();
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE,"Mensaje Critico", e);
			throw new RuntimeException("ERROR: ",e.getCause());
		}
	}

	@Override
	public List<Inmuebles> ListarInmuebleFiltrado(String text) {
		try {
			java.util.List<Inmuebles> listaH =new ArrayList<Inmuebles>();
			java.util.List<Inmuebles> lista =new ArrayList<Inmuebles>();
			lista=gestor.ObtenerInmuebles();
			int num=lista.size();
			for(int i=0;i<num;i++){
				if(lista.get(i).getNombre().indexOf(text)!=-1){
					listaH.add(lista.get(i));			
				}
			}
			return listaH;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("No se pudo instanciar el servicio debido a un error: "+e.getMessage());
		}
	}

	@Override
	public List<Inmuebles> ListarInmueblesParaAlquiler() {
		return gestor.ListarInmuebleHabilitado();
	}
    //contrato alquiler
	@Override
	public Alquiler CrearInstanciaAlquiler() {
		try {
			return gestor.CrearAlquiler();
		} 
		catch (BussinessException e) {
			throw new RuntimeException("No se pudo instanciar el servicio debido a un error: "+e.getMessage());
		}
	}

	//cuotas
	@Override
	public List<Cuota> ObtenerCuotasPorid(List<Integer> id) {
		try{
			return (gestor.ObtenerCuotasPorid(id));
		}
		catch (Exception e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE,"Mensaje Critico", e);
			throw new RuntimeException("ERROR: ",e.getCause());
		}
	}

	@Override
	public void RegistrarPagoCuotaSocio(List<Cuota> cuotas) {
		try{
			for(Cuota cuota : cuotas)
				gestor.GuardarCuota(cuota);
		}
		catch (Exception e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE,"Mensaje Critico", e);
			throw new RuntimeException("ERROR: ",e.getCause());
		}

	}

	

	

	

	

	

	

	


}
