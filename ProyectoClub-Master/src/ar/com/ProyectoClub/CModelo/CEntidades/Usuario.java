package ar.com.ProyectoClub.CModelo.CEntidades;
// Generated 01-oct-2017 13:17:29 by Hibernate Tools 5.2.3.Final

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private Integer idUsuario;
	private String nick;
	private Integer password;
	private String tipousuario;

	public Usuario() {
	}

	public Usuario(String nick, Integer password, String tipousuario) {
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

	public Integer getPassword() {
		return this.password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public String getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}

}
