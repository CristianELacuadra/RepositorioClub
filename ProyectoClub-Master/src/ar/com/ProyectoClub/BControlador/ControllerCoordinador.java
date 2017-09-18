package ar.com.ProyectoClub.BControlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.dialect.function.VarArgsSQLFunction;

import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.AVista.*;
import ar.com.ProyectoClub.AVista.ClasesRender.Render;
import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.CModelo.Logica;
import ar.com.ProyectoClub.CModelo.AServicios.FechaHora;
import ar.com.ProyectoClub.CModelo.CEntidades.*;
import javassist.compiler.ast.Variable;

public class ControllerCoordinador {
	private Logica miLogica;
	private Principal miVentanaPrincipal;
	private Inicio miVentanaInicio;
	private PantallaFormularioPersona miFormularioPersona;
	private PantallaSocios miVentanaSocios;
	private PantallaBusquedaSNS miVentanaBusquedaSNS;
	private PantallaDetallesInhabilitarSNS miVentanaDetallesSNS;
	private PantallaCobranzaCuota miVentanaCobranza;
	private PantallaBajaSNS miVentanaBajaSNS;
	private PantallaCategoriasTodas miVentanaCategorias;
	private PantallaCaja miVentanaCaja;
	private PantallaIngresoEgreso miventanaIngresoEgreso;
	private PantallaConfiguracion miVentanaConfiguracion;
	private PantallaPrincipalPersonas miVentanaPrincipalPersona;

	//alquiler
	private PantallaAlquiler miVentanaAlquiler;
	private PantallaNuevoAlquiler miVentanaNuevoAlquiler;
	private PantallaBusquedaAlquiler miVentanaBusquedaAlquiler;
	private PantallaNuevoInmueble miVentanaNuevoInmueble;
	private PantallaBusquedaInmueble miVentanaBusquedaInmueble;
	private PantallaNuevoInmueble miVentanaModificarInmueble;
	private PantallaNuevoInmueble miVentanaEliminarInmueble;
	private PantallaNuevoInmueble miVentanaRehabilitarInmueble;

	private PantallaDetallesAlquiler miVentanaModificarAlquiler;
	private PantallaDetallesAlquiler miVentanaEliminarAlquiler;
	private PantallaDetallesAlquiler miVentanaPagarAlquiler;


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

	public PantallaSocios getMiVentanaSocios() {
		return miVentanaSocios;
	}
	public void setMiVentanaSocios(PantallaSocios miVentanaSocios) {
		this.miVentanaSocios = miVentanaSocios;
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
	public PantallaCategoriasTodas getMiVentanaCategorias() {
		return miVentanaCategorias;
	}
	public void setMiVentanaCategorias(PantallaCategoriasTodas miVentanaCategorias) {
		this.miVentanaCategorias = miVentanaCategorias;
	}
	public PantallaCaja getMiVentanaCaja() {
		return miVentanaCaja;
	}
	public void setMiVentanaCaja(PantallaCaja miVentanaCaja) {
		this.miVentanaCaja = miVentanaCaja;
	}
	public PantallaIngresoEgreso getMiventanaIngresoEgreso() {
		return miventanaIngresoEgreso;
	}
	public void setMiventanaIngresoEgreso(PantallaIngresoEgreso miventanaIngresoEgreso) {
		this.miventanaIngresoEgreso = miventanaIngresoEgreso;
	}

	public PantallaConfiguracion getMiVentanaConfiguracion() {
		return miVentanaConfiguracion;
	}
	public void setMiVentanaConfiguracion(PantallaConfiguracion miVentanaConfiguracion) {
		this.miVentanaConfiguracion = miVentanaConfiguracion;
	}

	public PantallaPrincipalPersonas getMiVentanaPrincipalPersona() {
		return miVentanaPrincipalPersona;
	}

	public void setMiVentanaPrincipalPersona(PantallaPrincipalPersonas miVentanaPrincipalPersona) {
		this.miVentanaPrincipalPersona = miVentanaPrincipalPersona;
	}

	/*** alquiler   * */
	public  PantallaAlquiler getMiVentanaAlquiler(){
		return miVentanaAlquiler;
	}
	public void setMiVentanaAlquiler(PantallaAlquiler miVentanaAlquiler){
		this.miVentanaAlquiler=miVentanaAlquiler;
	}

	public  PantallaNuevoAlquiler getMiVentanaNuevoAlquiler(){
		return miVentanaNuevoAlquiler;
	}
	public void setMiVentanaNuevoAlquiler(PantallaNuevoAlquiler miVentanaNuevoAlquiler){
		this.miVentanaNuevoAlquiler=miVentanaNuevoAlquiler;
	} 

	public  PantallaBusquedaAlquiler getMiVentanaBusquedaAlquiler(){
		return miVentanaBusquedaAlquiler;
	}
	public void setMiVentanaBusquedaAlquiler(PantallaBusquedaAlquiler miVentanaBusquedaAlquiler){
		this.miVentanaBusquedaAlquiler=miVentanaBusquedaAlquiler;
	}

	public  PantallaNuevoInmueble getMiVentanaNuevoInmueble(){
		return miVentanaNuevoInmueble;
	}
	public void setMiVentanaNuevoInmueble(PantallaNuevoInmueble miVentanaNuevoInmueble){
		this.miVentanaNuevoInmueble=miVentanaNuevoInmueble;
	}

	public  PantallaBusquedaInmueble getMiVentanaBusquedaInmueble(){
		return miVentanaBusquedaInmueble;
	}
	public void setMiVentanaBusquedaInmueble(PantallaBusquedaInmueble miVentanaBusquedaInmueble){
		this.miVentanaBusquedaInmueble=miVentanaBusquedaInmueble;
	}

	public  PantallaNuevoInmueble getMiVentanaModificarInmueble(){
		return miVentanaModificarInmueble;
	}
	public void setMiVentanaModificarInmueble(PantallaNuevoInmueble miVentanaModificarInmueble){
		this.miVentanaModificarInmueble=miVentanaModificarInmueble;
	}

	public  PantallaNuevoInmueble getMiVentanaEliminarInmueble(){
		return miVentanaEliminarInmueble;
	}
	public void setMiVentanaEliminarInmueble(PantallaNuevoInmueble miVentanaEliminarInmueble){
		this.miVentanaEliminarInmueble=miVentanaEliminarInmueble;
	}

	public  PantallaNuevoInmueble getMiVentanaRehabilitarInmueble(){
		return miVentanaRehabilitarInmueble;
	}
	public void setMiVentanaRehabilitarInmueble(PantallaNuevoInmueble miVentanaRehabilitarInmueble){
		this.miVentanaRehabilitarInmueble=miVentanaRehabilitarInmueble;
	}


	public  PantallaDetallesAlquiler getMiVentanaModificarAlquiler(){
		return miVentanaModificarAlquiler;
	}
	public void setMiVentanaModificarAlquiler(PantallaDetallesAlquiler miVentanaModificarAlquiler){
		this.miVentanaModificarAlquiler=miVentanaModificarAlquiler;
	}
	public  PantallaDetallesAlquiler getMiVentanaEliminarAlquiler(){
		return miVentanaEliminarAlquiler;
	}
	public void setMiVentanaEliminarAlquiler(PantallaDetallesAlquiler miVentanaEliminarAlquiler){
		this.miVentanaEliminarAlquiler=miVentanaEliminarAlquiler;
	}

	public  PantallaDetallesAlquiler getMiVentanaPagarAlquiler(){
		return miVentanaPagarAlquiler;
	}
	public void setMiVentanaPagarAlquiler(PantallaDetallesAlquiler miVentanaPagarAlquiler){
		this.miVentanaPagarAlquiler=miVentanaPagarAlquiler;
	}


	//////////////////////////////////////////////////////////
	//METODOS 
	//Gestion Socio-NoSocio
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void GuardarPersonas(Personas entity){
		miLogica.GuardarSocio(entity);
	}

	public void MostrarVentanaPrincipalPersona(JTable tabla){
		miVentanaPrincipalPersona.setVisible(true);	
	}


	@SuppressWarnings("unchecked")
	public void mostrarFormularioPersona(boolean tipo ) {
		if(tipo){
			//Socios
			miFormularioPersona.setEssocio(tipo); //le paso que es un socio el que se va agregar
			this.PosicionarBotonesSocio();
			miFormularioPersona.lblTitulo.setText("FORMULARIO ALTA SOCIOS"); //titulo
			//miFormularioPersona.lblIdSocio.setText(String.valueOf(miLogica.DevolverUltimoID())); //muestro el ultimo id cargado
			for(int i=0;i<miFormularioPersona.comboCate.getItemCount();i++){
				miFormularioPersona.comboCate.removeItemAt(i);
			}
			miFormularioPersona.comboCate.addItem("Seleccione una categoria");
			for(Categoria categoria : miLogica.DevolverListaCategoria()){
				miFormularioPersona.comboCate.addItem(categoria.getNombre()); //Cargo Categorias y sus id
				miFormularioPersona.mapCategoria.put(categoria.getIdCategoria(), categoria.getNombre());
			}
			//miFormularioPersona.panelDatosSocios.setVisible(true);
			miFormularioPersona.setVisible(true);
		}
		else{
			//No Socio
			miFormularioPersona.setEssocio(tipo);
			this.PosicionarBotonesNSocio();
			miFormularioPersona.lblTitulo.setText("FORMULARIO ALTA PARA NO SOCIOS");
			//miFormularioPersona.panelDatosSocios.setVisible(false);
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
		miFormularioPersona.txtDomNro.setBounds(560,178,60,20);
		miFormularioPersona.txtTel.setBounds(300, 217, 173, 20);
		//label
		miFormularioPersona.lblDni.setBounds(200, 21, 173, 20);
		miFormularioPersona.lblNom.setBounds(200, 104, 81, 14);
		miFormularioPersona.lblApe.setBounds(200, 65, 81, 14);
		miFormularioPersona.lblFechNac.setBounds(200, 141, 80, 14);
		miFormularioPersona.lblDom.setBounds(200, 178, 81, 14);
		miFormularioPersona.lblNro.setBounds(530, 178, 81, 14);
		miFormularioPersona.lblTel.setBounds(200, 217, 81, 14);
	}

	//mostrarVentanaSocio y mostrarVentanaNoSocio es la misma miVentanaPersona
	//Cambia unicamente los nombre de sus componentes 
	@SuppressWarnings("deprecation")
	public void mostrarVentanaSocio() {
		miVentanaSocios.show();// setVisible(true);
	}

	//lanza el proceso que verifica si hay cuotas impagas y cambia el estado a los socios
	public void ProcesarMorosos(){
		miLogica.ProcesoMorosos();
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public void CargarDatosPersona(Personas persona){
		if(miVentanaBajaSNS.isVisible()){ //Carga los datos para la baja
			miVentanaBajaSNS.txtDni.setText(Integer.toString(persona.getDni()));
			miVentanaBajaSNS.txtDom.setText(persona.getDomicilio());
			miVentanaBajaSNS.txtNyA.setText(persona.getNombre()+" "+persona.getApellido());
			miVentanaBajaSNS.txtTel.setText(persona.getTelefono());
			miVentanaBajaSNS.rdbtnNoSocio.setSelected((!persona.isEssocio())?true:false);
			miVentanaBajaSNS.rdbtnSocio.setSelected((persona.isEssocio())?true:false);
			miVentanaBusquedaSNS.dispose();
		}
		else{
			//estable los valores para la ventana socio
			if(miVentanaSocios.isVisible()){
				//Carga los datos de la persona
				miVentanaSocios.txtDom.setText(persona.getDomicilio());
				miVentanaSocios.txtNroDom.setText(persona.getDomNro().toString());
				miVentanaSocios.txtdni.setText(Integer.toString(persona.getDni()));
				miVentanaSocios.txtMatri.setText(Integer.toString(persona.getMatricula()));
				miVentanaSocios.txtNro.setText(Integer.toString(persona.getNroSocio()));
				miVentanaSocios.txtNom.setText(persona.getNombre());
				miVentanaSocios.txtApe.setText(persona.getApellido());
				miVentanaSocios.txtTel.setText(persona.getTelefono());
				miVentanaSocios.dateNac.setDate(persona.getFecNacimiento());
				miVentanaSocios.dateIngre.setDate(persona.getFechaIngreso());
				miVentanaSocios.txtNombreCat.setText(persona.getCategoria().getNombre());
				miVentanaSocios.UltimoIdCategoria=persona.getCategoria().getIdCategoria();
				miVentanaSocios.comboSexo.setSelectedItem(persona.getSexo());
				miVentanaSocios.txtNac.setText(persona.getNacionalidad());
				if(miVentanaSocios.comboCate.getItemCount()>0){
					for(int i=0;i<miVentanaSocios.comboCate.getItemCount();i++){
						miVentanaSocios.comboCate.removeItemAt(i);
					}
				}

				miVentanaSocios.comboCate.addItem("Seleccione una categoria");
				for(Categoria categoria : miLogica.DevolverListaCategoria()){
					miVentanaSocios.comboCate.addItem(categoria.getNombre()); //Cargo Categorias y sus id
					miVentanaSocios.mapCategoria.put(categoria.getIdCategoria(), categoria.getNombre());
				}
				miVentanaSocios.comboEstadoCivil.setSelectedItem(persona.getEstadoCivil());
				this.EnableBotonesVtnSocios(false);					
				miVentanaBusquedaSNS.dispose();	
			}
		}

	}

	public Personas BuscarPersona(Integer dni){
		return miLogica.BuscarSocio(dni);
	}

	@SuppressWarnings("static-access")
	public void EnableBotonesVtnSocios(boolean valor){
		//pongo enable los valores que no se puede modificar
		miVentanaSocios.txtdni.setEditable(valor);
		miVentanaSocios.txtNro.setEditable(valor);
		miVentanaSocios.txtMatri.setEditable(valor);
		miVentanaSocios.txtApe.setEditable(valor);
		miVentanaSocios.txtNom.setEditable(valor);
		miVentanaSocios.txtTel.setEditable(valor);
		miVentanaSocios.dateIngre.setEnabled(valor);
		miVentanaSocios.dateNac.setEnabled(valor);
		miVentanaSocios.btnEditar.setEnabled(!valor);
		miVentanaSocios.btneliminar.setEnabled(!valor);
		miVentanaSocios.btnCobranza.setEnabled(!valor);
		miVentanaSocios.comboEstadoCivil.setEnabled(valor);
		miVentanaSocios.btnBuscar.setEnabled(valor);
		miVentanaSocios.txtDom.setEditable(valor);
		miVentanaSocios.txtNroDom.setEditable(valor);
		miVentanaSocios.txtNac.setEditable(valor);
		miVentanaSocios.comboCate.setEnabled(valor);
		miVentanaSocios.comboSexo.setEnabled(valor);
		miVentanaSocios.txtNro.setEditable(valor);
		miVentanaSocios.txtMatri.setEditable(valor);
		miVentanaSocios.txtNombreCat.setEditable(valor);
	}

//	public void InhabilitarSocio(Integer dni){
//		miLogica.InhabilitarSocio(dni);
//	}

	public void InhabilitarSocio(Integer dni){
		miLogica.InhabilitarSocio(dni);
	}
	
	public void MostrarVentanaDetallesInhabilitar(Integer dni){
		String habiilitado=new String();
		String texto=new String();
		Personas persona=this.CrearPersona();
		persona=miLogica.BuscarSocio(dni);
		if(persona.isHabilitado())
			habiilitado="SI";
		else
			habiilitado="No";
		miVentanaDetallesSNS.setTitle("DETALLES DEL SOCIO ");
		texto ="Numero de socio: "+persona.getNroSocio()+'\n'+""
				+ "Matricula: "+persona.getMatricula()+'\n'+""
				+"DNI: "+persona.getDni()+'\n'+""
				+"Nombre: "+persona.getNombre()+'\n'+""
				+"Apellido: "+persona.getApellido()+'\n'+""
				+"Domicilio: "+persona.getDomicilio()+'\n'+""
				+"Fecha de nacimiento: "+(new SimpleDateFormat("dd-MM-yyyy").format(persona.getFecNacimiento()))+'\n'+""
				+"Telefono: "+persona.getTelefono()+'\n'+""
				+"Sexo: "+persona.getSexo()+'\n'+""
				+"Estado: "+persona.getEstado()+'\n'+""	
				+"Nacionalidad: "+persona.getNacionalidad()+'\n'+""
				+"Estado Civil: "+persona.getEstadoCivil()+'\n'+""
				+"Fecha de Ingreso: "+(new SimpleDateFormat("dd-MM-yyyy").format(persona.getFechaIngreso()))+'\n'+""
				+"Habilitado: "+habiilitado+'\n';
		miVentanaDetallesSNS.textDetalle.setText(texto);
		miVentanaDetallesSNS.setVisible(true);
	}

	private void BusquedaSocios(JTable tabla){
		boolean[] editable= { false,true,false,false,false,false,false,false,false,false };
		DefaultTableModel  modeloT = new DefaultTableModel(){
			
			Class[] type= new Class[]{
					java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
					java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
			};
			public Class getColumnClass(int columnIndex){
				return type[columnIndex];
			}
			
			public boolean isCellEditable(int row,int colum){  
				return editable[colum];
			}
		};
		Object[] columna = new Object[10];
		java.util.List<Personas> listaNoSocios=new ArrayList<Personas>();
		

		tabla.setModel(modeloT);
		modeloT.addColumn("");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("DNI");
		modeloT.addColumn("NOMBRE Y APELLIDO");
		modeloT.addColumn("TELEFONO");
		modeloT.addColumn("DOMICILIO");

		if(miLogica.CantidadSociosRegistrados() > 1000  ){
			int opcion = JOptionPane.showConfirmDialog(null, "La siguiente consulta puede traer una masiva cantidad de datos, "
					+ "Selecione Si desea traer los datos, No si solo quiere traer maximo 100 datos ", "Aviso", JOptionPane.YES_NO_OPTION);
			if (opcion == 0)
				listaNoSocios=miLogica.HistoricosSocios();
			else
				listaNoSocios=miLogica.ListarParcialSocio();
		}
		else
			listaNoSocios=miLogica.HistoricosSocios();
		int numRegistros=listaNoSocios.size();// devuelve un rango de 100 socios

		//recorre y agrega socios habilitados e inhabilitados
		for (int i = 0; i < numRegistros; i++) {			
			columna[0] = listaNoSocios.get(i).isHabilitado();
			columna[1]=  false;//miVentanaPrincipalPersona.ChkNosocio;
			columna[2] = miVentanaPrincipalPersona.btnHabiitado;
			columna[3] = miVentanaPrincipalPersona.btnBaja;
			columna[4] = miVentanaPrincipalPersona.btnDetalles;
			columna[5]=  miVentanaPrincipalPersona.btnEditar;
			columna[6] = listaNoSocios.get(i).getDni();
			columna[7] = listaNoSocios.get(i).getNombre()+" "+listaNoSocios.get(i).getApellido();
			columna[8] = listaNoSocios.get(i).getTelefono();
			columna[9] = listaNoSocios.get(i).getDomicilio();
			modeloT.addRow(columna);
		}

		tabla.setRowHeight(25);
		//oculto la columna de habilitados
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		//tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
		//
		tabla.getColumnModel().getColumn(1).setMaxWidth(30);
		tabla.getColumnModel().getColumn(2).setMaxWidth(60);
		tabla.getColumnModel().getColumn(3).setMaxWidth(60);
		tabla.getColumnModel().getColumn(4).setMaxWidth(60);
		tabla.getColumnModel().getColumn(5).setMaxWidth(60);
		tabla.getColumnModel().getColumn(6).setMaxWidth(200);
		tabla.getColumnModel().getColumn(7).setMaxWidth(400);
		tabla.getColumnModel().getColumn(8).setMaxWidth(200);
		tabla.getColumnModel().getColumn(9).setMaxWidth(600);
		tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);
		
		//		tabla.getColumnModel().getColumn(6).setMaxWidth(0);
		//		tabla.getColumnModel().getColumn(6).setMinWidth(0);
		//		tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
		//		miVentanaBusquedaSNS.btnSeleccionar.setEnabled(true);
		//		//tabla.setDefaultRenderer(Object.class, new JButtonRenderer());
		//		tabla.setDefaultRenderer(Object.class,miVentanaBusquedaSNS.resaltado);
	}

	private void BusquedaNoSocios(JTable tabla){
		boolean[] editable= { false,true,false,false,false,false,false,false,false};
		
		DefaultTableModel  modeloT = new DefaultTableModel(){
			
			Class[] type= new Class[]{
					java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
					java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
			};
			public Class getColumnClass(int columnIndex){
				return type[columnIndex];
			}
			
			public boolean isCellEditable(int row,int colum){  
				return editable[colum];
			}
		};
		
		Object[] columna = new Object[9];
		java.util.List<NoSocioDTO> listaNoSocios=new ArrayList<>();
			
		tabla.setModel(modeloT);
		modeloT.addColumn("");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("DNI");
		modeloT.addColumn("NOMBRE Y APELLIDO");
		modeloT.addColumn("TELEFONO");
		modeloT.addColumn("DOMICILIO");

		tabla.setModel(modeloT);

		listaNoSocios=miLogica.ListaHabilitadosNoSocio();//ListarParcialSocio();

		int numRegistros=listaNoSocios.size();// devuelve un rango de 100 socios


		for (int i = 0; i < numRegistros; i++) {
				columna[0] = listaNoSocios.get(i).isHabilitado();
				columna[1]=	 false;
				columna[2] = miVentanaPrincipalPersona.btnHabiitado; 
				columna[3] = miVentanaPrincipalPersona.btnBaja; 
				columna[4] = miVentanaPrincipalPersona.btnEditar; 
				columna[5] = listaNoSocios.get(i).getDni();
				columna[6] = listaNoSocios.get(i).getNombre()+" "+listaNoSocios.get(i).getApellido();
				columna[7] = listaNoSocios.get(i).getTelefono();
				columna[8] = listaNoSocios.get(i).getDomicilio();
				modeloT.addRow(columna);
		}

		tabla.setRowHeight(25);
		//oculto la columna de habilitados
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		//
		tabla.getColumnModel().getColumn(1).setMaxWidth(40);
		tabla.getColumnModel().getColumn(2).setMaxWidth(40);
		tabla.getColumnModel().getColumn(3).setMaxWidth(40);
		tabla.getColumnModel().getColumn(4).setMaxWidth(40);
		tabla.getColumnModel().getColumn(5).setMaxWidth(200);
		tabla.getColumnModel().getColumn(6).setMaxWidth(400);
		tabla.getColumnModel().getColumn(7).setMaxWidth(200);
		tabla.getColumnModel().getColumn(8).setMaxWidth(600);
		tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);
	}
	
	private void CargarPersonasTodos(JTable tabla,List<Personas> socios,List<NoSocioDTO> noSocios){
		boolean[] editable= { false,true,false,false,false,false,false,false,false,false };
		DefaultTableModel  modeloT = new DefaultTableModel(){
			
			Class[] type= new Class[]{
					java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
					java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
			};
			public Class getColumnClass(int columnIndex){
				return type[columnIndex];
			}
			
			public boolean isCellEditable(int row,int colum){  
				return editable[colum];
			}
		};
		Object[] columna = new Object[10];
		
		tabla.setModel(modeloT);
		modeloT.addColumn("");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("DNI");
		modeloT.addColumn("NOMBRE Y APELLIDO");
		modeloT.addColumn("TELEFONO");
		modeloT.addColumn("DOMICILIO");
		int numRegistros=0;
		
		
		//Carga si esta marcado el socio
		if(!socios.isEmpty() && noSocios.isEmpty()){
			numRegistros=socios.size();
			//recorre y agrega socios habilitados e inhabilitados
			for (int i = 0; i < numRegistros; i++) {			
				columna[0] = socios.get(i).isHabilitado();
				columna[1]=  false;//miVentanaPrincipalPersona.ChkNosocio;
				columna[2] = miVentanaPrincipalPersona.btnHabiitado;
				columna[3] = miVentanaPrincipalPersona.btnBaja;
				columna[4] = miVentanaPrincipalPersona.btnDetalles;
				columna[5]=  miVentanaPrincipalPersona.btnEditar;
				columna[6] = socios.get(i).getDni();
				columna[7] = socios.get(i).getNombre()+" "+socios.get(i).getApellido();
				columna[8] = socios.get(i).getTelefono();
				columna[9] = socios.get(i).getDomicilio();
				modeloT.addRow(columna);
			}
		}
		
		//Carga no socio
		if(socios.isEmpty() && !noSocios.isEmpty()){
			numRegistros=noSocios.size();
			//recorre y agrega socios habilitados e inhabilitados
			for (int i = 0; i < numRegistros; i++) {			
				columna[0] = noSocios.get(i).isHabilitado();
				columna[1]=  false;//miVentanaPrincipalPersona.ChkNosocio;
				columna[2] = miVentanaPrincipalPersona.btnHabiitado;
				columna[3] = miVentanaPrincipalPersona.btnBaja;
				columna[4] = miVentanaPrincipalPersona.btnDetalles;
				columna[5]=  miVentanaPrincipalPersona.btnEditar;
				columna[6] = noSocios.get(i).getDni();
				columna[7] = noSocios.get(i).getNombre()+" "+noSocios.get(i).getApellido();
				columna[8] = noSocios.get(i).getTelefono();
				columna[9] = noSocios.get(i).getDomicilio();
				modeloT.addRow(columna);
			}
		}
		
		//Cargar Todos
		if(socios.isEmpty() && noSocios.isEmpty()){
			miLogica.ListarPersonasTodos();
			//llamo para que cargue todo
		}
		

		

		tabla.setRowHeight(25);
		//oculto la columna de habilitados
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		//tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
		//
		tabla.getColumnModel().getColumn(1).setMaxWidth(30);
		tabla.getColumnModel().getColumn(2).setMaxWidth(60);
		tabla.getColumnModel().getColumn(3).setMaxWidth(60);
		tabla.getColumnModel().getColumn(4).setMaxWidth(60);
		tabla.getColumnModel().getColumn(5).setMaxWidth(60);
		tabla.getColumnModel().getColumn(6).setMaxWidth(200);
		tabla.getColumnModel().getColumn(7).setMaxWidth(400);
		tabla.getColumnModel().getColumn(8).setMaxWidth(200);
		tabla.getColumnModel().getColumn(9).setMaxWidth(600);
		tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);

	}

	public void CargarGrilla(JTable tabla){
		 if(miVentanaPrincipalPersona.checkTodos.isSelected())
		 {
			 
		 }
			BusquedaSocios(tabla);
		 else
			BusquedaNoSocios(tabla);
	}

	public Integer DevolverUltimoIdSocio(){
		return miLogica.DevolverUltimoID();
	}

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
		//	if(persona.getDomNro()==0 || persona.getDni()==0 || persona.getNombre()==null || persona.getApellido()==null || persona.getFecNacimiento()==null ||
		//			persona.getDomicilio()==null || persona.getTelefono()==null)
		//		retorno=false;
		//	else{
		//datos obligatorios para socios
		if(miFormularioPersona.isEssocio()){
			if(persona.getMatricula()==0 || persona.getSexo() == null || persona.getNacionalidad()==null ||
					persona.getEstadoCivil()==null || persona.getFechaIngreso()==null || persona.getCategoria()==null)
				retorno=false;


		}
		//}
		return retorno;
	}

	public void mostrarVentanaNoSocio() {
		///------------------------------------------------------------------------completar
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Gestion Cuotas
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	public void CobrarCuota(Integer dni,java.util.List<Integer> IdCuotas){
		miLogica.CobranzaCuotas(dni, IdCuotas);
	}

	public void CargarDatosCobranza(Personas persona,JTable tabla){

		java.util.List<Cuota> cuotasSocio= new ArrayList<Cuota>();
		//Datos persona
		miVentanaCobranza.txtdni.setText(Integer.toString(persona.getDni()));
		miVentanaCobranza.txtDomi.setText(persona.getDomicilio());
		miVentanaCobranza.txtMatri.setText(Integer.toString(persona.getMatricula()));
		miVentanaCobranza.txtNsocio.setText(Integer.toString(persona.getNroSocio()));
		miVentanaCobranza.txtNyA.setText(persona.getNombre()+" "+persona.getApellido());
		miVentanaCobranza.txtTel.setText(persona.getTelefono());
		miVentanaCobranza.txtCat.setText(persona.getCategoria().getNombre());

		//cuota
		boolean[] editable = {false,false,false,false,true,false};

		tabla.setDefaultRenderer(Object.class, new Render());

		DefaultTableModel modeloT = new DefaultTableModel(new String[]{"MES", "AÑO", "FECHA PAGO", "IMPORTE","",""}, 0) {

			Class[] types = new Class[]{
					java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class
			};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int row, int column){
				return editable[column];
			}
		};
		Object[] columna = new Object[6];

		cuotasSocio=miLogica.ObtenerCuotasSocios(persona);
		int numRegistros=cuotasSocio.size();

		float total=0;
		Date fechaG= new Date();
		for (int i = 0; i < numRegistros; i++) {
			int mm,aaaa;
			fechaG=cuotasSocio.get(i).getFechaGeneracion();
			mm=fechaG.getMonth();
			aaaa=fechaG.getYear();
			columna[0] = mm+1;
			columna[1] = aaaa+1900;
			if(cuotasSocio.get(i).getFechaPago() ==null){
				columna[2] = "No Presenta Pagos";
				total+=cuotasSocio.get(i).getImporte();
			}
			else
				columna[2] = cuotasSocio.get(i).getFechaPago();
			columna[3] = cuotasSocio.get(i).getImporte();
			columna[4]=false;
			columna[5] = cuotasSocio.get(i).getId();
			modeloT.addRow(columna);
		}
		tabla.setModel(modeloT);
		tabla.setRowHeight(25); 
		tabla.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(30);
		tabla.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0); 

		miVentanaCobranza.txttotal.setText(String.valueOf(total));
		miVentanaCobranza.setVisible(true);
	}

	public void mostrarVentanaCobranza(Personas persona,JTable tabla){
		this.CargarDatosCobranza(persona,tabla);

	}

	@SuppressWarnings("deprecation")
	public void ConsultarUltimaGeneracionCuota(){
		Date fechaGene= new Date();
		fechaGene= miLogica.FechaUltimaGeneracionCuota(); 
		miVentanaConfiguracion.dateUltGeneracion.setDate(fechaGene);
		Date fechaProx= new Date();
		fechaProx=miLogica.sumarFechasDias(fechaGene);
		fechaProx.setDate(01);
		miVentanaConfiguracion.dateProxGeneracion.setDate(fechaProx);
	}

	//Generacion Automatica
	@SuppressWarnings("deprecation")
	public void LanzarPrcesoAutGeneracionCuota(){
		if(FechaHora.FechaActual().getDate()==01){
			miLogica.LanzarPrcesoGeneracionCuota();
		}
	}

	//Generacion Creada por el usuario Administrador
	public void LanzarPrcesoUsuGeneracionCuota(){
		miLogica.LanzarPrcesoGeneracionCuota();
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Gestion Categorias
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	public java.util.List<Categoria> ListarCategorias(){
		return miLogica.DevolverListaCategoria();
	}

	public void MostrarPantallaCategorias(JTable tabla){
		java.util.List<Categoria> categorias=new ArrayList<Categoria>();
		DefaultTableModel  modeloT = new DefaultTableModel(){
			public boolean isCellEditable(int row,int colum){  //la filas de mi tabla no pueden ser editable
				return false;
			}
		};

		Object[] columna = new Object[2];
		tabla.setModel(modeloT);
		modeloT.addColumn("ID");
		modeloT.addColumn("NOMBRES");
		categorias=miLogica.DevolverListaCategoria();

		int numRegistros=categorias.size();
		for (int i = 0; i < numRegistros; i++) {
			if(categorias.get(i).isHabilitado()){
				columna[0] = categorias.get(i).getIdCategoria();
				columna[1] = categorias.get(i).getNombre();
				modeloT.addRow(columna);
			}
		}
		tabla.setRowHeight(25);
		tabla.getColumnModel().getColumn(0).setMaxWidth(50);
		//tabla.getColumnModel().getColumn(1).setMaxWidth(750);
		miVentanaCategorias.setVisible(true);
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Gestion Caja
	//---------------------------------------------------------------------------------------------------------------------------------------------------	

	public void MostrarVentanaIngresoEgreso(){
		if(miventanaIngresoEgreso.isEsIngreso())
			miventanaIngresoEgreso.txtTipo.setText("Ingreso");
		else
			miventanaIngresoEgreso.txtTipo.setText("Egreso");
		miventanaIngresoEgreso.setVisible(true);
	}

	public Caja CrearRegistroCaja(){
		return miLogica.CrearInstanciaCaja();
	}

	public void GuardarIngresoEgreso(Caja registro){
		if(miventanaIngresoEgreso.isEsIngreso())
			registro.setTipo(true);
		else
			registro.setTipo(false);
		miLogica.GuardarIngresoEgreso(registro);
	}

	public void CerrarVentanaIngEgre(){
		miventanaIngresoEgreso.dispose();
	}

	public void MostrarVentanaCaja(JTable tabla){
		miVentanaCaja.show();
		miVentanaCaja.lblUsuario.setText(miVentanaPrincipal.getTitle());
		miVentanaCaja.chcEgresos.setSelected(true);
		miVentanaCaja.chckIngresos.setSelected(true);
		tabla.setRowHeight(25);
		//fecha
		tabla.getColumnModel().getColumn(0).setMaxWidth(110);
		//descripcion
		tabla.getColumnModel().getColumn(1).setMaxWidth(1000);
		//tipo
		tabla.getColumnModel().getColumn(2).setMaxWidth(90);
		//importe
		tabla.getColumnModel().getColumn(3).setMaxWidth(150);

	}

	private boolean ValidarUltimoIngreso(){
		//me fijo si esta vacia la caja
		int total=miLogica.TotalRegistradoCaja().size();
		if(total==0){
			return false;
		}
		else
			//miVentanaCaja.txtIngrPlata.setEnabled(false);
			//miVentanaCaja.btnIngresoMonto.setEnabled(false);
			return true;

	}

	public void BuscarCajaParametros(Date FechaDesde,Date FechaHasta,String Descripcion,boolean Ingreso,boolean Egreso,JTable tabla){
		if(!this.ValidarUltimoIngreso()){ // valida si hay registros en la caja
			JOptionPane.showMessageDialog(null,"No se encuentra registro en la base de datos,Por favor ingrese un monto inicial ","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			java.util.List<Caja> cajas=new ArrayList<Caja>();
			float SubTotal=0;
			DefaultTableModel  modeloT = new DefaultTableModel(){
				public boolean isCellEditable(int row,int colum){  //la filas de mi tabla no pueden ser editable
					return false;
				}
			};

			Object[] columna = new Object[4];
			tabla.setModel(modeloT);
			modeloT.addColumn("FECHA");
			modeloT.addColumn("DESCRIPCION");
			modeloT.addColumn("TIPO");
			modeloT.addColumn("MONTO");
			cajas=miLogica.BuscarCajasParametros(FechaDesde, FechaHasta, Descripcion, Ingreso, Egreso);
			int numRegistros=cajas.size();
			for (int i = 0; i < numRegistros; i++) {
				columna[0] = cajas.get(i).getFecha();
				columna[1] = cajas.get(i).getDescripcion();
				if(cajas.get(i).isTipo()){
					columna[2] = "I";
					SubTotal += cajas.get(i).getMonto(); //suma el subtotal
				}
				else{
					columna[2]="E";
					SubTotal -= cajas.get(i).getMonto();//resta el subtotal
				}
				columna[3]= String.valueOf(cajas.get(i).getMonto()); 
				modeloT.addRow(columna);
			}
			//fecha
			tabla.getColumnModel().getColumn(0).setMaxWidth(110);
			//descripcion
			tabla.getColumnModel().getColumn(1).setMaxWidth(1000);
			//tipo
			tabla.getColumnModel().getColumn(2).setMaxWidth(90);
			//importe
			tabla.getColumnModel().getColumn(3).setMaxWidth(150);
			miVentanaCaja.txtSubTotal.setText(String.valueOf(SubTotal));
		}
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Gestion Configuracion
	//---------------------------------------------------------------------------------------------------------------------------------------------------

	public void CerraConfiguracion(){
		miVentanaConfiguracion.dateProxGeneracion.setDate(null);
		miVentanaConfiguracion.dateUltGeneracion.setDate(null);
		miVentanaConfiguracion.dispose();
	}
	public void MostrarVentnaConfiguracion(){
		miVentanaConfiguracion.setVisible(true);
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Principal y loggin
	//---------------------------------------------------------------------------------------------------------------------------------------------------	
	public void mostrarVentanaPrincipal(Usuario usuario) {
		miVentanaPrincipal.setTitle("USUARIO: "+this.miLogica.DevolverUsuario(usuario).getNick()+"  TIPO: "+this.miLogica.DevolverUsuario(usuario).getTipousuario());
		if(this.miLogica.DevolverUsuario(usuario).getTipousuario().equals("Administrador"))
			miVentanaPrincipal.btnConfig.setEnabled(true);
		else
			miVentanaPrincipal.btnConfig.setEnabled(false);
		miVentanaPrincipal.setVisible(true);
	}
	public void mostrarVentanaPrincipal() {
		miVentanaPrincipal.setVisible(true);
	}
	public void ocultarVentanaPrincipal(){
		miVentanaPrincipal.setVisible(false);
	}

	public boolean validarUsuario(Usuario usuario){
		if(miLogica.DevolverUsuario(usuario) == null)
			return false;
		else
			return true;
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------




	public void mostrarVentanaAlquiler(){
		miVentanaAlquiler.setVisible(true);

	}
	public void mostrarVentanaNuevoAlquiler(){
		miVentanaNuevoAlquiler.cargarCombo();//carga los componentes obligatorios de la pantalla
		miVentanaNuevoAlquiler.setVisible(true);
	}
	public void mostrarVentanaBusquedaAlquiler(){
		miVentanaBusquedaAlquiler.setVisible(true);
	}
	public void mostrarVentanaNuevoInmueble(){

		miVentanaNuevoInmueble.setVisible(true);
	}
	public void mostrarVentanaBusquedaInmueble(){
		miVentanaBusquedaInmueble.setVisible(true);
	}

	public void mostrarVentanaModificarInmueble(Inmuebles entity){
		miVentanaModificarInmueble.mostrarDat(entity);
		miVentanaModificarInmueble.setVisible(true);
	}
	public void mostrarVentanaEliminarInmuelble(Inmuebles entity){
		miVentanaEliminarInmueble.mostrarDat(entity);
		miVentanaEliminarInmueble.setVisible(true);
	}
	public void mostrarVentanaRehabilitarInmueble(Inmuebles entity){
		miVentanaRehabilitarInmueble.mostrarDat(entity);
		miVentanaRehabilitarInmueble.setVisible(true);
	}


	public void mostrarVentanaModificarAlquiler(){
		miVentanaModificarAlquiler.setVisible(true);
	}
	public void mostrarVentanaEliminaralquiler(){
		miVentanaEliminarAlquiler.setVisible(true);
	}
	public void mostrarVentanaPagarAlquiler(){
		miVentanaPagarAlquiler.setVisible(true);
	}

	public Inmuebles BuscarInmueble(Integer id) {
		return miLogica.BuscarInmueble(id);
	}

	public Inmuebles CrearInmueble() {
		return miLogica.CrearInstanciaInmueble();
	}

	public void listarInmuebles(JTable jtdatos, String text, boolean selected) {
		miLogica.ListarInmuebles(jtdatos, text, selected);

	}
	public java.util.List<Inmuebles> ListarInmueblesAlquiler(){
		return miLogica.ListarInmueblesParaAlquiler();
	}


	public Alquiler CrearAlquiler() {

		return miLogica.CrearInstanciaAlquiler();

	}

	public float CalcularPrecioTotal(Alquiler alqui, Personas pers, Inmuebles inm) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void RegistrarInmueble(Inmuebles entity) {
		entity.setHabilitado(true);
		miLogica.GuardarInmueble(entity);

	}

	public void ModificarInmueble(Inmuebles inm) {
		miLogica.ModificarInmueble(inm);

	}

	public void EliminarInmueble(Inmuebles inm) {
		miLogica.EliminarInmueble(inm);

	}

	public void RestaurarInmueble(Inmuebles inm) {
		miLogica.RestaurarInmueble(inm);

	}

	public void RegistrarNuevoAlquiler(Alquiler alqui) {
		miLogica.GuardarAlquiler(alqui);

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
