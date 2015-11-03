package excepciones;

public class ExcepcionValidador extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public ExcepcionValidador(String msg){
		mensaje= msg;
	}
	
	public String getMensaje(){
		return mensaje;
	}
}
