package clasesDeTablas;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONTRIBUYENTE database table.
 * 
 */
@Embeddable
public class ContribuyentePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String tipodoc;

	private String nrodoc;

	public ContribuyentePK() {
	}
	public String getTipodoc() {
		return this.tipodoc;
	}
	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}
	public String getNrodoc() {
		return this.nrodoc;
	}
	public void setNrodoc(String nrodoc) {
		this.nrodoc = nrodoc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ContribuyentePK)) {
			return false;
		}
		ContribuyentePK castOther = (ContribuyentePK)other;
		return 
			this.tipodoc.equals(castOther.tipodoc)
			&& this.nrodoc.equals(castOther.nrodoc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tipodoc.hashCode();
		hash = hash * prime + this.nrodoc.hashCode();
		
		return hash;
	}
}