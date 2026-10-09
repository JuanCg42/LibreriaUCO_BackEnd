package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCODatosException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -6240488015702704944L;

	private LibreriaUCODatosException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCODatosException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCODatosException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCODatosException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
