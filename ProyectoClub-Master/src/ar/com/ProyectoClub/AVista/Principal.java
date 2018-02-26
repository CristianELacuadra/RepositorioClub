package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Dialog.ModalExclusionType;

import jcMousePanel.jcMousePanel;

import java.awt.FlowLayout;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;

import javax.swing.DebugGraphics;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JSeparator;

import java.awt.Window.Type;

import javax.swing.border.TitledBorder;

import JCDesktopPane.JCDesktopPane;
import ar.com.ProyectoClub.AVista.ClasesRender.ImagenFondo;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import j2Button.j2Button;

import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;

public class Principal extends JFrame implements ActionListener{
    
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JPanel contentPane;
	public j2Button btnSocios;
	public j2Button btnAlquiler; 
	public j2Button btnCaja;
	public j2Button btnConfig;
	public j2Button btnSalir;
	public JToolBar jtoolbar1;
	public JDesktopPane jCDesktopPane1; 
	private j2Button info;
	private j2Button btnAyuda;
	
	public Principal(){
		initComponents();
		jCDesktopPane1.setBorder(new ImagenFondo());
		this.setExtendedState(Principal.MAXIMIZED_BOTH);
	}
	
	@SuppressWarnings("deprecation")
	private void initComponents()  {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		jtoolbar1 = new JToolBar();
		btnSocios = new j2Button();		
		btnAlquiler = new j2Button();
		btnCaja = new j2Button();
		btnConfig = new j2Button();
		btnSalir = new j2Button();
		jCDesktopPane1 = new JDesktopPane();
		
		btnSocios.setIcon(new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/icoSocios.png")));
		btnSocios.setColor1(new java.awt.Color(0, 0, 0));
		btnSocios.setColor2(new java.awt.Color(153, 153, 153));
		btnSocios.setFocusable(false);
        btnSocios.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        btnSocios.setFuente2(new java.awt.Font("Arial", 1, 10));
        btnSocios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSocios.setTexto1("Personas");
        btnSocios.setTexto2("");
        btnSocios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtoolbar1.add(btnSocios);
        jtoolbar1.addSeparator();
        
        btnAlquiler.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoAlquiler.png")));
        btnAlquiler.setColor1(new java.awt.Color(0, 0, 0));
        btnAlquiler.setColor2(new java.awt.Color(153, 153, 153));
        btnAlquiler.setEnabled(true);
        btnAlquiler.setFocusable(false);
        btnAlquiler.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        btnAlquiler.setFuente2(new java.awt.Font("Arial", 1, 10));
        btnAlquiler.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlquiler.setTexto1(" Alquiler");
        btnAlquiler.setTexto2("");
        btnAlquiler.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtoolbar1.add(btnAlquiler);
        jtoolbar1.addSeparator();
        
        btnCaja.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoCaja.png")));       
        btnCaja.setColor1(new java.awt.Color(0, 0, 0));
        btnCaja.setColor2(new java.awt.Color(153, 153, 153));
        btnCaja.setEnabled(true);
        btnCaja.setFocusable(false);
        btnCaja.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        btnCaja.setFuente2(new java.awt.Font("Arial", 1, 10));
        btnCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCaja.setTexto1("Caja");
        btnCaja.setTexto2("");
        btnCaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtoolbar1.add(btnCaja);
        jtoolbar1.addSeparator();
        
        //btnConfig.setHorizontalTextPosition(SwingConstants.LEFT);
		btnConfig.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoConfig.png")));
		btnConfig.setColor1(new java.awt.Color(0, 0, 0));
		btnConfig.setColor2(new java.awt.Color(153, 153, 153));
		btnConfig.setFocusable(false);
		btnConfig.setFuente1(new java.awt.Font("Arial Black", 1, 12));
		btnConfig.setFuente2(new java.awt.Font("Arial", 1, 10));
		btnConfig.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnConfig.setTexto1("Configuración");
		btnConfig.setTexto2("");
		btnConfig.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtoolbar1.add(btnConfig);
        jtoolbar1.addSeparator();
        
        //btnConfig.setHorizontalTextPosition(SwingConstants.LEFT);
       
        
        info = new j2Button();
        info.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/Informacion.png")));
        info.setColor1(new java.awt.Color(0, 0, 0));
        info.setColor2(new java.awt.Color(153, 153, 153));
        info.setEnabled(true);
        info.setFocusable(false);
        info.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        info.setFuente2(new java.awt.Font("Arial", 1, 10));
        info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        info.setTexto1("Acerca de");
        info.setTexto2("");
        info.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        info.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		infoActionPerformed(evt);
        	}
        });
        jtoolbar1.add(info);
        jtoolbar1.addSeparator();
        
        btnAyuda = new j2Button();
        btnAyuda.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/pregunta (1).png")));
        btnAyuda.setColor1(new java.awt.Color(0, 0, 0));
        btnAyuda.setColor2(new java.awt.Color(153, 153, 153));
        btnAyuda.setEnabled(true);
        btnAyuda.setFocusable(false);
        btnAyuda.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        btnAyuda.setFuente2(new java.awt.Font("Arial", 1, 10));
        btnAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAyuda.setTexto1("Ayuda");
        btnAyuda.setTexto2("");
        btnAyuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		AbrirArchivo("src/ar/com/ProyectoClub/Avista/icon/ArchivoAyuda/ManualUsuario.pdf");
        	}

			
        });
        
        jtoolbar1.add(btnAyuda);
        jtoolbar1.addSeparator();
        
        btnSalir.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoSalida.png")));
        btnSalir.setColor1(new java.awt.Color(0, 0, 0));
        btnSalir.setColor2(new java.awt.Color(153, 153, 153));
        btnSalir.setEnabled(true);
        btnSalir.setFocusable(false);
        btnSalir.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        btnSalir.setFuente2(new java.awt.Font("Arial", 1, 10));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setTexto1("Salir");
        btnSalir.setTexto2("");
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtoolbar1.add(btnSalir);

        jCDesktopPane1.setBackground(new java.awt.Color(153, 153, 153));
		 
		 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jtoolbar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
	            .addComponent(jCDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jtoolbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jCDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
	        );
	        

	        pack();
	        
	        
	        //atentos a las acciones del usuario
	        btnSocios.addActionListener(this);
			btnAlquiler.addActionListener(this);
			btnCaja.addActionListener(this);
			btnConfig.addActionListener(this);
			btnSalir.addActionListener(this);
		
	}
	
	private void AbrirArchivo(String archivo) {
		try {

			File objetofile = new File (archivo);
			Desktop.getDesktop().open(objetofile);

		}catch (IOException  ex) {

			JOptionPane.showMessageDialog(null,ex.getMessage(),"Atencion", JOptionPane.ERROR_MESSAGE);
		}

	}
	private void infoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
		JOptionPane.showMessageDialog(this, "El SISTEMA CLUB AVENIDA EJERCITO fue creado por estudiantes de la Facultad de Ciencia y Tecnologia UADER\n\n"
				+" Con el propósito de recibirse de Analista de Sistemas de información. "
				+ "cuenta con una serie de opciones para el manejo del mismo.\n\n" 
				+"*PERSONAS: este apartado registra personas(Socio y no socios) "
				+ "para que puedan acceder al sistema, Y unas series de funcionalidades\n"
				+ " que le permitirán entre otras cosas: cobrar cuota del socio,revisar morosos,\n"
				+ "editar una personas existente, habilitar e inhabilitar una persona.\n\n"
				+"*ALQUILER: este apartado realiza CREACION-MODIFICACION-CANCELACION de alquileres\n"
				+ " de los distintos inmuebles que posee el club.\n\n"                                
				+ "*CAJA: en este apartado se muestran todos los ingreso y egresos realizadas\n"
				+ "durante determinada fecha y se pueden filtrar diferentes registros.\n\n"
				+ "*CONFIGURACION: en este apartado mustra y configura el backup. Solo Usuario Administrador.\n\n"
				+ "el usuario administrador es el unnico con todos los privilegios sobre el sistema,\n"
				+ "y el usuario normal a todos menos a la configuracion.\n\n" +
				"________________________________________________________________\n"+
				"FCYT FACULTAD DE CIENCIA Y TECNOLOGIA UADER \n"
				+"INTEGRANTES: GIECO MAXIMILIANO ROMAN , LACUADRA CRISTIAN EMANUEL CEFERINO\n"
				+"CONTACO: maximiliano-g@hotmail.com  emanuellacuadra@gmail.com", "Informacion", 0,new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/facultad.png")));
	}

	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnSocios) {
            miCoordinador.MostrarVentanaPrincipalPersona(PantallaPrincipalPersonas.tablaPersona);
		}
		
		if(e.getSource()==btnCaja){
			miCoordinador.MostrarVentanaCaja(PantallaCaja.jtdatos);
		}
		if(e.getSource()==btnConfig){
			miCoordinador.MostrarVentnaConfiguracion();
		}
		if(e.getSource()==btnAlquiler){
			miCoordinador.mostrarVentanaAlquilerPrincipal();
		}
		if(e.getSource()==btnSalir){
			int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente deseas salir?", "Aviso", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) { //The ISSUE is here
				this.dispose();
				System.exit(0);
			} 
		}
		
	}
}
