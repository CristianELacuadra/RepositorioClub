package ar.com.ProyectoClub.BControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ar.com.ProyectoClub.AVista.PantallaNuevoSocios;
import ar.com.ProyectoClub.AVista.PantallaPersona;
import ar.com.ProyectoClub.CModelo.Modelo;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

public class ControladorPersonas implements ActionListener,KeyListener {
	/*objeto del modelo*/
	private Modelo modelo;
	/*objeto formulario que gobierna*/
	private PantallaNuevoSocios frmNuevoSocio;
	private PantallaPersona fmrPersonas;
	
	public ControladorPersonas(Modelo modelo,PantallaNuevoSocios frmNuevoSocio,PantallaPersona frmPersonas) {
		this.modelo=modelo;
		this.frmNuevoSocio=frmNuevoSocio;
		this.fmrPersonas=frmPersonas;
		Inicia();
	}
	
	private void Inicia() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void Form_NuevoSocio() {
		this.vista.getFrmAgregarPersona().setTitle("REGISTRO SOCIOS");
		this.vista.getFrmAgregarPersona().setVisible(true);
		this.vista.getFrmAgregarPersona().setLocationRelativeTo(null);
		//atiende la acciones a los controles
		this.vista.getFrmAgregarPersona().btnRegistrar.setActionCommand("REGISTRAR");
		this.vista.getFrmAgregarPersona().btnEditar.setActionCommand("EDITAR");
		this.vista.getFrmAgregarPersona().btnGEdit.setActionCommand("OK");
		this.vista.getFrmAgregarPersona().btnEliminar.setActionCommand("ELIMINAR");
		this.vista.getFrmAgregarPersona().btnListar.setActionCommand("LISTAR");
		this.vista.getFrmAgregarPersona().btnSalir.setActionCommand("VOLVER");
		
		//se pone a escuchar las acciones del usuario
		this.vista.getFrmAgregarPersona().btnRegistrar.addActionListener(this);
		this.vista.getFrmAgregarPersona().btnEditar.addActionListener(this);
		this.vista.getFrmAgregarPersona().btnGEdit.addActionListener(this);
		this.vista.getFrmAgregarPersona().btnEliminar.addActionListener(this);
		this.vista.getFrmAgregarPersona().btnListar.addActionListener(this);
		this.vista.getFrmAgregarPersona().btnSalir.addActionListener(this);
		this.vista.getFrmrprincipal().setVisible(true);
	}
	
	
	public void LLenarTabla(JTable tablaD){
		DefaultTableModel  modeloT = new DefaultTableModel();
		java.util.List<Personas> SociosActivos=new ArrayList<Personas>();
		SociosActivos=this.modelo.getMdlservicesocio().ObtnerTresPersonas(Integer.parseInt(this.vista.getFrmAgregarPersona().lblNroSocio.getText().toString()));
		tablaD.setModel(modeloT);

		modeloT.addColumn("DNI");
		modeloT.addColumn("APELLIDOS");
		modeloT.addColumn("NOMBRES");
		modeloT.addColumn("FECHA N.");
		modeloT.addColumn("DOMICILIO");
		modeloT.addColumn("TELEFONO");
		modeloT.addColumn("MATRICULA");
		modeloT.addColumn("SEXO");
		modeloT.addColumn("NACIONALIDAD");
		modeloT.addColumn("DOMICILIO");
		modeloT.addColumn("ESTADOC");
		modeloT.addColumn("FECHA INGRE");
		modeloT.addColumn("CATEGORIA");

		Object[] columna = new Object[14];

		int numRegistros = SociosActivos.size();

		for (int i = 0; i < numRegistros; i++) {
			columna[0] = SociosActivos.get(i).getNroSocio();
			columna[1] = SociosActivos.get(i).getDni();
			columna[2] = SociosActivos.get(i).getApellido();
			columna[3] = SociosActivos.get(i).getNombre();
			columna[4] = SociosActivos.get(i).getFecNacimiento();
			columna[5] = SociosActivos.get(i).getDomicilio();
			columna[6] = SociosActivos.get(i).getTelefono();
			columna[7] = SociosActivos.get(i).getMatricula();
			columna[8] = SociosActivos.get(i).getSexo();
			columna[9] = SociosActivos.get(i).getNacionalidad();
			columna[10] = SociosActivos.get(i).getDomicilio();
			columna[11] = SociosActivos.get(i).getEstadoCivil();
			columna[12] = SociosActivos.get(i).getFechaIngreso();
			columna[13] = SociosActivos.get(i).getCategoria().getNombre();
			modeloT.addRow(columna);
		}
	}

	

}
