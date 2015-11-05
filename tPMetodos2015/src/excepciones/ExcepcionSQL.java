package excepciones;

public class ExcepcionSQL extends Exception {
	private static final long serialVersionUID = 1L;

	private String mensaje;
	public ExcepcionSQL(String msg){
		mensaje= msg;
	}
	
	public String getMensaje(){
		return mensaje;
	}
}
