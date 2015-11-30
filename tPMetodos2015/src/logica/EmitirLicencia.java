package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import clasesDeTablas.Clase;
import clasesDeTablas.Comprobante;
import clasesDeTablas.Licenciaexpirada;
import clasesDeTablas.Licenciavigente;
import clasesDeTablas.Titular;
import clasesDeTablas.TitularPK;
import clasesDeTablas.Usuario;
import excepciones.ExcepcionClaseLicencia;
import interfaces.PanelVisualizarLicencia;
import persistencia.DAOClase;
import persistencia.DAOLicenciaExpirada;
import persistencia.DAOLicenciaVigente;
import persistencia.DAOTitular;

public class EmitirLicencia {
	//categoria "nuevo" o "renovacion", con minusculas y sin tildes!!
	public void guardarLicencia(Licenciavigente licVig, Comprobante comprobante) throws ExcepcionClaseLicencia{
		
		Titular titular = licVig.getTitular();		
		DAOTitular daoTitular= new DAOTitular();
		DAOLicenciaVigente daoLicenciaVigente = new DAOLicenciaVigente();
		
			
		//setea comprobante a licencia
		licVig.setComprobante(comprobante);
			
		//aquellas licencias vigentes de menor jerarquía se deben hacer expirar (se hacen LicenciaExpirada)
		expirarLicenciasMenorJerarquia(licVig.getClase(), titular);
			
		//por último, le agrego la licenciavigente al titular, lo actualizo y guardo la licencia en la BD
		titular.getLicenciasVigentes().add(licVig);
		daoTitular.update(titular);
		licVig.setTitular(titular);
		daoLicenciaVigente.save(licVig);
	}
		
	public  Licenciavigente crearLicencia(Titular titular, String observacion, String categoria, Clase claseSolicitada) throws ExcepcionClaseLicencia{
		List<Calendar> fechasVigencia = calcularVigenciaLicencia(titular, categoria);
		
		//se juntan todas las clases de las cuales el titular tiene licencias vigentes
		List <Clase> clasesVigentes= new ArrayList<>();
		for (Licenciavigente licVig : titular.getLicenciasVigentes()) {
			clasesVigentes.add(licVig.getClase());
		}
		//se verifica que las clases solicitadas no sean de menor o igual jerarquía que las vigentes
		verificarClaseSolicitada(claseSolicitada,clasesVigentes);
		
		//se procede a crear una licencia vigente
		Licenciavigente licenciaVigente = new Licenciavigente();
		licenciaVigente.setCategoria(categoria);
		licenciaVigente.setCosto(claseSolicitada.getCosto()+8);
		licenciaVigente.setFechaEmision(fechasVigencia.get(0));
		licenciaVigente.setFechaVencimiento(fechasVigencia.get(1));
		licenciaVigente.setObservaciones(observacion);
		licenciaVigente.setClase(claseSolicitada);
		licenciaVigente.setUsuario(new Usuario());
		licenciaVigente.setTitular(titular);
		
		return licenciaVigente;
	}
	
	private void expirarLicenciasMenorJerarquia(Clase claseSolicitada, Titular titular) {
		// TODO Auto-generated method stub
		List<Licenciavigente> licenciasVigentes= titular.getLicenciasVigentes();
		//si es licencia C, expirar la B (si hay)
		if(claseSolicitada.getDescripcion().equals("C")&& licenciasVigentes!=null)
			for (Licenciavigente licenciaVigente : licenciasVigentes) {
				if(licenciaVigente.getClase().getDescripcion().equals("B"))
					expirarLicencia(licenciaVigente,titular);
			}
		//si es licencia D o E, expirar la C (si hay)
		else if((claseSolicitada.getDescripcion().equals("D")||claseSolicitada.getDescripcion().equals("E")) && licenciasVigentes!=null)
			for (Licenciavigente licenciaVigente : licenciasVigentes) {
				if(licenciaVigente.getClase().getDescripcion().equals("C"))
					expirarLicencia(licenciaVigente,titular);
			}
	}

	private void expirarLicencia(Licenciavigente licenciaVigente, Titular titular) {
		// TODO Auto-generated method stub
		
		//instancia una llicencia expirada y le asigno casi todos los mismos datos de la licenciaa vigente
		//luego, borro la licencia vigente del titular y le agrego la expirada
		//mas abajo, actualizo el titular, elimino la vigente de la BD y guardo la expirada
		DAOTitular daoTitular = new DAOTitular();
		DAOLicenciaExpirada daoLicenciaExpirada = new DAOLicenciaExpirada();
		DAOLicenciaVigente daoLicenciaVigente = new DAOLicenciaVigente();
		
		Licenciaexpirada licenciaExpirada = new Licenciaexpirada();
		licenciaExpirada.setCategoria(licenciaVigente.getCategoria());
		licenciaExpirada.setClase(licenciaVigente.getClase());
		licenciaExpirada.setComprobante(licenciaVigente.getComprobante());
		licenciaExpirada.setCosto(licenciaVigente.getCosto());
		licenciaExpirada.setFechaEmision(licenciaVigente.getFechaEmision());
		licenciaExpirada.setFechaVencimiento(Calendar.getInstance());
		licenciaExpirada.setIdLicencia(licenciaVigente.getIdlicencia());
		licenciaExpirada.setNumeroCopia(licenciaVigente.getNumeroCopia());
		licenciaExpirada.setObservaciones(licenciaVigente.getObservaciones());
		licenciaExpirada.setTitular(licenciaVigente.getTitular());
		licenciaExpirada.setUsuario(licenciaVigente.getUsuario());
		
		
		
		titular.getLicenciasVigentes().remove(licenciaVigente);
		titular.getLicenciasExpiradas().add(licenciaExpirada);
		daoTitular.update(titular);
		
		daoLicenciaVigente.delete(licenciaVigente);
		daoLicenciaExpirada.save(licenciaExpirada);
		
	}
	// se verifica que no posea una clase de igual o mayor rango a la que solicita
	private void verificarClaseSolicitada(Clase claseSolicitada, List<Clase> clasesVigentes) throws ExcepcionClaseLicencia {
		// TODO Auto-generated method stub
		if(clasesVigentes.contains(claseSolicitada))
			throw new ExcepcionClaseLicencia("Ya posee una licencia vigente con la clase solicitada");
		
		else if(claseSolicitada.getDescripcion().equals("B")){
			for (Clase clase : clasesVigentes) {
				if(clase.getDescripcion().equals("C")||clase.getDescripcion().equals("D")||clase.getDescripcion().equals("E"))
					throw new ExcepcionClaseLicencia("Ya posee una licencia vigente de mayor jerarquía que la B");
			}
		}
		else if(claseSolicitada.getDescripcion().equals("C")){
			for (Clase clase : clasesVigentes) {
				if(clase.getDescripcion().equals("D")||clase.getDescripcion().equals("E"))
					throw new ExcepcionClaseLicencia("Ya posee una licencia vigente de mayor jerarquía que la C");
			}
		}
		
	}
	//este método se ejecuta cada vez que se ingresa un caracter en los campos detallados abajo, devuelve los titulares que cumplan con la busqueda
	public List<Titular> buscarTitular(String nombre, String apellido, String nroDoc, String tipoDoc) {
		List<Titular> titulares = new ArrayList<>();
		DAOTitular daoTitular= new DAOTitular();
		List<Titular> todosLosTitulares =daoTitular.getAll();
		
		for (Titular titular : todosLosTitulares) {
			if((titular.getApellido().startsWith(apellido) && !apellido.isEmpty()) ||
			   (titular.getNombre().startsWith(nombre) && !nombre.isEmpty()) ||
			   (titular.getId().getNroDoc().startsWith(nroDoc) && !nroDoc.isEmpty())
			   )
				titulares.add(titular);
		}
		return titulares;
	}
	//de acuerdo a la fecha de nacimiento, devuelve la edad actual
	public static int calcularEdad(Calendar fechaNacimientoTitular){
		Calendar fechaActual = Calendar.getInstance();
		
		int edad = (fechaActual.get(Calendar.YEAR)) - (fechaNacimientoTitular.get(Calendar.YEAR));
		
		if (fechaNacimientoTitular.get(Calendar.DAY_OF_YEAR) > fechaActual.get(Calendar.DAY_OF_YEAR)) //quiere decir que no todavía no cumplió los anios
			edad -= 1;
		
		return edad;
	}
	
	// se calcula cuantos años estara vigente una licencia, y se retorna fecha emision y fecha de expiracion
	public List<Calendar> calcularVigenciaLicencia (Titular titular, String categoria){
		
		Calendar fechaInicioVigencia = Calendar.getInstance();
		Calendar fechaNacimientoTitular = titular.getFechaNacimiento();
		
		// a la fecha de expiracion se le setea el dia y mes del nacimiento del titular
		Calendar fechaExpiracion = Calendar.getInstance();
		fechaExpiracion.set(Calendar.DAY_OF_MONTH, fechaNacimientoTitular.get(Calendar.DAY_OF_MONTH));
		fechaExpiracion.set(Calendar.MONTH, fechaNacimientoTitular.get(Calendar.MONTH));
		
		// se calcula la edad para saber cuantos años de vigencia tendra la licencia
		int edad = calcularEdad(fechaNacimientoTitular);
		
		// segun la edad del titular se le setea a la fecha de expiracion el año correspondiente
		if((edad < 21 && categoria.equals("nuevo")) || edad > 70)
			fechaExpiracion.set(Calendar.YEAR, fechaNacimientoTitular.get(Calendar.YEAR)+1);		
		if((edad < 21 && categoria.equals("renovacion")) || (edad > 60 && edad <= 70) )
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.get(Calendar.YEAR)+3);
		if(edad >= 21 && edad <= 46)
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.get(Calendar.YEAR)+5);
		if(edad > 46 && edad <= 60)
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.get(Calendar.YEAR)+4);
		
		// se crea una lista con las dos fechas indicadas para el retorno
		List<Calendar> fechasVigencia = new ArrayList<Calendar>();
		fechasVigencia.add(fechaInicioVigencia);
		fechasVigencia.add(fechaExpiracion);
		
		return fechasVigencia;
	}

	//se calculan cuantos años desde su emision tiene la licencia
	public static int antiguedadLicencia(Licenciavigente licVig) {
		// TODO Auto-generated method stub
		Calendar fechaActual= Calendar.getInstance();
		
		int antiguedad = fechaActual.get(Calendar.YEAR) - licVig.getFechaEmision().get(Calendar.YEAR);
		
		if(licVig.getFechaEmision().get(Calendar.DAY_OF_YEAR) - fechaActual.get(Calendar.DAY_OF_YEAR) > 0)
			antiguedad--;
		return antiguedad;
	}
		
}
