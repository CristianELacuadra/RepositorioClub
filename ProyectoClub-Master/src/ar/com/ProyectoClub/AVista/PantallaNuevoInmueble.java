package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;

import java.awt.Toolkit;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.UIManager;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;

public class PantallaNuevoInmueble extends JDialog implements ActionListener,KeyListener{
	public JPanel panel;
	public JLabel lblTit;
	public JPanel panelTxt;
	public JPanel panelLabel;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JTextField textNumeroIn;
	public JTextField textNombreIn;
	public JTextField textDirecIn;
	public JTextField textPrecioHoraIn;
	public JPanel panel_1;
	public JLabel lblDescripcion;
	public JTextArea textDescrip;
	public JButton btnAceptar;
	public JButton btnModificar;
	public JScrollPane scrollPane;
	public JButton btnEliminar;
	public JButton btnRestaurar;
	public JButton btnCancelar;
	private ControllerCoordinador miCoordinador;
	public Inmuebles inm;

	public PantallaNuevoInmueble(javax.swing.JDialog vtn,boolean b,Integer opcion) {
		super(vtn,b);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaNuevoInmueble.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setBounds(100, 100, 540, 550);
		getContentPane().setLayout(null);
		
		
		initComponents(opcion);
	}
	
	
	public void initComponents(Integer aux){
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(10, 11, 514, 46);
		getContentPane().add(panel);
		
		lblTit = new JLabel();
		lblTit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblTit);
		
		panelLabel = new JPanel();
		panelLabel.setBackground(Color.LIGHT_GRAY);
		panelLabel.setBorder(UIManager.getBorder("ComboBox.border"));
		panelLabel.setBounds(10, 68, 177, 297);
		getContentPane().add(panelLabel);
		panelLabel.setLayout(new GridLayout(0, 1, 30, 40));
		
		lblNewLabel = new JLabel("NUMERO DEL INMUEBLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBorder(UIManager.getBorder("ComboBox.border"));
		panelLabel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setToolTipText("nombre que sirva para identificar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBorder(UIManager.getBorder("ComboBox.border"));
		panelLabel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("DIRECCI\u00D3N:");
		lblNewLabel_2.setToolTipText("direccion donde esta ubicado el inmueble");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBorder(UIManager.getBorder("ComboBox.border"));
		panelLabel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("PRECIO POR HORA: $...");
		lblNewLabel_3.setToolTipText("precio por hora del alquiler");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBorder(UIManager.getBorder("ComboBox.border"));
		panelLabel.add(lblNewLabel_3);
		
		panelTxt = new JPanel();
		panelTxt.setBorder(UIManager.getBorder("ComboBox.border"));
		panelTxt.setBackground(Color.LIGHT_GRAY);
		panelTxt.setBounds(185, 68, 180, 297);
		getContentPane().add(panelTxt);
		panelTxt.setLayout(new GridLayout(0, 1, 302, 40));
		
		textNumeroIn = new JTextField();
		textNumeroIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTxt.add(textNumeroIn);
		textNumeroIn.setColumns(10);
		
		textNombreIn = new JTextField();
		textNombreIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTxt.add(textNombreIn);
		textNombreIn.setColumns(10);
		
		textDirecIn = new JTextField();
		textDirecIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTxt.add(textDirecIn);
		textDirecIn.setColumns(10);
		
		textPrecioHoraIn = new JTextField();
		textPrecioHoraIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTxt.add(textPrecioHoraIn);
		textPrecioHoraIn.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 376, 355, 135);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setToolTipText("una descripcion de detalles a tener encuenta del inmueble");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescripcion.setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
		lblDescripcion.setBounds(10, 11, 79, 21);
		panel_1.add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 11, 246, 113);
		panel_1.add(scrollPane);
		
		textDescrip = new JTextArea();
		textDescrip.setLineWrap(true);
		textDescrip.setAutoscrolls(false);
		textDescrip.setBounds(99, 12, 246, 112);
		scrollPane.setViewportView(textDescrip);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAceptar.setIcon(new ImageIcon(PantallaNuevoInmueble.class.getResource("/ar/com/ProyectoClub/AVista/icon/apply.png")));
		btnAceptar.setBounds(385, 133, 139, 41);
		btnAceptar.setEnabled(false);
		btnAceptar.setVisible(false);
		getContentPane().add(btnAceptar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(385, 198, 139, 41);
		btnModificar.setEnabled(false);
		btnModificar.setVisible(false);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(385, 261, 139, 41);
		btnEliminar.setEnabled(false);
		btnEliminar.setVisible(false);
		getContentPane().add(btnEliminar);
		
		btnRestaurar = new JButton("RESTAURAR");
		btnRestaurar.setBounds(385, 324, 139, 41);
		btnRestaurar.setEnabled(false);
		btnRestaurar.setVisible(false);
		getContentPane().add(btnRestaurar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(385, 457, 139, 41);
		getContentPane().add(btnCancelar);
		
		switch(aux){
		case 0 :
			btnAceptar.setEnabled(true);
			btnAceptar.setVisible(true);
			lblTit.setText("AGREGAR UN NUEVO INMUEBLE");
			break;
		
		case 1 :
			btnModificar.setEnabled(true);
			btnModificar.setVisible(true);
			lblTit.setText("MODIFICAR EL INMUEBLE");
			break;
		
		case 2 :
			btnEliminar.setEnabled(true);
			btnEliminar.setVisible(true);
			lblTit.setText("ELIMINAR O DESHABILITAR EL INMUEBLE");
			break;
		
		case 3:
			btnRestaurar.setEnabled(true);
			btnRestaurar.setVisible(true);
			lblTit.setText("REHABILITAR EL INMUEBLE");
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "ha ocurrido un error al generarse la ventana", null,JOptionPane.ERROR_MESSAGE );
			
		}
		
		//inm=miCoordinador.CrearInmueble();
		
		btnAceptar.addActionListener(this);
		btnModificar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnRestaurar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}

	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void mostrarDat(Inmuebles e){
		textNumeroIn.setText(e.getIdInmueble().toString());
		textNombreIn.setText(e.getNombre());
		textDirecIn.setText(e.getDireccion());
		textPrecioHoraIn.setText(String.valueOf(e.getPrecioHora()));
		textDescrip.setText(e.getDescripcion());
		
	}
	public Inmuebles cargarDat(){
		Inmuebles a;
		a=miCoordinador.CrearInmueble();
		a.setIdInmueble(Integer.valueOf(textNumeroIn.getText()));
		a.setNombre(textNombreIn.getText());
		a.setDireccion(textDirecIn.getText());
		a.setPrecioHora(Float.valueOf(textPrecioHoraIn.getText()));
		a.setDescripcion(textDescrip.getText());
			
	return a;
}
	public void limpiar(){
		textNumeroIn.setText("");;
		textNombreIn.setText("");
		textDirecIn.setText("");
		textPrecioHoraIn.setText("");
		textDescrip.setText("");
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar){
			inm=cargarDat();
			inm.setHabilitado(true);
		//miCoordinador.RegistrarInmueble(inm);
			limpiar();
			this.dispose();
			
		}
		
		if(e.getSource()==btnModificar){
			mostrarDat(inm);
			inm=cargarDat();
		//	miCoordinador.ModificarInmueble(Inm);
			limpiar();this.dispose();
		}
		
		if(e.getSource()==btnEliminar){
		//	miCoordinador.EliminarInmueble(Inm);
			limpiar();
			this.dispose();
		}
		
		if(e.getSource()==btnRestaurar){
		//	miCoordinador.RestaurarInmueble(Inm);
			limpiar();
			this.dispose();
		}
		
		if(e.getSource()==btnCancelar){
			this.dispose();
		}
		
		
		
	}
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
