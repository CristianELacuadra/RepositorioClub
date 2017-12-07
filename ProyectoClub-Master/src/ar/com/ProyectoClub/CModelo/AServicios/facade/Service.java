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
import ar.com.ProyectoClub.CModelo.CEntidades.Conceptos;
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

	//Contrato Caja
	/**
	 * Se propaga la excepcion para que la capa de presentacion la muestre al usuario
	 */
	@Override
	public Caja CrearInstanciaCaja(){
		try {
			return gestor.CrearCaja();
		}
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.CONFIG, null, e);
			throw new RuntimeException("Error: ",e.getCause());
		}
	}

	@Override
	public Conceptos CrearInstanciaConcepto() {
		try {
			return gestor.CrearInstanciaConcepto();
		}
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.CONFIG, null, e);
			throw new RuntimeException("Error: ",e.getCause());
		}
	}

	@Override
	public Conceptos BuscarConcepto(Integer id) {
		try {
			return gestor.BuscarConcepto(id);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.INFO, "Mensaje Critico", e);
			throw new RuntimeException("Error: ",e.getCause());
		}
	}

	@Override
	public long ObtenerRegistrosDeCaja() {
		try {
			return gestor.ObtenerTotalRegistradosCaja();
		} catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.INFO, "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error: "+e.getBussinessMessages());
		}
	}

	@Override
	public void GuardarRegistroCaja(Caja registro) {
		try {
			gestor.GuardarRegistroCaja(registro);
		} 
		catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error: "+e.getBussinessMessages());
		}
	}

	@Override
	public Caja UltimoRegistroCaja() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caja> ObtenerCajasPorParamatros(Date FechaDesde, Date FechaHasta, String Descripcion, boolean Ingreso,
			boolean Egreso) {
		try {
			return gestor.ObtenerRegistroCajasPorParametros(FechaDesde, FechaHasta, Descripcion, Ingreso, Egreso);
		} 
		catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.INFO, "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error "+e.getBussinessMessages());
		}
	}

	@Override
	public List<Conceptos> ObtenerConceptos() {
		try {
			return gestor.ObtenerConceptos();
		} 
		catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.INFO, "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error: "+e.getBussinessMessages());
		}
	}
	
	//Contrato usuario
	@Override
	public Usuario CrearUsuario() {
		try{
			return gestor.CrearUsuario();
		}
		catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.CONFIG , "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error: "+e.getBussinessMessages());
		}
	}
	
	@Override
	public Usuario ValidarUsuario(String nombreUsuario, String PassUsuario) {
		try{
			return gestor.VerificarUsuario(nombreUsuario, PassUsuario);
		}
		catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.INFO, "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error: "+e.getBussinessMessages());
		}
	}
	@Override
	public Usuario ObtenerUsuarioPorNombre(String nombreUsuario) {
		return ObtenerUsuarioPorNombre(nombreUsuario);
	}
	
    //Contrato Perosna
	@Override
	public List<Personas> ObtenerPersonaNomApe(String nom, String ape) {
		try {
			return gestor.FiltrarPersonasNombeApellido(nom, ape);
		} catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.INFO, "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error: "+e.getBussinessMessages());
		}
	}
	@Override
	public void HabilitarPersona(int dni) {
		try {
			gestor.habilitarPersona(dni);
		} catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.INFO, "Mensaje Critico", e.getCause());
			throw new RuntimeException("Error: "+e.getBussinessMessages());
		}
		
	}
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
		try {
			return	gestor.ObtenerCuotasDelSocio(dni);
		} catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.INFO , "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error: "+e.getBussinessMessages());
		}
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
	public void habilitarInhabilitarCategoria(int id) {
		try {
			gestor.HabiliInhabiCategoria(id);
		} catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e.getLocalizedMessage());
			throw new RuntimeException("Error :"+ e.getBussinessMessages());
		}
		
	}
	
	@Override
	public void GuardarCategoria(Categoria categoria) {
		try {
			gestor.GuardarCaegoria(categoria);
		} 
		catch (BussinessException e) {
			//loggeo el error mostrando la localizacion y su causa
			Logger.getLogger(Service.class.getName()).log(Level.INFO, "Mensaje Critico",e.getBussinessMessages()+" Cause : "+e.getCause());
			//propago hacia el cliente el mensaje de error 
			throw new RuntimeException("Error "+e.getBussinessMessages());
		}

	}
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

	@Override
	public List<Socios> ControlCuotaSocio() {
		try{
			//Genero las cuotas
			gestor.GenerarCuotas();
			return null;
		}
		catch (Exception e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE,"Mensaje Critico", e);
			throw new RuntimeException("ERROR: ",e.getCause());
		}
	}

	

	

	

	

	
	
	@Override
	public void GuardarAlquiler(Alquiler alqui) {
		try {
			gestor.GuardarAlquiler(alqui);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al Guardar el socio",e.getCause());
		}
	}
		
		
	

	@Override
	public List<Alquiler> ListarAlquileres() {
		
	try {
			return gestor.listarAlquileres();
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al Listar Alquileres",e.getCause());
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Alquiler> ListarAlquileresRealizados(Inmuebles inm, Date a) {
		try {
			
		java.util.List<Alquiler> listaH =new ArrayList<Alquiler>();
			java.util.List<Alquiler> lista =new ArrayList<Alquiler>();
			lista=gestor.listarAlquileres();
			if(!lista.isEmpty()){
				int num=lista.size();
				for(int i=0;i<num;i++){
					if((lista.get(i).getInmuebles().getIdInmubles().equals(inm.getIdInmubles()))&&
							(0==(lista.get(i).getFechareserva().compareTo(a)))){
					//compara el id inmueble que pase con el de la lista para ver si es el mismo.
						//compara la fecha de reserva con la que se pasa por sistema. para determinar 
						//la funcion tiene como ob obtener todos los alquileres con el mismo inmueble y fecha de reserva. en un listado.
					
						listaH.add(lista.get(i));
					}
				}
			
			}
			return listaH;
			/*
			
			java.util.List<Inmuebles> listaH =new ArrayList<Inmuebles>();
			java.util.List<Inmuebles> lista =new ArrayList<Inmuebles>();
			lista=gestor.ObtenerInmuebles();
			int num=lista.size();
			for(int i=0;i<num;i++){
				if(lista.get(i).getNombre().indexOf(text)!=-1){
					listaH.add(lista.get(i));			
				}
			}
			return listaH;*/
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error al Listar Alquileres",e.getCause());
		}
	}

	@Override
	public Alquiler buscarAlquiler(Integer numAlquiler) {
	try {
			
			return gestor.buscarAlquiler(numAlquiler);
		} 
		catch (BussinessException e) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, "Mensaje Critico", e);
			throw new RuntimeException("Error en la Busqueda",e.getCause());
		}
		
	}

	
	
	
	

	

	

	

	

	

	

	


}
