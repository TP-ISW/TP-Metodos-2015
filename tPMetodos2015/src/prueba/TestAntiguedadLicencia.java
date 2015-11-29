package prueba;

import java.util.Calendar;

import clasesDeTablas.Licenciavigente;
import junit.framework.TestCase;
import logica.EmitirLicencia;

public class TestAntiguedadLicencia extends TestCase {

	  protected String categoriaNuevo, categoriaRenovacion;
	   

	  public void testAntiguedadLicencia(){
	      categoriaNuevo = "nuevo";
	      categoriaRenovacion = "renovacion";
	      
	      Calendar fechaEmision = Calendar.getInstance();
	      fechaEmision.set(2013, 9, 9); //mes enero=0, mes diciembre=11 , se setea 9/10/2013
	      
	      Licenciavigente licenciaVigente = new Licenciavigente();
	      licenciaVigente.setFechaEmision(fechaEmision);
	      
	      //la antiguedad a la fecha de hoy deberia ser de 2 años
	      int antiguedad = EmitirLicencia.antiguedadLicencia(licenciaVigente);
	      
	      assertTrue(antiguedad == 2);
	      
	      //seteamos una fecha de emision mayor a la actual en dia/mes
	      fechaEmision.set(2013, 11, 25); //se setea 25/12/2013
	      licenciaVigente.setFechaEmision(fechaEmision);
	      //ahora la antiguedad deberia ser 1 año
	      int antiguedad1 = EmitirLicencia.antiguedadLicencia(licenciaVigente);
	      
	      assertTrue(antiguedad1 == 1);
	   }
	   
	   
	
}
