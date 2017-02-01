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
        //Obtenemos el valor del a�o, mes, d�a,
        //hora, minuto y segundo del sistema
        //usando el m�todo get y el par�metro correspondiente
        int a�o = fecha.get(Calendar.YEAR)-1900;
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        Date fecha2=new Date(a�o,mes,dia);
        return fecha2;
	}

}
