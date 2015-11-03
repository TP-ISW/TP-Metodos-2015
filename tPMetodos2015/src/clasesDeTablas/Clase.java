package clasesDeTablas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLASE database table.
 * 
 */
@Entity
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*@SequenceGenerator(name="CLASE_IDCLASE_GENERATOR", sequenceName="SECUENCIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASE_IDCLASE_GENERATOR")*/
	private String idClase;

	private Float costo;

	private String descripcion;

	private int edad;

	//bi-directional many-to-one association to Licenciavigente
	@OneToMany(mappedBy="clase")
	private List<Licenciavigente> licenciasVigentes;

	//bi-directional many-to-many association to Titular
	@ManyToMany(mappedBy="clasesSolicitadas")
	private List<Titular> titulares;

	public Clase() {
	}

	public String getIdClase() {
		return this.idClase;
	}

	public void setIdClase(String idClase) {
		this.idClase = idClase;
	}

	public Float getCosto() {
		return this.costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Licenciavigente> getLicenciasVigentes() {
		return this.licenciasVigentes;
	}

	public void setLicenciasVigentes(List<Licenciavigente> licenciasVigentes) {
		this.licenciasVigentes = licenciasVigentes;
	}

	public Licenciavigente addLicenciasVigente(Licenciavigente licenciasVigente) {
		getLicenciasVigentes().add(licenciasVigente);
		licenciasVigente.setClase(this);

		return licenciasVigente;
	}

	public Licenciavigente removeLicenciasVigente(Licenciavigente licenciasVigente) {
		getLicenciasVigentes().remove(licenciasVigente);
		licenciasVigente.setClase(null);

		return licenciasVigente;
	}

	public List<Titular> getTitulares() {
		return this.titulares;
	}

	public void setTitulares(List<Titular> titulares) {
		this.titulares = titulares;
	}

	public boolean superior(Clase claseSolicitada) {
			// TODO Auto-generated method stub
			if(claseSolicitada.getIdClase().equals("B") && (this.getIdClase().equals("D")||this.getIdClase().equals("E")||
					this.getIdClase().equals("C")))
				return true;
			else if(claseSolicitada.getIdClase().equals("C") && (this.getIdClase().equals("D")||this.getIdClase().equals("E")))
				return true;
			return false;
		
	}

}