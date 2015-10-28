package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import clasesDeTablas.Titular;

public class EmitirLicencia {
	
	//categoria "nuevo" o "renovacion", con minusculas y sin tildes!!
	
	public List<Calendar> CalcularVigenciaLicencia (Titular titular, String categoria){
		
		Calendar fechaInicioVigencia = Calendar.getInstance();
		Calendar fechaNacimientoTitular = titular.getFechaNacimiento();
		
		Calendar fechaExpiracion = Calendar.getInstance();
		fechaExpiracion.set(fechaExpiracion.DAY_OF_MONTH, fechaNacimientoTitular.DAY_OF_MONTH);
		fechaExpiracion.set(fechaExpiracion.MONTH, fechaNacimientoTitular.MONTH);

		int edad = (fechaInicioVigencia.YEAR) - (fechaNacimientoTitular.YEAR);
		
		if (fechaNacimientoTitular.DAY_OF_YEAR > fechaInicioVigencia.DAY_OF_YEAR) //quiere decir que no todav�a no cumpli� los anios
			edad =- 1;
		
		if((edad < 21 && categoria.equals("nuevo")) || edad > 70)
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.YEAR+1);		
		if((edad < 21 && categoria.equals("renovacion")) || (edad > 60 && edad <= 70) )
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.YEAR+3);
		if(edad >= 21 && edad <= 46)
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.YEAR+5);
		if(edad > 46 && edad <= 60)
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.YEAR+4);
		
		List<Calendar> fechasVigencia = new ArrayList<Calendar>();
		fechasVigencia.add(fechaInicioVigencia);
		fechasVigencia.add(fechaExpiracion);
		
		return fechasVigencia;
	}
		
}
