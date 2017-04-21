/**
 * 
 */
package mainProject;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ar.com.ProyectoClub.AVista.Inicio;
import ar.com.ProyectoClub.AVista.PantallaNuevoSocio;
import ar.com.ProyectoClub.AVista.PantallaPersona;
import ar.com.ProyectoClub.AVista.Principal;
import ar.com.ProyectoClub.AVista.Vistas;
import ar.com.ProyectoClub.BControlador.Controlador;
import ar.com.ProyectoClub.CModelo.Modelo;

/**
 *@author Lacuadra Gieco
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //se crean los objetos MODELO Y VISTAS
		Modelo modelo = new Modelo(); 
		Vistas vista=new Vistas();     
		
       //Para colocar un skin propio de java
       try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista.getFrminicio());
            SwingUtilities.updateComponentTreeUI(vista.getFrmrprincipal());
            //SwingUtilities.updateComponentTreeUI(vista.getFrmpantallasocio());
            //SwingUtilities.updateComponentTreeUI(vista.getFrmrprincipal());
            new Controlador(vista,modelo).go(); //vistasocio,vistapersona).go();
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
    }

	}


