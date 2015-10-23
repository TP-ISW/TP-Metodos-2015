package clasesDeTablas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;


/**
 * The persistent class for the COMPROBANTE database table.
 * 
 */
@Entity
@NamedQuery(name="Comprobante.findAll", query="SELECT c FROM Comprobante c")
public class Comprobante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPROBANTE_IDCOMPROBANTE_GENERATOR", sequenceName="SECUENCIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPROBANTE_IDCOMPROBANTE_GENERATOR")
	private int idcomprobante;

	private String cuit;

	@Temporal(TemporalType.DATE)
	private Calendar fechaEmision;

	private Float monto;

	//bi-directional one-to-one association to Licenciaexpirada
	@OneToOne(mappedBy="comprobante")
	private Licenciaexpirada licenciaExpirada;

	//bi-directional one-to-one association to Licenciavigente
	@OneToOne(mappedBy="comprobante")
	private Licenciavigente licenciaVigente;

	public Comprobante() {
	}

	public int getIdcomprobante() {
		return this.idcomprobante;
	}

	public void setIdcomprobante(int idcomprobante) {
		this.idcomprobante = idcomprobante;
	}

	public String getCuit() {
		return this.cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public Calendar getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Calendar fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Float getMonto() {
		return this.monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Licenciaexpirada getLicenciaExpirada() {
		return this.licenciaExpirada;
	}

	public void setLicenciaExpirada(Licenciaexpirada licenciaExpirada) {
		this.licenciaExpirada = licenciaExpirada;
	}

	public Licenciavigente getLicenciaVigente() {
		return this.licenciaVigente;
	}

	public void setLicenciaVigente(Licenciavigente licenciaVigente) {
		this.licenciaVigente = licenciaVigente;
	}

}