package co.edu.uco.libreriauco.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import co.edu.uco.libreriauco.dao.factoria.impl.SqlServerDAOFactory;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

/**
 * Prueba de integracion: requiere SQL Server con la base libreriauco y las tablas de db/libreriauco.sql.
 * Todo se ejecuta dentro de una transaccion que se cancela al final, por lo que no deja datos.
 */
class PaisSqlServerDAOTest {

	@Test
	void debeCrearConsultarActualizarYEliminarPais() {
		var factoria = new SqlServerDAOFactory();
		try {
			factoria.iniciarTransaccion();
			var dao = factoria.obtenerPaisDAO();

			var pais = new PaisEntidad();
			pais.setId(UtilUUID.generar());
			pais.setNombre("  PaisDePrueba  ");

			dao.crear(pais);

			var consultado = dao.consultarPorId(pais.getId());
			assertNotNull(consultado);
			assertEquals("PaisDePrueba", consultado.getNombre());

			var filtro = new PaisEntidad();
			filtro.setNombre("DePrue");
			assertEquals(1, dao.consultarPorFiltro(filtro).size());

			consultado.setNombre("PaisActualizado");
			dao.actualizar(consultado.getId(), consultado);
			assertEquals("PaisActualizado", dao.consultarPorId(pais.getId()).getNombre());
			assertTrue(dao.consultarTodos().stream().anyMatch(p -> p.getId().equals(pais.getId())));

			dao.eliminar(pais.getId());
			assertNull(dao.consultarPorId(pais.getId()));
		} finally {
			factoria.cancelarTransaccion();
			factoria.cerrarConexion();
		}
	}

}
