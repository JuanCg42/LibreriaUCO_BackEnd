package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.libreriauco.transversal.excepciones.enums.LibreriaUCOTransversalException;

public class UtilSQL {
	private UtilSQL() {
		
	}
	
	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return(!conexionEstaVacia(conexion) && !conexion.isClosed());
		} catch (SQLException excepcion) {
			var mensajeUsuario= "";
			var mensajeTecnico="";
			
			LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(),excepcion);
			
		
		}catch(Exception excepcion) {
			excepcion.printStackTrace();
		}
		
	}
	
	public static void asegurarConexionAbierta(Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "Mensaje que indique en terminos de usuario que no es posible ";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
			
			
		}
	}
	
	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}
	

}