package co.edu.uco.libreriauco.transversal.excepciones.enums;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOControladorException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -6240488015702704944L;

	private LibreriaUCOControladorException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADORA, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		
		return new LibreriaUCOControladorException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		
		return new LibreriaUCOControladorException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		
		return new LibreriaUCOControladorException(mensajeUsuario, mensajeTecnico, new Exception(excepcionRaiz));
	}
	
}