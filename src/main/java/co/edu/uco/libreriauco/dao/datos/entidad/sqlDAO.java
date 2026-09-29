package co.edu.uco.libreriauco.dao.datos.entidad;

import java.sql.Connection;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilSQL;

public abstract class sqlDAO {

	private Connection conexion;

	protected sqlDAO(Connection conexion) {
		setConexion(conexion);
	}

	private void setConexion(Connection conexion) {
		UtilSQL.asegurarConexionAbierta(conexion);
		this.conexion = conexion;
	}

	protected Connection getConexion() {
		return conexion;
	}

}
