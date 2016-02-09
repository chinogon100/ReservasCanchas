package ec.edu.ups.canchas.objetos;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "usuario", catalog = "canchas", uniqueConstraints = @UniqueConstraint(columnNames = "usuario") )
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5961343839019461458L;
	private Integer idusuario;
	private String usuario;
	private String contraseña;
	private String email;
	private Boolean habilitado;
	private Set<Persona> personas = new HashSet<Persona>(0);
	private Set<Roles> roleses = new HashSet<Roles>(0);
	private Set<Noticias> noticiases = new HashSet<Noticias>(0);
	private Set<Observaciones> observacioneses = new HashSet<Observaciones>(0);
	private Set<Reservas> reservases = new HashSet<Reservas>(0);
	private Set<Canchas> canchases = new HashSet<Canchas>(0);

	public Usuario() {
	}

	public Usuario(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public Usuario(String usuario, String contraseña, String email, Boolean habilitado, Set<Persona> personas,
			Set<Roles> roleses, Set<Noticias> noticiases, Set<Observaciones> observacioneses, Set<Reservas> reservases,
			Set<Canchas> canchases) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.email = email;
		this.habilitado = habilitado;
		this.personas = personas;
		this.roleses = roleses;
		this.noticiases = noticiases;
		this.observacioneses = observacioneses;
		this.reservases = reservases;
		this.canchases = canchases;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusuario", unique = true, nullable = false)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@Column(name = "usuario", unique = true, nullable = false, length = 70)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "contraseña", nullable = false, length = 250)
	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Column(name = "email", length = 250)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "habilitado")
	public Boolean getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Noticias> getNoticiases() {
		return this.noticiases;
	}

	public void setNoticiases(Set<Noticias> noticiases) {
		this.noticiases = noticiases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Observaciones> getObservacioneses() {
		return this.observacioneses;
	}

	public void setObservacioneses(Set<Observaciones> observacioneses) {
		this.observacioneses = observacioneses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Reservas> getReservases() {
		return this.reservases;
	}

	public void setReservases(Set<Reservas> reservases) {
		this.reservases = reservases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Canchas> getCanchases() {
		return this.canchases;
	}

	public void setCanchases(Set<Canchas> canchases) {
		this.canchases = canchases;
	}

}
