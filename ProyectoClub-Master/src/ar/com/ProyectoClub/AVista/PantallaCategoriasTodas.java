package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Window.Type;

public class PantallaCategoriasTodas extends JDialog {
	
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	private final JPanel contentPanel = new JPanel();
	public static JTable jtdatos;
	public PantallaCategoriasTodas(PantallaPrincipalPersonas ventana,boolean value){
		super(ventana,true);
		setType(Type.POPUP);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaCategoriasTodas.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setTitle("Sistema Club Avenida Ejercito - Categorias");
		initComponents();
	}
	
	private void initComponents(){
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new CompoundBorder());
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(0, 0, 434, 228);
		contentPanel.add(jScrollPane1);
		jtdatos= new JTable();
		jScrollPane1.setColumnHeaderView(jtdatos);
		jtdatos.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "Id", "Nombre",
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return false;
	            }
	        });
		jtdatos.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(jtdatos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

}
