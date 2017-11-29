package ar.com.ProyectoClub.AVista;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import jcMousePanel.jcMousePanel;
import java.awt.FlowLayout;
import com.bolivia.panel.JCPanel;
import com.bolivia.panel.USEMODE;
import antlr.ParserSharedInputState;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Usuario;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.DebugGraphics;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;




public class Inicio extends JFrame  implements ActionListener,KeyListener {
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
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
		botCancelar.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoSalida32x32.png")));
		botAceptar = new JButton();
		botAceptar.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoAceptar.png")));
		contentPane= new JPanel();
		textField=new JTextField();
		passwordField= new JPasswordField();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 461);
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
	   //panel_1.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/closingsession_theoutputnear_cierredesesion_10028.png")));
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
		labUsuario.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/usuariolbl.png")));
		labUsuario.setBounds(20, 144, 194, 80);
		panel_1.add(labUsuario);
		JLabel labContra = new JLabel("Contrase\u00F1a");
		labContra.setForeground(Color.WHITE);
		labContra.setFont(new Font("Tahoma", Font.BOLD, 22));
	//	ima
		labContra.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/key_1564.png")));
		labContra.setBounds(20, 253, 194, 80);
		panel_1.add(labContra);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(224, 170, 250, 31);
		textField.addKeyListener(this);
		panel_1.add(textField);
		textField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(224, 279, 250, 31);
		passwordField.addKeyListener(this);
		panel_1.add(passwordField);
		
	
		botAceptar.addActionListener(this);
		
		botAceptar.setText("Aceptar");
		botAceptar.setBorder(UIManager.getBorder("CheckBox.border"));
		botAceptar.setToolTipText("");
		botAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botAceptar.setForeground(new Color(0, 0, 0));
		botAceptar.setBounds(279, 368, 120, 43);
		panel_1.add(botAceptar);
		botCancelar.setText("Salir");
		botCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botCancelar.setBorder(UIManager.getBorder("CheckBox.border"));
		botCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botCancelar.addActionListener(this);
		botCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botCancelar.setBounds(409, 368, 120, 43);
		panel_1.add(botCancelar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 550, 110);
		panel_1.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/ar/com/ProyectoClub/AVista/icon/Bienvenidos.png")));
		panel.add(lblNewLabel);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	private void limpiar() 
	{
		textField.setText("");
		passwordField.setText("");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botAceptar){
			this.EntraAlSistema();
		}
		
		if(e.getSource()==botCancelar){
			this.dispose();
		}

	}
	
	private void EntraAlSistema(){
		try{
			String nom,pass;
			Usuario usuario=miCoordinador.CrearUsuario();
			nom=textField.getText();
			pass=passwordField.getText();
			usuario=miCoordinador.validarUsuario(nom, pass);
			if(usuario !=null){
				if(!usuario.getNick().equals(null)){
					miCoordinador.mostrarVentanaPrincipal(usuario);	
					dispose();
				}
				else					
					JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecta,Por favor vuelva a intentarlo","Acceso al sistema denegado",JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"Usuario inexistente","Acceso al sistema denegado",JOptionPane.ERROR_MESSAGE);

			//Antes de abrir lanzo la generacion de cuota;
			//miCoordinador.LanzarPrcesoAutGeneracionCuota(); //Lanza Proceso de generacion de cuotas
			//miCoordinador.ProcesarMorosos(); //lanza proceso de generacion de morosos			
			this.limpiar();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No se puede seguir ejecutando el sistema debido al siguiente error: "+e.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			this.EntraAlSistema();
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
