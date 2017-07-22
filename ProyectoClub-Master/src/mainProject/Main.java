/**
 * 
 */
package mainProject;

import java.util.Date;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ar.com.ProyectoClub.AVista.Inicio;
import ar.com.ProyectoClub.AVista.Principal;
import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;

/**
 *@author Lacuadra Gieco
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date fechas=new Date();
		fechas.setMonth(11);
		fechas.setYear(112);
		Date fecha2=new Date();
		fecha2.setMonth(12+3);
		fecha2.setYear(FechaHora.Convertidoranio((12+3),2012));
    }

	}


