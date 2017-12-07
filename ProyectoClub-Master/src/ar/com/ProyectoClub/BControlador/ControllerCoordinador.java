package ar.com.ProyectoClub.BControlador;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ar.com.ProyectoClub.AVista.*;
import ar.com.ProyectoClub.AVista.ClasesRender.Render;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IService;
import ar.com.ProyectoClub.CModelo.AServicios.facade.Service;
import ar.com.ProyectoClub.CModelo.CEntidades.*;

public class ControllerCoordinador {
	//Objeto a mi modelo de servicio
	private IService modeloService;

	private Principal miVentanaPrincipal;
	private Inicio miVentanaInicio;
	private PantallaFormularioPersona miFormularioPersona;
	private PantallaBusquedaSNS miVentanaBusquedaSNS;
	private PantallaCobranzaCuota miVentanaCobranza;
	private PantallaCaja miVentanaCaja;
	private PantallaIngresoEgreso miventanaIngresoEgreso;
	private PantallaConfiguracion miVentanaConfiguracion;
	private PantallaPrincipalPersonas miVentanaPrincipalPersona;
	private PantallaDetallesInhabilitarSNS miVentanaDetallesSNS;
	private PantallaConfiguracionCategoria miVentanaConfCategoria ;

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

	public ControllerCoordinador() {
		modeloService=new Service();
	}

	public Personas CrearPersona(){
		return modeloService.CrearInstanciaPersona();
	}

	public Categoria CrearCategoria(){
		return modeloService.CrearInstanciaCategoria();
	}

	public Socios CrearSocio(){
		return modeloService.CrearInstanciaSocio();
	}
	
	public Categoria BuscarCategoria(Integer idcategoria){
		return modeloService.BuscarCategoria(idcategoria);
	}

	public PantallaFormularioPersona getMiFormularioPersona() {
		return miFormularioPersona;
	}

	public void setMiFormularioPersona(PantallaFormularioPersona miFormularioPersona) {
		this.miFormularioPersona = miFormularioPersona;
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

	public IService getModeloService() {
		return modeloService;
	}

	public void setModeloService(IService modeloService) {
		this.modeloService = modeloService;
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

	public PantallaConfiguracionCategoria getMiVentanaConfCategoria() {
		return miVentanaConfCategoria;
	}
	
	public void setMiVentanaConfCategoria(PantallaConfiguracionCategoria miVentanaConfCategoria) {
		this.miVentanaConfCategoria = miVentanaConfCategoria;
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
	public void ObtenerPersonaNomApe(String nom, String ape) {
		List<Personas> listaPersonas= modeloService.ObtenerPersonaNomApe(nom,ape);
		if(!listaPersonas.isEmpty())
			CargarGrilla(PantallaPrincipalPersonas.tablaPersona, listaPersonas);
	}

	public void HabilitarPersona(int dni) {
		modeloService.HabilitarPersona(dni);
		
	}

	public Personas ValidarPersona(int dni) {
		return modeloService.ValidarPersona(dni);
		
	}
	
	public void LimpiarDetallePersona() {
		miVentanaDetallesSNS.textDetalle.setText(null);
		miVentanaDetallesSNS.textPanelDetalleSocio.setText(null);
	}
	
	public void MostrarVentanaDetallesInhabilitar(int dni) {
		String habiilitado=new String();
		String Essocio=new String();
		String textoPersona=new String();
		String textoSocio=new String();
		Personas persona=this.CrearPersona();
		miVentanaDetallesSNS.setTitle("DETALLES");
		persona=modeloService.BuscarPersona(dni);
		
		habiilitado= persona.isHabilitado() ? "SI" : "NO";
		Essocio=persona.getSocios() != null ? "SI" : "NO";
		String[] partes = persona.getDomicilio().split("-");
		String domicilio=partes[0]+" Nº "+partes[1];

		textoPersona ="Domicilio: "+domicilio+'\n'+""
				+"Fecha de nacimiento: "+(new SimpleDateFormat("dd-MM-yyyy").format(persona.getFechanac()))+'\n'+""
				+"Sexo: "+persona.getSexo()+'\n'+""
				+"Nacionalidad: "+persona.getNacionalidad()+'\n'+""
				+"Estado Civil: "+persona.getEstadocivil()+'\n'+""
				+"Habilitado: "+habiilitado+'\n'+"";
		miVentanaDetallesSNS.textDetalle.setText(textoPersona);
		if(persona.getSocios() != null){
			textoSocio = "Matricula: "+persona.getSocios().getMatricula()+'\n'+""
					+"Estado: "+persona.getSocios().getEstado()+'\n'+""	
					+"Fecha de Ingreso: "+(new SimpleDateFormat("dd-MM-yyyy").format(persona.getSocios().getFechaingreso()))+'\n'+"";
			miVentanaDetallesSNS.textPanelDetalleSocio.setText(textoSocio);
		}
		miVentanaDetallesSNS.setVisible(true);
	}
	
	public void GuardarPersona(Personas personas){
		modeloService.GuardarPersona(personas);
	}

	public void MostrarVentanaPrincipalPersona(JTable tabla){
		miVentanaPrincipalPersona.setVisible(true);	
		this.CargarGrilla(tabla);
	}
	@SuppressWarnings("unchecked")
	public void mostrarFormularioPersona(){
		//Limpia el combo de categoria y lo vuelve agragar
		for(int i=0;i<miFormularioPersona.comboCate.getItemCount();i++){
			miFormularioPersona.comboCate.removeItemAt(i);
		}
		miFormularioPersona.comboCate.addItem("Seleccione una categoria");
		for(Categoria categoria : modeloService.DevolverListaCategoria()){
			if(categoria.isHabilitado()){ //si esta habilitada la categoria
				miFormularioPersona.comboCate.addItem(categoria.getIdCategoria()+"-"+categoria.getNombre()); //Cargo Categorias y sus id
				miFormularioPersona.mapCategoria.put(categoria.getIdCategoria(), categoria.getNombre());
			}
		}
		miFormularioPersona.setVisible(true);
	}

	//mustra ventana busqueda para obtener un socio para cobrar
	public void MostrarVentanaBusqueda(){
		miVentanaBusquedaSNS.setVisible(true);
	}


	@SuppressWarnings("unchecked")
	public void mostrarVentanaBusquedaSNS() {
		miVentanaBusquedaSNS.setVisible(true);
	}


//	//lanza el proceso que verifica si hay cuotas impagas y cambia el estado a los socios
//	public void ProcesarMorosos(){
//		miLogica.ProcesoMorosos();
//	}
	

	public Personas BuscarPersona(Integer dni){
		return modeloService.BuscarPersona(dni);
	}


	public void InhabilitarPersona(Integer dni){
		modeloService.InhabilitarPersona(dni);
	}

	private void BusquedaSocios(JTable tabla){
	}

	@SuppressWarnings("serial")
	public void CargarGrilla(JTable tabla){
		
		boolean[] editable= { false,false,true,false,false,false,false,false,false,false,false };
		DefaultTableModel  modeloT = new DefaultTableModel(){
			
			Class[] type= new Class[]{
					java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
					java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
			};
			public Class getColumnClass(int columnIndex){
				return type[columnIndex];
			}
			
			public boolean isCellEditable(int row,int colum){  
				return editable[colum];
			}
		};
		Object[] columna = new Object[12];
		
		tabla.setModel(modeloT);
		modeloT.addColumn("");
		modeloT.addColumn("");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("DNI");
		modeloT.addColumn("NOMBRE Y APELLIDO");
		modeloT.addColumn("TELEFONO");
		modeloT.addColumn("DOMICILIO");
		java.util.List<Personas> listaPersona = modeloService.ListarPersonas();

        int numRegistros=listaPersona.size();// devuelve un rango de 100 socios
        if(numRegistros>0){
        	
        	for (int i = 0; i < numRegistros; i++) {
        		columna[0] = listaPersona.get(i).isHabilitado();
        		columna[1] = (listaPersona.get(i).getSocios() != null && !listaPersona.get(i).getSocios().isBaja())? true:false;
        		columna[2]=  false;//miVentanaPrincipalPersona.ChkNosocio;
        		columna[3] = miVentanaPrincipalPersona.btnHabiitado;
        		columna[4] = miVentanaPrincipalPersona.btnBaja;
        		columna[5] = miVentanaPrincipalPersona.btnDetalles;
        		columna[6]=  miVentanaPrincipalPersona.btnEditar;
        		columna[7] =miVentanaPrincipalPersona.btnCuotas;
        		columna[8] = listaPersona.get(i).getDni();
        		columna[9] = listaPersona.get(i).getNombre()+" "+listaPersona.get(i).getApellido();
        		columna[10] = listaPersona.get(i).getTelefono();
        		//Saco el - del nombre de domicilio y su numero
        		String[] partes =listaPersona.get(i).getDomicilio().split("-");
        		String domicilio=partes[0]+" "+partes[1];
        		columna[11] = domicilio;
        		modeloT.addRow(columna);
        	}
        	tabla.setRowHeight(25);
        	tabla.getColumnModel().getColumn(0).setMinWidth(0);
        	tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        	tabla.getColumnModel().getColumn(1).setMinWidth(0);
        	tabla.getColumnModel().getColumn(1).setMaxWidth(0);
        	tabla.getColumnModel().getColumn(2).setMaxWidth(30);
        	tabla.getColumnModel().getColumn(3).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(4).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(5).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(6).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(7).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(8).setMaxWidth(200);
        	tabla.getColumnModel().getColumn(9).setMaxWidth(400);
        	tabla.getColumnModel().getColumn(10).setMaxWidth(200);
        	tabla.getColumnModel().getColumn(11).setMaxWidth(600);
        	tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);
        }
	}
	@SuppressWarnings("serial")
	public void CargarGrilla(JTable tabla,List<Personas> listaPersonas){
		
		boolean[] editable= { false,false,true,false,false,false,false,false,false,false,false };
		DefaultTableModel  modeloT = new DefaultTableModel(){
			
			Class[] type= new Class[]{
					java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
					java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
			};
			public Class getColumnClass(int columnIndex){
				return type[columnIndex];
			}
			
			public boolean isCellEditable(int row,int colum){  
				return editable[colum];
			}
		};
		Object[] columna = new Object[12];
		
		tabla.setModel(modeloT);
		modeloT.addColumn("");
		modeloT.addColumn("");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("  ");
		modeloT.addColumn("DNI");
		modeloT.addColumn("NOMBRE Y APELLIDO");
		modeloT.addColumn("TELEFONO");
		modeloT.addColumn("DOMICILIO");

        int numRegistros=listaPersonas.size();// devuelve un rango de 100 socios
        if(numRegistros>0){
        	
        	for (int i = 0; i < numRegistros; i++) {
        		columna[0] = listaPersonas.get(i).isHabilitado();
        		columna[1] = (listaPersonas.get(i).getSocios() != null && !listaPersonas.get(i).getSocios().isBaja())? true:false;
        		columna[2]=  false;//miVentanaPrincipalPersona.ChkNosocio;
        		columna[3] = miVentanaPrincipalPersona.btnHabiitado;
        		columna[4] = miVentanaPrincipalPersona.btnBaja;
        		columna[5] = miVentanaPrincipalPersona.btnDetalles;
        		columna[6]=  miVentanaPrincipalPersona.btnEditar;
        		columna[7] =miVentanaPrincipalPersona.btnCuotas;
        		columna[8] = listaPersonas.get(i).getDni();
        		columna[9] = listaPersonas.get(i).getNombre()+" "+listaPersonas.get(i).getApellido();
        		columna[10] = listaPersonas.get(i).getTelefono();
        		//Saco el - del nombre de domicilio y su numero
        		String[] partes =listaPersonas.get(i).getDomicilio().split("-");
        		String domicilio=partes[0]+" "+partes[1];
        		columna[11] = domicilio;
        		modeloT.addRow(columna);
        	}
        	tabla.setRowHeight(25);
        	tabla.getColumnModel().getColumn(0).setMinWidth(0);
        	tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        	tabla.getColumnModel().getColumn(1).setMinWidth(0);
        	tabla.getColumnModel().getColumn(1).setMaxWidth(0);
        	tabla.getColumnModel().getColumn(2).setMaxWidth(30);
        	tabla.getColumnModel().getColumn(3).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(4).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(5).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(6).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(7).setMaxWidth(60);
        	tabla.getColumnModel().getColumn(8).setMaxWidth(200);
        	tabla.getColumnModel().getColumn(9).setMaxWidth(400);
        	tabla.getColumnModel().getColumn(10).setMaxWidth(200);
        	tabla.getColumnModel().getColumn(11).setMaxWidth(600);
        	tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);
        }
	}

	public void GuardarSocio(Socios socio){
		modeloService.GuardarSocio(socio);
	}

	
	public void GuardarNosocio(Personas persona,boolean Essocio){
			modeloService.GuardarNoSocio(persona);
	}

//	public boolean ValidarDatosPersona(Personas persona){
//		boolean retorno=true;
//		//datos obligatorio para ambos
//		//	if(persona.getDomNro()==0 || persona.getDni()==0 || persona.getNombre()==null || persona.getApellido()==null || persona.getFecNacimiento()==null ||
//		//			persona.getDomicilio()==null || persona.getTelefono()==null)
//		//		retorno=false;
//		//	else{
//		//datos obligatorios para socios
//		if(miFormularioPersona.isEssocio()){
//			if(persona.getMatricula()==0 || persona.getSexo() == null || persona.getNacionalidad()==null ||
//					persona.getEstadoCivil()==null || persona.getFechaIngreso()==null || persona.getCategoria()==null)
//				retorno=false;
//
//
//		}
//		//}
//		return retorno;
//	}


	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Gestion Cuotas
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	public void RegistrarPagoCuotaSocio(List<Cuota> cuotas) {
		modeloService.RegistrarPagoCuotaSocio(cuotas);
	}
		

	@SuppressWarnings("unchecked")
	public void CargarDatosCobranza(Integer dni,JTable tabla){

		java.util.Set<Cuota> cuotasSocio= new HashSet<Cuota>();
		Socios socio = modeloService.CrearInstanciaSocio();
		socio= modeloService.BuscarSocio(dni);
		//Datos persona
		miVentanaCobranza.txtdni.setText(Integer.toString(socio.getDni()));
		miVentanaCobranza.txtDomi.setText(socio.getPersonas().getDomicilio());
		miVentanaCobranza.txtMatri.setText(Integer.toString(socio.getMatricula()));
		miVentanaCobranza.txtNyA.setText(socio.getPersonas().getNombre()+" "+socio.getPersonas().getApellido());
		miVentanaCobranza.txtTel.setText(socio.getPersonas().getTelefono());
		miVentanaCobranza.txtCat.setText(socio.getCategoria().getNombre());

		//cuota
		boolean[] editable = {false,true,false,false,false,false};

		tabla.setDefaultRenderer(Object.class, new Render());

		DefaultTableModel  modeloT = new DefaultTableModel(){

			Class[] type= new Class[]{
					java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
			};
			public Class getColumnClass(int columnIndex){
				return type[columnIndex];
			}

			public boolean isCellEditable(int row,int colum){  
				return editable[colum];
			}
		};
		Object[] columna = new Object[6];

		tabla.setModel(modeloT);
		modeloT.addColumn("");
		modeloT.addColumn("");
		modeloT.addColumn("MES");
		modeloT.addColumn("AÑIO");
		modeloT.addColumn("FECHA PAGO");
		modeloT.addColumn("IMPORTE");

		//Paso las cuotas del socio
		cuotasSocio= socio.getCuotas();
		float total=0;
		if(!socio.getCuotas().isEmpty())
		{
			Iterator<Cuota> it= socio.getCuotas().iterator();
			while(it.hasNext()){  		   
				Cuota cuota=it.next();
				if(cuota.getFechapago()==null){
					columna[0]= cuota.getIdCuota();
					columna[1]=false;
					columna[2]=cuota.getFechageneracion().getMonth()+1;
					columna[3]= cuota.getFechageneracion().getYear()+1900;
					columna[4] ="";
					columna[5]=cuota.getImporte();
					total =0; //cuota.getImporte();
					modeloT.addRow(columna);	   
				}
			}
		}
		tabla.setRowHeight(25);
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		tabla.getColumnModel().getColumn(1).setMaxWidth(40);
		tabla.getColumnModel().getColumn(2).setMaxWidth(150);
		tabla.getColumnModel().getColumn(3).setMaxWidth(150);
		tabla.getColumnModel().getColumn(4).setMaxWidth(200);
		tabla.getColumnModel().getColumn(5).setMaxWidth(260);
		tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);
		miVentanaCobranza.txttotal.setText(String.valueOf(total));
		miVentanaCobranza.setVisible(true);

	}

	public void mostrarVentanaCobranza(Integer dni,JTable tabla){
		this.CargarDatosCobranza(dni,tabla);

	}

	public List<Cuota> BuscarCuotas(List<Integer> id){
		return(modeloService.ObtenerCuotasPorid(id));
	}
	
//	@SuppressWarnings("deprecation")
//	public void ConsultarUltimaGeneracionCuota(){
//		Date fechaGene= new Date();
//		fechaGene= miLogica.FechaUltimaGeneracionCuota(); 
//		miVentanaConfiguracion.dateUltGeneracion.setDate(fechaGene);
//		Date fechaProx= new Date();
//		fechaProx=miLogica.sumarFechasDias(fechaGene);
//		fechaProx.setDate(01);
//		miVentanaConfiguracion.dateProxGeneracion.setDate(fechaProx);
//	}

//	//Generacion Automatica
//	@SuppressWarnings("deprecation")
//	public void LanzarPrcesoAutGeneracionCuota(){
//		if(FechaHora.FechaActual().getDate()==01){
//			miLogica.LanzarPrcesoGeneracionCuota();
//		}
//	}

//	//Generacion Creada por el usuario Administrador
//	public void LanzarPrcesoUsuGeneracionCuota(){
//		miLogica.LanzarPrcesoGeneracionCuota();
//	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Gestion Categorias
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	public void HabilitarInhabilitarCategoria(int id) {
		modeloService.habilitarInhabilitarCategoria(id);

	}	
	public java.util.List<Categoria> ListarCategorias(){
		return modeloService.DevolverListaCategoria();
	}
	
	
	public void MostarVentanaConfCategoria(JTable tabla) {
		this.CargarGrillaCategoria(tabla);
		miVentanaConfCategoria.setVisible(true);
	}

	public void GuardarCategoria(Categoria categoria) {
		modeloService.GuardarCategoria(categoria);
		
	}
     
	public void CargarGrillaCategoria(JTable tabla){

		java.util.List<Categoria> categorias=new ArrayList<Categoria>();
		DefaultTableModel  modeloT = new DefaultTableModel(){
			public boolean isCellEditable(int row,int colum){  //la filas de mi tabla no pueden ser editable
				return false;
			}
		};

		Object[] columna = new Object[7];
		tabla.setModel(modeloT);
		modeloT.addColumn("");
		modeloT.addColumn("");
		modeloT.addColumn("ID");
		modeloT.addColumn("NOMBRES");
		modeloT.addColumn("MONTO");
		modeloT.addColumn("DESCUENTO");
		modeloT.addColumn("DESCRIPCION");
		categorias=modeloService.DevolverListaCategoria();

		int numRegistros=categorias.size();
		for (int i = 0; i < numRegistros; i++) {
			columna[0] = categorias.get(i).isHabilitado();
			columna[1] = miVentanaConfCategoria.btnEditar;
			columna[2] = categorias.get(i).getIdCategoria();
			columna[3] = categorias.get(i).getNombre();
			columna[4] = categorias.get(i).getMonto();
			columna[5] = categorias.get(i).getDescuento();
			columna[6] = categorias.get(i).getDescripcion();
			modeloT.addRow(columna);
		}
		//Estilo Tabla
		tabla.getTableHeader().setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		tabla.setDefaultRenderer(Object.class,new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());
		//Dimentsion tabla
		tabla.setRowHeight(25);
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		tabla.getColumnModel().getColumn(1).setMaxWidth(30);
    	tabla.getColumnModel().getColumn(2).setMaxWidth(30);
    	tabla.getColumnModel().getColumn(3).setMaxWidth(150);
    	tabla.getColumnModel().getColumn(4).setMaxWidth(100);
    	tabla.getColumnModel().getColumn(5).setMaxWidth(120);
    	tabla.getColumnModel().getColumn(6).setMaxWidth(450);
    	//acciones tabla
    	tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Gestion Caja
	//---------------------------------------------------------------------------------------------------------------------------------------------------	

	public Conceptos BuscarConcepto(Integer id) {
		return modeloService.BuscarConcepto(id);
	}
	
	public Conceptos CrearConcepto() {
		return modeloService.CrearInstanciaConcepto();
	}
	@SuppressWarnings("unchecked")
	public void MostrarVentanaIngresoEgreso(){
		miventanaIngresoEgreso.comboTipo.addItem("Seleccione el tipo de ingreso");
		for(Conceptos conceptos : modeloService.ObtenerConceptos()){
			miventanaIngresoEgreso.comboTipo.addItem(conceptos.getTipo()+"-"+conceptos.getNombre()); //Cargo conceptos y sus id
			miventanaIngresoEgreso.mapConceptos.put (conceptos.getIdConcepto(), conceptos.getTipo());
		}
		miventanaIngresoEgreso.setVisible(true);
	}

	public Caja CrearRegistroCaja(){
		return modeloService.CrearInstanciaCaja();
	}

	public void GuardarRegistroCaja(Caja registro){
		modeloService.GuardarRegistroCaja(registro);
	}

	public void CerrarVentanaIngEgre(){
		miventanaIngresoEgreso.dispose();
	}

	public void MostrarVentanaCaja(JTable tabla){
		miVentanaCaja.show();
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
		long total= modeloService.ObtenerRegistrosDeCaja();
		if(total==0)
			return false;
		else
			return true;

	}

	public void BuscarCajaParametros(Date FechaDesde,Date FechaHasta,String Descripcion,boolean Ingreso,boolean Egreso,JTable tabla){
		if(!this.ValidarUltimoIngreso()){ // valida si hay registros en la caja
			JOptionPane.showMessageDialog(null,"No se encuentra registro en la base de datos,Por favor ingrese un monto inicial ","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			java.util.List<Caja> cajas=new ArrayList<Caja>();
			float SubTotal=0;
			DecimalFormat df = new DecimalFormat("#.##");
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
			cajas=modeloService.ObtenerCajasPorParamatros(FechaDesde, FechaHasta, Descripcion, Ingreso, Egreso);
			if(cajas != null){
				int numRegistros=cajas.size();
				for (int i = 0; i < numRegistros; i++) {
					columna[0] = cajas.get(i).getFecha();
					columna[1] = cajas.get(i).getDescripcion();
					if(cajas.get(i).getConceptos().getTipo().equals("I")){
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
			}
			else
				JOptionPane.showMessageDialog(null,"No se han encontrado coincidencias","Information",JOptionPane.INFORMATION_MESSAGE);

			//fecha
			tabla.getColumnModel().getColumn(0).setMaxWidth(110);
			//descripcion
			tabla.getColumnModel().getColumn(1).setMaxWidth(1000);
			//tipo
			tabla.getColumnModel().getColumn(2).setMaxWidth(90);
			//importe
			tabla.getColumnModel().getColumn(3).setMaxWidth(150);
			miVentanaCaja.txtSubTotal.setText(String.valueOf(df.format(SubTotal)));

		}
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Gestion Configuracion
	//---------------------------------------------------------------------------------------------------------------------------------------------------

	public void CerraConfiguracion(){
		miVentanaConfiguracion.dispose();
	}

	public void CargarPrecioCuota(){
		try {
			//Mostrar Precio Cuota
			Float valor= modeloService.ObtenerPrecioCuota();
			String variable=String.valueOf(valor);
			String[] precio = variable.split("\\.");
			miVentanaConfiguracion.txtEntero.setText(precio[0]);
			miVentanaConfiguracion.txtDecimal.setText(precio[1]);		
		} 
		catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,"Advertencia: "+e.getMessage(),"Advertencia",JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	public void MostrarVentnaConfiguracion(){
		this.CargarPrecioCuota();
		miVentanaConfiguracion.setVisible(true);
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//Principal y loggin
	//---------------------------------------------------------------------------------------------------------------------------------------------------	
	public void mostrarVentanaPrincipal(Usuario usuario) {
		miVentanaPrincipal.setTitle("USUARIO: "+usuario.getNick()+"  TIPO: "+usuario.getTipousuario());
		if(usuario.getTipousuario().equals("ADMINISTRADOR"))
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
 
	public Usuario CrearUsuario(){
		return modeloService.CrearUsuario();
	}
	public Usuario validarUsuario(String nombreUsuario,String PassUsuario){
		return  modeloService.ValidarUsuario(nombreUsuario, PassUsuario);
	}
	public Usuario ObtenerUsuarioPorNombre(String nomUsuario){
		return modeloService.ObtenerUsuarioPorNombre(nomUsuario);
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
		return modeloService.BuscarInmueble(id);
	}

	public Inmuebles CrearInmueble() {
		return modeloService.CrearInstanciaInmueble();
	}

	
	public void ListarInmuebles(JTable jtdatos, String text, boolean selected){
		java.util.List<Inmuebles> listaInmuebles=new ArrayList<Inmuebles>();
		
		if(text.isEmpty() && !selected){//si es verdadero incluye todos los inmuebles
			listaInmuebles=modeloService.ListarInmuebleHabilitado();
			// solo inmuebles habilitados
		}else if(selected){
			listaInmuebles=modeloService.ListarInmueble();
			//incluir todos habilitados y no habilitados
			
		}else if(!text.isEmpty()){
			listaInmuebles=modeloService.ListarInmuebleFiltrado(text);
			//listar resultados
		}
		
		DefaultTableModel  modeloT = (DefaultTableModel) jtdatos.getModel();
		//"Numero", "Nombre", "Precio por hora", "Direccion"
		Object[] columna = new Object[4];
		int numr=listaInmuebles.size();
		for(int i=0;i<numr;i++){
			columna[0]=listaInmuebles.get(i).getIdInmubles();
			columna[1]=listaInmuebles.get(i).getNombre();
			columna[2]=listaInmuebles.get(i).getPreciohora();
			columna[3]=listaInmuebles.get(i).getDireccion();
			modeloT.addRow(columna);
		}
		jtdatos.setModel(modeloT);
			
	}
	
	public java.util.List<Inmuebles> ListarInmueblesAlquiler(){
		return modeloService.ListarInmueblesParaAlquiler();
	}


	public Alquiler CrearAlquiler() {

		return  modeloService.CrearInstanciaAlquiler();

	}

	public float CalcularPrecioTotal(Alquiler alqui, Personas pers, Inmuebles inm) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void RegistrarInmueble(Inmuebles entity) {
		entity.setHabilitado(true);
		modeloService.GuardarInmueble(entity);

	}

	

	

	

	
	

	
	

	

	
	}
//	public void ModificarInmueble(Inmuebles inm) {
//		miLogica.ModificarInmueble(inm);
//
//	}
//
//	public void EliminarInmueble(Inmuebles inm) {
//		miLogica.EliminarInmueble(inm);
//
//	}
//
//	public void RestaurarInmueble(Inmuebles inm) {
//		miLogica.RestaurarInmueble(inm);
//
//	}
//
//	public void RegistrarNuevoAlquiler(Alquiler alqui) {
//		miLogica.GuardarAlquiler(alqui);
//
//	}

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

