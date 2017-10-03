package ar.com.ProyectoClub.CModelo.DRepository.ExceptionsHibernate;

public interface ISessionTransaccionGeneric{
	/**
	 * Setession():si la secion no se inicializo, la inicializa a partir de hibernetutil.
	 */
	public void Setsession() throws BussinessException;
	
	/**
	 * @see settransaction verifica si hay una transaccion activa,si la tiene la abre, si no no hace nada.
	 */
	public void SetTransaction() throws BussinessException;
}
