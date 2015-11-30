package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import clasesDeTablas.Clase;
import clasesDeTablas.Contribuyente;
import clasesDeTablas.ContribuyentePK;
import clasesDeTablas.Licenciaexpirada;
import clasesDeTablas.Licenciavigente;
import clasesDeTablas.Titular;
import clasesDeTablas.TitularAux;
import clasesDeTablas.TitularPK;
import excepciones.*;
import persistencia.DAOClase;
import persistencia.DAOContribuyente;
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

	public void altaTitular(TitularAux titularAux)throws ExcepcionValidador, ExcepcionLicenciasInvalidas, ExcepcionContribuyente, ExcepcionSQL{
		
		//se verifica que el titular sea contribuyente
		verificarSiEsContribuyente(titularAux.getNroDoc(),titularAux.getTipoDoc());
		
		TitularPK id= new TitularPK();
		id.setNroDoc(titularAux.getNroDoc());
		id.setTipoDoc(titularAux.getTipoDoc());
		
		Titular nuevoTitular= new Titular();
		nuevoTitular.setApellido(titularAux.getApellido());
		nuevoTitular.setDomicilio(titularAux.getDomicilio());
		nuevoTitular.setDonante(titularAux.getDonante());
		nuevoTitular.setFactorRh(titularAux.getFactorRh());
		nuevoTitular.setFechaNacimiento(titularAux.getFechaNacimiento());
		nuevoTitular.setFoto(titularAux.getFoto());
		nuevoTitular.setGrupoSanguineo(titularAux.getGrupoSanguineo());
		nuevoTitular.setNombre(titularAux.getNombre());
		nuevoTitular.setSexo(titularAux.getSexo());
		nuevoTitular.setId(id);
		
		DAOClase daoClase = new DAOClase();
		
		//se obtienen las clase seleccionadas como un lista de String
		List<String> clases = titularAux.getClases();
		//se traen las clases solicitadas desde la BD
		List <Clase> clasesSolicitadas=new ArrayList<>();
		for (String idClase : clases) {
			Clase clase = daoClase.getById(idClase);
			clasesSolicitadas.add(clase);
		}		
		nuevoTitular.setClasesSolicitadas(clasesSolicitadas);
		
		//se ejecutan acciones para brindar seguridad (inyeccion sql y demas validaciones)
		Validar.validar(nuevoTitular);
		chequearLicenciasSolicitadas(nuevoTitular);
		DAOTitular daoTitular = new DAOTitular();
		
		if(titularYaExiste(titularAux.getNroDoc(), titularAux.getTipoDoc()))
			daoTitular.update(nuevoTitular);
		else
			daoTitular.save(nuevoTitular);

	}
	//se verifica que el titular sea contribuyente del municipio
	private void verificarSiEsContribuyente(String nroDoc, String tipoDoc) throws ExcepcionContribuyente {
		// TODO Auto-generated method stub
		DAOContribuyente daoContribuyente = new DAOContribuyente();
		ContribuyentePK contriPK = new ContribuyentePK();
		contriPK.setNrodoc(nroDoc);
		contriPK.setTipodoc(tipoDoc);
		
		Contribuyente contribuyente = daoContribuyente.getByDocumentoYTipo(contriPK);
		if(contribuyente==null)
			throw new ExcepcionContribuyente("El titular no es contribuyente");
		
		
	}
	
	private void chequearLicenciasSolicitadas(Titular nuevoTitular)throws ExcepcionLicenciasInvalidas {
		// TODO Auto-generated method stub
		Calendar fechaNacimientoTitular = nuevoTitular.getFechaNacimiento();
		int edad= EmitirLicencia.calcularEdad(fechaNacimientoTitular);
		
		//se verifica que el titular tenga al menos 17 anos
		if(edad<17){
			throw new ExcepcionLicenciasInvalidas("No cumple la edad mínima");
		}
		
		
		//se verifica que el titular tenga al menos 21 anos para obtener clases profesionales
		//se verifica que el titular haya tenido una licencia previamente
		//se verifica que no posea licencia vigente con la clase que solicita, ni licencia de menor jerarquia
		for (Clase claseSolicitada : nuevoTitular.getClasesSolicitadas()) {
			if(clasesRequieren21.contains(claseSolicitada.getIdClase())){
				if(edad<21)
					throw new ExcepcionLicenciasInvalidas("No cumple la edad mínima para la clase C, D o E");
				else if (!puedeSerProfesional(nuevoTitular,edad))					
					throw new ExcepcionLicenciasInvalidas("El titular no puede obtener una clase profesional");
			}
			
			if(nuevoTitular.getLicenciasVigentes()!=null)	
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
		if(nuevoTitular.getLicenciasExpiradas()!=null)
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
		if(nuevoTitular.getLicenciasExpiradas()!=null)
		for (Licenciaexpirada licExp : nuevoTitular.getLicenciasExpiradas()) {
			if(licExp.getClase().getIdClase().equals("B"))
				return true;
		}
		if(nuevoTitular.getLicenciasVigentes()!=null)
		for(Licenciavigente licVig: nuevoTitular.getLicenciasVigentes()){
			if(licVig.getClase().getIdClase().equals("B")){
				if (EmitirLicencia.antiguedadLicencia(licVig)>=1)
					return true;
			}
		}
		return false;
	}
	//este metodo verifica si el titular fue cargado previamente en el sistema. 
	//si es así lo devuelve para que sus datos se muestren en panntalla
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
