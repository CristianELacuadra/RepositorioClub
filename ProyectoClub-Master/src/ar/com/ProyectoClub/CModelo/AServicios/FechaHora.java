package ar.com.ProyectoClub.CModelo.AServicios;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FechaHora {
	GregorianCalendar c;
	Date fechaactual;
	Time hora;
	
	public FechaHora() {
		c=new GregorianCalendar();
		fechaactual=new Date();
	}
	

	@SuppressWarnings("deprecation")
	public Date FechaSistema (){
		int anio=c.get(Calendar.YEAR)-1900;
		fechaactual.setYear(anio);
		fechaactual.setMonth(c.get(Calendar.MONTH));
		fechaactual.setDate(c.get(Calendar.DAY_OF_MONTH));
		return fechaactual;
	}
	
	@SuppressWarnings("deprecation")
	public Time HoraSistema(){
		Time hora=new Time(c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),c.get(Calendar.SECOND));
		return hora;
	}

}
