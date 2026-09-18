package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;

public class SqlServerDAOFactory extends DAOFactory{

	private static final String SERVIDOR = "localhost\\MSSQLSERVER01";
	private static final String PUERTO = "1433";
	private static final String BASE_DE_DATOS = "libreriauco";
	
	
	@Override
	protected void abrirConexion() {
		// TAREA: Como abrir una conexion con SQL server desde java
		/**Connection conexion = null;
		setConexion(conexion);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String cadenaConexion = "jdbc:sqlserver://" + SERVIDOR + ":" + PUERTO
					+ ";databaseName=" + BASE_DE_DATOS
					+ ";integratedSecurity=true;encrypt=false;trustServerCertificate=true;";

			conexion = DriverManager.getConnection(cadenaConexion);

		} catch (ClassNotFoundException excepcion) {
			throw new RuntimeException("No se encontró el driver JDBC de SQL Server", excepcion);
		} catch (SQLException excepcion) {
			throw new RuntimeException("Error al establecer la conexión con la base de datos", excepcion);
		}

		setConexion(conexion);
	}*/
		

	
	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisSqlServerDAO();
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoSqlServerDAO();
	}

}
