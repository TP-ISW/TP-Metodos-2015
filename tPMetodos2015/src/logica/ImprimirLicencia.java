package logica;

import java.util.Calendar;

import clasesDeTablas.Comprobante;
import persistencia.DAOComprobante;

public class ImprimirLicencia {

	static void imprimirLicencia(){
		
		DAOComprobante daoComprobante = new DAOComprobante();
		
		
		//se instancia un comprobante y se setean valores ficticios
		Comprobante comprobante = new Comprobante();
		comprobante.setCuit("XX-XXXXXXXX-X");
		comprobante.setFechaEmision(Calendar.getInstance());
		comprobante.setLicenciaExpirada(null);
		comprobante.setMonto((float) 99.0);
		
		imprimirComprobante(comprobante);
		
		
		//se guarda el comprobante en la BD
		daoComprobante.save(comprobante);
		
	}

	private static void imprimirComprobante(Comprobante comprobante) {
		// TODO Auto-generated method stub
		
	}
}
