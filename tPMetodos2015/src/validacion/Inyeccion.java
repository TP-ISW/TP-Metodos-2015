package validacion;

import excepciones.ExcepcionSQL;

public class Inyeccion {
	
	static void controlSQL(String cadena) throws ExcepcionSQL{
		if(cadena.contains("INSERT") || cadena.contains("SELECT") || cadena.contains("DROP") 
			|| cadena.contains("DELETE") || cadena.contains("FROM") || cadena.contains("{")
			|| cadena.contains("}") || cadena.contains("(") || cadena.contains(")")
			|| cadena.contains(";"))
			{
			throw new ExcepcionSQL("La cadena contiene posible código malicioso.");
			} 
		}
}
