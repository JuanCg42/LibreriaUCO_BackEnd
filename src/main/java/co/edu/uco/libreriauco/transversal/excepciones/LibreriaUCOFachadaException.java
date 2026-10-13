package co.edu.uco.libreriauco.transversal.excepciones;


import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOFachadaException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -6240488015702704944L;

	private LibreriaUCOFachadaException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.FACHADA, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCOFachadaException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCOFachadaException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCOFachadaException(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
