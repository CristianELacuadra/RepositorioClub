package ar.com.ProyectoClub.BControlador;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Convert;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ar.com.ProyectoClub.AVista.Inicio;
import ar.com.ProyectoClub.AVista.PantallaNuevoSocios;
import ar.com.ProyectoClub.AVista.PantallaPersona;
import ar.com.ProyectoClub.AVista.Principal;
import ar.com.ProyectoClub.CModelo.Modelo;
import ar.com.ProyectoClub.CModelo.CEntidades.*;
public class ControladorLogeoPrincipal implements ActionListener,KeyListener {
	//Modelo,Vista
	private Modelo modelo;
	//vistas que gobierna el controlador
	private Inicio frmInicio;
	private Principal frmPrincipal;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
	//constructor
	public ControladorLogeoPrincipal (Modelo modelo,Inicio frminicio,Principal frmprincipal)
	{
		this.modelo=modelo;
		this.frmInicio=frminicio;
		this.frmPrincipal=frmprincipal;
		Inicia(); //->solo inicia con el formLogeo
	}
	
	public void go()
    {
        //this.vista.getFrminicio().setVisible(true);
        //this.vista.getFrmrprincipal().setVisible(false);
    }
	//----------------------------------------------------------------------------------------------------------------------------------------------------

	/*Atentos a las acciones*/
	//Todas las acciones del usuario
	//ActionListeriner
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando =e.getActionCommand();
		try {
			if(comando.equals("Aceptar")) 
			{	
				Usuario usuario=modelo.getMdlserviceusuario().newusuario();// crea el usuario
				usuario=modelo.getMdlserviceusuario().DevolverUsuario(this.frmInicio.textField.getText(),this.frmInicio.passwordField.getText());
				//valida si usuario y contraseña es valido
				if(!(usuario==null)) 
				{
					this.frmInicio.dispose();
					form_principal(usuario.getNick(),usuario.getTipousuario());
				}
				else {
					JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecta","Acceso al sistema denegado",JOptionPane.ERROR_MESSAGE);
					this.frmInicio.textField.setText(null);
					this.frmInicio.passwordField.setText(null);
					this.frmInicio.botAceptar.setEnabled(false);
				}

			}

			if(comando.equals("Socios")) {
				//Creo los formularios que va a gobernar el controlador
				PantallaPersona frmPersona=new PantallaPersona();
				PantallaNuevoSocios frmNuevoSocio= new PantallaNuevoSocios();
				ControladorPersonas controladorPersonas= new ControladorPersonas(this.modelo,frmNuevoSocio,frmPersona);
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
					this.frmPrincipal.dispose();
					System.exit(0);
				} 
			}
				
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex.toString(),"Mensaje de error",JOptionPane.ERROR_MESSAGE);
		}
	}
	//keyListeriner
	@Override
	public void keyPressed(KeyEvent e) {
		//e.getKeyChar();
		if(!this.frmInicio.textField.getText().isEmpty() && !this.frmInicio.passwordField.getPassword().equals("")) {
				this.frmInicio.botAceptar.setEnabled(true);
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
	//----------------------------------------------------------------------------------------------------------------------------------------------------
	/*FORMULARIOS*/
	private void Inicia() 
	{	
		//loggea
		form_logueo();
	}
	
	//Loggeo
	private void form_logueo()
	{	        
	        this.frmInicio.setTitle("Identificate");
	        //Se aÃ±aden las acciones a los controles
	        this.frmInicio.botAceptar.setActionCommand("Aceptar");
	        this.frmInicio.botCancelar.setActionCommand("Salir");
	        //Se pone a escuchar
	        this.frmInicio.textField.addKeyListener(this);
	        this.frmInicio.passwordField.addKeyListener(this);
	        this.frmInicio.botAceptar.addActionListener(this);
	        this.frmInicio.botCancelar.addActionListener(this);
	        //centrado de formulario
	        Point p=new Point(0, 0);
			Dimension panel= this.frmInicio.contentPane.getSize();
			Dimension ventana= this.frmInicio.getSize();
			p.x= (ventana.width - ventana.width)/2;
			p.y=(panel.height -panel.height)/2;
			this.frmInicio.setLocation(p);
			this.frmInicio.setVisible(true);	 
	}
	
	//Principal
	private void form_principal(String usuario,String tipo) 
	{
		this.frmPrincipal.setTitle("Usuario: "+usuario+"("+tipo+")");
		this.frmPrincipal.setLocationRelativeTo(null); //centrando en la pantalla
		this.frmPrincipal.setExtendedState(this.frmPrincipal.MAXIMIZED_BOTH);//estado maximizado
		//atiende la acciones a los controles
		this.frmPrincipal.btnSocios.setActionCommand("Socios");
		this.frmPrincipal.btnNoSocio.setActionCommand("No Socios");
		this.frmPrincipal.btnAlquiler.setActionCommand("Alquiler");
		this.frmPrincipal.btnCaja.setActionCommand("Caja");
		this.frmPrincipal.btnConfig.setActionCommand("Configuracion");
		this.frmPrincipal.btnSalir.setActionCommand("Salir");
		
		//si usuario es administrador desbloquea la configuracion
		if(tipo.equals("Administrador"))
			this.frmPrincipal.btnConfig.setEnabled(true);
		else
			this.frmPrincipal.btnConfig.setEnabled(false);
		
		//se pone a escuchar las acciones del usuario
		this.frmPrincipal.btnSocios.addActionListener(this);
		this.frmPrincipal.btnNoSocio.addActionListener(this);
		this.frmPrincipal.btnAlquiler.addActionListener(this);
		this.frmPrincipal.btnCaja.addActionListener(this);
		this.frmPrincipal.btnConfig.addActionListener(this);
		this.frmPrincipal.btnSalir.addActionListener(this);
		this.frmPrincipal.setVisible(true);
	}
}

