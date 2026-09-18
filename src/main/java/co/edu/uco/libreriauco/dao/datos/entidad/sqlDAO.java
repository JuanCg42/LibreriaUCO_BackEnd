package co.edu.uco.libreriauco.dao.datos.entidad;

import java.sql.Connection;

public abstract class sqlDAO {
	private Connection conexion;
	
	
	protected sqlDAO(Connection conexion) {
		setConexion(conexion);
	}
	
	private void setConexion(Connection conexion) {
		
		
		this.conexion= conexion;
	}

	private Connection getConnection() {
		return conexion;
	}
	
	
	

}
