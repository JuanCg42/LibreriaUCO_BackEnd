package co.edu.uco.libreriauco.transversal.excepciones.enums;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;


public class LibreriaUCODTOException extends LibreriaUCOExcepcion{

	private static final long serialVersionUID = -6240488015702704944L;

	
	protected LibreriaUCODTOException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DTO, mensajeUsuario,mensajeTecnico, excepcionRaiz);
		
	}

}
