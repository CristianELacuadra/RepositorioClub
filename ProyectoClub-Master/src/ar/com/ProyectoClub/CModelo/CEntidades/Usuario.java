package ar.com.ProyectoClub.CModelo.CEntidades;
// Generated 23-oct-2017 18:29:51 by Hibernate Tools 5.2.3.Final

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private Integer idUsuario;
	private String nick;
	private String password;
	private String tipousuario;

	public Usuario() {
	}

	public Usuario(String nick, String password, String tipousuario) {
		this.nick = nick;
		this.password = password;
		this.tipousuario = tipousuario;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}

}
