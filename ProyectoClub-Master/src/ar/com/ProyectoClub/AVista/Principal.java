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

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
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
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import j2Button.j2Button;

import javax.swing.border.CompoundBorder;

public class Principal extends JFrame implements ActionListener{
    
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JPanel contentPane;
	public j2Button btnNoSocio;
	public j2Button btnSocios;
	public j2Button btnAlquiler; 
	public j2Button btnCaja;
	public j2Button btnConfig;
	public j2Button btnSalir;
	public JToolBar jtoolbar1;
	public JDesktopPane jCDesktopPane1; 
	
	@SuppressWarnings("deprecation")
	public Principal() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		jtoolbar1 = new JToolBar();
		btnSocios = new j2Button();		
		btnNoSocio=new j2Button();
		btnAlquiler = new j2Button();
		btnCaja = new j2Button();
		btnConfig = new j2Button();
		btnSalir = new j2Button();
		jCDesktopPane1 = new JDesktopPane();
		
		btnSocios.setIcon(new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/user_person_people_6100.png")));
		btnSocios.setColor1(new java.awt.Color(0, 0, 0));
		btnSocios.setColor2(new java.awt.Color(153, 153, 153));
		btnSocios.setFocusable(false);
        btnSocios.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        btnSocios.setFuente2(new java.awt.Font("Arial", 1, 10));
        btnSocios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSocios.setTexto1("Socios");
        btnSocios.setTexto2("");
        btnSocios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtoolbar1.add(btnSocios);
        jtoolbar1.addSeparator();
        
        btnNoSocio.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/bootloader_users_person_people_6080.png")));
        btnNoSocio.setColor1(new java.awt.Color(0, 0, 0));
		btnNoSocio.setColor2(new java.awt.Color(153, 153, 153));
        btnNoSocio.setEnabled(true);
        btnNoSocio.setFocusable(false);
        btnNoSocio.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        btnNoSocio.setFuente2(new java.awt.Font("Arial", 1, 10));
        btnNoSocio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNoSocio.setTexto1("No socios");
        btnNoSocio.setTexto2("");
        btnNoSocio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtoolbar1.add(btnNoSocio);
        jtoolbar1.addSeparator();
        
        btnAlquiler.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/folder_9903.png")));
        btnAlquiler.setColor1(new java.awt.Color(0, 0, 0));
        btnAlquiler.setColor2(new java.awt.Color(153, 153, 153));
        btnAlquiler.setEnabled(true);
        btnAlquiler.setFocusable(false);
        btnAlquiler.setFuente1(new java.awt.Font("Arial Black", 1, 12));
        btnAlquiler.setFuente2(new java.awt.Font("Arial", 1, 10));
        btnAlquiler.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlquiler.setTexto1("Alquiler");
        btnAlquiler.setTexto2("");
        btnAlquiler.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtoolbar1.add(btnAlquiler);
        jtoolbar1.addSeparator();
        
        btnCaja.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/dollar_money_17872.png")));       
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
		btnConfig.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/developer_folder_black_13857.png")));
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
        btnSalir.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/exit_closethesession_close_6317.png")));
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
			btnNoSocio.addActionListener(this);
			btnAlquiler.addActionListener(this);
			btnCaja.addActionListener(this);
			btnConfig.addActionListener(this);
			btnSalir.addActionListener(this);
		
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnSocios) {
			miCoordinador.mostrarVentanaSocio();
		}
		
		if (e.getSource()==btnNoSocio) {
			miCoordinador. mostrarVentanaNoSocio();			
		}
		if(e.getSource()==btnCaja){
			miCoordinador.MostrarVentanaCaja();
		}
		if(e.getSource()==btnAlquiler){
			miCoordinador.mostrarVentanaAlquiler();
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
