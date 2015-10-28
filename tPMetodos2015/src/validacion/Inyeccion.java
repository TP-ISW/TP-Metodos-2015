package validacion;

import excepciones.ExcepcionSQL;

public class Inyeccion {
	
	static void controlSQL(String cadena) throws ExcepcionSQL{
		if(cadena.contains("INSERT")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains("SELECT")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains("DROP")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains("DELETE")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains("FROM")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains("{")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains("}")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains("(")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains(")")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}
		if(cadena.contains(";")){
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
		}

	}
	
	
	
}
