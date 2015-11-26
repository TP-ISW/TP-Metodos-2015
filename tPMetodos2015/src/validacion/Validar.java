package validacion;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Calendar;

import clasesDeTablas.Titular;
import excepciones.ExcepcionSQL;
import excepciones.ExcepcionValidador;
import logica.EmitirLicencia;
import validacion.Inyeccion;


public class Validar{
	
	static boolean validarMayus(String campo){
		if(campo.toUpperCase().equals(campo)){
			return true;
		}
		else return false;
	}
	
	static boolean validarLetras(String campo){
		if (Pattern.matches("[a-zA-Z ']+", campo) == true){
			return true;
		}
		else return false;
	}
	
	static boolean validarNumero(String campo){
		if (Pattern.matches("[0-9]+", campo) == true){
			return true;
		}
		else return false;
	}
	
	static boolean validarAlfaNumerico(String campo){
		if (Pattern.matches("[a-zA-Z0-9 ]+", campo) == true){
			return true;
		}
		else return false;
	}
	
	public static void validar(Titular titular) throws ExcepcionValidador, ExcepcionSQL{
		
		controlSQL(titular);
		
		List<String> tiposValidos = Arrays.asList("DNI", "LU", "LE");		
		
		if(!tiposValidos.contains(titular.getId().getTipoDoc())){
			throw new ExcepcionValidador("El tipo de documento inválido.");
		};
		
		if((titular.getId().getNroDoc().length()>8 || titular.getId().getNroDoc().length()<7) && validarNumero(titular.getId().getNroDoc())== false){
			throw new ExcepcionValidador("El número de documento inválido.");
		};		
		
		if(validarAyN(titular.getApellido()) == false){
			throw new ExcepcionValidador("El apellido es inválido.");
		};
		
		if(validarAyN(titular.getNombre()) == false){
			throw new ExcepcionValidador("El nombre es inválido.");
		};
		
		if(validarDireccion(titular.getDomicilio()) == false){
			throw new ExcepcionValidador("El domicilio es inválido.");
		};
		
		if(validarFechaNac(titular.getFechaNacimiento())==false){
			throw new ExcepcionValidador("El usuario esta en un rango de edades no aceptado.");
		};
		
		/*if(titular.getSexo()!="Masculino" && titular.getSexo()!="Femenino"){
			throw new ExcepcionValidador("El sexo seleccioes inválido.");
		};*/
		
		List<String> gruposValidos = Arrays.asList("A","B","AB","O");
		
		if(!gruposValidos.contains(titular.getGrupoSanguineo())){
			throw new ExcepcionValidador("El grupo sanguíneo es inválido.");
		};
		
		if(titular.getFactorRh() != "+" && titular.getFactorRh() != "-")
			throw new ExcepcionValidador("El factor sanguíneo es inválido.");
		
		if(titular.getDonante()!= true && titular.getDonante()!=false)
			throw new ExcepcionValidador("El campo donante inválido.");
		
		List<String> clasesValidos = Arrays.asList("A","B","C","D","E","F","G");
		
		for(int j=0; j<titular.getClasesSolicitadas().size();j++){
			if(!clasesValidos.contains(titular.getClasesSolicitadas().get(j).getIdClase()))
				throw new ExcepcionValidador("Una de las clases solicitadas es inválida.");
			
		}
		if(titular.getFoto().length()>200)
			throw new ExcepcionValidador("La dirección de la foto es inválida.");
		
	}
	
	static void controlSQL(Titular titular) throws ExcepcionSQL{
		Inyeccion.controlSQL(titular.getNombre());
		Inyeccion.controlSQL(titular.getApellido());
		Inyeccion.controlSQL(titular.getDomicilio());
		Inyeccion.controlSQL(titular.getFoto());
	}
	
	static boolean validarAyN(String cadena){
		if(cadena.length()<=50 && cadena.length() >1)
		{
			if(validarMayus(cadena) && validarLetras(cadena)) return true;
			else return false;
		}
		else return false;
	}
	
	static boolean validarDireccion(String cadena){
		if(cadena.length()<=100 && cadena.length() >1)
		{
			if(validarMayus(cadena) && validarAlfaNumerico(cadena)) return true;
			else return false;
		}
		else return false;
	}
	static boolean validarFechaNac(Calendar fechaNacimiento){
			int edad = EmitirLicencia.calcularEdad(fechaNacimiento);
			if(edad<17 || edad >90) return false;
			else return true;
	}
}

