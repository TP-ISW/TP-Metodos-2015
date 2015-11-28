package prueba;

import java.util.Calendar;

import clasesDeTablas.Licenciavigente;
import junit.framework.TestCase;
import logica.EmitirLicencia;

public class TestAntiguedadLicencia extends TestCase {

	  protected String categoriaNuevo, categoriaRenovacion;
	   

	  protected void testAntiguedadLicencia(){
	      categoriaNuevo = "nuevo";
	      categoriaRenovacion = "renovacion";
	      
	      Calendar fechaEmision = Calendar.getInstance();
	      fechaEmision.set(2013, 10, 9); //mes enero=0, mes diciembre=11 
	      
	      Licenciavigente licenciaVigente = new Licenciavigente();
	      licenciaVigente.setFechaEmision(fechaEmision);
	      
	      int antiguedad = EmitirLicencia.antiguedadLicencia(licenciaVigente);
	      
	      assertTrue(antiguedad == 1);
	      assertTrue(antiguedad == 2);
	   }
	   
	   
	
}
