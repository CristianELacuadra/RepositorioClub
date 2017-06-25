package ar.com.ProyectoClub.BControlador;

import ar.com.ProyectoClub.AVista.*;
import ar.com.ProyectoClub.CModelo.Logica;
/*
 * Esta clase contiene el método main que ejecuta la aplicación, 
 * el método hace un llamado al método iniciar el cual crea las 
 * instancias de las clases ventanas y la clase Logica  
 * estableciendo las relaciones con la clase Coordinador.
 */
public class ControlllerPrincipal {
    //Modelo
	Logica miLogica;
	//Vistas
	Principal miVentanaPrincipal;
	Inicio miVentanaInicio;
	PantallaPersonas miVentanaPersona;
	PantallaFormularioPersona miFormularioPersona;
	PantallaBusquedaSNS miVentanaEliminar;
	
	//clase puente entre el modelo y las vistas.
	ControllerCoordinador miCoordinador;
	
	public static void main(String[] args) {
		ControlllerPrincipal miPrincipal=new ControlllerPrincipal();
		miPrincipal.Iniciar();
	}
	
	private void Iniciar(){
		/*Se instancian las clases*/
		miLogica=new Logica();
		miVentanaInicio=new Inicio();
		miVentanaPrincipal=new Principal();
		miVentanaPersona=new PantallaPersonas(miVentanaPrincipal,true); //mi ventana persona depende de ventana principal
		miFormularioPersona=new PantallaFormularioPersona(miVentanaPersona,true); // mi ventana formulario persona depende de pantalla persona
		miVentanaEliminar=new PantallaBusquedaSNS(miVentanaPersona,true);
		miCoordinador= new ControllerCoordinador();
		
		/*Se establecen las relaciones entre clases*/
		miLogica.setCoordinador(miCoordinador);
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miVentanaInicio.setCoordinador(miCoordinador);
		miVentanaPersona.setCoordinador(miCoordinador);
		miFormularioPersona.setCoordinador(miCoordinador);
		miVentanaEliminar.setCoordinador(miCoordinador);
		
		/*Se establecen relaciones con la clase coordinador*/
		miCoordinador.setMiLogica(miLogica);
		miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setMiVentanaInicio(miVentanaInicio);
		miCoordinador.setMiVentanaPersona(miVentanaPersona);
		miCoordinador.setMiFormularioPersona(miFormularioPersona);
		miCoordinador.setMiVentanaElimarSNS(miVentanaEliminar);
		
		miVentanaInicio.setVisible(true);
	}

}
