package ar.com.ProyectoClub.CModelo.DPersistencia.BDao;

public class RelanzadorExcepciones {
	public static RuntimeException Lanzar(Exception ex){
		throw new AssertionError("Esta línea nunca se ejecutará pero Java no lo sabe");
	}
	@SuppressWarnings({ "unused", "unchecked" })
	private static <T extends Exception> void lanzarComoUnchecked(Exception Tothrow) throws T{
		throw (T) Tothrow;	
	}
}
