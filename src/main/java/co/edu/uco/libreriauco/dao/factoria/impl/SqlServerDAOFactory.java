package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;

public class SqlServerDAOFactory extends DAOFactory {

	private static final String SERVIDOR = "localhost";
	private static final String PUERTO = "1433";
	private static final String BASE_DE_DATOS = "libreriauco";

	@Override
	protected void abrirConexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String cadenaConexion = "jdbc:sqlserver://" + SERVIDOR + ":" + PUERTO
					+ ";databaseName=" + BASE_DE_DATOS
					+ ";integratedSecurity=true;encrypt=false;trustServerCertificate=true;";

			Connection conexion = DriverManager.getConnection(cadenaConexion);
			setConexion(conexion);

		} catch (ClassNotFoundException excepcion) {
			throw LibreriaUCODatosException.crear(
					"No fue posible conectarse a la fuente de datos. Por favor contacte al administrador de la aplicacion.",
					"No se encontro el driver JDBC de SQL Server (com.microsoft.sqlserver.jdbc.SQLServerDriver). Verifique la dependencia mssql-jdbc en el pom.xml.",
					excepcion);
		} catch (SQLException excepcion) {
			throw LibreriaUCODatosException.crear(
					"No fue posible conectarse a la fuente de datos. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.",
					"Error al abrir la conexion con SQL Server: " + excepcion.getMessage(),
					excepcion);
		}
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisSqlServerDAO(getConexion());
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoSqlServerDAO(getConexion());
	}

}
