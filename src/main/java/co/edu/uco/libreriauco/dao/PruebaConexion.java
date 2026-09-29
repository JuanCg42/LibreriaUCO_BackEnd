package co.edu.uco.libreriauco.dao;

import co.edu.uco.libreriauco.dao.factoria.impl.SqlServerDAOFactory;

public class PruebaConexion {

		public static void main(String[] args) {
			var factoria = new SqlServerDAOFactory();   // abre la conexion
			try {
				var paises = factoria.obtenerPaisDAO().consultarTodos();
				System.out.println("Conectado. Paises encontrados: " + paises.size());
				paises.forEach(p -> System.out.println(p.getId() + " - " + p.getNombre()));
			} finally {
				factoria.cerrarConexion();
			}
		}
	}


