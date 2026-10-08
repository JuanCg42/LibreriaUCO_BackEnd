package co.edu.uco.libreriauco.transversal.catalogo;

public class CatalogoMensajes {
	
	


	private CatalogoMensajes() {
		
	}
	

	public static class UtilSQL{
		
		private UtilSQL() {
			
		}
		
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción ya fue iniciada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		

		
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información no se encuentra abierta, ya sea porque está cerrada o porque está vacía. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible confirmar los cambios de la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción no fue iniciada previamente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible deshacer los cambios de la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción no fue iniciada previamente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL = "No es posible finalizar de manera adecuada la operación deseada, debido a que la conexión contra la fuente de información que se intentó cerrar ya se encuentra cerrada o está vacía. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
	}
	
	public static class PaisNegocioImpl{
		private PaisNegocioImpl() {
			
		}
		
		public static final String PAIS_EXISTE_CON_EL_MISMO_NOMBRE_DE_PAIS_YA_A_CREAR = "Ya existe otro país con el nombre con el cuál se desea ";
		public static final String NOMBRE_PAIS_OBLIGATORIO = "El nombre del pais es obligatorio para llevar a cabo la operación deseada.";
		public static final String LONGITUD_NOMBRE_PAIS_NO_VALIDA = "La longitud del nombre del pais no es válida.asegurese que este entre 1 y 50";
		public static final String FORMATO_NOMBRE_PAIS_NO_VALIDO = "El formato del nombre no es valido. Asegurese de que solamente tenga letras de la A a la Z, mayúsculas o minusculas y espacios";
	}
	
	
	
	
}