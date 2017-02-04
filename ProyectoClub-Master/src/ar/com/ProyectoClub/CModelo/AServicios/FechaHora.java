package ar.com.ProyectoClub.CModelo.AServicios;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FechaHora {
	
	public static boolean ValidarFecha (){
		Calendar fechaactual=Calendar.getInstance();
		if((fechaactual.get(Calendar.DATE) >= 13) && (fechaactual.get(Calendar.DATE) < 16))
			return true;
		else
			return false;
	}
	
	
	@SuppressWarnings("deprecation")
	public static Date DameFechaActual(){
		
		//Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar().getInstance();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR)-1900;
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        Date fecha2=new Date(año,mes,dia);
        return fecha2;
	}
	
	public static int Convertidoranio(int mes,int anio) {
		int i;
		if(mes==0|| mes==-1 || mes==-2)
			i=--anio;
		else
			i=anio;
		return i;
	}
	
	public static int ConvertidorMes(int mes) {
		int i;
		switch (mes) {
		case 0:
			i=12;
			break;
		case -1:
			i=11;
			break;
		case -2:
		    i=10;
		    break;
		default:
			i=mes;
			break;
		} 
		return i;
	}
	
}
