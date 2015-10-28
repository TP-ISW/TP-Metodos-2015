package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import clasesDeTablas.Clase;
import clasesDeTablas.Titular;
import clasesDeTablas.TitularPK;
import excepciones.*;
import validacion.Validar;

public class AltaTitular {

	public AltaTitular(String nroDoc, String tipoDoc, String nombre, String apellido, String domicilio, 
			Boolean donante, String factorRh,String grupoSanguineo, Calendar fechaNacimiento, String sexo, 
			String foto, List<String> clases)throws ExcepcionValidador, ExcepcionLicenciasInvalidas{
		
		TitularPK id= new TitularPK();
		id.setNroDoc(nroDoc);
		id.setTipoDoc(tipoDoc);
		
		Titular nuevoTitular= new Titular();
		nuevoTitular.setApellido(apellido);
		nuevoTitular.setDomicilio(domicilio);
		nuevoTitular.setDonante(donante);
		nuevoTitular.setFactorRh(factorRh);
		nuevoTitular.setFechaNacimiento(fechaNacimiento);
		nuevoTitular.setFoto(foto);
		nuevoTitular.setGrupoSanguineo(grupoSanguineo);
		nuevoTitular.setNombre(nombre);
		nuevoTitular.setSexo(sexo);
		nuevoTitular.setId(id);
		List <Clase> clasesSolicitadas=new ArrayList<>();
		for (String string : clases) {
			Clase clase = new Clase();
			clase.setIdClase(string);
			clasesSolicitadas.add(clase);
		}		
		nuevoTitular.setClasesSolicitadas(clasesSolicitadas);
		
		try{
			Validar.validar(nuevoTitular);
			chequearLicenciasSolicitadas(nuevoTitular);
		}
	}
	private void chequearLicenciasSolicitadas(Titular nuevoTitular)throws ExcepcionLicenciasInvalidas {
		// TODO Auto-generated method stub
		
	}
	public void verificarExistenciaTitular(String nroDoc) {
		
	}
}
