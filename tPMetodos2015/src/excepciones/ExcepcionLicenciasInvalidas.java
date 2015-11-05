package excepciones;

public class ExcepcionLicenciasInvalidas extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public ExcepcionLicenciasInvalidas(String msg){
		mensaje= msg;
	}
	
	public String getMensaje(){
		return mensaje;
	}
}
