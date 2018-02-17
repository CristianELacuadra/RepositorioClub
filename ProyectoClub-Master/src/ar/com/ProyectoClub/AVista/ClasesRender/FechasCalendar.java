package ar.com.ProyectoClub.AVista.ClasesRender;

import java.awt.Color;
import java.awt.List;
import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.*;

import com.mysql.fabric.xmlrpc.base.Struct;
import com.toedter.calendar.IDateEvaluator;


public class FechasCalendar implements IDateEvaluator{
	private ControllerCoordinador miCoordinador;
	private Color darkGreen = new Color(0x007F00);
	private Color lightGreen = new Color(0xbbebc8);
	private Calendar calendar = Calendar.getInstance();
	private int i = 0;
	private Integer ban;
	private java.util.List<Alquiler> aux= new ArrayList<Alquiler>();
	private String nombreInmueble=null;
	
	public FechasCalendar(Integer bandera) {
		miCoordinador= new ControllerCoordinador();
		ban=bandera;
	}
	public FechasCalendar(){
		miCoordinador= new ControllerCoordinador();
	}
	
	
	public void setListDeFechasCalendar(java.util.List<Alquiler> lis){
		if(lis!=null)
			aux=lis;
	}
	public java.util.List<Alquiler> getListDeFechasCalendar(){
		return aux;
	}
	public String getNombreInmueble(){
		
		return nombreInmueble;
	}
	public void setNombreInmueble(String nombre){
		nombreInmueble=nombre;
	}
	public void nullNombreInmuble(){
		nombreInmueble=null;
	}
	
	@Override
	public boolean isSpecial(Date date) {
		try {
			calendar.setTime(date);
//		if((ban==null)||(ban==0))
			// anda por cada dia
			// sacar la llamada de funcion afuera de la funcion isSpecial
			
			for(i=0;i<aux.size();i++){	
//			Calendar auxCalendar= Calendar.getInstance();
				Calendar auxCalendar= new GregorianCalendar();//PROBANDO	
				auxCalendar.setTime(aux.get(i).getFechareserva());
				
				if((calendar.get(Calendar.MONTH)==auxCalendar.get(Calendar.MONTH))//puede generar error
						&&(calendar.get(Calendar.YEAR)==auxCalendar.get(Calendar.YEAR))
						&&(calendar.get(Calendar.DAY_OF_MONTH)==auxCalendar.get(Calendar.DAY_OF_MONTH)))
				{
					if((nombreInmueble==null)||(nombreInmueble.equals(aux.get(i).getInmuebles().getNombre())))
						return true;//if para determinar si el inmueble 
					//esta elegido y pintar en el calendario
				}
			}
			return false;
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Ocurrió un error de tipo: " + e.getMessage(), "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	
	}

	@Override
	public Color getSpecialForegroundColor() {
		
		return Color.BLUE;
	}
	@Override
	public Color getSpecialBackroundColor() {
	
		return Color.RED;
	}
	@Override
	public String getSpecialTooltip() {
		
		return "Hay Alquileres";
	}


	
	
	
	
	@Override
	public Color getInvalidBackroundColor() {
		return null;
	}

	@Override
	public Color getInvalidForegroundColor() {
		return null;
	}

	@Override
	public String getInvalidTooltip() {
		return null;
	}



	@Override
	public boolean isInvalid(Date arg0) {
		return false;
	}



}
