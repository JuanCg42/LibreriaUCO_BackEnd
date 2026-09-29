package co.edu.uco.libreriauco.transversal.catalogo;

public class CatalogoMensajes {

	private CatalogoMensajes() {

	}

	public static class Datos {

		private Datos() {

		}

		public static final String USUARIO_ERROR_CREANDO = "Se ha presentado un problema tratando de registrar la informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.";
		public static final String USUARIO_ERROR_CONSULTANDO = "Se ha presentado un problema tratando de consultar la informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.";
		public static final String USUARIO_ERROR_ACTUALIZANDO = "Se ha presentado un problema tratando de actualizar la informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.";
		public static final String USUARIO_ERROR_ELIMINANDO = "Se ha presentado un problema tratando de eliminar la informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.";

	}

	public static class UtilSQL {

		private UtilSQL() {

		}

		private static final String CONTACTO = " Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.";

		public static final String USUARIO_ERROR_VALIDANDO_CONEXION_ABIERTA = "Se ha presentado un problema tratando de validar si la conexion con la fuente de datos esta abierta." + CONTACTO;
		public static final String TECNICO_ERROR_VALIDANDO_CONEXION_ABIERTA = "Se presento una SQLException al validar el estado de la conexion (Connection.isClosed). Revise la causa raiz.";

		public static final String USUARIO_ERROR_CONEXION_CERRADA = "No es posible realizar la operacion porque la conexion con la fuente de datos no esta abierta." + CONTACTO;
		public static final String TECNICO_ERROR_CONEXION_CERRADA = "La conexion recibida es nula o esta cerrada.";

		public static final String USUARIO_ERROR_CERRANDO_CONEXION = "Se ha presentado un problema tratando de cerrar la conexion con la fuente de datos." + CONTACTO;
		public static final String TECNICO_ERROR_CERRANDO_CONEXION = "Se presento una SQLException al cerrar la conexion (Connection.close). Revise la causa raiz.";

		public static final String USUARIO_ERROR_INICIANDO_TRANSACCION = "Se ha presentado un problema tratando de iniciar la transaccion." + CONTACTO;
		public static final String TECNICO_ERROR_INICIANDO_TRANSACCION = "Se presento una SQLException al desactivar el autocommit (Connection.setAutoCommit(false)). Revise la causa raiz.";

		public static final String USUARIO_ERROR_CONFIRMANDO_TRANSACCION = "Se ha presentado un problema tratando de confirmar la transaccion." + CONTACTO;
		public static final String TECNICO_ERROR_CONFIRMANDO_TRANSACCION = "Se presento una SQLException al confirmar la transaccion (Connection.commit). Revise la causa raiz.";

		public static final String USUARIO_ERROR_CANCELANDO_TRANSACCION = "Se ha presentado un problema tratando de cancelar la transaccion." + CONTACTO;
		public static final String TECNICO_ERROR_CANCELANDO_TRANSACCION = "Se presento una SQLException al cancelar la transaccion (Connection.rollback). Revise la causa raiz.";

	}

}
