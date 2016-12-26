package ar.com.ProyectoClub.CModelo.BAplicacion.ExceptionAplicacion;

@SuppressWarnings("serial")
public class NroSocioErronea extends Exception {
     public NroSocioErronea() {}
     public NroSocioErronea(String Mensaje){
    	 super(Mensaje);
     }
}
