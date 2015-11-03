package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import clasesDeTablas.Licenciavigente;
import clasesDeTablas.Titular;

public class EmitirLicencia {
	
	//categoria "nuevo" o "renovacion", con minusculas y sin tildes!!
	
	public static int calcularEdad(Calendar fechaNacimientoTitular){
		Calendar fechaActual = Calendar.getInstance();
		
		int edad = (fechaActual.get(Calendar.YEAR)) - (fechaNacimientoTitular.get(Calendar.YEAR));
		
		if (fechaNacimientoTitular.get(Calendar.DAY_OF_YEAR) > fechaActual.get(Calendar.DAY_OF_YEAR)) //quiere decir que no todav�a no cumpli� los anios
			edad -= 1;
		
		return edad;
	}
	
	public List<Calendar> calcularVigenciaLicencia (Titular titular, String categoria){
		
		Calendar fechaInicioVigencia = Calendar.getInstance();
		Calendar fechaNacimientoTitular = titular.getFechaNacimiento();
		
		Calendar fechaExpiracion = Calendar.getInstance();
		fechaExpiracion.set(Calendar.DAY_OF_MONTH, fechaNacimientoTitular.get(Calendar.DAY_OF_MONTH));
		fechaExpiracion.set(Calendar.MONTH, fechaNacimientoTitular.get(Calendar.MONTH));

		int edad = calcularEdad(fechaNacimientoTitular);
		
		if((edad < 21 && categoria.equals("nuevo")) || edad > 70)
			fechaExpiracion.set(Calendar.YEAR, fechaNacimientoTitular.get(Calendar.YEAR)+1);		
		if((edad < 21 && categoria.equals("renovacion")) || (edad > 60 && edad <= 70) )
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.get(Calendar.YEAR)+3);
		if(edad >= 21 && edad <= 46)
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.get(Calendar.YEAR)+5);
		if(edad > 46 && edad <= 60)
			fechaExpiracion.set(fechaExpiracion.YEAR, fechaNacimientoTitular.get(Calendar.YEAR)+4);
		
		List<Calendar> fechasVigencia = new ArrayList<Calendar>();
		fechasVigencia.add(fechaInicioVigencia);
		fechasVigencia.add(fechaExpiracion);
		
		return fechasVigencia;
	}

	public static int antiguedadLicencia(Licenciavigente licVig) {
		// TODO Auto-generated method stub
		Calendar fechaActual= Calendar.getInstance();
		int antiguedad=licVig.getFechaEmision().YEAR - fechaActual.YEAR ;
		if(licVig.getFechaEmision().get(Calendar.DAY_OF_YEAR) - fechaActual.get(Calendar.DAY_OF_YEAR) > 0)
			antiguedad--;
		return antiguedad;
	}
		
}
