package clasesDeTablas;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONTRIBUYENTE database table.
 * 
 */
@Entity
@NamedQuery(name="Contribuyente.findAll", query="SELECT c FROM Contribuyente c")
public class Contribuyente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContribuyentePK id;

	private String apellido;

	private String nombre;

	public Contribuyente() {
	}

	public ContribuyentePK getId() {
		return this.id;
	}

	public void setId(ContribuyentePK id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}