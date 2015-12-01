package excepciones;

public class ExcepcionNull extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public ExcepcionNull(String msg){
		mensaje=msg;
	}
	public String getMensaje(){
		return mensaje;
	}
}
