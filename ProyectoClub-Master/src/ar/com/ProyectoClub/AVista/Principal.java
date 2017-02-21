package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

import jcMousePanel.jcMousePanel;

import java.awt.FlowLayout;

import javax.swing.UIManager;
import javax.swing.JButton;
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
import javax.swing.JSeparator;

import java.awt.Window.Type;

import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public Principal() {
		setIconImage(null);  // no funca no saca el icono de la pantalla
		
		setVisible(true);
		setResizable(true);
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(Frame.MAXIMIZED_BOTH); //maximo tamaño de pestaña
				
		setBounds(0, 0, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelBotones.setBorder(UIManager.getBorder("CheckBox.border"));
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelBotones, BorderLayout.NORTH);
		
		
		JButton btnNoSocio = new JButton("No Socios");
		btnNoSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNoSocio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNoSocio.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNoSocio.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/bootloader_users_person_people_6080.png")));
		panelBotones.add(btnNoSocio);
		
		JButton btnSocios = new JButton("Socios");
		btnSocios.setBorder(UIManager.getBorder("CheckBox.border"));
		btnSocios.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/user_person_people_6100.png")));
		panelBotones.add(btnSocios);
		
		JButton btnAlquiler = new JButton("Alquiler");
		btnAlquiler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlquiler.setBorder(UIManager.getBorder("CheckBox.border"));
		btnAlquiler.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/folder_9903.png")));
		panelBotones.add(btnAlquiler);
		
		JButton btnCaja = new JButton("Caja");
		btnCaja.setBorder(UIManager.getBorder("CheckBox.border"));
		btnCaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCaja.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/dollar_money_17872.png")));
		panelBotones.add(btnCaja);
		
		JButton btnConfig = new JButton("Configuraci\u00F3n");
		btnConfig.setHorizontalTextPosition(SwingConstants.LEFT);
		btnConfig.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/developer_folder_black_13857.png")));
		btnConfig.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnConfig.setBorder(UIManager.getBorder("CheckBox.border"));
		btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBotones.add(btnConfig);
	
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setHorizontalTextPosition(SwingConstants.LEFT);
		btnSalir.setIcon(new ImageIcon(Principal.class.getResource("/ar/com/ProyectoClub/AVista/icon/exit_closethesession_close_6317.png")));
		btnSalir.setBorder(UIManager.getBorder("CheckBox.border"));
		panelBotones.add(btnSalir);
	}

}
