package clasesDeTablas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the TITULAR database table.
 * 
 */
@Entity
@NamedQuery(name="Titular.findAll", query="SELECT t FROM Titular t")
public class Titular implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TitularPK id;

	private String apellido;

	private String domicilio;

	private Boolean donante;

	private String factorRh;

	@Temporal(TemporalType.DATE)
	private Calendar fechaNacimiento;

	private String foto;

	private String grupoSanguineo;

	private String nombre;

	private String sexo;

	//bi-directional many-to-one association to Licenciaexpirada
	@OneToMany(mappedBy="titular")
	private List<Licenciaexpirada> licenciasExpiradas;

	//bi-directional many-to-one association to Licenciavigente
	@OneToMany(mappedBy="titular")
	private List<Licenciavigente> licenciasVigentes;

	//bi-directional many-to-many association to Clase
	@ManyToMany
	@JoinTable(
		name="SOLICITA"
		, joinColumns={
			@JoinColumn(name="NRODOC", referencedColumnName="NRODOC"),
			@JoinColumn(name="TIPODOC", referencedColumnName="TIPODOC")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDCLASE")
			}
		)
	private List<Clase> clasesSolicitadas;

	public Titular() {
	}

	public TitularPK getId() {
		return this.id;
	}

	public void setId(TitularPK id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Boolean getDonante() {
		return this.donante;
	}

	public void setDonante(Boolean donante) {
		this.donante = donante;
	}

	public String getFactorRh() {
		return this.factorRh;
	}

	public void setFactorRh(String factorRh) {
		this.factorRh = factorRh;
	}

	public Calendar getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getGrupoSanguineo() {
		return this.grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Licenciaexpirada> getLicenciasExpiradas() {
		return this.licenciasExpiradas;
	}

	public void setLicenciasExpiradas(List<Licenciaexpirada> licenciasExpiradas) {
		this.licenciasExpiradas = licenciasExpiradas;
	}

	public Licenciaexpirada addLicenciasExpirada(Licenciaexpirada licenciasExpirada) {
		getLicenciasExpiradas().add(licenciasExpirada);
		licenciasExpirada.setTitular(this);

		return licenciasExpirada;
	}

	public Licenciaexpirada removeLicenciasExpirada(Licenciaexpirada licenciasExpirada) {
		getLicenciasExpiradas().remove(licenciasExpirada);
		licenciasExpirada.setTitular(null);

		return licenciasExpirada;
	}

	public List<Licenciavigente> getLicenciasVigentes() {
		return this.licenciasVigentes;
	}

	public void setLicenciasVigentes(List<Licenciavigente> licenciasVigentes) {
		this.licenciasVigentes = licenciasVigentes;
	}

	public Licenciavigente addLicenciasVigente(Licenciavigente licenciasVigente) {
		getLicenciasVigentes().add(licenciasVigente);
		licenciasVigente.setTitular(this);

		return licenciasVigente;
	}

	public Licenciavigente removeLicenciasVigente(Licenciavigente licenciasVigente) {
		getLicenciasVigentes().remove(licenciasVigente);
		licenciasVigente.setTitular(null);

		return licenciasVigente;
	}

	public List<Clase> getClasesSolicitadas() {
		return this.clasesSolicitadas;
	}

	public void setClasesSolicitadas(List<Clase> clasesSolicitadas) {
		this.clasesSolicitadas = clasesSolicitadas;
	}

}