package ec.edu.ups.canchas.objetos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "C_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Usuario() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idusuario;
	@Column(unique = true, nullable = true, length = 255)
	private String usuario;
	@Lob
	@Column(nullable = true)
	private String contrase�a;
	private Boolean habilitado=true;
	private String email;
	public long getIdusuario() {
		return idusuario;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public void setIdusuario(long id) {
		this.idusuario = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String param) {
		this.usuario = param;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String param) {
		this.contrase�a = param;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String param) {
		this.email = param;
	}

}