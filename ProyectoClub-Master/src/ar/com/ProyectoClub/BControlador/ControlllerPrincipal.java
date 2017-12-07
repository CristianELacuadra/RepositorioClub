package ar.com.ProyectoClub.BControlador;

import javax.swing.JOptionPane;

import ar.com.ProyectoClub.AVista.*;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IService;
import ar.com.ProyectoClub.CModelo.AServicios.facade.Service;
/*
 * Esta clase contiene el método main que ejecuta la aplicación, 
 * el método hace un llamado al método iniciar el cual crea las 
 * instancias de las clases ventanas y la clase Logica  
 * estableciendo las relaciones con la clase Coordinador.
 */
public class ControlllerPrincipal {
	//Modelo
	IService miModeloService;
	//Vistas
	Principal miVentanaPrincipal;
	Inicio miVentanaInicio;
	PantallaFormularioPersona miFormularioPersona;
	PantallaBusquedaSNS miVentanaBusquedaSNSElim;
	PantallaBusquedaSNS miVentanaBusquedaSNSCobr;
	PantallaCobranzaCuota miVentanaCobranzaCuota;
	PantallaCaja miVentanaCaja;
	PantallaIngresoEgreso miVentanaIngresoEgreso;
	PantallaConfiguracion miVentanaConfiguracion;
	PantallaPrincipalPersonas miVentanaPrincipalPersonas;
	PantallaDetallesInhabilitarSNS miVentanaDetalllesSNS;
	PantallaConfiguracionCategoria  miVentanaConfCategoria;
	

	
	PantallaAlquilerPrincipal miVentanaAlquilerPrincipal;
	PantallaNuevoAlquiler miVentanaNuevoAlquiler;
		
	
	
	
	
	//clase puente entre el modelo y las vistas.
	ControllerCoordinador miCoordinador;

	public static void main(String[] args) {
		ControlllerPrincipal miPrincipal=new ControlllerPrincipal();
		miPrincipal.Iniciar();
	}

	private void Iniciar(){
		try{
			/*Se instancian las clases*/
			miModeloService=new  Service();
			miVentanaInicio=new Inicio();
			miVentanaPrincipal=new Principal();
			miFormularioPersona=new PantallaFormularioPersona(miVentanaPrincipalPersonas,true); // mi ventana formulario persona depende de pantalla persona
			miVentanaBusquedaSNSElim=new PantallaBusquedaSNS();
			miVentanaBusquedaSNSCobr=new PantallaBusquedaSNS(miVentanaCobranzaCuota, true);
			miVentanaCobranzaCuota= new PantallaCobranzaCuota(miVentanaPrincipalPersonas,true);
			miCoordinador= new ControllerCoordinador();
			miVentanaIngresoEgreso=new PantallaIngresoEgreso(miVentanaCaja, true); 
			miVentanaConfiguracion=new PantallaConfiguracion(miVentanaPrincipal, true);
			miVentanaCaja=new PantallaCaja();
			miVentanaPrincipalPersonas= new PantallaPrincipalPersonas();
			miVentanaDetalllesSNS=new PantallaDetallesInhabilitarSNS(miVentanaBusquedaSNSCobr, true);
			miVentanaConfCategoria = new PantallaConfiguracionCategoria(miVentanaConfiguracion,true);

			
			
			
			miVentanaAlquilerPrincipal=new PantallaAlquilerPrincipal();
			miVentanaNuevoAlquiler = new PantallaNuevoAlquiler(miVentanaAlquilerPrincipal,true);
			
			
			
			/*Se establecen las relaciones entre clases*/
			miVentanaPrincipal.setCoordinador(miCoordinador);
			miVentanaInicio.setCoordinador(miCoordinador);
			miFormularioPersona.setCoordinador(miCoordinador);
			miVentanaBusquedaSNSElim.setCoordinador(miCoordinador);
			miVentanaBusquedaSNSCobr.setCoordinador(miCoordinador); 
			miVentanaCobranzaCuota.setCoordinador(miCoordinador);
			miVentanaCaja.setCoordinador(miCoordinador);
			miVentanaIngresoEgreso.setCoordinador(miCoordinador);
			miVentanaConfiguracion.setCoordinador(miCoordinador);
			miVentanaPrincipalPersonas.setCoordinador(miCoordinador);
			miVentanaDetalllesSNS.setCoordinador(miCoordinador);
			miVentanaConfCategoria.setCoordinador(miCoordinador);
			
			
			
			
			miVentanaAlquilerPrincipal.setCoordinador(miCoordinador);
			miVentanaNuevoAlquiler.setCoordinador(miCoordinador);
	
			/*Se establecen relaciones con la clase coordinador*/
			miCoordinador.setModeloService(miModeloService);
			miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
			miCoordinador.setMiVentanaInicio(miVentanaInicio);
			miCoordinador.setMiFormularioPersona(miFormularioPersona);
			miCoordinador.setMiVentanaBusquedaSNS(miVentanaBusquedaSNSCobr);
			miCoordinador.setMiVentanaBusquedaSNS(miVentanaBusquedaSNSElim);
			miCoordinador.setMiVentanaCobranza(miVentanaCobranzaCuota);
			miCoordinador.setMiVentanaCaja(miVentanaCaja);
			miCoordinador.setMiventanaIngresoEgreso(miVentanaIngresoEgreso);
			miCoordinador.setMiVentanaConfiguracion(miVentanaConfiguracion);
			miCoordinador.setMiVentanaPrincipalPersona(miVentanaPrincipalPersonas);
			miCoordinador.setMiVentanaDetallesSNS(miVentanaDetalllesSNS);
			miCoordinador.setMiVentanaConfCategoria(miVentanaConfCategoria);
			
			
			
			miCoordinador.setMiVentanaAlquilerPrincipal(miVentanaAlquilerPrincipal);
			miCoordinador.setMiVentanaNuevoAlquiler(miVentanaNuevoAlquiler);
			
			

			miVentanaInicio.setVisible(true);
			
//github.com/CristianELacuadra/RepositorioClub.git
			
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"El sistema no puede seguir la ejecucion debido al siguiente error"+e.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);

		}
	}
}


