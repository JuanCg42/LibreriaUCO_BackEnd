package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.enums.LibreriaUCOTransversalException;

public class UtilSQL {

	private UtilSQL() {

	}

	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}

	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return !conexionEstaVacia(conexion) && !conexion.isClosed();
		} catch (SQLException excepcion) {
			throw LibreriaUCOTransversalException.crear(
					CatalogoMensajes.UtilSQL.USUARIO_ERROR_VALIDANDO_CONEXION_ABIERTA,
					CatalogoMensajes.UtilSQL.TECNICO_ERROR_VALIDANDO_CONEXION_ABIERTA + " " + excepcion.getMessage(),
					excepcion);
		}
	}

	public static void asegurarConexionAbierta(Connection conexion) {
		if (!conexionEstaAbierta(conexion)) {
			throw LibreriaUCOTransversalException.crear(
					CatalogoMensajes.UtilSQL.USUARIO_ERROR_CONEXION_CERRADA,
					CatalogoMensajes.UtilSQL.TECNICO_ERROR_CONEXION_CERRADA);
		}
	}

	public static void cerrarConexion(Connection conexion) {
		try {
			if (conexionEstaAbierta(conexion)) {
				conexion.close();
			}
		} catch (SQLException excepcion) {
			throw LibreriaUCOTransversalException.crear(
					CatalogoMensajes.UtilSQL.USUARIO_ERROR_CERRANDO_CONEXION,
					CatalogoMensajes.UtilSQL.TECNICO_ERROR_CERRANDO_CONEXION + " " + excepcion.getMessage(),
					excepcion);
		}
	}

	public static void iniciarTransaccion(Connection conexion) {
		asegurarConexionAbierta(conexion);
		try {
			conexion.setAutoCommit(false);
		} catch (SQLException excepcion) {
			throw LibreriaUCOTransversalException.crear(
					CatalogoMensajes.UtilSQL.USUARIO_ERROR_INICIANDO_TRANSACCION,
					CatalogoMensajes.UtilSQL.TECNICO_ERROR_INICIANDO_TRANSACCION + " " + excepcion.getMessage(),
					excepcion);
		}
	}

	public static void confirmarTransaccion(Connection conexion) {
		asegurarConexionAbierta(conexion);
		try {
			conexion.commit();
		} catch (SQLException excepcion) {
			throw LibreriaUCOTransversalException.crear(
					CatalogoMensajes.UtilSQL.USUARIO_ERROR_CONFIRMANDO_TRANSACCION,
					CatalogoMensajes.UtilSQL.TECNICO_ERROR_CONFIRMANDO_TRANSACCION + " " + excepcion.getMessage(),
					excepcion);
		}
	}

	public static void cancelarTransaccion(Connection conexion) {
		asegurarConexionAbierta(conexion);
		try {
			conexion.rollback();
		} catch (SQLException excepcion) {
			throw LibreriaUCOTransversalException.crear(
					CatalogoMensajes.UtilSQL.USUARIO_ERROR_CANCELANDO_TRANSACCION,
					CatalogoMensajes.UtilSQL.TECNICO_ERROR_CANCELANDO_TRANSACCION + " " + excepcion.getMessage(),
					excepcion);
		}
	}

}
