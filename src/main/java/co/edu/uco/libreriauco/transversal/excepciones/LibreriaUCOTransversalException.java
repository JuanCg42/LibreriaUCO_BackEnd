package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOTransversalException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -6240488015702704944L;

	private LibreriaUCOTransversalException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCOTransversalException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCOTransversalException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCOTransversalException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
