package ar.com.ProyectoClub.CModelo.AServicios.facade;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IServiceInmuebles;
import ar.com.ProyectoClub.CModelo.BGestores.GestorInmueble;
import ar.com.ProyectoClub.CModelo.BIGestores.IGestorInmueble;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.IinmueblesDAO;
import ar.com.ProyectoClub.CModelo.DPersistencia.CIDao.Impl.Hibernet.InmueblesDaoImplHibernate;

public class ServiceInmueble implements IServiceInmuebles {

	private IGestorInmueble gestorInmueble;

	public ServiceInmueble() {
		try{
			gestorInmueble=new GestorInmueble();
			}
			catch (Exception e) {
			    throw new RuntimeException("No se pudo iniciar el servicio debido al siguiente error:"+e.getMessage());
			}				
	}
	
	@Override
	public Inmuebles BusquedaInmueble(Integer id) {
		try {
			return gestorInmueble.Busqueda(id);
		}catch(Exception e){
			throw new RuntimeException("No se pudo realizar la busqueda debido al siguiente error "+ e.toString());
		}	
		
		
	}
	
	public Integer UltimoIdInmueble() {
		return gestorInmueble.ObtenerSiguienteIdInmueble();
	}
	@Override
	public Inmuebles CrearInmueble(){
		try{
			return (gestorInmueble.Crear());
		}catch(Exception e){
			throw new RuntimeException("No se pudo instanciar el servicio debido al siguiente error: "+e.getMessage());
		}
	}
	
	public void GuardarInmueble(Inmuebles entity){
		try {
			
			//Inmuebles =gestorInmueble.Crear();
			//inm=entity;
			gestorInmueble.Guardar(entity);
		} catch (Exception e) {
			throw new RuntimeException("No se pudo instanciar el servicio debido al siguiente error: "+e.getMessage());
			//e.printStackTrace();
		}
	}
	
	public List<Inmuebles> ListarInmueble(){
		try {
			return gestorInmueble.Listar();
		} catch (Exception e) {
			throw new RuntimeException("No se pudo instanciar el servicio debido error: ");
			//JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		
		}
	}
	public List<Inmuebles> ListarInmuebleHabilitado(){
		try {
			java.util.List<Inmuebles> listaH =new ArrayList<Inmuebles>();
			java.util.List<Inmuebles> lista =new ArrayList<Inmuebles>();
			lista=gestorInmueble.Listar();
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
	public List<Inmuebles> ListarInmuebleFiltrado(String text){
		try {
			java.util.List<Inmuebles> listaH =new ArrayList<Inmuebles>();
			java.util.List<Inmuebles> lista =new ArrayList<Inmuebles>();
			lista=gestorInmueble.Listar();
			int num=lista.size();
			for(int i=0;i<num;i++){
				if(lista.get(i).getNombre().indexOf(text)!=-1){
					listaH.add(lista.get(i));			
				}
			}
			return listaH;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("No se pudo instanciar el servicio debido a un error: ");
		}
	}
	
	
	
	
	
	
	
	

}
