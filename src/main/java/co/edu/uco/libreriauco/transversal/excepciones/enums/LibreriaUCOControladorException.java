package co.edu.uco.libreriauco.transversal.excepciones.enums;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;


public class LibreriaUCOControladorException extends LibreriaUCOExcepcion{

	private static final long serialVersionUID = -6240488015702704944L;

	
	private LibreriaUCOControladorException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADORA, mensajeUsuario,mensajeTecnico, excepcionRaiz);
		
		public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
			return new LibreriaUCOControladorException(mensajeUsuario , mensaje Usuario, new Exception(mensajeUsuario))
					
		}
		
		public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
			return new LibreriaUCOControladorException(mensajeUsuario , mensaje Usuario, new Exception(mensajeTecnico))
					
		}
		
		
		public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
			return new LibreriaUCOControladorException(mensajeUsuario , mensaje Usuario, new Exception(mensaje))
					
		}
	

}
