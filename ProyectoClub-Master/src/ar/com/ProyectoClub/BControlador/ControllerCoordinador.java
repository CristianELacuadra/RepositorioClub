package ar.com.ProyectoClub.BControlador;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private PantallaCobranzaCuota miVentanaCobranza;
	private PantallaBajaSNS miVentanaBajaSNS;
	
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
	public PantallaCobranzaCuota getMiVentanaCobranza() {
		return miVentanaCobranza;
	}
	public void setMiVentanaCobranza(PantallaCobranzaCuota miVentanaCobranza) {
		this.miVentanaCobranza = miVentanaCobranza;
	}
	
	public PantallaBajaSNS getMiVentanaBajaSNS() {
		return miVentanaBajaSNS;
	}
	public void setMiVentanaBajaSNS(PantallaBajaSNS miVentanaBajaSNS) {
		this.miVentanaBajaSNS = miVentanaBajaSNS;
	}
//////////////////////////////////////////////////////////
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void CargarDatosPersona(Personas persona){
		if(miVentanaBajaSNS.isVisible()){ //Carga los datos para la baja
			miVentanaBajaSNS.txtDni.setText(Integer.toString(persona.getDni()));
			miVentanaBajaSNS.txtDom.setText(persona.getDomicilio());
			miVentanaBajaSNS.txtNyA.setText(persona.getDni()+" "+persona.getApellido());
			miVentanaBajaSNS.txtTel.setText(persona.getTelefono());
		}
		else{
			if(miVentanaCobranza.isVisible()){ // carga los datos para la cobranza
              miVentanaCobranza.txtdni.setText(Integer.toString(persona.getDni()));
              miVentanaCobranza.txtDomi.setText(persona.getDomicilio());
              miVentanaCobranza.txtMatri.setText(Integer.toString(persona.getMatricula()));
              miVentanaCobranza.txtNsocio.setText(Integer.toString(persona.getNroSocio()));
              miVentanaCobranza.txtNyA.setText(persona.getDni()+" "+persona.getApellido());
              miVentanaCobranza.txtTel.setText(persona.getTelefono());
              miVentanaCobranza.txtCat.setText(persona.getCategoria().getNombre());
			}
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Personas BuscarPersona(Integer dni){
		return miLogica.BuscarSocio(dni);
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void InhabilitarSNS(Integer dni){
		 Personas persona=this.CrearPersona();
		 persona=miLogica.BuscarSocio(dni);
		 if(persona.isHabilitado() && persona != null){
			 int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente deseas inhabilitar esta persona?", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) { //The ISSUE is here
					persona.setHabilitado(false);
					 miLogica.GuardarSocio(persona);
				}
		 }
		 else
			 JOptionPane.showMessageDialog(null,"la persona ya se encuentra inhabilitada");
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void MostrarVentanaDetallesInhabilitar(Integer dni){
		String habiilitado=new String();
		String texto=new String();
		
		Personas persona=this.CrearPersona();
		persona=miLogica.BuscarSocio(dni);
		if(persona.isHabilitado())
			habiilitado="Habilitado: "+"SI";
		else
			habiilitado="Habilitado: "+"No";
		if(persona.isEssocio()){
			miVentanaDetallesSNS.setTitle("DETALLES DEL SOCIO ");
			texto ="Numero de socio: "+persona.getNroSocio()+'\n'+""
					+ "Matricula: "+persona.getMatricula()+'\n'+""
					+"DNI: "+persona.getDni()+'\n'+""
					+"Nombre: "+persona.getNombre()+'\n'+""
					+"Apellido: "+persona.getApellido()+'\n'+""
					+"Domicilio: "+persona.getDomicilio()+'\n'+""
					+"Fecha de nacimiento: "+persona.getFecNacimiento()+'\n'+""
					+"Telefono: "+persona.getTelefono()+'\n'+""
					+"Sexo: "+persona.getSexo()+'\n'+""
					+"Estado: "+persona.getEstado()+'\n'+""
					+"Nacionalidad: "+persona.getNacionalidad()+'\n'+""
					+"Estado Civil: "+persona.getEstadoCivil()+'\n'+""
					+"Fecha de Ingreso: "+persona.getFechaIngreso()+'\n'+""
					+"Habilitado: "+habiilitado+'\n';
		}
		else{
			miVentanaDetallesSNS.setTitle("DETALLES DEL NO SOCIO ");
			texto ="DNI: "+persona.getDni()+'\n'+""
					+"Nombre: "+persona.getNombre()+'\n'+""
					+"Apellido: "+persona.getApellido()+'\n'+""
					+"Domicilio: "+persona.getDomicilio()+'\n'+""
					+"Fecha de nacimiento: "+persona.getFecNacimiento()+'\n'+""
					+"Estado: "+persona.getEstado()+'\n'+""
					+"Habilitado: "+habiilitado+'\n';
		}
		miVentanaDetallesSNS.textDetalle.setText(texto);
		miVentanaDetallesSNS.setVisible(true);
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void Listar(JTable tablaD,String nom,String ape,String dni){
			DefaultTableModel  modeloT = new DefaultTableModel(){
				public boolean isCellEditable(int row,int colum){  //la filas de mi tabla no pueden ser editable
					return false;
				}
			};
			Object[] columna = new Object[5];
			java.util.List<Personas> listapersonas=new ArrayList<Personas>();
			JButton btnDetalles=new JButton();
			btnDetalles.setText("");
			btnDetalles.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Search.png"));

			tablaD.setModel(modeloT);

			modeloT.addColumn("DNI");
			modeloT.addColumn("APELLIDOS");
			modeloT.addColumn("NOMBRES");
			modeloT.addColumn("DETALLE");
			modeloT.addColumn("");
			//modeloT.isCellEditable(row, column)

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
					columna[3]=btnDetalles;
					columna[4] = listapersonas.get(i).isHabilitado();
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
						columna[3]=btnDetalles;
						columna[4] = listapersonas.get(i).isHabilitado();
						modeloT.addRow(columna);
					}
				}
			}
			
			

			tablaD.setRowHeight(25); 
			tablaD.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0); 
			tablaD.getColumnModel().getColumn(3).setMaxWidth(70);
			//tablaD.getColumnModel().getColumn(3).setPreferredWidth(30);
			
			tablaD.getColumnModel().getColumn(4).setMaxWidth(0);
			tablaD.getColumnModel().getColumn(4).setMinWidth(0);
			tablaD.getColumnModel().getColumn(4).setPreferredWidth(0);
			
			//tablaD.setDefaultRenderer(Object.class, new JButtonRenderer());
			tablaD.setDefaultRenderer(Object.class,miVentanaBusquedaSNS.resaltado);
			
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
	public void mostrarVentanaCobranza(){
		miVentanaCobranza.setVisible(true);
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
	//mustra ventana busqueda para obtener un socio para cobrar
	public void MostrarVentanaBusqueda(){
		miVentanaBusquedaSNS.setVisible(true);
	}
	
	public void MostrarVentanaBajaSNS(){
		miVentanaBajaSNS.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	public void mostrarVentanaBusquedaSNS() {
		miVentanaBusquedaSNS.setVisible(true);
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
