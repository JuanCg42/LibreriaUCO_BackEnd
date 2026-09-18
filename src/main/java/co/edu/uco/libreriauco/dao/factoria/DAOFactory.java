package co.edu.uco.libreriauco.dao.factoria;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes.UtilSQL;

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
		UtilSQL.cerrarConexion(conexion)
	}
	
	public void iniciarTransaccion() {
		// TAREA: Como se inicia una transaccion de forma segura
		UtilSQL.iniciarConexion(conexion)
	}
	
	public void confirmarTransaccion() {
		//Tarea: como se confirma una transaccion de forma segura
		UtilSQL.confirmarConexion(conexion)
	}
	
	public void cancelarTransaccion() {
		//Tarea: como se cancela una transaccion de forma segura
		UtilSQL.cancelarConexion(conexion)
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract DepartamentoDAO obtenerDepartamentoDAO();
	
	
}
