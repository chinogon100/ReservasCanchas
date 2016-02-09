package ec.edu.ups.canchas.objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "roles", catalog = "canchas")
public class Roles implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5918642204121394588L;
	private Integer idroles;
	private Usuario usuario;
	private String rol;

	public Roles() {
	}

	public Roles(Usuario usuario, String rol) {
		this.usuario = usuario;
		this.rol = rol;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idroles", unique = true, nullable = false)
	public Integer getIdroles() {
		return this.idroles;
	}

	public void setIdroles(Integer idroles) {
		this.idroles = idroles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "rol", nullable = false, length = 45)
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
