package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import jcMousePanel.jcMousePanel;

import java.awt.FlowLayout;

import javax.swing.SpringLayout;

import com.bolivia.panel.JCPanel;
import com.bolivia.panel.USEMODE;

import antlr.ParserSharedInputState;

import javax.swing.border.BevelBorder;

import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.DebugGraphics;

import java.awt.Component;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;



public class Inicio extends JFrame {
    public JButton botCancelar;
	public JPanel contentPane;
	public JButton botAceptar;
	public JTextField textField;
	public JPasswordField passwordField;
	
	public Inicio() {
		
		initComponents();
	}
	
	
	private void initComponents() {
		botCancelar = new JButton();
		botAceptar = new JButton();
		botAceptar.setEnabled(false);
		contentPane= new JPanel();
		textField=new JTextField();
		passwordField= new JPasswordField();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristian\\git\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\logo.png"));
	
       
		

		setResizable(false);
		setTitle("Ingresar Usuario y Contraseña");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		
		JCPanel panel_1 = new JCPanel();
		panel_1.setOpacity(1.0f);
		panel_1.setUseMode(USEMODE.DEGRADED);
		panel_1.setIconLogo(null);
		panel_1.setVisibleLogo(false);
		panel_1.setSecondColor(new Color(211, 211, 211));
		panel_1.setFirstColor(new Color(128, 128, 128));
		panel_1.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/closingsession_theoutputnear_cierredesesion_10028.png")));
		panel_1.setSideHexagon(2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labUsuario = new JLabel("Usuario");
		labUsuario.setForeground(Color.WHITE);
		labUsuario.setFont(new Font("Tahoma", Font.BOLD, 22));
		labUsuario.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/Personal_user_6031.png")));
		labUsuario.setBounds(20, 20, 194, 80);
		panel_1.add(labUsuario);
		
		JLabel labContra = new JLabel("Contrase\u00F1a");
		labContra.setForeground(Color.WHITE);
		labContra.setFont(new Font("Tahoma", Font.BOLD, 22));
	//	ima
		labContra.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/key_1564.png")));
		labContra.setBounds(20, 110, 194, 80);
		panel_1.add(labContra);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(224, 46, 250, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(224, 136, 250, 31);
		panel_1.add(passwordField);
		
		
		botAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botAceptar.setText("Aceptar");
		botAceptar.setBorder(UIManager.getBorder("CheckBox.border"));
		botAceptar.setToolTipText("");
		botAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botAceptar.setForeground(new Color(0, 0, 0));
		botAceptar.setBounds(224, 208, 120, 43);
		panel_1.add(botAceptar);
		
	//	botAceptar.set
		
		botCancelar.setText("Salir");
		botCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botCancelar.setBorder(UIManager.getBorder("CheckBox.border"));
		botCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botCancelar.setBounds(354, 208, 120, 43);
		panel_1.add(botCancelar);
	//	labContra.si
		
		//labUsuario.
	}

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
