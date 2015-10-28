package validacion;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Arrays;

import clasesDeTablas.Titular;
import excepciones.ExcepcionValidador;


public class Validar{
	
	boolean validarMayus(String campo){
		if(campo.toUpperCase().equals(campo)){
			return true;
		}
		else return false;
	}
	
	boolean validarLetras(String campo){
		if (Pattern.matches("[a-zA-Z']+", campo) == true){
			return true;
		}
		else return false;
	}
	
	boolean validarNumero(String campo){
		if (Pattern.matches("[0-9]+", campo) == true){
			return true;
		}
		else return false;
	}
	
	boolean validarAlfaNumerico(String campo){
		if (Pattern.matches("[a-zA-Z0-9]+", campo) == true){
			return true;
		}
		else return false;
	}
	
	void validar(Titular titular) throws ExcepcionValidador{
		int comprobar=0;
		List<String> tiposValidos = Arrays.asList("DNI", "LU", "LE");		
		
		if(tiposValidos.contains(titular.getId().getTipoDoc())) comprobar++;
		
		if(titular.getId().getNroDoc().length()==8 && validarNumero(titular.getId().getNroDoc())) comprobar++;		
		
		if(validarAyN(titular.getApellido()) == true) comprobar++;
		
		if(validarAyN(titular.getNombre()) == true) comprobar++;
		
		if(validarDireccion(titular.getDomicilio()) == true) comprobar++;
		
		if(titular.getSexo()=="M" || titular.getSexo()=="F") comprobar++;
		
		List<String> gruposValidos = Arrays.asList("A","B","AB","O");
		
		if(gruposValidos.contains(titular.getGrupoSanguineo())) comprobar++;
		
		if(titular.getFactorRh() == "+" || titular.getFactorRh() == "-")
		
		if(titular.getDonante()== true || titular.getDonante()==false) comprobar++;
		
		List<String> clasesValidos = Arrays.asList("A","B","C","D","E","F","G");
		
		for(int j=0; j<titular.getClasesSolicitadas().size();j++){
			if(clasesValidos.contains(titular.getClasesSolicitadas().get(j))) comprobar++;
		}
		
		if(titular.getFoto().length()<200) comprobar++;
		
		if (comprobar !=11)
			throw new ExcepcionValidador("Existen campos inválidos.");
	}
	
	boolean validarAyN(String cadena){
		if(cadena.length()<=50 && cadena.length() >1)
		{
			if(validarMayus(cadena) && validarLetras(cadena)) return true;
			else return false;
		}
		else return false;
	}
	
	boolean validarDireccion(String cadena){
		if(cadena.length()<=100 && cadena.length() >1)
		{
			if(validarMayus(cadena) && validarAlfaNumerico(cadena)) return true;
			else return false;
		}
		else return false;
	}
}

