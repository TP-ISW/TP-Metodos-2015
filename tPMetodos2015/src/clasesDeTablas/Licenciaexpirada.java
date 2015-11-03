package clasesDeTablas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;


/**
 * The persistent class for the LICENCIAEXPIRADA database table.
 * 
 */
@Entity
@NamedQuery(name="Licenciaexpirada.findAll", query="SELECT l FROM Licenciaexpirada l")
public class Licenciaexpirada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LICENCIAEXPIRADA_IDLICENCIA_GENERATOR", sequenceName="SECUENCIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LICENCIAEXPIRADA_IDLICENCIA_GENERATOR")
	private int idLicencia;

	private String categoria;

	private Float costo;

	@Temporal(TemporalType.DATE)
	private Calendar fechaEmision;

	@Temporal(TemporalType.DATE)
	private Calendar fechaVencimiento;

	private String numeroCopia;

	private String observaciones;

	//uni-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="IDCLASE")
	private Clase clase;

	//bi-directional one-to-one association to Comprobante
	@OneToOne
	@JoinColumn(name="IDCOMPROBANTE", referencedColumnName="IDCOMPROBANTE")
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

	public Licenciaexpirada() {
	}

	public int getIdLicencia() {
		return this.idLicencia;
	}

	public void setIdLicencia(int idLicencia) {
		this.idLicencia = idLicencia;
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