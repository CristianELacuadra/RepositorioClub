package ar.com.ProyectoClub.CModelo.BNegocio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FechaHora {
	static int[] diasMes= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static boolean ValidarFecha (){
		Calendar fechaactual=Calendar.getInstance();
		if((fechaactual.get(Calendar.DATE) >= 13) && (fechaactual.get(Calendar.DATE) < 16))
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param aaaa, año a comprobar
	 * @param mm , mes a comprobar
	 * @param dd , dia a comprobar
	 * @return true si la fecha es correcta,false si la fecha es incorrecta
	 * @throws IllegalArgumentException si el año es menor que 1900.
	 */
	public static boolean ValidarFechaEntrada(Integer aaaa,Integer mm,Integer dd) {
			if(aaaa<1900) 
				throw new IllegalArgumentException("Solo se comprueban fechas del año 1900 o posterior");			
			if(mm<1 || mm>12)
				return false;
			if ( mm==2 && aaaa%4==0 )
		        return dd>=1 && dd<=29;
		    return dd>=0 && dd<=diasMes[mm-1];
	}
	
	@SuppressWarnings("deprecation")
	public static Date FechaActual(){
		
		//Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar().getInstance();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR)-1900;
        int mes = fecha.get(Calendar.MONTH);
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
	public static Calendar HoraActual() {

		Calendar _calendar= new GregorianCalendar();
		return _calendar;
	}
	
	/**
	 * suma o resta la fecha deacuero al parametro(dias menos a 0 resta,dias mayor a 0 suma)
	 * @param fecha
	 * @param dias
	 * @return fecha modificada
	 */
	public static Date sumarRestarDiasFecha(Date fecha, int dias){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0

		return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

	}
	 /* suma o resta la fecha deacuero al parametro(dias menos a 0 resta,dias mayor a 0 suma)
	 * @param fecha
	 * @param dias
	 * @return fecha modificada
	 */
	public static Date sumarRestarMesFecha(Date fecha, int mes){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.MONTH , mes);  // numero de meses que sumamos o restamos 

		return calendar.getTime(); // Devuelve el objeto Date con el mes sumado 

	}
	
	/**
	 * Obtiene el mes de la fecha pasada como parametro
	 * @param date
	 * @return Entero mes
	 */
	public static int obtenerMes(Date date){
		if (null == date)
			return 0;

		else{
			String formato="MM";
			SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
			return Integer.parseInt(dateFormat.format(date));
		}

	}
	
/**
 * Obtiene el añio de la fecha pasada como parametros	
 * @param date
 * @return int anio
 */
	public static int obtenerAnio(Date date){
		if (null == date)
			return 0;
		else{
			String formato="yyyy";
			SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
			return Integer.parseInt(dateFormat.format(date));
		}
	}
	
	/**
	 * Obtinene la diferencia  de meses entre 2 fecha la cual se pasan como parametros.
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public static int DiferenciaMesFechas(Date fechaInicio,Date fechaFin){
		Calendar fechaI = GregorianCalendar.getInstance();
		Calendar fechaF = GregorianCalendar.getInstance();
		fechaI.setTime(fechaInicio);
		fechaF.setTime(fechaFin);
		int elapsed = -1; // Por defecto estaba en 0 y siempre asi no haya pasado un mes contaba 1)
		GregorianCalendar gc1, gc2;
		Date d1,d2;

		if (fechaF.after(fechaI)) {
		gc2 = (GregorianCalendar) fechaF.clone();
		gc1 = (GregorianCalendar) fechaI.clone();
		}
		else {
		gc2 = (GregorianCalendar) fechaI.clone();
		gc1 = (GregorianCalendar) fechaF.clone();
		} 

		while ( gc1.before(gc2) ) {
		gc1.add(Calendar.MONTH, 1);
		elapsed++; 
		}

		if (gc1.get(Calendar.DATE)==(gc2.get(Calendar.DATE))) elapsed++; // si es el mismo dia cuenta para la suma de meses 
		return elapsed;
	}

    public static boolean CompararFecha(Date FechaAComparar){
    	Date fechaActual= new Date();
    	int dd=fechaActual.getDate();
    	int mm=fechaActual.getMonth()+1;
    	int aaaa=fechaActual.getYear()+1900;
    	if(dd==FechaAComparar.getDate() && mm==FechaAComparar.getMonth()+1 && aaaa==fechaActual.getYear()+1900)
    		return true;
    	return false;
    }
}
