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
@Table(name = "observaciones", catalog = "canchas")
public class Observaciones implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2798024884742466069L;
	private Integer idobservaciones;
	private Reservas reservas;
	private Usuario usuario;
	private String observacion;

	public Observaciones() {
	}

	public Observaciones(Reservas reservas, Usuario usuario) {
		this.reservas = reservas;
		this.usuario = usuario;
	}

	public Observaciones(Reservas reservas, Usuario usuario, String observacion) {
		this.reservas = reservas;
		this.usuario = usuario;
		this.observacion = observacion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idobservaciones", unique = true, nullable = false)
	public Integer getIdobservaciones() {
		return this.idobservaciones;
	}

	public void setIdobservaciones(Integer idobservaciones) {
		this.idobservaciones = idobservaciones;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservas_idreservas", nullable = false)
	public Reservas getReservas() {
		return this.reservas;
	}

	public void setReservas(Reservas reservas) {
		this.reservas = reservas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "observacion", length = 45)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
