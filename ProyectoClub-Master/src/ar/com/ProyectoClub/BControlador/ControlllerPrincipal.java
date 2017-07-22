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
	PantallaSocios miVentanaSocios;
	PantallaFormularioPersona miFormularioPersona;
	PantallaBusquedaSNS miVentanaBusquedaSNSElim;
	PantallaBusquedaSNS miVentanaBusquedaSNSCobr;
	PantallaDetallesInhabilitarSNS miVentanaDetalllesSNS;
	PantallaCobranzaCuota miVentanaCobranzaCuota;
	PantallaBajaSNS miventanaBajaSNS;
	PantallaCategoriasTodas miVentanaCategorias;
	PantallaCaja miVentanaCaja;
	//
	PantallaAlquiler miVentanaAlquiler;
	PantallaNuevoAlquiler miVentanaNuevoAlquiler;
	PantallaNuevoInmueble miVentanaNuevoInmueble;
	PantallaBusquedaAlquiler miVentanaBusquedaAlquiler;
	PantallaBusquedaInmueble miVentanaBusquedaInmueble;
	PantallaNuevoInmueble miVentanaModificarInmueble;
	PantallaNuevoInmueble miVentanaEliminarInmueble;
	PantallaNuevoInmueble miVentanaRehabilitarInmueble;
	
	
	PantallaDetallesAlquiler miVentanaModificarAlquiler;
	PantallaDetallesAlquiler miVentanaEliminarAlquiler;
	PantallaDetallesAlquiler miVentanaPagarAlquiler;
	
	/*
	 miVentanaModificarAlquiler
	miVentanaEliminarAlquiler
	miVentanaPagarAlquiler
	 * */
	
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
			miVentanaSocios=new PantallaSocios(miVentanaPrincipal,true); //mi ventana persona depende de ventana principal
			miFormularioPersona=new PantallaFormularioPersona(miVentanaSocios,true); // mi ventana formulario persona depende de pantalla persona
			miVentanaBusquedaSNSElim=new PantallaBusquedaSNS(miVentanaSocios,true);
			miVentanaBusquedaSNSCobr=new PantallaBusquedaSNS(miVentanaCobranzaCuota, true);
			miVentanaDetalllesSNS=new PantallaDetallesInhabilitarSNS(miVentanaBusquedaSNSCobr, true);
			miVentanaCobranzaCuota= new PantallaCobranzaCuota(miVentanaSocios,true);
			miCoordinador= new ControllerCoordinador();
			miventanaBajaSNS=new PantallaBajaSNS(miVentanaSocios, true);
			miVentanaCategorias=new PantallaCategoriasTodas(miVentanaSocios, true);
			miVentanaCaja=new PantallaCaja();
			
			miVentanaAlquiler=new PantallaAlquiler (miVentanaPrincipal,true);
			miVentanaNuevoAlquiler=new PantallaNuevoAlquiler (miVentanaAlquiler,true);
			miVentanaNuevoInmueble=new PantallaNuevoInmueble (miVentanaAlquiler,true,0);
			miVentanaModificarInmueble=new PantallaNuevoInmueble (miVentanaBusquedaInmueble,true,1);//usan la misma vista
			miVentanaEliminarInmueble=new PantallaNuevoInmueble (miVentanaBusquedaInmueble,true,2);
			miVentanaRehabilitarInmueble=new PantallaNuevoInmueble (miVentanaBusquedaInmueble,true,3);
			miVentanaBusquedaAlquiler=new PantallaBusquedaAlquiler (miVentanaAlquiler,true);
			miVentanaBusquedaInmueble=new PantallaBusquedaInmueble (miVentanaAlquiler,true);
			
			miVentanaModificarAlquiler=new PantallaDetallesAlquiler(miVentanaBusquedaAlquiler,true,0);
			miVentanaEliminarAlquiler=new PantallaDetallesAlquiler(miVentanaBusquedaAlquiler,true,1);
			miVentanaPagarAlquiler=new PantallaDetallesAlquiler(miVentanaBusquedaAlquiler,true,2);
			
			
			
			/*Se establecen las relaciones entre clases*/
			miLogica.setCoordinador(miCoordinador);
			miVentanaPrincipal.setCoordinador(miCoordinador);
			miVentanaInicio.setCoordinador(miCoordinador);
			miVentanaSocios.setCoordinador(miCoordinador);
			miFormularioPersona.setCoordinador(miCoordinador);
			miVentanaBusquedaSNSElim.setCoordinador(miCoordinador);
			miVentanaBusquedaSNSCobr.setCoordinador(miCoordinador); 
			miVentanaDetalllesSNS.setCoordinador(miCoordinador);
			miVentanaCobranzaCuota.setCoordinador(miCoordinador);
			miventanaBajaSNS.setCoordinador(miCoordinador);
			miVentanaCategorias.setCoordinador(miCoordinador);
			miVentanaCaja.setCoordinador(miCoordinador);
			
			miVentanaAlquiler.setCoordinador(miCoordinador);
			miVentanaNuevoAlquiler.setCoordinador(miCoordinador);
			miVentanaNuevoInmueble.setCoordinador(miCoordinador);
			miVentanaBusquedaAlquiler.setCoordinador(miCoordinador);
			miVentanaBusquedaInmueble.setCoordinador(miCoordinador);
			miVentanaModificarInmueble.setCoordinador(miCoordinador);
			miVentanaEliminarInmueble.setCoordinador(miCoordinador);
			miVentanaRehabilitarInmueble.setCoordinador(miCoordinador);
			miVentanaModificarAlquiler.setCoordinador(miCoordinador);
			miVentanaEliminarAlquiler.setCoordinador(miCoordinador);
			miVentanaPagarAlquiler.setCoordinador(miCoordinador);

			/*Se establecen relaciones con la clase coordinador*/
			miCoordinador.setMiLogica(miLogica);
			miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
			miCoordinador.setMiVentanaInicio(miVentanaInicio);
			miCoordinador.setMiVentanaSocios(miVentanaSocios);
			miCoordinador.setMiFormularioPersona(miFormularioPersona);
			miCoordinador.setMiVentanaBusquedaSNS(miVentanaBusquedaSNSCobr);
			miCoordinador.setMiVentanaBusquedaSNS(miVentanaBusquedaSNSElim);
			miCoordinador.setMiVentanaDetallesSNS(miVentanaDetalllesSNS);
			miCoordinador.setMiVentanaCobranza(miVentanaCobranzaCuota);
			miCoordinador.setMiVentanaBajaSNS(miventanaBajaSNS);
			miCoordinador.setMiVentanaCategorias(miVentanaCategorias);
			miCoordinador.setMiVentanaCaja(miVentanaCaja);
			miVentanaInicio.setVisible(true);
			
			miCoordinador.setMiVentanaAlquiler(miVentanaAlquiler);
			miCoordinador.setMiVentanaNuevoAlquiler(miVentanaNuevoAlquiler);
			miCoordinador.setMiVentanaNuevoInmueble(miVentanaNuevoInmueble);
			miCoordinador.setMiVentanaBusquedaAlquiler(miVentanaBusquedaAlquiler);
			miCoordinador.setMiVentanaBusquedaInmueble(miVentanaBusquedaInmueble);
			miCoordinador.setMiVentanaModificarInmueble(miVentanaModificarInmueble);
			miCoordinador.setMiVentanaEliminarInmueble(miVentanaEliminarInmueble);
			miCoordinador.setMiVentanaRehabilitarInmueble(miVentanaRehabilitarInmueble);
			miCoordinador.setMiVentanaModificarAlquiler(miVentanaModificarAlquiler);
			miCoordinador.setMiVentanaEliminarAlquiler(miVentanaEliminarAlquiler);
			miCoordinador.setMiVentanaPagarAlquiler(miVentanaPagarAlquiler);
			
			
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"El sistema no puede seguir la ejecucion debido al siguiente error"+e.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}


