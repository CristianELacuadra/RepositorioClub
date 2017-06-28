package ar.com.ProyectoClub.BControlador;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ar.com.ProyectoClub.AVista.*;
import ar.com.ProyectoClub.CModelo.Logica;
import ar.com.ProyectoClub.CModelo.CEntidades.*;

public class ControllerCoordinador {
	private Logica miLogica;
	private Principal miVentanaPrincipal;
	private Inicio miVentanaInicio;
	private PantallaFormularioPersona miFormularioPersona;
	private PantallaPersonas miVentanaPersona;
	private PantallaBusquedaSNS miVentanaBusquedaSNS;
	private PantallaDetallesInhabilitarSNS miVentanaDetallesSNS;
	
	public Personas CrearPersona(){
		return miLogica.CrearInstanciaPersona();
	}
	
	public Categoria CrearCategoria(){
		return miLogica.CrearinstanciaCategoria();
	}
	
	public Categoria BuscarCategoria(Integer idcategoria){
		return miLogica.BuscarCategoria(idcategoria);
	}
	
	public PantallaFormularioPersona getMiFormularioPersona() {
		return miFormularioPersona;
	}
	
	public void setMiFormularioPersona(PantallaFormularioPersona miFormularioPersona) {
		this.miFormularioPersona = miFormularioPersona;
	}
	
	public PantallaPersonas getMiVentanaPersona() {
		return miVentanaPersona;
	}
	
	public void setMiVentanaPersona(PantallaPersonas miVentanaPersona) {
		this.miVentanaPersona = miVentanaPersona;
	}
	
	public Principal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	
	public void setMiVentanaPrincipal(Principal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	
	public Inicio getMiVentanaInicio() {
		return miVentanaInicio;
	}
	
	public void setMiVentanaInicio(Inicio miVentanaInicio) {
		this.miVentanaInicio = miVentanaInicio;
	}
	
	public Logica getMiLogica() {
		return miLogica;
	}
	
	public void setMiLogica(Logica miLogica) {
		this.miLogica = miLogica;
	}
	public PantallaBusquedaSNS getMiVentanaBusquedaSNS() {
		return miVentanaBusquedaSNS;
	}
	public void setMiVentanaBusquedaSNS(PantallaBusquedaSNS miVentanaBusquedaSNS) {
		this.miVentanaBusquedaSNS = miVentanaBusquedaSNS;
	}
	public PantallaDetallesInhabilitarSNS getMiVentanaDetallesSNS() {
		return miVentanaDetallesSNS;
	}
	public void setMiVentanaDetallesSNS(PantallaDetallesInhabilitarSNS miVentanaDetallesSNS) {
		this.miVentanaDetallesSNS = miVentanaDetallesSNS;
	}
	
//////////////////////////////////////////////////////////
	
	public void MostrarVentanaDetallesInhabilitar(Integer dni){
		 Personas persona=this.CrearPersona();
		 persona=miLogica.BuscarSocio(dni);
		 if(persona.isHabilitado() && persona != null){
			 int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente deseas dar inhabilitar esta persona?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) { //The ISSUE is here
					persona.setHabilitado(false);
					 miLogica.GuardarSocio(persona);
				}
		 }
		 else
			 JOptionPane.showMessageDialog(null,"la persona ya se encuentra inhabilitada");
	}
	public void Listar(JTable tablaD,String nom,String ape,String dni){
		if(this.ValidarEsSocio()){ //se selecciono el formulario socio
			DefaultTableModel  modeloT = new DefaultTableModel();
			Object[] columna = new Object[4];
			java.util.List<Personas> listapersonas=new ArrayList<Personas>();

			tablaD.setModel(modeloT);

			modeloT.addColumn("DNI");
			modeloT.addColumn("APELLIDOS");
			modeloT.addColumn("NOMBRES");
			modeloT.addColumn("habilitado");

			if(dni.isEmpty() && nom.isEmpty() && ape.isEmpty()){
				JOptionPane.showMessageDialog(null,"El rango de busqueda esta limitado a 100 personas");
				listapersonas=miLogica.ListarParcialSocio();
			}
			else{
				if(!dni.isEmpty()){
					listapersonas.add(miLogica.BuscarSocio(Integer.parseInt(dni))); //buscar directamente por id
				}
				else{
					listapersonas=miLogica.filtrarNombreApellido(nom, ape);
				}
			}

			int numRegistros=listapersonas.size();// devuelve un rango de 100 socios
			if(numRegistros>99){
				JOptionPane.showMessageDialog(null,"El rango de busqueda esta limitado a 100 personas");
			}
			if(miVentanaBusquedaSNS.chcIncluidos.isSelected()){
				//recorre y agrega socios habilitados e inhabilitados
				for (int i = 0; i < numRegistros; i++) {
					columna[0] = listapersonas.get(i).getDni();
					columna[1] = listapersonas.get(i).getApellido();
					columna[2] = listapersonas.get(i).getNombre();
					columna[3] = listapersonas.get(i).isHabilitado();
					modeloT.addRow(columna);
				}
			}
			else{
				//recorre y agrega socios habilitados
				for (int i = 0; i < numRegistros; i++) {
					if(listapersonas.get(i).isHabilitado()){
						columna[0] = listapersonas.get(i).getDni();
						columna[1] = listapersonas.get(i).getApellido();
						columna[2] = listapersonas.get(i).getNombre();
						columna[3] = listapersonas.get(i).isHabilitado();
						modeloT.addRow(columna);
					}
				}
			}


			tablaD.getColumnModel().getColumn(3).setMaxWidth(0);

			tablaD.getColumnModel().getColumn(3).setMinWidth(0);

			tablaD.getColumnModel().getColumn(3).setPreferredWidth(0);

			tablaD.setDefaultRenderer(Object.class,miVentanaBusquedaSNS.resaltado);
		}

	}

	public Integer DevolverUltimoIdSocio(){
		return miLogica.DevolverUltimoID();
	}
	public boolean ValidarEsSocio(){
		return this.miVentanaPersona.checkEsSocio.isSelected();
	}
	
	//se encarga de dirigir a la persona
	public void GuardarSocioNosocio(Personas persona,boolean Essocio){
		if(Essocio){
			miLogica.GuardarSocio(persona);
			JOptionPane.showMessageDialog(null, "Se agrego la persona: "+persona.getNombre()+" "+persona.getApellido()+", con el numero de socio: "+persona.getNroSocio());
		}
		else{
			miLogica.GuardarNoSocio(persona);
			JOptionPane.showMessageDialog(null, "Nueva Persona registrada en en la base de datos");
		}
	}
	
	public boolean ValidarDatosPersona(Personas persona){
		boolean retorno=true;
		//datos obligatorio para ambos
		if(persona.getDni()==0 || persona.getNombre()==null || persona.getApellido()==null || persona.getFecNacimiento()==null ||
				persona.getDomicilio()==null || persona.getTelefono()==null)
			retorno=false;
		else{
			//datos obligatorios para socios
			if(miVentanaPersona.checkEsSocio.isSelected()){
				if(persona.getMatricula()==0 || persona.getSexo() == null || persona.getNacionalidad()==null ||
						persona.getEstadoCivil()==null || persona.getFechaIngreso()==null || persona.getCategoria()==null)
					retorno=false;


			}
		}
		return retorno;
	}
	
	public void mostrarVentanaPrincipal(Usuario usuario) {
		miVentanaPrincipal.setTitle("USUARIO: "+this.miLogica.DevolverUsuario(usuario).getNick()+"  TIPO: "+this.miLogica.DevolverUsuario(usuario).getTipousuario());
		if(this.miLogica.DevolverUsuario(usuario).getTipousuario().equals("Administrador"))
			miVentanaPrincipal.btnConfig.setEnabled(true);
		else
			miVentanaPrincipal.btnConfig.setEnabled(false);
		miVentanaPrincipal.setVisible(true);
	}
	public void ocultarVentana(){
		miVentanaPrincipal.setEnabled(false);
	}
	//mostrarVentanaSocio y mostrarVentanaNoSocio es la misma miVentanaPersona
	//Cambia unicamente los nombre de sus componentes 
	public void mostrarVentanaSocio() {
		miVentanaPersona.lblImagen.setIcon(new ImageIcon(PantallaPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/user_person_people_6100.png")));
		miVentanaPersona.lblPersonas.setText("SOCIOS");
		miVentanaPersona.btnAlta.setText("ALTA SOCIO");
		miVentanaPersona.btnBaja.setText("BAJA SOCIO");
		miVentanaPersona.btnBuscar.setText("BUSCAR SOCIO");
		miVentanaPersona.btnModificacion.setText("MODIFICAR SOCIO");
		miVentanaPersona.checkEsSocio.setSelected(true);
		miVentanaPersona.show();// setVisible(true);
	}
	
	public void mostrarVentanaNoSocio() {
		miVentanaPersona.lblImagen.setIcon(new ImageIcon(PantallaPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/bootloader_users_person_people_6080.png")));
		miVentanaPersona.lblPersonas.setText("NO SOCIOS");
		miVentanaPersona.btnAlta.setText("ALTA NO SOCIO");
		miVentanaPersona.btnBaja.setText("BAJA NO SOCIO");
		miVentanaPersona.btnBuscar.setText("BUSCAR NO SOCIO");
		miVentanaPersona.btnModificacion.setText("MODIFICAR NO SOCIO");
		miVentanaPersona.checkEsSocio.setSelected(false);
		miVentanaPersona.setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	public void mostrarFormularioPersona(boolean tipo ) {
		if(tipo){
			//Socios
			this.PosicionarBotonesSocio();
			miFormularioPersona.lblTitulo.setText("FORMULARIO ALTA SOCIOS"); //titulo
			miFormularioPersona.lblIdSocio.setText(String.valueOf(miLogica.DevolverUltimoID())); //muestro el ultimo id cargado
			for(int i=0;i<miFormularioPersona.comboCate.getItemCount();i++){
				miFormularioPersona.comboCate.removeItemAt(i);
		     }
			miFormularioPersona.comboCate.addItem("Seleccione una categoria");
			for(Categoria categoria : miLogica.DevolverListaCategoria()){
				miFormularioPersona.comboCate.addItem(categoria.getNombre()); //Cargo Categorias y sus id
				miFormularioPersona.mapCategoria.put(categoria.getIdCategoria(), categoria.getNombre());
			}
			miFormularioPersona.panelDatosSocios.setVisible(true);
			miFormularioPersona.setVisible(true);
		}
		else{
			//No Socio
			this.PosicionarBotonesNSocio();
			miFormularioPersona.lblTitulo.setText("FORMULARIO ALTA PARA NO SOCIOS");
			miFormularioPersona.panelDatosSocios.setVisible(false);
			miFormularioPersona.setVisible(true);
		}
		
	}
	@SuppressWarnings("unchecked")
	public void mostrarVentanaEliminarSNS(boolean tipo) {
//		miVentanaElimarSNS.setTitle("Mi ventana de baja");
		miVentanaBusquedaSNS.setVisible(true);
		if(tipo){
			//Socios
		}
		else{
			//No Socio
			
		}
		
	}
	
	private void PosicionarBotonesSocio(){
		//textbox
		miFormularioPersona.txtDni.setBounds(101, 8, 173, 20);
		miFormularioPersona.txtApe.setBounds(101, 52, 176, 20);
		miFormularioPersona.txtNom.setBounds(101, 91, 176, 20);
		miFormularioPersona.dateFechNac.setBounds(101, 128, 95, 20);
		miFormularioPersona.txtDom.setBounds(101, 165, 224, 20);
		miFormularioPersona.txtTel.setBounds(101, 204, 173, 20);
		//label
		miFormularioPersona.lblDni.setBounds(10, 11, 43, 14);
		miFormularioPersona.lblApe.setBounds(10, 55, 81, 14);
		miFormularioPersona.lblNom.setBounds(10, 94, 81, 14);
		miFormularioPersona.lblFechNac.setBounds(11, 134, 80, 14);
		miFormularioPersona.lblDom.setBounds(10, 168, 81, 14);
		miFormularioPersona.lblTel.setBounds(10, 207, 81, 14);
	}
	private void PosicionarBotonesNSocio(){
		//textbox
		miFormularioPersona.txtDni.setBounds(300, 21, 173, 20);
		miFormularioPersona.txtApe.setBounds(300, 65, 176, 20);
		miFormularioPersona.txtNom.setBounds(300, 104, 176, 20);
		miFormularioPersona.dateFechNac.setBounds(300, 141, 95, 20);
		miFormularioPersona.txtDom.setBounds(300, 178, 224, 20);
		miFormularioPersona.txtTel.setBounds(300, 217, 173, 20);
		//label
		miFormularioPersona.lblDni.setBounds(200, 21, 173, 20);
		miFormularioPersona.lblApe.setBounds(200, 65, 81, 14);
		miFormularioPersona.lblNom.setBounds(200, 104, 81, 14);
		miFormularioPersona.lblFechNac.setBounds(200, 141, 80, 14);
		miFormularioPersona.lblDom.setBounds(200, 178, 81, 14);
		miFormularioPersona.lblTel.setBounds(200, 217, 81, 14);
	}
	
	public boolean validarUsuario(Usuario usuario){
		if(miLogica.DevolverUsuario(usuario) == null)
			return false;
		else
			return true;
	}
	
	public void GuardarPersonas(Personas entity){
		
	}
	
/*
	public void registrarPersona(PersonaVo miPersona) {
		miLogica.validarRegistro(miPersona);
	}
	
	public PersonaVo buscarPersona(String codigoPersona) {
		return miLogica.validarConsulta(codigoPersona);
	}
	
	public void modificarPersona(PersonaVo miPersona) {
		miLogica.validarModificacion(miPersona);
	}
	public void eliminarPersona(String codigo) {
		miLogica.validarEliminacion(codigo);
	}
*/
}
