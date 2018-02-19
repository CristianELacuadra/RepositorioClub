package ar.com.ProyectoClub.BControlador;

import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;









import ar.com.ProyectoClub.AVista.*;
import ar.com.ProyectoClub.AVista.ClasesRender.Render;
import ar.com.ProyectoClub.AVista.ClasesRender.RowsRende;
import ar.com.ProyectoClub.CModelo.AServicios.Ifacade.IService;
import ar.com.ProyectoClub.CModelo.AServicios.facade.Service;
import ar.com.ProyectoClub.CModelo.BNegocio.FechaHora;
import ar.com.ProyectoClub.CModelo.CEntidades.*;
import ar.com.ProyectoClub.AVista.ClasesRender.FechasCalendar;

public class ControllerCoordinador {
	//Objeto a mi modelo de servicio
	private IService modeloService;
	private  DefaultTableModel dm;
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
    private PantallaControlMorosos miVentanaControlMoroso;
    private PantallaHistCuota miVentanaHistCuota;
	//ALQUILER
	private PantallaAlquilerPrincipal miVentanaAlquilerPrincipal;
	private PantallaNuevoAlquiler miVentanaNuevoAlquiler;
	private PantallaDetallesAlquiler miVentanaDetallesAlquiler;
	
	
	
	
	
	public ControllerCoordinador() {
		try {
			modeloService=new Service();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	

	public void setMiVentanaControlMoroso(PantallaControlMorosos miVentanaControlMoroso) {
		this.miVentanaControlMoroso = miVentanaControlMoroso;
	}
	
	public PantallaControlMorosos getMiVentanaControlMoroso() {
		return miVentanaControlMoroso;
	}
	
	public PantallaHistCuota getMiVentanaHistCuota() {
		return miVentanaHistCuota;
	}
	
	public void setMiVentanaHistCuota(PantallaHistCuota miVentanaHistCuota) {
		this.miVentanaHistCuota = miVentanaHistCuota;
	}
	/*Metodo filtro sobre tabla*/
	//--------------------------------------------------------------------------------------------------
	public void Filtro(String consulta,JTable jTable){
		dm = (DefaultTableModel) jTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
	}
	//----------------------------------------------------------------------------
	
//github.com/CristianELacuadra/RepositorioClub.git


	//////////////////////////////////////////////////////////
	//METODOS 
	//Gestion Socio-NoSocio
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Socios BuscarSocio(int dni) {
		return modeloService.BuscarSocio(dni);
	}
	
	public void CargarDatosPersona(Integer dni) {
		miFormularioPersona.comboCate.removeAllItems();
		miFormularioPersona.comboCate.addItem("Seleccione una categoria");
		for(Categoria categoria : modeloService.DevolverListaCategoria()){
			if(categoria.isHabilitado()){ //si esta habilitada la categoria
				miFormularioPersona.comboCate.addItem(categoria.getIdCategoria()+"-"+categoria.getNombre()); //Cargo Categorias y sus id
				miFormularioPersona.mapCategoria.put(categoria.getIdCategoria(), categoria.getNombre());
			}
		}
		CargarDatos(dni);
		miFormularioPersona.setVisible(true);
	}
	
	private void CargarDatos(Integer dni) {
		Personas persona=this.CrearPersona(); 
		persona=modeloService.BuscarPersona(dni);
		miFormularioPersona.txtDni.setText(persona.getDni().toString());
		miFormularioPersona.txtDni.setEnabled(false);
		miFormularioPersona.txtApe.setText(persona.getApellido());
		miFormularioPersona.txtNom.setText(persona.getNombre());
		miFormularioPersona.txtTel.setText(persona.getTelefono());
		String[] divisor = persona.getDomicilio().split("-");
		miFormularioPersona.txtDom.setText(divisor[0]);
		miFormularioPersona.txtDomNro.setText(divisor[1]);
		miFormularioPersona.dateFechNac.setDate(persona.getFechanac());
		miFormularioPersona.txtNacion.setText(persona.getNacionalidad());
		if(!persona.getSexo().equals("M"))
			miFormularioPersona.rdbFemenino.setSelected(true); 
		else
			miFormularioPersona.rdbMasculino.setSelected(true);
		miFormularioPersona.txtEstdoCiv.setText(persona.getEstadocivil());
		//si es socio
		if(persona.getSocios() != null){
			miFormularioPersona.txtMatri.setText(persona.getSocios().getMatricula().toString());
			miFormularioPersona.txtMatri.setEnabled(false);
			miFormularioPersona.dateFechIngreso.setDate(persona.getSocios().getFechaingreso());
			miFormularioPersona.txtCateg.setText(persona.getSocios().getCategoria().getIdCategoria()+"-"+persona.getSocios().getCategoria().getNombre());
			if(!persona.getSocios().isBaja()){
				miFormularioPersona.rdbtnSi.setSelected(true);
				botones(true);				
				miFormularioPersona.txtMatri.setEnabled(false);
			}
			else
			{
				miFormularioPersona.rdbtnNo.setSelected(true);
				botones(false);				
			}
		}
		else
			miFormularioPersona.rdbtnNo.setSelected(true);
		HabilitarBotonoes(true);

	}
	private void botones(boolean valor){
		miFormularioPersona.txtMatri.setEnabled(valor);
		miFormularioPersona.comboCate.setEnabled(valor);
		miFormularioPersona.dateFechIngreso.setEnabled(valor);
		miFormularioPersona.txtCateg.setEnabled(valor);
	}
	private void HabilitarBotonoes(boolean valor){

		miFormularioPersona.txtApe.setEnabled(valor);
		miFormularioPersona.txtDom.setEnabled(valor);
		miFormularioPersona.txtDomNro.setEnabled(valor);
		miFormularioPersona.txtNacion.setEnabled(valor);
		miFormularioPersona.txtNom.setEnabled(valor);
		miFormularioPersona.txtTel.setEnabled(valor);
		miFormularioPersona.rdbFemenino.setEnabled(valor);
		miFormularioPersona.rdbMasculino.setEnabled(valor);
		miFormularioPersona.txtEstdoCiv.setEnabled(valor);
		miFormularioPersona.rdbtnNo.setEnabled(valor);
		miFormularioPersona.rdbtnSi.setEnabled(valor);
		miFormularioPersona.dateFechNac.setEnabled(valor);
	}

	public void ObtenerPersonaNomApe(String nom, String ape) {
		List<Personas> listaPersonas= modeloService.ObtenerPersonaNomApe(nom,ape);
		if(listaPersonas != null)
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
		Essocio=(persona.getSocios() != null && !persona.getSocios().isBaja()) ? "SI" : "NO";
		String[] partes = persona.getDomicilio().split("-");
		String domicilio=partes[0]+" Nº "+partes[1];

		textoPersona ="Domicilio: "+domicilio+'\n'+""
				+"Fecha de nacimiento: "+(new SimpleDateFormat("dd-MM-yyyy").format(persona.getFechanac()))+'\n'+""
				+"Sexo: "+persona.getSexo()+'\n'+""
				+"Nacionalidad: "+persona.getNacionalidad()+'\n'+""
				+"Estado Civil: "+persona.getEstadocivil()+'\n'+""
				+"Habilitado: "+habiilitado+'\n'+""
		        +"Es Socio: "+Essocio+'\n'+"";
		miVentanaDetallesSNS.textDetalle.setText(textoPersona);
		if(persona.getSocios() != null && !persona.getSocios().isBaja()){
			textoSocio = "Matricula: "+persona.getSocios().getMatricula()+'\n'+""
					+"Estado: "+persona.getSocios().getEstado()+'\n'+""	
					+"Fecha de Ingreso: "+(new SimpleDateFormat("dd-MM-yyyy").format(persona.getSocios().getFechaingreso()))+'\n'+"";
			miVentanaDetallesSNS.textPanelDetalleSocio.setText(textoSocio);
		}
		miVentanaDetallesSNS.setVisible(true);
	}
	
	public void GuardarPersona(Personas personas,boolean tipoEntrada){
		modeloService.GuardarPersona(personas,tipoEntrada);
	}

	public void MostrarVentanaPrincipalPersona(JTable tabla){
		miVentanaPrincipalPersona.setVisible(true);	
		this.CargarGrilla(tabla);
	}
	@SuppressWarnings("unchecked")
	public void mostrarFormularioPersona(){
		miFormularioPersona.txtDni.setEnabled(true);
		//Limpia el combo de categoria y lo vuelve agragar
		miFormularioPersona.comboCate.removeAllItems();
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
		if(listaPersona != null){

			int numRegistros=listaPersona.size();// devuelve un rango de 100 socios

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
		}
		tabla.setRowHeight(25);
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		tabla.getColumnModel().getColumn(1).setMinWidth(0);
		tabla.getColumnModel().getColumn(1).setMaxWidth(0);
		tabla.getColumnModel().getColumn(2).setMinWidth(0);
		tabla.getColumnModel().getColumn(2).setMaxWidth(0);
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

		//int numRegistros=listaPersonas.size();// devuelve un rango de 100 socios
		if(listaPersonas != null){

			int numRegistros=listaPersonas.size();// devuelve un rango de 100 socios

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
		}
		tabla.setRowHeight(25);
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		tabla.getColumnModel().getColumn(1).setMinWidth(0);
		tabla.getColumnModel().getColumn(1).setMaxWidth(0);
		tabla.getColumnModel().getColumn(2).setMinWidth(0);
		tabla.getColumnModel().getColumn(2).setMaxWidth(0);
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
	

	public void GuardarSocio(Socios socio){
		modeloService.GuardarSocio(socio);
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
	public void MostrarPantallaHistorialCuota(Integer dni,JTable tabla){
		Personas persona= modeloService.BuscarPersona(dni);
		miVentanaHistCuota.txtNomApe.setText((persona.getApellido()+" "+persona.getNombre()));
		
		java.util.List<Cuota> listaCuota=new ArrayList<Cuota>();
		DefaultTableModel  modeloT = new DefaultTableModel(){
			public boolean isCellEditable(int row,int colum){  //la filas de mi tabla no pueden ser editable
				return false;
			}
		};

		Object[] columna = new Object[5];
		tabla.setModel(modeloT);
		TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(modeloT);
		tabla.setRowSorter(elQueOrdena);
		modeloT.addColumn("PERIODO");
		modeloT.addColumn("FECHA PAGO");
		modeloT.addColumn("DESCRIPCION");
		modeloT.addColumn("IMPORTE");
		
		listaCuota= modeloService.ObtenerCuotaSocio(dni);
		
		Integer numRegistros=listaCuota.size();
		miVentanaHistCuota.txtTotal.setText(numRegistros.toString());
		for (int i = 0; i < numRegistros; i++) {
			columna[0] = listaCuota.get(i).getFechageneracion().getMonth()+1+"-"+(listaCuota.get(i).getFechageneracion().getYear()+1900);
			columna[1] = listaCuota.get(i).getFechapago();
			columna[2] = listaCuota.get(i).getDescripcion();
			columna[3] = listaCuota.get(i).getImporte();
			modeloT.addRow(columna);
		}
		tabla.setRowHeight(25);
		tabla.getColumnModel().getColumn(0).setMaxWidth(200);
		tabla.getColumnModel().getColumn(1).setMaxWidth(100);
		tabla.getColumnModel().getColumn(2).setMaxWidth(310);
		tabla.getColumnModel().getColumn(3).setMaxWidth(120);
		miVentanaHistCuota.setVisible(true);
	}

	public void RegistrarPagoCuotaSocio(List<Cuota> cuotas) {
		modeloService.RegistrarPagoCuotaSocio(cuotas);
	}
		

	@SuppressWarnings("unchecked")
	public void CargarDatosCobranza(Integer dni,JTable tabla){

		//java.util.Set<Cuota> cuotasSocio= new HashSet<Cuota>();
		List<Cuota> cuotas=new ArrayList<Cuota>();
		Socios socio = modeloService.CrearInstanciaSocio();
		socio= modeloService.BuscarSocio(dni);
		//Datos persona
		miVentanaCobranza.txtdni.setText(Integer.toString(socio.getDni()));
		miVentanaCobranza.txtDomi.setText(socio.getPersonas().getDomicilio());
		miVentanaCobranza.txtMatri.setText(Integer.toString(socio.getMatricula()));
		miVentanaCobranza.txtNyA.setText(socio.getPersonas().getNombre()+" "+socio.getPersonas().getApellido());
		miVentanaCobranza.txtTel.setText(socio.getPersonas().getTelefono());
		miVentanaCobranza.txtCat.setText(socio.getCategoria().getNombre());
		miVentanaCobranza.txtEstado.setText(socio.getEstado());

		//cuota
		boolean[] editable = {false,true,false,false,false,false};
		boolean[] editable2 = {false,false,false,false,false,false};
		
		tabla.setDefaultRenderer(Object.class, new Render());

		DefaultTableModel  modeloT = new DefaultTableModel(){

			Class[] type= new Class[]{
					java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
			};
			public Class getColumnClass(int columnIndex){
				return type[columnIndex];
			}
			
//			public boolean isCellEditable (int row, int column)
//			{
//				// Aquí devolvemos true o false según queramos que una celda
//				// identificada por fila,columna (row,column), sea o no editable
//				if (row == 1 && column==1)
//					return true;
//				else
//					return false;
//			}

			public boolean isCellEditable(int row,int colum){ 
				if(miVentanaCobranza.txtEstado.getText().equals("MOROSO")){
					return editable2[colum];
				}
				else
				{
					if(row==0)
						return editable2[row];
					else
						return editable[colum];
				}
			}
		};

		Object[] columna = new Object[5];

		tabla.setModel(modeloT);
		modeloT.addColumn("");
		modeloT.addColumn("");
		modeloT.addColumn("MES");
		modeloT.addColumn("AÑIO");
		//modeloT.addColumn("FECHA PAGO");
		modeloT.addColumn("IMPORTE");

		//Paso las cuotas del socio
		cuotas=  modeloService.ControlCuotaSocio(socio.getDni());
		if(!cuotas.isEmpty())
			miVentanaCobranza.listaCuota=cuotas;
		
		float total=0;
		for (int i = 0; i < cuotas.size(); i++) {
			columna[0] = cuotas.get(i).getIdCuota();
			if(i==0)
			columna[1] = true;
			columna[2] = FechaHora.ConvertMestoMes(cuotas.get(i).getFechageneracion().getMonth());
			columna[3] = cuotas.get(i).getFechageneracion().getYear()+1900;
			columna[4] = cuotas.get(i).getImporte();
			total+=cuotas.get(i).getImporte();
			miVentanaCobranza.btnCobrar.setEnabled(true);
			modeloT.addRow(columna);
		}
		tabla.setRowHeight(25);
		//tabla.getColumnModel().getColumn(0).;
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		tabla.getColumnModel().getColumn(1).setMaxWidth(50);
		tabla.getColumnModel().getColumn(2).setMaxWidth(200);
		tabla.getColumnModel().getColumn(3).setMaxWidth(250);
		tabla.getColumnModel().getColumn(4).setMaxWidth(300);
		//tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);
		miVentanaCobranza.txttotal.setText(String.valueOf(total));
		if(miVentanaCobranza.txtEstado.getText().equals("MOROSO"))
			JOptionPane.showMessageDialog(null,"El estado actual del socio es MOROSO."
					+'\n'+ "Debe saldar la totalidad de la deuda para actualizar su estado","ATENCION",JOptionPane.WARNING_MESSAGE);
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
		tabla.getColumnModel().getColumn(2).setMinWidth(0);
    	tabla.getColumnModel().getColumn(2).setMaxWidth(0);
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
		if(miventanaIngresoEgreso.comboTipo.getItemCount() != 0)
			miventanaIngresoEgreso.comboTipo.removeAllItems();
		
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
	public Usuario validarUsuario(Usuario usuario){
		return  modeloService.ValidarUsuario(usuario);
	}
	public Usuario ObtenerUsuarioPorNombre(String nomUsuario){
		return modeloService.ObtenerUsuarioPorNombre(nomUsuario);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------
	//MOROSOS
	//---------------------------------------------------------------------------------------------------------------------------------------------------	
	
	//no aplicable
	public void FiltrarMorosos(String filtro,JTable tablaDeudores) {
		List<Morosos> listaMorososDeudores=new ArrayList<Morosos>();
		if(filtro.equals("MOROSO"))
			 listaMorososDeudores= modeloService.FiltrarMorosos();
		
		if(filtro.equals("DEUDOR"))
			listaMorososDeudores = modeloService.FiltrarDeudores();
		
		//CargarGrillaMorosos(tablaDeudores, listaMorososDeudores,null);
	}
	
	
	public void MostrarVentanaControlMorosos(JTable tablaDeudores) {
		CargarGrillaMorosos(tablaDeudores);
		miVentanaControlMoroso.setVisible(true);
	}
	public List<Morosos> ActulizarListaMoroso(){
		return modeloService.ListarMorososDeudores();
	}
	
	/**
	 * rellena la tabla con los datos 
	 * @param tabla
	 * @param listaMorosos
	 * @return
	 */
	public void  CargarGrillaMorosos(JTable tabla){
		DefaultTableModel ModeloDeuMoros=this.ArmadoModeloDeudoresMorosos();
		List<Morosos> listaMorosos=this.ActulizarListaMoroso();
		Object[] columna = new Object[12];
		int numRegistros=listaMorosos.size();
		for (int i = 0; i < numRegistros; i++) {
			columna[0] = listaMorosos.get(i).getMatricula();
			columna[1] = listaMorosos.get(i).getDni();
			columna[2] = listaMorosos.get(i).getNombre();
			columna[3] = listaMorosos.get(i).getApellido();
			columna[4] = listaMorosos.get(i).getTelefono();
			columna[5] = listaMorosos.get(i).getDomicilio();
			columna[6] = listaMorosos.get(i).getCategoria();
			columna[7] = listaMorosos.get(i).getFechaingreso();
			columna[8] = listaMorosos.get(i).getEstado();
			columna[9] = listaMorosos.get(i).getCantMesAtraso()+" MES";
			columna[10] = listaMorosos.get(i).getImporteTotal();
			columna[11] = listaMorosos.get(i).getUltimaFecMovim();
			ModeloDeuMoros.addRow(columna);
		}	
		tabla.setModel(ModeloDeuMoros);
		//Estilo Tabla
		tabla.getTableHeader().setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		tabla.setDefaultRenderer(Object.class,new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());
		//Dimentsion tabla
		tabla.setRowHeight(25);
		tabla.getColumnModel().getColumn(0).setMaxWidth(100);
		tabla.getColumnModel().getColumn(1).setMaxWidth(70);
    	tabla.getColumnModel().getColumn(2).setMaxWidth(100);
    	tabla.getColumnModel().getColumn(3).setMaxWidth(100);
    	tabla.getColumnModel().getColumn(4).setMaxWidth(150);
    	tabla.getColumnModel().getColumn(5).setMaxWidth(250);
    	tabla.getColumnModel().getColumn(6).setMaxWidth(100);
    	tabla.getColumnModel().getColumn(7).setMaxWidth(120);
    	tabla.getColumnModel().getColumn(8).setMaxWidth(100);
    	tabla.getColumnModel().getColumn(9).setMaxWidth(70);
    	tabla.getColumnModel().getColumn(10).setMaxWidth(120);
    	tabla.getColumnModel().getColumn(11).setMaxWidth(140);
    	//acciones tabla
    	//tabla.setDefaultRenderer(Object.class, miVentanaPrincipalPersona.resaltado);
	}
	
	
	
	//Saco el modelo de datos para poder usar en varios metodos
	private DefaultTableModel ArmadoModeloDeudoresMorosos(){

		DefaultTableModel  modeloT = new DefaultTableModel(){
			public boolean isCellEditable(int row,int colum){  //la filas de mi tabla no pueden ser editable
				return false;
			}
		};

		modeloT.addColumn("MATRICULA");
		modeloT.addColumn("DNI");
		modeloT.addColumn("NOMBRE");
		modeloT.addColumn("APELLIDO");
		modeloT.addColumn("TELEFONO");
		modeloT.addColumn("DOMICILIO");
		modeloT.addColumn("CATEGORIA");
		modeloT.addColumn("INGRESO");
		modeloT.addColumn("ESTADO");
		modeloT.addColumn("ATRASO");
		modeloT.addColumn("IMP. TOTAL $");
		modeloT.addColumn("ULT. REGISTRACION");

		return modeloT;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
//set y get de pantallas
	/*** alquiler   * */

	public  PantallaAlquilerPrincipal getMiVentanaAlquilerPrincipal(){
		return miVentanaAlquilerPrincipal;
	}

	public void setMiVentanaAlquilerPrincipal(PantallaAlquilerPrincipal miVentanaAlquilerPrincipal){
		this.miVentanaAlquilerPrincipal=miVentanaAlquilerPrincipal;
	}

    // VENTANA 
	public  PantallaNuevoAlquiler getMiVentanaNuevoAlquiler(){
		return miVentanaNuevoAlquiler;
	}

	public void setMiVentanaNuevoAlquiler(PantallaNuevoAlquiler miVentanaNuevoAlquiler){
		this.miVentanaNuevoAlquiler=miVentanaNuevoAlquiler;
	} 

	
	public  PantallaDetallesAlquiler getMiVentanaDetallesAlquiler(){
		return miVentanaDetallesAlquiler;
	}

	public void setMiVentanaDetallesAlquiler(PantallaDetallesAlquiler miVentanaDetallesAlquiler){
		this.miVentanaDetallesAlquiler=miVentanaDetallesAlquiler;
	} 

	
	
	
	

	//---------------------------------------------------------------------------------------------------------------------------------------------------
		// Pantalla Alquileres principal
			/** panel inmueble**/
		//---------------------------------------------------------------------------------------------------------------------------------------------------

	
	public void mostrarVentanaAlquilerPrincipal(){
		miVentanaAlquilerPrincipal.setVisible(true);
		CardLayout c= (CardLayout)(miVentanaAlquilerPrincipal.contentPane.getLayout());
		c.show(miVentanaAlquilerPrincipal.contentPane, "p1");
		this.ListarAlquileres(miVentanaAlquilerPrincipal.tableAlq, modeloService.ListarAlquileres());
	
	}
	
	
	
		
	
	public Inmuebles BuscarInmueble(Integer id) {
		return modeloService.BuscarInmueble(id);
	}

	public Inmuebles CrearInmueble() {
		return modeloService.CrearInstanciaInmueble();
	}

	
	public void ListarInmuebles(JTable jtdatos, boolean selected){
		java.util.List<Inmuebles> listaInmuebles=new ArrayList<Inmuebles>();
		
		if(!selected){//si es verdadero incluye todos los inmuebles
			listaInmuebles=modeloService.ListarInmuebleHabilitado();
			// solo inmuebles habilitados
			}else if(selected){
				listaInmuebles=modeloService.ListarInmueble();
				//incluir todos habilitados y no habilitados
				
				}
		
		DefaultTableModel  modeloT = (DefaultTableModel) jtdatos.getModel();
		//"Numero", "Nombre", "Precio por hora", "SEÑA"
		Object[] columna = new Object[5];
		int numr=listaInmuebles.size();
		for(int i=0;i<numr;i++){
			columna[0]=listaInmuebles.get(i).getIdInmubles();
			columna[1]=listaInmuebles.get(i).getNombre();
			columna[2]=listaInmuebles.get(i).getPreciohora();
			columna[3]=listaInmuebles.get(i).getSenial();
			columna[4]=listaInmuebles.get(i).isHabilitado();
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

	public float CalcularPrecioTotal(Personas pers, Inmuebles inm, Integer cantHoras) {
		
		
	
		
		return 0;
	}

	public boolean personaHabilitadaParaAlquiler(Personas per){
	/*	if(per.isHabilitado())
		{
			per.getSocios().get
		}
		if(per.isHabilitado()&&(!per.getSocios().isBaja())&&((per.getSocios().getEstado().equals("ACTIVO"))||(per.getSocios().getEstado().equals("DEUDOR"))
				||(per.getSocios().getEstado().equals("")) ))//TODO ojo es para probar si anda hay que eliminar el nulo para cuando es posta

		
		
		{ 
			cargarCombo();
			habilitarCampoPersona(false);
				return true;
				
		}
		else
		{
			miCoordinador.mensajes("Esta persona no esta habilitada para Alquilar", 3);
			//limpiar();
			return false;
		}*/
	return false;
	}
	
	public void RegistrarInmueble(Inmuebles entity) {
		entity.setHabilitado(true);
		modeloService.GuardarInmueble(entity);
// sirve para los dos guardar o actualizar
		// id vacio
	}

	public void panelRegInmDesHabilitar(){
		miVentanaAlquilerPrincipal.texInmNombre.setEnabled(false);
		miVentanaAlquilerPrincipal.texInmDireccion.setEnabled(false);
		miVentanaAlquilerPrincipal.texInmDireccionNum.setEnabled(false);
		miVentanaAlquilerPrincipal.texInmPrecioHora.setEnabled(false);
		miVentanaAlquilerPrincipal.texInmSe.setEnabled(false);
		miVentanaAlquilerPrincipal.texInmDescrip.setEnabled(false);
	
	}
	
	
	public void panelRegInmHabilitar(){
		miVentanaAlquilerPrincipal.texInmNombre.setEnabled(true);
		miVentanaAlquilerPrincipal.texInmDireccion.setEnabled(true);
		miVentanaAlquilerPrincipal.texInmDireccionNum.setEnabled(true);
		miVentanaAlquilerPrincipal.texInmPrecioHora.setEnabled(true);
		miVentanaAlquilerPrincipal.texInmSe.setEnabled(true);
		miVentanaAlquilerPrincipal.texInmDescrip.setEnabled(true);
	}

	
	public void limpiarPanelRegInm(){
	 	miVentanaAlquilerPrincipal.texInmNombre.setText(null);
		miVentanaAlquilerPrincipal.texInmDireccion.setText(null);
		miVentanaAlquilerPrincipal.texInmDireccionNum.setText(null);
		miVentanaAlquilerPrincipal.texInmPrecioHora.setText(null);
		miVentanaAlquilerPrincipal.texInmSe.setText(null);
		miVentanaAlquilerPrincipal.texInmDescrip.setText(null);
	}
	public boolean validarPanelRegInm(){
	boolean ban=false;
		try {
			
			if((!miVentanaAlquilerPrincipal.texInmNombre.getText().isEmpty())&&(!miVentanaAlquilerPrincipal.texInmDireccion.getText().isEmpty())&&
					(!miVentanaAlquilerPrincipal.texInmDireccionNum.getText().isEmpty())&&(!miVentanaAlquilerPrincipal.texInmPrecioHora.getText().isEmpty())&&
					(miVentanaAlquilerPrincipal.texInmDescrip.getText().length()<300)){
				if((miVentanaAlquilerPrincipal.texInmSe.getText().isEmpty()))
					miVentanaAlquilerPrincipal.texInmSe.setText("0");

				ban= true;
				
			}else ban= false;
			return ban;
		} catch (Exception e) {
			mensajes("Ocurrio un Error al Guardar", 0);
			//e.printStackTrace();
			return ban=false;
		}
		
		
		// validar y tambien validad id si esta vacio
		// no se fija si idInmueble esta vacio lo hace en el boton
		
	}
	public boolean validarNombreInmueble(String tex,Integer id){	
	return modeloService.validarNombreInmueble(tex,id);
	}
		
	
	
	public void botonCancelarHabilitarInm(){
		miVentanaAlquilerPrincipal.bEliminarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/remove11_10189.png")));
		miVentanaAlquilerPrincipal.botCanhab=true;
		miVentanaAlquilerPrincipal.bEliminarI.setText("Cancelar");
		miVentanaAlquilerPrincipal.bEliminarI.setEnabled(true);
	}
	public void botonCancelarDeshabilitarInm(){
		miVentanaAlquilerPrincipal.bEliminarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/borrarT1.png")));
		miVentanaAlquilerPrincipal.botCanhab=false;
		miVentanaAlquilerPrincipal.bEliminarI.setText("Eliminar");
		miVentanaAlquilerPrincipal.bEliminarI.setEnabled(false);
	}
	
	public void botonCancelarInm(){
		
		//TODO revisar funcion  no se ejecuta
		if(0== mensajeOpciones("Pregunta", "¿Deseas cancelar? \n perdera toda la informacion que no guardo", 3)){
			miVentanaAlquilerPrincipal.inmuebleEnt=null;
			miVentanaAlquilerPrincipal.limpiarCampos();
			botonCancelarDeshabilitarInm();
			panelRegInmDesHabilitar();
			miVentanaAlquilerPrincipal.bRegistrarI.setSelected(false);
			miVentanaAlquilerPrincipal.bActualizarI.setSelected(false);
			miVentanaAlquilerPrincipal.bRegistrarI.setText("Registrar");
			miVentanaAlquilerPrincipal.bActualizarI.setText("Modificar");
			miVentanaAlquilerPrincipal.recargarPanelInmueble();
			//revisari si faltan funciones
			
			/** el boton cancelar tambien se habilita cuando se actualiza/modifica un inmueble.
			 * 
			 */
		}
	}

	
	public void botonEliminarInm(Inmuebles inm){
		// accion del boton eliminar-- es una actualizacion
	if(!inm.getIdInmubles().equals(null)){
		inm.setHabilitado(false);
		modeloService.GuardarInmueble(inm);	
		mensajes("Se Deshabilito correctamente el inmueble, ", 1);
	}else
		mensajes("Ocurrio un error inesperado, \n reintente", 0);
	
	

	
	

	
	

	

	
	}
	
	public void botonRestaurarInm(Inmuebles inm){
		
		if(!inm.getIdInmubles().equals(null)){
			inm.setHabilitado(true);
			modeloService.GuardarInmueble(inm);	
			mensajes("Se habilito correctamente el inmueble, ", 1);
		}else
			mensajes("Ocurrio un error inesperado, \n reintente", 0);
		
		
		}
		
	
	public void deshabilitarBotonesInm(){
	miVentanaAlquilerPrincipal.bActualizarI.setEnabled(false);;
	miVentanaAlquilerPrincipal.bEliminarI.setEnabled(false);
	miVentanaAlquilerPrincipal.bRestaurarI.setEnabled(false);
	}
	
	public void habilitarBotonesInm(boolean inmHabil){
		miVentanaAlquilerPrincipal.bActualizarI.setEnabled(true);
		if(inmHabil){
			miVentanaAlquilerPrincipal.bEliminarI.setEnabled(true);
			miVentanaAlquilerPrincipal.bRestaurarI.setEnabled(false);
		}else{
			miVentanaAlquilerPrincipal.bRestaurarI.setEnabled(true);
			miVentanaAlquilerPrincipal.bEliminarI.setEnabled(false);
		}
	}
	
	
	
	public void GuardarAlquiler(Alquiler alqui) {
		if(alqui.getNroalquiler()==null)
				PagarAlquilerCaja(alqui.getFechaactual(),
						( alqui.getPreciototal()-alqui.getMontofaltante()),
						alqui.getPersonas().getApellido()+" "+ alqui.getPersonas().getNombre());
		modeloService.GuardarAlquiler(alqui);
			
	}
	
	
//	public void GuardarAlquiler(Alquiler aux, Alquiler oldAlqui) {
//		modeloService.GuardarAlquiler(alqui);
//		
//		
//	}
	
	
//TODO REVISAR SI COMPRUEBA BIEN LOS DATOS VALOR BYTE
	/**
		CLASS ROWSRENDE YA MODIFICADA COMPROBAR BOTONES
	**/
	@SuppressWarnings("deprecation")
	public void ListarAlquileres(JTable tableAlq, List<Alquiler> listaAlquiler) {
		try{
//		java.util.List<Alquiler> listaAlquiler3= new ArrayList<Alquiler>();
//		Date aux= new Date(0,0,0,0,0);
//		aux.setDate(22);
//		aux.setMonth(1);
//		aux.setYear(2018-1900);			
//		//pruebas
//		Date in=new Date(0,0,0,0,0);
//		listaAlquiler3= BusquedaAlquilerXFechaActual(in,aux);
//			Integer anio, mes;
//			anio=2018;
//			mes=3;
//			Alquiler a=CrearAlquiler();
//				a=	buscarAlquiler(2);
//				Inmuebles I=BuscarInmueble(3);
//			listaAlquiler3=ListarAlquilerPormes(anio, mes);
//		this.listarCalendarioReserva();
//			listaAlquiler3=modeloService.ListarAlquileres();
//			Alquiler aux = modeloService.buscarAlquiler(1);
		DefaultTableModel  modeloT = new DefaultTableModel(){
			
			Class[] columnTypes = new Class[] {
					Byte.class, 
					Byte.class,
					Object.class,
					Object.class,
					Object.class, 
					Object.class, 
					Integer.class,
					String.class, 
					String.class ,//Date.class
					String.class,
					Float.class,
					String.class//Date.class
				};
				public Class getColumnClass(int columnIndex) {

					return columnTypes[columnIndex];
				}

			public boolean isCellEditable(int row,int colum){  
				return false;
			}
			
		};
		
		tableAlq.setModel(modeloT);
		modeloT.addColumn("Habilitado"); 
		modeloT.addColumn("Pagado");
		modeloT.addColumn(" "); //boton detalle
		modeloT.addColumn(" "); // boton mod
		modeloT.addColumn(" "); //boton pagar
		modeloT.addColumn(" "); // boton eliminar cancelar alquiler
		modeloT.addColumn("Nro de Alquiler"); 
		modeloT.addColumn("Persona");// apellido + nombre
		modeloT.addColumn("Inmueble");
		modeloT.addColumn("Fecha de reserva");
		modeloT.addColumn("Monto");
		modeloT.addColumn("Fecha de emisi\u00F3n");
	
	
		Object[] columna = new Object[12];//tableAlq
		if(listaAlquiler!=null){
		int numr=listaAlquiler.size();
		for(int i=numr-1;i>=0;i--){

			columna[0]=listaAlquiler.get(i).getActivo();
			columna[1]=listaAlquiler.get(i).getPagoalquiler();		
			columna[2]=miVentanaAlquilerPrincipal.btnDet;
			columna[3]=miVentanaAlquilerPrincipal.btnMod;
			columna[4]=miVentanaAlquilerPrincipal.btnPag;
			columna[5]=miVentanaAlquilerPrincipal.btnEli;
			columna[6]=listaAlquiler.get(i).getNroalquiler();
			columna[7]=listaAlquiler.get(i).getPersonas().getApellido()+" "+listaAlquiler.get(i).getPersonas().getNombre();
			columna[8]=listaAlquiler.get(i).getInmuebles().getNombre();
			Calendar cal =new GregorianCalendar(2015,1,1,0,0,0);
			
//			new SimpleDateFormat("dd-MM-yyyy").format(listaAlquiler.get(i).getFechareserva());
			if(listaAlquiler.get(i).getFechareserva().before(cal.getTime()))
				columna[9]= "S/N";
			else
				columna[9]=""+new SimpleDateFormat("yyyy-MM-dd").format(listaAlquiler.get(i).getFechareserva())
						+" " + new SimpleDateFormat("HH:mm:ss").format(listaAlquiler.get(i).getFechareserva());
			columna[10]= listaAlquiler.get(i).getPreciototal();
			columna[11]=listaAlquiler.get(i).getFechaactual();


			modeloT.addRow(columna);
			}
		}
		tableAlq.setRowHeight(25);
		ocultarColumnaAlquiler(0,tableAlq);
		ocultarColumnaAlquiler(1,tableAlq);
		ocultarColumnaAlquiler(6, tableAlq);
//		tableAlq.getTableHeader().getColumnModel().getColumn(numCol).setMaxWidth(0);
//		tableAlq.getTableHeader().getColumnModel().getColumn(numCol).setMinWidth(0);
//		tableAlq.getColumnModel().getColumn(numCol).setMaxWidth(0);
//		tableAlq.getColumnModel().getColumn(numCol).setMinWidth(0);
//		tableAlq.getColumnModel().getColumn(0).setResizable(false);
		
		
		tableAlq.getColumnModel().getColumn(2).setMaxWidth(40);
		tableAlq.getColumnModel().getColumn(2).	setPreferredWidth(30);
		tableAlq.getColumnModel().getColumn(3).setMaxWidth(40);
		tableAlq.getColumnModel().getColumn(3).setPreferredWidth(30);
		tableAlq.getColumnModel().getColumn(4).setMaxWidth(40);
		tableAlq.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableAlq.getColumnModel().getColumn(5).setMaxWidth(40);
		tableAlq.getColumnModel().getColumn(5).setPreferredWidth(30);
		tableAlq.getColumnModel().getColumn(6).setMaxWidth(80);
		tableAlq.getColumnModel().getColumn(7).setPreferredWidth(150);
		tableAlq.getColumnModel().getColumn(7).setMaxWidth(200);
		tableAlq.getColumnModel().getColumn(8).setPreferredWidth(150);
		tableAlq.getColumnModel().getColumn(8).setMaxWidth(200);
		tableAlq.getColumnModel().getColumn(9).setPreferredWidth(150);
		tableAlq.getColumnModel().getColumn(9).setMaxWidth(200);
		tableAlq.getColumnModel().getColumn(10).setPreferredWidth(70);
		tableAlq.getColumnModel().getColumn(10).setMaxWidth(200);
		tableAlq.getColumnModel().getColumn(11).setPreferredWidth(150);
		tableAlq.getColumnModel().getColumn(11).setMaxWidth(200);
		tableAlq.setDefaultRenderer(Object.class, new RowsRende(0,1));
		tableAlq.getTableHeader()
		.setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		tableAlq.setAutoCreateRowSorter(true);
		tableAlq.getTableHeader().setReorderingAllowed(false);
		//tableAlq.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		

		
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null,"¡ERROR! "+ /*e.toString()+ " " +*/ e.getLocalizedMessage(),"Atencion", JOptionPane.ERROR_MESSAGE);
			
			mensajes("OCURRIO ERROR CUANDO SE CARGABAN LOS ALQUILERES",0);
			//ocurio un error
		}
			
		
	}
		public void ocultarColumnaAlquiler(int numCol, JTable tableAlq){
			tableAlq.getTableHeader().getColumnModel().getColumn(numCol).setMaxWidth(0);
			tableAlq.getTableHeader().getColumnModel().getColumn(numCol).setMinWidth(0);
			tableAlq.getColumnModel().getColumn(numCol).setMaxWidth(0);
			tableAlq.getColumnModel().getColumn(numCol).setMinWidth(0);
			tableAlq.getColumnModel().getColumn(numCol).setResizable(false);
		}
		
		public List<Alquiler> BusquedaAlquilerXFechaReserva(Date fechaIn,Date fechaFin){
			return modeloService.BusquedaAlquilerXFecha(fechaIn,fechaFin);
		}
		public List<Alquiler> BusquedaAlquilerXFechaActual(Date fechaInicio,Date fechaFin){
			return modeloService.BusquedaAlquilerEntreFechas(fechaInicio,fechaFin);
		 }
		
		public List<Alquiler> ListarAlquilerPormes(Integer anio, Integer mes){
			return modeloService.ListaAlquilerPormes(anio, mes);
		}
		
		
	public List<Calendar> listarCalendarioReserva(){
			List<Calendar> aux=new ArrayList<Calendar>();
			List<Alquiler> auxAl= new ArrayList<Alquiler>();
			auxAl=modeloService.ListarAlquileres();
			
			for(int i=0;i<auxAl.size();i++){
				Calendar cal=Calendar.getInstance();
//				if((auxAl.get(i).getActivo()==(byte)1)&&(auxAl.get(i).getInmuebles()==numIdInmueble))
				if(auxAl.get(i).getActivo()==(byte)1){
					cal.setTime(auxAl.get(i).getFechareserva());
					aux.add(cal);
				}
			}
		return aux;
	}
	
	public List<Alquiler> listaAlquileresTodos(){
		
	java.util.List<Alquiler> listaAlquiler= new ArrayList<Alquiler>();
	listaAlquiler=modeloService.ListarAlquileres();
	return listaAlquiler;
	}
	
	public List<Alquiler> listaAlquileresPagados(){
		java.util.List<Alquiler> listaAlquiler= new ArrayList<Alquiler>();
		listaAlquiler=modeloService.ListarAlquileres();
		java.util.List<Alquiler> listaAux = new ArrayList<Alquiler>();
		byte b=1;
		int numr=listaAlquiler.size();
		
		for(int i=0;i<numr;i++){
			if(listaAlquiler.get(i).getPagoalquiler()==b){
				listaAux.add(listaAlquiler.get(i));
			}
		}
		
		return listaAux;
	}
	
	public List<Alquiler> listaAlquileresSeñados(){
		java.util.List<Alquiler> listaAlquiler= new ArrayList<Alquiler>();
		listaAlquiler=modeloService.ListarAlquileres();
		java.util.List<Alquiler> listaAux = new ArrayList<Alquiler>();
		byte b=0;
		int numr=listaAlquiler.size();
		for(int i=0;i<numr;i++){
			if(listaAlquiler.get(i).getPagoalquiler()==b){
				listaAux.add(listaAlquiler.get(i));
			}
		}
		
		
		return listaAux;
	}
	
	public boolean buscarAlquilerInmuebleFecha(Inmuebles inm, Date a){
		java.util.List<Alquiler> listaAlquiler= new ArrayList<Alquiler>();
		listaAlquiler=modeloService.ListarAlquileresRealizados(inm, a);
	
	if (listaAlquiler.isEmpty()){
		return listaAlquiler.isEmpty();
	}else{
		//funcion cuando no esta vacia
		//para agregar un listado 
		
		return listaAlquiler.isEmpty();
	}
	}
	
	public List<Alquiler> ListarAlquilerPorDia ( int anio,int mes, int dia) {
		return modeloService.ListarAlquilerPorDia(anio,mes,dia);
	}
	
	public List<Alquiler> ListarAlquilerPorDia (Date dia){
		return modeloService.ListarAlquilerPorDia(dia);
	}
	public Alquiler buscarAlquiler(Integer numAlquiler) {
	
		return modeloService.buscarAlquiler(numAlquiler);
	
	}
	
		
	
		
	
	
	
	
	
	
	
	
	
	
	
	/***FUNCIONES DE  MENSAJES
	  */
	public void mensajes(String mensaje, int tip){
	//	tip 0: error;
	//	1: informacion; 
	//	2:advertencia 
	//	3:pregunta 
	//	defecto: cuadro solo
		
		switch(tip){
		case 0:
			JOptionPane.showMessageDialog(null,mensaje,"Sistema Club Avenida Ejercito"/*: Error"*/,JOptionPane.ERROR_MESSAGE,new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/impo.png")));
			break;
		case 1:
			JOptionPane.showMessageDialog(null, mensaje ,"Sistema Club Avenida Ejercito"/*: Información"*/,JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/info.png")));
			
			break;
		case 2:
			JOptionPane.showMessageDialog(null, mensaje ,"Sistema Club Avenida Ejercito"/*: Advertencia"*/,JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png")));
			break;
			
		case 3:JOptionPane.showMessageDialog(null, mensaje, "Sistema Club Avenida Ejercito"/*: ¿Pregunta?"*/,JOptionPane.QUESTION_MESSAGE);
			break;
			
			default:
				JOptionPane.showMessageDialog(null, mensaje/*,JOptionPane.PLAIN_MESSAGE*/);
				break;
		}
	}
	
	

	public int mensajeOpciones(String titulo,String mensaje,int tip){
	if(tip<0 || tip>3){
		tip=-1;
	}
	// YES_OPTION=0
	// NO_OPTION	1
	//CANCEL_OPTION	2
	// CLOSED_OPTION	-1
	
	//	ERROR_MESSAGE	0
	//INFORMATION_MESSAGE	1
//	WARNING_MESSAGE	2
	// QUESTION_MESSAGE	3
	
	//	PLAIN_MESSAGE	-1
	
	/*
	 if (JOptionPane.showConfirmDialog(this, 
	 "¿Desea inhabilitar la persona",
	  "Sistema Club Avenida Ejercito",
	   JOptionPane.YES_NO_OPTION, 
	   0,
	   new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION)
	 */
	
	int num= JOptionPane.showConfirmDialog(null
			,mensaje
			,"Sistema Club Avenida Ejercito: " + titulo
			,JOptionPane.YES_NO_OPTION
			,tip
			,new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png")));	
		return num;
		
		/*
		int num= JOptionPane.showConfirmDialog(null
			,mensaje
			,"Sistema Club Avenida Ejercito: " + titulo
			,JOptionPane.YES_NO_OPTION
			,tip);	
		return num;
		
		*/
		
		
	}
	
	

	public void mostrarVentanaNuevoAlquiler(){
		miVentanaNuevoAlquiler.limpiar();
		miVentanaNuevoAlquiler.Colorear.setListDeFechasCalendar(modeloService.ListarAlquileres());
		miVentanaNuevoAlquiler.Colorear.nullNombreInmuble();
		//miVentanaNuevoAlquiler.calen.getDayChooser().addDateEvaluator(new FechasCalendar(null));
		miVentanaNuevoAlquiler.setVisible(true);//TODO pantalla nuevo alquiler
		
		
	}
	public void mostrarVentanaDetallesAlquiler(int nroAlqui) {
		try{
		
		miVentanaDetallesAlquiler.texDetalle.setText(null);
		miVentanaDetallesAlquiler.texDetalle.setEditable(false);
		Alquiler aux=this.CrearAlquiler();
		aux=modeloService.buscarAlquiler(nroAlqui);
		String texto=new String();
		String textoactivo=new String();
		String textoPagado=new String();
		String textoFechaReserva= new String();
		String textoHoraReserva=new String();
		byte q=1;
		String texPer=new String();
		String texInm=new String();
		if(aux.getActivo()==q){
			textoactivo="Estado del Alquiler: Habilitado";
			textoFechaReserva="Fecha de Reserva: "+ (new SimpleDateFormat("dd-MM-yyyy").format(aux.getFechareserva()));
			textoHoraReserva="Hora de Reserva: "+ new SimpleDateFormat("HH:mm:ss").format(aux.getFechareserva());
		}else{
			textoactivo	= "Estado del Alquiler: Deshabilitado";
			textoFechaReserva="Fecha de Reserva: S/N";
			textoHoraReserva="Hora de Reserva: S/N";
		}
		if(aux.getPagoalquiler()==q){
			textoPagado="Alquiler: Pagado Completo" +'\n'+""+ 
		"Fecha de Pago: "+ (new SimpleDateFormat("dd-MM-yyyy").format(aux.getFechapagoalquiler()));
			
			
		}else{
			textoPagado="Alquiler: Pagado Incompleto" +'\n'+""+ 
		"Monto Faltante: "+aux.getMontofaltante();
		}
		
		/*    
		 DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
System.out.println("Hora: "+hourFormat.format(date)); 
		 +'\n'+""+
		 */
		
		
		texPer=aux.getPersonas().getApellido()+" "+aux.getPersonas().getNombre();
		texInm=aux.getInmuebles().getNombre();
		texto= "Persona: " + texPer +'\n'+""+
		"Inmueble Alquilado: "+texInm +'\n'+""+
		"Fecha de emisión: "+ (new SimpleDateFormat("dd-MM-yyyy").format(aux.getFechaactual())) +'\n'+""+
		textoactivo +'\n'+""+ 
		textoFechaReserva +'\n'+""+
		textoHoraReserva +'\n'+""+
		"Cantidad de horas alquilado: "+ aux.getCantidadhoras() +'\n'+""+
		"Precio Total: "+aux.getPreciototal()  +'\n'+""+
		textoPagado +'\n'+""+
		"Observaciones: "+ aux.getObservaciones();
		miVentanaDetallesAlquiler.texDetalle.setText(texto);
		
		miVentanaDetallesAlquiler.setVisible(true);
		}catch(Exception e){
			mensajes("Error en la ventana detalles", 0);
		}
		
	}

	public void eliminarAlquiler(int nroAlqui) {
		modeloService.EliminarAlquiler(nroAlqui);
	}

	public void recargarPanelAlquiler(){
		miVentanaAlquilerPrincipal.RecargarPanelAlquiler();
	}
	public void modificarAlquiler(int nroAlqui) {
		miVentanaNuevoAlquiler.cargarDatosAlquilerModificar(nroAlqui);
		
		// no puede modificar alquileres eliminados
		// se genera como un nuevo alquiler con nueva fecha de emision
	}
	
	
	public void cargarDatosAlquilerModificar(int nroAlqui){
try {   
			miVentanaNuevoAlquiler.limpiar();
			//miVentanaNuevoAlquiler.oldAlqui=modeloService.buscarAlquiler(nroAlqui);
			Alquiler alquiler=modeloService.CrearInstanciaAlquiler();
			alquiler=modeloService.buscarAlquiler(nroAlqui);
			alquiler.setCantidadhoras(8);
			modeloService.GuardarAlquiler(alquiler);
			/**Campos personas*/
		miVentanaNuevoAlquiler.pers=miVentanaNuevoAlquiler.oldAlqui.getPersonas();
			if(miVentanaNuevoAlquiler.personaHabilitadaParaAlquiler(miVentanaNuevoAlquiler.pers)){
				miVentanaNuevoAlquiler.habilitarCampoPersona(false);
				miVentanaNuevoAlquiler.txtApe.setText(miVentanaNuevoAlquiler.oldAlqui.getPersonas().getApellido());
				miVentanaNuevoAlquiler.txtDni.setText(miVentanaNuevoAlquiler.oldAlqui.getPersonas().getDni().toString());
				miVentanaNuevoAlquiler.txtNom.setText(miVentanaNuevoAlquiler.oldAlqui.getPersonas().getNombre());
				//miVentanaNuevoAlquiler.
				miVentanaNuevoAlquiler.pers=this.BuscarPersona(
						miVentanaNuevoAlquiler.oldAlqui.getPersonas().getDni());
				if(miVentanaNuevoAlquiler.oldAlqui.getInmuebles().isHabilitado()==true){
					String auxNombreInmueble =miVentanaNuevoAlquiler.oldAlqui.getInmuebles().getNombre();
//					miVentanaNuevoAlquiler.comboInmuebles.setSelectedItem(miVentanaNuevoAlquiler.oldAlqui.getInmuebles().getNombre());
					miVentanaNuevoAlquiler.comboInmuebles.setSelectedItem(auxNombreInmueble);
				}else
					this.mensajes("El inmueble de este alquiler esta deshabilitado", 1);
				
//				miVentanaNuevoAlquiler.comboInmuebles.setEnabled(true);
				Calendar fechaDeReserva = new GregorianCalendar();
				fechaDeReserva.setTime(miVentanaNuevoAlquiler.oldAlqui.getFechareserva());
				
				miVentanaNuevoAlquiler.txtHoraR.setValue(fechaDeReserva.get(Calendar.HOUR_OF_DAY));
				miVentanaNuevoAlquiler.calen.setDate(fechaDeReserva.getTime());
				miVentanaNuevoAlquiler.txtCantidadHoras.setValue(miVentanaNuevoAlquiler.oldAlqui.getCantidadhoras());
				miVentanaNuevoAlquiler.txtSen.setText(Float.toString(miVentanaNuevoAlquiler.oldAlqui.getInmuebles().getSenial()));
				miVentanaNuevoAlquiler.ResuPrecioTotal.setText(Float.toString(miVentanaNuevoAlquiler.oldAlqui.getPreciototal()));
				Float montoAFavor=miVentanaNuevoAlquiler.oldAlqui.getPreciototal()-miVentanaNuevoAlquiler.oldAlqui.getMontofaltante();
				miVentanaNuevoAlquiler.txtMontoApagar.setText(Float.toString(montoAFavor));
				miVentanaNuevoAlquiler.txtMontoFaltante.setText(Float.toString(miVentanaNuevoAlquiler.oldAlqui.getMontofaltante()));
				miVentanaNuevoAlquiler.habilitarCamporReserva(true, false);
				miVentanaNuevoAlquiler.txtObservaciones.setText(miVentanaNuevoAlquiler.oldAlqui.getObservaciones());
				
				miVentanaNuevoAlquiler.setVisible(true);
			} else 
				this.mensajes("La persona no esta habilitada para el alquiler", 2);
} catch (Exception e) {
	this.mensajes("Ocurrió un error: "+e.getMessage(), 0);

}
		
		
		
		
}
	

	
	public void pagarAlquiler(int nroAlqui) {
		mensajes("boton Pagar "+ nroAlqui,0);
		miVentanaNuevoAlquiler.cargarDatosAlquilerPagar(nroAlqui);
		//puede ser un joption panel que muestre la cantidad faltante, nombre apellido, 
		// inmueble, monto total y monto faltante 
		
	}
	
	
	public void cargarDatosAlquilerPagar(int nroAlqui){
		try {
			miVentanaNuevoAlquiler.limpiar();
			miVentanaNuevoAlquiler.oldAlqui=modeloService.buscarAlquiler(nroAlqui);
			/**Campos personas*/
			miVentanaNuevoAlquiler.pers=miVentanaNuevoAlquiler.oldAlqui.getPersonas();
				if(miVentanaNuevoAlquiler.personaHabilitadaParaAlquiler(miVentanaNuevoAlquiler.pers)){
					miVentanaNuevoAlquiler.habilitarCampoPersona(false);
					miVentanaNuevoAlquiler.txtApe.setText(miVentanaNuevoAlquiler.oldAlqui.getPersonas().getApellido());
					miVentanaNuevoAlquiler.txtDni.setText(miVentanaNuevoAlquiler.oldAlqui.getPersonas().getDni().toString());
					miVentanaNuevoAlquiler.txtNom.setText(miVentanaNuevoAlquiler.oldAlqui.getPersonas().getNombre());
					
					miVentanaNuevoAlquiler.pers=this.BuscarPersona(
							miVentanaNuevoAlquiler.oldAlqui.getPersonas().getDni());
					if(miVentanaNuevoAlquiler.oldAlqui.getInmuebles().isHabilitado()==true){
						String auxNombreInmueble =miVentanaNuevoAlquiler.oldAlqui.getInmuebles().getNombre();
//						miVentanaNuevoAlquiler.comboInmuebles.setSelectedItem(miVentanaNuevoAlquiler.oldAlqui.getInmuebles().getNombre());
						miVentanaNuevoAlquiler.comboInmuebles.setSelectedItem(auxNombreInmueble);
						
						Calendar fechaDeReserva = new GregorianCalendar();
						fechaDeReserva.setTime(miVentanaNuevoAlquiler.oldAlqui.getFechareserva());
						
						miVentanaNuevoAlquiler.txtHoraR.setValue(fechaDeReserva.get(Calendar.HOUR_OF_DAY));
						miVentanaNuevoAlquiler.calen.setDate(fechaDeReserva.getTime());
						miVentanaNuevoAlquiler.txtCantidadHoras.setValue(miVentanaNuevoAlquiler.oldAlqui.getCantidadhoras());
						miVentanaNuevoAlquiler.txtSen.setText(Float.toString(miVentanaNuevoAlquiler.oldAlqui.getInmuebles().getSenial()));
						miVentanaNuevoAlquiler.ResuPrecioTotal.setText(Float.toString(miVentanaNuevoAlquiler.oldAlqui.getPreciototal()));
						Float montoAFavor=miVentanaNuevoAlquiler.oldAlqui.getPreciototal()-miVentanaNuevoAlquiler.oldAlqui.getMontofaltante();
						//miVentanaNuevoAlquiler.txtMontoApagar.setText(Float.toString(montoAFavor));
						miVentanaNuevoAlquiler.txtMontoFaltante.setText(Float.toString(miVentanaNuevoAlquiler.oldAlqui.getMontofaltante()));
						
						miVentanaNuevoAlquiler.habilitarCamporReserva(false, true);
						miVentanaNuevoAlquiler.txtObservaciones.setText(miVentanaNuevoAlquiler.oldAlqui.getObservaciones());
//					miVentanaNuevoAlquiler.
						miVentanaNuevoAlquiler.setVisible(true);
					
					
					
					}else{
						this.mensajes("El inmueble de este alquiler esta deshabilitado", 1);
						miVentanaNuevoAlquiler.limpiar();
					}
					
					
				} else {
					this.mensajes("La persona no esta habilitada para el alquiler", 2);
					miVentanaNuevoAlquiler.limpiar();
				}
			
			
			
			
			
			
			
		}catch (Exception e) {
			this.mensajes("Ocurrió un error: "+e.getMessage(), 0);

		}
		
		
	}
	
	
	public List<Personas> filtrarPersonaPor(String nom, String ape){
		
		return modeloService.ObtenerPersonaNomApe(nom,ape);
			
				
		}

	
	public void PagarAlquilerCaja(Date fecha,float monto, String ApeYNomb){
		Caja aux=CrearRegistroCaja();
		aux.setConceptos(BuscarConcepto(1));
		aux.setFecha(fecha);
		aux.setMonto(monto);
		String descripcion=ApeYNomb +"Pago de Alquiler";
		aux.setDescripcion(descripcion);
		aux.setHabilitar(true);
		GuardarRegistroCaja(aux);
		
		
	}


	public void CargarTablaAlquilerPorDia(JTable tableDia, List<Alquiler> listaAl,
			Object selectedItem) {
		
		try {
			DefaultTableModel modeloT =new DefaultTableModel(){
				
				public boolean isCellEditable (int row, int colum){
					return false;
				}
			};
			tableDia.setModel(modeloT);
			modeloT.addColumn("Inmueble");
			modeloT.addColumn("Desde");
			modeloT.addColumn("Hasta");
			modeloT.addColumn("nroAlquiler");
			modeloT.addColumn("cantidadHoras");
			
			Object[] columna=new Object[5];
			if(listaAl!=null){
				int num=listaAl.size();
				for(int i =0;i<num;i++){
					if((listaAl.get(i).getInmuebles().getNombre().equals(selectedItem))
							||(selectedItem.equals("Seleccione el inmueble"))){
						columna[0]=listaAl.get(i).getInmuebles().getNombre();
						Calendar cal =Calendar.getInstance();
						cal.setTime(listaAl.get(i).getFechareserva());
						columna[1]=cal.get(Calendar.HOUR_OF_DAY)+":00";
						int aux=(cal.get(Calendar.HOUR_OF_DAY)+listaAl.get(i).getCantidadhoras());
						if(aux>=24)
							aux=aux-24;
						columna[2]=aux+":00";
						columna[3]=listaAl.get(i).getNroalquiler();
						columna[4]=listaAl.get(i).getCantidadhoras();
						modeloT.addRow(columna);
					}
				}
				tableDia.setRowHeight(25);
				tableDia.setToolTipText("Clic para ver\n detalles");
				ocultarColumnaAlquiler(3, tableDia);	
				ocultarColumnaAlquiler(4, tableDia);
			}
			tableDia.setRowHeight(25);
			tableDia.setToolTipText("Clic para ver\n detalles");
			ocultarColumnaAlquiler(3, tableDia);	
		} catch (Exception e) {
			mensajes("OCURRIÓ UN ERROR EN LA CARGA", 0);
//			e.printStackTrace();
		}
	}

	
	


	
	
}



