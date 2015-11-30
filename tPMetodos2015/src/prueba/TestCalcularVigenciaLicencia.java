package prueba;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import clasesDeTablas.Titular;
import clasesDeTablas.TitularPK;
import logica.EmitirLicencia;
import persistencia.DAOTitular;

public class TestCalcularVigenciaLicencia {

	@Test
	public void testCalcularVigenciaLicencia() {
		//se trae un titular de la BD
		TitularPK pkDeEjemplo= new TitularPK();
		pkDeEjemplo.setNroDoc("37566732");
		pkDeEjemplo.setTipoDoc("DNI");
		DAOTitular daoTitular = new DAOTitular();
		Titular titular = daoTitular.getByDocumentoYTipo(pkDeEjemplo);
		
		//se ejecuta la función a testear
		EmitirLicencia emitirLicencia = new EmitirLicencia();
		List<Calendar> vigenciaProbar = emitirLicencia.calcularVigenciaLicencia(titular, "nuevo");
		
		//se instancia una lista que contiene dos Calendar, identicos a los que se espera obtener
		List<Calendar> vigenciaEjemplo = new ArrayList<>();
		vigenciaEjemplo.add(Calendar.getInstance());
		Calendar fechaExpir= titular.getFechaNacimiento();
		fechaExpir.set(Calendar.YEAR, titular.getFechaNacimiento().get(Calendar.YEAR)+5);
		vigenciaEjemplo.add(fechaExpir);
		
		//se aclara que se compara por campos porque si no, podría evaluar falso con solo tener los segundos distintos
		assertTrue(vigenciaProbar.get(0).get(Calendar.DAY_OF_MONTH)==vigenciaEjemplo.get(0).get(Calendar.DAY_OF_MONTH) &&
				vigenciaProbar.get(1).get(Calendar.DAY_OF_MONTH)==vigenciaEjemplo.get(1).get(Calendar.DAY_OF_MONTH)		&&
				vigenciaProbar.get(0).get(Calendar.MONTH)==vigenciaEjemplo.get(0).get(Calendar.MONTH)					&&
				vigenciaProbar.get(1).get(Calendar.MONTH)==vigenciaEjemplo.get(1).get(Calendar.MONTH)					&&
				vigenciaProbar.get(0).get(Calendar.YEAR)==vigenciaEjemplo.get(0).get(Calendar.YEAR)						&&
				vigenciaProbar.get(1).get(Calendar.YEAR)==vigenciaEjemplo.get(1).get(Calendar.YEAR)						);
	}

}
