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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((clasesSolicitadas == null) ? 0 : clasesSolicitadas.hashCode());
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + ((donante == null) ? 0 : donante.hashCode());
		result = prime * result + ((factorRh == null) ? 0 : factorRh.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((grupoSanguineo == null) ? 0 : grupoSanguineo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((licenciasExpiradas == null) ? 0 : licenciasExpiradas.hashCode());
		result = prime * result + ((licenciasVigentes == null) ? 0 : licenciasVigentes.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titular other = (Titular) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (clasesSolicitadas == null) {
			if (other.clasesSolicitadas != null)
				return false;
		} else if (!clasesSolicitadas.equals(other.clasesSolicitadas))
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (donante == null) {
			if (other.donante != null)
				return false;
		} else if (!donante.equals(other.donante))
			return false;
		if (factorRh == null) {
			if (other.factorRh != null)
				return false;
		} else if (!factorRh.equals(other.factorRh))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (grupoSanguineo == null) {
			if (other.grupoSanguineo != null)
				return false;
		} else if (!grupoSanguineo.equals(other.grupoSanguineo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (licenciasExpiradas == null) {
			if (other.licenciasExpiradas != null)
				return false;
		} else if (!licenciasExpiradas.equals(other.licenciasExpiradas))
			return false;
		if (licenciasVigentes == null) {
			if (other.licenciasVigentes != null)
				return false;
		} else if (!licenciasVigentes.equals(other.licenciasVigentes))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}

}