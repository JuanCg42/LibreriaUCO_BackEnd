package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCODTOException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -6240488015702704944L;

	private LibreriaUCODTOException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DTO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCODTOException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCODTOException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCODTOException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
