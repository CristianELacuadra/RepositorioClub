package ar.com.ProyectoClub.BControlador;

import javax.swing.JOptionPane;

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
	PantallaBusquedaSNS miVentanaBusquedaSNSElim;
	PantallaBusquedaSNS miVentanaBusquedaSNSCobr;
	PantallaDetallesInhabilitarSNS miVentanaDetalllesSNS;
	PantallaCobranzaCuota miVentanaCobranzaCuota;
	PantallaBajaSNS miventanaBajaSNS;

	//clase puente entre el modelo y las vistas.
	ControllerCoordinador miCoordinador;

	public static void main(String[] args) {
		ControlllerPrincipal miPrincipal=new ControlllerPrincipal();
		miPrincipal.Iniciar();
	}

	private void Iniciar(){
		try{
			/*Se instancian las clases*/
			miLogica=new Logica();
			miVentanaInicio=new Inicio();
			miVentanaPrincipal=new Principal();
			miVentanaPersona=new PantallaPersonas(miVentanaPrincipal,true); //mi ventana persona depende de ventana principal
			miFormularioPersona=new PantallaFormularioPersona(miVentanaPersona,true); // mi ventana formulario persona depende de pantalla persona
			miVentanaBusquedaSNSElim=new PantallaBusquedaSNS(miVentanaPersona,true);
			miVentanaBusquedaSNSCobr=new PantallaBusquedaSNS(miVentanaCobranzaCuota, true);
			miVentanaDetalllesSNS=new PantallaDetallesInhabilitarSNS(miVentanaBusquedaSNSCobr, true);
			miVentanaCobranzaCuota= new PantallaCobranzaCuota(miVentanaPersona,true);
			miCoordinador= new ControllerCoordinador();
			miventanaBajaSNS=new PantallaBajaSNS(miVentanaPersona, true);

			/*Se establecen las relaciones entre clases*/
			miLogica.setCoordinador(miCoordinador);
			miVentanaPrincipal.setCoordinador(miCoordinador);
			miVentanaInicio.setCoordinador(miCoordinador);
			miVentanaPersona.setCoordinador(miCoordinador);
			miFormularioPersona.setCoordinador(miCoordinador);
			miVentanaBusquedaSNSElim.setCoordinador(miCoordinador);
			miVentanaBusquedaSNSCobr.setCoordinador(miCoordinador); 
			miVentanaDetalllesSNS.setCoordinador(miCoordinador);
			miVentanaCobranzaCuota.setCoordinador(miCoordinador);
			miventanaBajaSNS.setCoordinador(miCoordinador);

			/*Se establecen relaciones con la clase coordinador*/
			miCoordinador.setMiLogica(miLogica);
			miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
			miCoordinador.setMiVentanaInicio(miVentanaInicio);
			miCoordinador.setMiVentanaPersona(miVentanaPersona);
			miCoordinador.setMiFormularioPersona(miFormularioPersona);
			miCoordinador.setMiVentanaBusquedaSNS(miVentanaBusquedaSNSCobr);
			miCoordinador.setMiVentanaBusquedaSNS(miVentanaBusquedaSNSElim);
			miCoordinador.setMiVentanaDetallesSNS(miVentanaDetalllesSNS);
			miCoordinador.setMiVentanaCobranza(miVentanaCobranzaCuota);
			miCoordinador.setMiVentanaBajaSNS(miventanaBajaSNS);
			miVentanaInicio.setVisible(true);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR" , e.getMessage(), JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}
}


