package ec.edu.ups.canchas.objetos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "canchas", catalog = "canchas")
public class Canchas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -939811621318652157L;
	private Integer idcanchas;
	private Usuario usuario;
	private String nombreComercial;
	private String razonSocial;
	private String ruc;
	private String coordenadasx;
	private String coordenadasy;
	private String direccion;
	private String email;
	private Date horaApertura;
	private Date horaCierre;
	private String ciudad;
	private Integer capacidad;
	private BigDecimal costoHora;
	private Set<Reservas> reservases = new HashSet<Reservas>(0);

	public Canchas() {
	}

	public Canchas(Usuario usuario, String nombreComercial) {
		this.usuario = usuario;
		this.nombreComercial = nombreComercial;
	}

	public Canchas(Usuario usuario, String nombreComercial, String razonSocial, String ruc, String coordenadasx,
			String coordenadasy, String direccion, String email, Date horaApertura, Date horaCierre, String ciudad,
			Integer capacidad, BigDecimal costoHora, Set<Reservas> reservases) {
		this.usuario = usuario;
		this.nombreComercial = nombreComercial;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.coordenadasx = coordenadasx;
		this.coordenadasy = coordenadasy;
		this.direccion = direccion;
		this.email = email;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.ciudad = ciudad;
		this.capacidad = capacidad;
		this.costoHora = costoHora;
		this.reservases = reservases;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idcanchas", unique = true, nullable = false)
	public Integer getIdcanchas() {
		return this.idcanchas;
	}

	public void setIdcanchas(Integer idcanchas) {
		this.idcanchas = idcanchas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nombre_comercial", nullable = false, length = 250)
	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	@Column(name = "razon_social", length = 250)
	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Column(name = "ruc", length = 13)
	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	@Column(name = "coordenadasx", length = 200)
	public String getCoordenadasx() {
		return this.coordenadasx;
	}

	public void setCoordenadasx(String coordenadasx) {
		this.coordenadasx = coordenadasx;
	}

	@Column(name = "coordenadasy", length = 200)
	public String getCoordenadasy() {
		return this.coordenadasy;
	}

	public void setCoordenadasy(String coordenadasy) {
		this.coordenadasy = coordenadasy;
	}

	@Column(name = "direccion", length = 45)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "email", length = 200)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_apertura", length = 8)
	public Date getHoraApertura() {
		return this.horaApertura;
	}

	public void setHoraApertura(Date horaApertura) {
		this.horaApertura = horaApertura;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_cierre", length = 8)
	public Date getHoraCierre() {
		return this.horaCierre;
	}

	public void setHoraCierre(Date horaCierre) {
		this.horaCierre = horaCierre;
	}

	@Column(name = "ciudad", length = 45)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Column(name = "capacidad")
	public Integer getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	@Column(name = "costo_hora", precision = 10)
	public BigDecimal getCostoHora() {
		return this.costoHora;
	}

	public void setCostoHora(BigDecimal costoHora) {
		this.costoHora = costoHora;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "canchas")
	public Set<Reservas> getReservases() {
		return this.reservases;
	}

	public void setReservases(Set<Reservas> reservases) {
		this.reservases = reservases;
	}

}
