package ec.edu.ups.canchas.objetos;
// Generated 08-feb-2016 21:26:20 by Hibernate Tools 4.3.1.Final

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

/**
 * Reservas generated by hbm2java
 */
@Entity
@Table(name = "reservas", catalog = "canchas")
public class Reservas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1279606865585829633L;
	private Integer idreservas;
	private Canchas canchas;
	private Usuario usuario;
	private Date fecha;
	private Date hora;
	private Date duracion;
	private BigDecimal costoTotal;
	private Integer calificacionUsuario;
	private Integer calificacionCancha;
	private Set<Observaciones> observacioneses = new HashSet<Observaciones>(0);

	public Reservas() {
	}

	public Reservas(Canchas canchas, Usuario usuario) {
		this.canchas = canchas;
		this.usuario = usuario;
	}

	public Reservas(Canchas canchas, Usuario usuario, Date fecha, Date hora, Date duracion, BigDecimal costoTotal,
			Integer calificacionUsuario, Integer calificacionCancha, Set<Observaciones> observacioneses) {
		this.canchas = canchas;
		this.usuario = usuario;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.costoTotal = costoTotal;
		this.calificacionUsuario = calificacionUsuario;
		this.calificacionCancha = calificacionCancha;
		this.observacioneses = observacioneses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idreservas", unique = true, nullable = false)
	public Integer getIdreservas() {
		return this.idreservas;
	}

	public void setIdreservas(Integer idreservas) {
		this.idreservas = idreservas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "canchas_idcanchas", nullable = false)
	public Canchas getCanchas() {
		return this.canchas;
	}

	public void setCanchas(Canchas canchas) {
		this.canchas = canchas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora", length = 8)
	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "duracion", length = 8)
	public Date getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Date duracion) {
		this.duracion = duracion;
	}

	@Column(name = "costo_total", precision = 10)
	public BigDecimal getCostoTotal() {
		return this.costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	@Column(name = "calificacion_usuario")
	public Integer getCalificacionUsuario() {
		return this.calificacionUsuario;
	}

	public void setCalificacionUsuario(Integer calificacionUsuario) {
		this.calificacionUsuario = calificacionUsuario;
	}

	@Column(name = "calificacion_cancha")
	public Integer getCalificacionCancha() {
		return this.calificacionCancha;
	}

	public void setCalificacionCancha(Integer calificacionCancha) {
		this.calificacionCancha = calificacionCancha;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reservas")
	public Set<Observaciones> getObservacioneses() {
		return this.observacioneses;
	}

	public void setObservacioneses(Set<Observaciones> observacioneses) {
		this.observacioneses = observacioneses;
	}

}