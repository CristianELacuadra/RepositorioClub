package ar.com.ProyectoClub.AVista;



public class Vistas {
	//vistas contiene todos los  formularios que el controlador va usar
	private Inicio frminicio;
	private PantallaNuevoSocio frmpantallasocio;
	private PantallaPersona frmpantallapersona;
    private Principal frmrprincipal;
	
    public Vistas() {
    	frminicio=new Inicio();
    	frmrprincipal=new Principal();
    	/*
    	frmpantallapersona=new PantallaPersona();
    	frmpantallasocio=new PantallaNuevoSocio();
    	*/
    }
    
    public Inicio getFrminicio() {
		return frminicio;
    }
    /*
    public PantallaPersona getFrmpantallapersona() {
		return frmpantallapersona;
	}
    public PantallaNuevoSocio getFrmpantallasocio() {
		return frmpantallasocio;
	}
	*/
    public Principal getFrmrprincipal() {
		return frmrprincipal;
	}
	
    public void setFrminicio(Inicio frminicio) {
		this.frminicio = frminicio;
	}
    /*
    public void setFrmpantallapersona(PantallaPersona frmpantallapersona) {
		this.frmpantallapersona = frmpantallapersona;
	}
    public void setFrmpantallasocio(PantallaNuevoSocio frmpantallasocio) {
		this.frmpantallasocio = frmpantallasocio;
	}
	*/
	public void setFrmrprincipal(Principal frmrprincipal) {
		this.frmrprincipal = frmrprincipal;
	}
	
}
