package excepciones;

public class ExcepcionContribuyente extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public ExcepcionContribuyente(String msg){
		mensaje= msg;
	}
	
	public String getMensaje(){
		return mensaje;
	}
}
