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

		try {
			conexion.setAutoCommit(false);
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQLTecnico.USUARIO_ERROR_INICIANDO_TRANSACCION;
			var mensajeTecnico = CatalogoMensajes.UtilSQLTecnico.ERROR_INICIANDO_TRANSACCION + excepcion.getMessage();
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}
	
	public static void confirmarTransaccion(Connection conexion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.commit();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQLTecnico.USUARIO_ERROR_CONFIRMANDO_TRANSACCION;
			var mensajeTecnico = CatalogoMensajes.UtilSQLTecnico.ERROR_CONFIRMANDO_TRANSACCION + excepcion.getMessage();
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}
	
	
	
	public static void cancelarTransaccion(Connection conexion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.rollback();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQLTecnico.USUARIO_ERROR_CANCELANDO_TRANSACCION;
			var mensajeTecnico = CatalogoMensajes.UtilSQLTecnico.ERROR_CANCELANDO_TRANSACCION + excepcion.getMessage();
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
	}
	
	public static void cerrarConexion(Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.close();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQLTecnico.USUARIO_ERROR_CERRANDO_CONEXION;
			var mensajeTecnico = CatalogoMensajes.UtilSQLTecnico.ERROR_CERRANDO_CONEXION + excepcion.getMessage();
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, mensajeTecnico, excepcion);
		}
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
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
			
		}
	}
	
	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}
	

}