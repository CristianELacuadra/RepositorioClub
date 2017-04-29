package ar.com.ProyectoClub.BControlador;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import ar.com.ProyectoClub.AVista.Inicio;
import ar.com.ProyectoClub.AVista.PantallaNuevoSocio;
import ar.com.ProyectoClub.AVista.PantallaPersona;
import ar.com.ProyectoClub.AVista.Principal;
import ar.com.ProyectoClub.AVista.Vistas;
import ar.com.ProyectoClub.CModelo.Modelo;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;

public class Controlador implements ActionListener,KeyListener {

	
	private Modelo modelo;
	private Vistas vista;
	
	public Controlador(Vistas vista,Modelo modelo)// Principal principal, , PantallaNuevoSocio fmnuevosocio,PantallaPersona fmPantallaPersona) 
	{
		this.modelo=modelo;
		this.vista=vista;
		Inicia();
	}
	public void go()
    {
        //this.vista.getFrminicio().setVisible(true);
        //this.vista.getFrmrprincipal().setVisible(false);
    }
	private void Inicia() 
	{	
		//loggea
		form_logueo();
		//form_Inicio();
	}
	
	
	private void form_logueo()
	{	        
	        this.vista.getFrminicio().setTitle("Identificate");
	        //Se aÃ±aden las acciones a los controles
	        this.vista.getFrminicio().botAceptar.setActionCommand("Aceptar");
	        this.vista.getFrminicio().botCancelar.setActionCommand("Salir");
	        //Se pone a escuchar
	        this.vista.getFrminicio().textField.addKeyListener(this);
	        this.vista.getFrminicio().passwordField.addKeyListener(this);
	        this.vista.getFrminicio().botAceptar.addActionListener(this);
	        this.vista.getFrminicio().botCancelar.addActionListener(this);
	        //centrado de formulario
	        Point p=new Point(0, 0);
			Dimension panel= this.vista.getFrminicio().contentPane.getSize();
			Dimension ventana= this.vista.getFrminicio().getSize();
			p.x= (ventana.width - ventana.width)/2;
			p.y=(panel.height -panel.height)/2;
			this.vista.getFrminicio().setLocation(p);
			this.vista.getFrminicio().setVisible(true);	 
	}

	/*Atentos a las acciones*/
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando =e.getActionCommand();
		try {
			if(comando.equals("Aceptar")) 
			{	
				Usuario usuario=modelo.getMdlserviceusuario().newusuario();// crea el usuario
				usuario=modelo.getMdlserviceusuario().DevolverUsuario(this.vista.getFrminicio().textField.getText(),this.vista.getFrminicio().passwordField.getText());
				//valida si usuario y contraseña es valido
				if(!(usuario==null)) 
				{
					this.vista.getFrminicio().dispose();
					form_principal(usuario.getNick(),usuario.getTipousuario());
				}
				else {
					JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecta","Acceso al sistema denegado",JOptionPane.ERROR_MESSAGE);
					this.vista.getFrminicio().textField.setText(null);
					this.vista.getFrminicio().passwordField.setText(null);
					this.vista.getFrminicio().botAceptar.setEnabled(false);
				}

			}
			if(comando.equals("Salir")) 
				this.vista.getFrminicio().dispose();
			if(comando.equals("Socios")) {
				
			}
			if(comando.equals("No Socios")) {
				
			}
			if(comando.equals("Alquiler")) {
				
			}
			if(comando.equals("Caja")){
				
			}
			if(comando.equals("Configuracion")){
			
			}
			if(comando.equals("Salir")) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente deseas salir?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) { //The ISSUE is here
					this.vista.getFrmrprincipal().dispose();
					System.exit(0);
				} 
			}
				
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex.toString(),"Mensaje de error",JOptionPane.ERROR_MESSAGE);
		}
	}
	private void form_principal(String usuario,String tipo) 
	{
		Principal NuevoformPrinc=new Principal();
		this.vista.setFrmrprincipal(NuevoformPrinc);
		this.vista.getFrmrprincipal().setTitle("Usuario: "+usuario+"("+tipo+")");
		this.vista.getFrmrprincipal().setLocationRelativeTo(null); //centrando en la pantalla
		this.vista.getFrmrprincipal().setExtendedState(this.vista.getFrmrprincipal().MAXIMIZED_BOTH);//estado maximizado
		//atiende la acciones a los controles
		this.vista.getFrmrprincipal().btnSocios.setActionCommand("Socios");
		this.vista.getFrmrprincipal().btnNoSocio.setActionCommand("No Socios");
		this.vista.getFrmrprincipal().btnAlquiler.setActionCommand("Alquiler");
		this.vista.getFrmrprincipal().btnCaja.setActionCommand("Caja");
		this.vista.getFrmrprincipal().btnConfig.setActionCommand("Configuracion");
		this.vista.getFrmrprincipal().btnSalir.setActionCommand("Salir");
		
		//si usuario es administrador desbloquea la configuracion
		if(tipo.equals("Administrador"))
			this.vista.getFrmrprincipal().btnConfig.setEnabled(true);
		else
			this.vista.getFrmrprincipal().btnConfig.setEnabled(false);
		
		//se pone a escuchar las acciones del usuario
		this.vista.getFrmrprincipal().btnSocios.addActionListener(this);
		this.vista.getFrmrprincipal().btnNoSocio.addActionListener(this);
		this.vista.getFrmrprincipal().btnAlquiler.addActionListener(this);
		this.vista.getFrmrprincipal().btnCaja.addActionListener(this);
		this.vista.getFrmrprincipal().btnConfig.addActionListener(this);
		this.vista.getFrmrprincipal().btnSalir.addActionListener(this);
		this.vista.getFrmrprincipal().setVisible(true);
	}
	/*form_legeo keyactionlistener*/
	@Override
	public void keyPressed(KeyEvent e) {
		//e.getKeyChar();
		if(!this.vista.getFrminicio().textField.getText().isEmpty() && !this.vista.getFrminicio().passwordField.getPassword().equals("")) {
				this.vista.getFrminicio().botAceptar.setEnabled(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

