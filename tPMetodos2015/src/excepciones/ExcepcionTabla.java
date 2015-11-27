package excepciones;

public class ExcepcionTabla extends Exception {
	private static final long serialVersionUID = 1L;

	private String mensaje;
	public ExcepcionTabla(String msg){
		mensaje= msg;
	}
	
	public String getMensaje(){
		return mensaje;
	}
}
