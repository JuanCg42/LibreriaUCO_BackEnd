package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;

public class SqlServerDAOFactory extends DAOFactory{

	@Override
	protected void abrirConexion() {
		// TAREA: Como abrir una conexion con SQL server desde java
		Connection conexion = null;
		setConexion(conexion);
		
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisSqlServerDAO();
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoSqlServerDAO();
	}

}
