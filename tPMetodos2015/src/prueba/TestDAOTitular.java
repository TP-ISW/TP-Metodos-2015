package prueba;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import clasesDeTablas.Clase;
import clasesDeTablas.Titular;
import clasesDeTablas.TitularPK;
import excepciones.ExcepcionContribuyente;
import excepciones.ExcepcionLicenciasInvalidas;
import excepciones.ExcepcionSQL;
import excepciones.ExcepcionValidador;
import junit.framework.TestCase;
import logica.AltaTitular;
import persistencia.DAOClase;
import persistencia.DAOTitular;

public class TestDAOTitular extends TestCase {

	DAOTitular daoTitular = new DAOTitular();
	Titular titularDeEjemplo = new Titular();
	TitularPK pkDeEjemplo = new TitularPK();
	Titular titularBD = new Titular();
	List<String> stringClases = new ArrayList<>();
	DAOClase daoClase= new DAOClase();
	List<Clase> clasesSolicitadas = new ArrayList<>();
	Calendar fechaNac= Calendar.getInstance();
	
	@Test
	public void testDAOTitular() throws Exception {
		//crea el titular y lo guarda en la BD
		fechaNac.set(Calendar.YEAR, 1994);
		stringClases.add("A");
		AltaTitular altaTitular = new AltaTitular();
		try {
			altaTitular.altaTitular("37566732",
					"DNI",
					"MATIAS",
					"SEQUEIRA",
					"GENERAL PAZ 1111",
					false,
					"+",
					"A",
					fechaNac,
					"M",
					"FOTO.jpg",
					stringClases);
		} catch (ExcepcionValidador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionLicenciasInvalidas e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionContribuyente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//se setea un titular de ejemplo para luego compararlo con el que recuperamos de la BD
	    titularDeEjemplo.setNombre("MATIAS");
		titularDeEjemplo.setApellido("SEQUEIRA");
		titularDeEjemplo.setDomicilio("GENERAL PAZ 1111");
		titularDeEjemplo.setDonante(false);
		titularDeEjemplo.setFactorRh("+");
		titularDeEjemplo.setFechaNacimiento(fechaNac);
		titularDeEjemplo.setFoto("FOTO.jpg");
		titularDeEjemplo.setGrupoSanguineo("A");
		titularDeEjemplo.setSexo("M"); 
		
		pkDeEjemplo.setNroDoc("37566732");
		pkDeEjemplo.setTipoDoc("DNI");
		
		titularDeEjemplo.setId(pkDeEjemplo);
		//recuperamos la clase A de la BD y la seteamos al titularDeEjemplo
		clasesSolicitadas.add(daoClase.getById("A"));
		titularDeEjemplo.setClasesSolicitadas(clasesSolicitadas);
		
		//recuperamos el titular guardado anteriormente
		titularBD = daoTitular.getByDocumentoYTipo(pkDeEjemplo);
		
		assertEquals(titularBD, titularDeEjemplo);
		
	   }
}
