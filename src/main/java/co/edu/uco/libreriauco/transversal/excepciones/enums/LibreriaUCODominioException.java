package co.edu.uco.libreriauco.transversal.excepciones.enums;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;


public class LibreriaUCODominioException extends LibreriaUCOExcepcion{

	private static final long serialVersionUID = -6240488015702704944L;

	
	protected LibreriaUCODominioException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DOMINIO, mensajeUsuario,mensajeTecnico, excepcionRaiz);
		
	}

}
