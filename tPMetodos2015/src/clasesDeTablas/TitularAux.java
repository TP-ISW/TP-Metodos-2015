package clasesDeTablas;

import java.util.Calendar;
import java.util.List;

public class TitularAux {

	public String nroDoc;
	public String tipoDoc;
	public String nombre;
	public String apellido;
	public String domicilio;
	public Boolean donante;
	public String factorRh;
	public String grupoSanguineo;
	public Calendar fechaNacimiento;
	public String sexo;
	public String foto;
	public List<String> clases;
	
	public String getNroDoc() {
		return nroDoc;
	}
	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Boolean getDonante() {
		return donante;
	}
	public void setDonante(Boolean donante) {
		this.donante = donante;
	}
	public String getFactorRh() {
		return factorRh;
	}
	public void setFactorRh(String factorRh) {
		this.factorRh = factorRh;
	}
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public List<String> getClases() {
		return clases;
	}
	public void setClases(List<String> clases) {
		this.clases = clases;
	}
	
	
}
