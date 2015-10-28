package validacion;
import clasesDeTablas.Titular;

public class Validar {
	boolean validar(Titular titular){
		int comprobar=0;
		titular.getId().getTipoDoc();
		if(titular.getId().getNroDoc().length()==8){
			comprobar++;
		}
		if (comprobar ==11) return true;
		else return false;
	}
}
