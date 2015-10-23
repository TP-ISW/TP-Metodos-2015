package clasesDeTablas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;


/**
 * The persistent class for the LICENCIAVIGENTE database table.
 * 
 */
@Entity
@NamedQuery(name="Licenciavigente.findAll", query="SELECT l FROM Licenciavigente l")
public class Licenciavigente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LICENCIAVIGENTE_IDLICENCIA_GENERATOR", sequenceName="SECUENCIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LICENCIAVIGENTE_IDLICENCIA_GENERATOR")
	private int idlicencia;

	private String categoria;

	private Float costo;

	@Temporal(TemporalType.DATE)
	private Calendar fechaEmision;

	@Temporal(TemporalType.DATE)
	private Calendar fechaVencimiento;

	@Column(name="NUEMEROCOPIA")
	private String numeroCopia;

	private String observaciones;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="IDCLASE")
	private Clase clase;

	//bi-directional one-to-one association to Comprobante
	@OneToOne
	@JoinColumn(name="IDLICENCIA", referencedColumnName="IDLICENCIA")
	private Comprobante comprobante;

	//bi-directional many-to-one association to Titular
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="NRODOC", referencedColumnName="NRODOC"),
		@JoinColumn(name="TIPODOC", referencedColumnName="TIPODOC")
		})
	private Titular titular;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO")
	private Usuario usuario;

	public Licenciavigente() {
	}

	public int getIdlicencia() {
		return this.idlicencia;
	}

	public void setIdlicencia(int idlicencia) {
		this.idlicencia = idlicencia;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Float getCosto() {
		return this.costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Calendar getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Calendar fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Calendar getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Calendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNumeroCopia() {
		return this.numeroCopia;
	}

	public void setNumeroCopia(String numeroCopia) {
		this.numeroCopia = numeroCopia;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Comprobante getComprobante() {
		return this.comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public Titular getTitular() {
		return this.titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}