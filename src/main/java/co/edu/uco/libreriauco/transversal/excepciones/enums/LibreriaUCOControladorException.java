package co.edu.uco.libreriauco.transversal.excepciones.enums;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;


public class LibreriaUCOControladorException extends LibreriaUCOExcepcion{

	private static final long serialVersionUID = -6240488015702704944L;

	
	private LibreriaUCOControladorException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario,mensajeTecnico, excepcionRaiz);
		
	}

}
