package clasesDeTablas;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TITULAR database table.
 * 
 */
@Embeddable
public class TitularPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String nroDoc;

	private String tipoDoc;

	public TitularPK() {
	}
	public String getNroDoc() {
		return this.nroDoc;
	}
	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}
	public String getTipoDoc() {
		return this.tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TitularPK)) {
			return false;
		}
		TitularPK castOther = (TitularPK)other;
		return 
			this.nroDoc.equals(castOther.nroDoc)
			&& this.tipoDoc.equals(castOther.tipoDoc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nroDoc.hashCode();
		hash = hash * prime + this.tipoDoc.hashCode();
		
		return hash;
	}
}