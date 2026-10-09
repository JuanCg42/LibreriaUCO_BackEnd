package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOTransversalException;


public class UtilSQL {
	private UtilSQL() {
		
	}
	
	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return(!conexionEstaVacia(conexion) && !conexion.isClosed());
		} catch (SQLException excepcion) {
			var mensajeUsuario= CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(),excepcion);
			
			}catch(Exception excepcion) {
				var mensajeUsuario= CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
				throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(),excepcion);
		}
		
	}
	
	public static void iniciarTransaccion (Connection conexion) {
		
		if(transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}
		// Tarea que se tenia de como iniciar una transaccion
	}
	
	public static void confirmarTransaccion(Connection conexion) {
		if(transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible confirmar una transaccion que no fue iniciada";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}
		//Tarea que se tenia de como confirmar una transaccion
		
	}
	
	
	
	public static void cancelarTransaccion(Connection conexion) {
		if(transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible cancelar una transaccion que no fue iniciada";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}
		//Tarea que se tenia de como cancelar la transaccion
		
	}
	
	public static void cerrarConexion(Connection conexion) {
		if(transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible cerrar conexion que no esta abierta";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}
		//Tarea que se tenia de como cerrar la conexion 
		}
	
	
	
	public static boolean transaccionEstaIniciada(Connection conexion) {
		try{
			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
		} catch (SQLException excepcion) {
			var mensajeUsuario= CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(),excepcion);
			
			}catch(Exception excepcion) {
				var mensajeUsuario= CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
				throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(),excepcion);
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