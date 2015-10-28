package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import clasesDeTablas.Clase;
import clasesDeTablas.Licenciaexpirada;
import clasesDeTablas.Licenciavigente;
import clasesDeTablas.Titular;
import clasesDeTablas.TitularPK;
import excepciones.*;
import persistencia.DAOTitular;
import validacion.Validar;

public class AltaTitular {
	private List<String> clasesRequieren21 = new ArrayList<String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		add("C");
		add("D");
		add("E");			
	}};

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
		
		Validar.validar(nuevoTitular);
		chequearLicenciasSolicitadas(nuevoTitular);
		DAOTitular daoTitular = new DAOTitular();
		
		if(titularYaExiste(nroDoc, tipoDoc))
			daoTitular.update(nuevoTitular);
		else
			daoTitular.save(nuevoTitular);

	}
	private void chequearLicenciasSolicitadas(Titular nuevoTitular)throws ExcepcionLicenciasInvalidas {
		// TODO Auto-generated method stub
		Calendar fechaNacimientoTitular = nuevoTitular.getFechaNacimiento();
		int edad= EmitirLicencia.calcularEdad(fechaNacimientoTitular);
		if(edad<17){
			throw new ExcepcionLicenciasInvalidas("No cumple la edad mínima");
		}
		
		
		
		for (Clase claseSolicitada : nuevoTitular.getClasesSolicitadas()) {
			if(clasesRequieren21.contains(claseSolicitada.getIdClase())){
				if(edad<21)
					throw new ExcepcionLicenciasInvalidas("No cumple la edad mínima para la clase C, D o E");
				else if (!puedeSerProfesional(nuevoTitular,edad))					
					throw new ExcepcionLicenciasInvalidas("El titular no puede obtener una clase profesional");
			}
			for (Licenciavigente licVig : nuevoTitular.getLicenciasVigentes()) {
				if(licVig.getClase().getIdClase().equals(claseSolicitada.getIdClase()))
					throw new ExcepcionLicenciasInvalidas("Ya posee una licencia vigente de esta clase. Debería renovarla");
				else if (licVig.getClase().superior(claseSolicitada))
					throw new ExcepcionLicenciasInvalidas("La clase que solicita es inferior a la/s que posee");
			}
			
		}
	}
	
	private boolean puedeSerProfesional(Titular nuevoTitular,int edad) {
		
		boolean tieneLicenciaProfesional=false;
		
		for (Licenciaexpirada licExp : nuevoTitular.getLicenciasExpiradas()) {
			if(clasesRequieren21.contains(licExp.getClase().getIdClase()))
				tieneLicenciaProfesional=true;
		}
		if(edad>65)
			if(tieneLicenciaProfesional)
				return true;
			else
				return false;
		//si sigue quiere decir que tiene menos de 65
		//ahora verificamos que haya tenido al menos una clase B
		
		for (Licenciaexpirada licExp : nuevoTitular.getLicenciasExpiradas()) {
			if(licExp.getClase().getIdClase().equals("B"))
				return true;
		}
		for(Licenciavigente licVig: nuevoTitular.getLicenciasVigentes()){
			if(licVig.getClase().getIdClase().equals("B")){
				if (EmitirLicencia.antiguedadLicencia(licVig)>=1)
					return true;
			}
		}
		return false;
	}
	public Titular verificarExistenciaTitular(String nroDoc, String tipoDoc) {
		TitularPK titularPK = new TitularPK();
		titularPK.setNroDoc(nroDoc);
		titularPK.setTipoDoc(tipoDoc);
		
		DAOTitular daoTitular= new DAOTitular();
		Titular titular =daoTitular.getByDocumentoYTipo(titularPK);
		return titular;
	}
	private boolean titularYaExiste(String nroDoc, String tipoDoc) {
		TitularPK titularPK = new TitularPK();
		titularPK.setNroDoc(nroDoc);
		titularPK.setTipoDoc(tipoDoc);
		
		DAOTitular daoTitular= new DAOTitular();
		Titular titular =daoTitular.getByDocumentoYTipo(titularPK);
		if(titular==null)
			return false;
		return true;			
	}
}
