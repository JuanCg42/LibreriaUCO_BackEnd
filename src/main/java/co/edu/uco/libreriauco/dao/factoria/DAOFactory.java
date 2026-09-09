package co.edu.uco.libreriauco.dao.factoria;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;

public abstract class DAOFactory {
	
	private Connection conexion;
	
	protected DAOFactory() {
		abrirConexion();
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		//TAREA : Asegurar que la conexión este abierta y sea valida
		this.conexion = conexion;
	}
	

	//No en todos los motores se abre igual conexion
	
	protected abstract void abrirConexion();
	
	
	
	public void cerrarConexion() {
		//TAREA : como se cierra la conexion de manera segura
	}
	
	public void iniciarTransaccion() {
		// TAREA: Como se inicia una transaccion de forma segura
	}
	
	public void confirmarTransaccion() {
		//Tarea: como se confirma una transaccion de forma segura
	}
	
	public void cancelarTransaccion() {
		//Tarea: como se cancela una transaccion de forma segura
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract DepartamentoDAO obtenerDepartamentoDAO();
	
	
}
