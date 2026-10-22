package co.edu.uco.libreriauco.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlDAO;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisSqlServerDAO extends sqlDAO implements PaisDAO {

	private static final String SELECT_BASE = "SELECT id, nombre FROM Pais WHERE 1 = 1";

	public PaisSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(PaisEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PaisEntidad());
		var sentencia = "INSERT INTO Pais (id, nombre) VALUES (?, ?)";

		try (PreparedStatement ps = getConexion().prepareStatement(sentencia)) {
			ps.setString(1, entidadTmp.getId().toString());
			ps.setString(2, entidadTmp.getNombre());
			ps.executeUpdate();
		} catch (SQLException excepcion) {
			throw LibreriaUCODatosException.crear(CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO,
					CatalogoMensajes.Datos.TECNICO_ERROR_SQL_CREANDO_PAIS + excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public PaisEntidad consultarPorId(UUID id) {
		var filtro = new PaisEntidad();
		filtro.setId(id);

		var resultado = consultarPorFiltro(filtro);
		// Sin null: si no existe se devuelve una entidad con los valores por defecto
		return resultado.isEmpty() ? new PaisEntidad() : resultado.get(0);
	}

	@Override
	public List<PaisEntidad> consultarPorFiltro(PaisEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PaisEntidad());
		var sentencia = new StringBuilder(SELECT_BASE);
		var parametros = new ArrayList<String>();

		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())) {
			sentencia.append(" AND id = ?");
			parametros.add(filtroTmp.getId().toString());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNombre())) {
			sentencia.append(" AND nombre = ?");
			parametros.add(filtroTmp.getNombre());
		}
		sentencia.append(" ORDER BY nombre");

		return ejecutarConsulta(sentencia.toString(), parametros);
	}

	@Override
	public List<PaisEntidad> consultarTodos() {
		return ejecutarConsulta(SELECT_BASE + " ORDER BY nombre", new ArrayList<>());
	}

	@Override
	public void actualizar(UUID id, PaisEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new PaisEntidad());
		var sentencia = "UPDATE Pais SET nombre = ? WHERE id = ?";

		try (PreparedStatement ps = getConexion().prepareStatement(sentencia)) {
			ps.setString(1, entidadTmp.getNombre());
			ps.setString(2, UtilUUID.obtenerValorDefecto(id).toString());
			ps.executeUpdate();
		} catch (SQLException excepcion) {
			throw LibreriaUCODatosException.crear(CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO,
					CatalogoMensajes.Datos.TECNICO_ERROR_SQL_ACTUALIZANDO_PAIS + excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public void eliminar(UUID id) {
		var sentencia = "DELETE FROM Pais WHERE id = ?";

		try (PreparedStatement ps = getConexion().prepareStatement(sentencia)) {
			ps.setString(1, UtilUUID.obtenerValorDefecto(id).toString());
			ps.executeUpdate();
		} catch (SQLException excepcion) {
			throw LibreriaUCODatosException.crear(CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO,
					CatalogoMensajes.Datos.TECNICO_ERROR_SQL_ELIMINANDO_PAIS + excepcion.getMessage(), excepcion);
		}
	}

	private List<PaisEntidad> ejecutarConsulta(String sentencia, List<String> parametros) {
		var resultado = new ArrayList<PaisEntidad>();

		try (PreparedStatement ps = getConexion().prepareStatement(sentencia)) {
			for (int i = 0; i < parametros.size(); i++) {
				ps.setString(i + 1, parametros.get(i));
			}
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					resultado.add(mapear(rs));
				}
			}
		} catch (SQLException excepcion) {
			throw LibreriaUCODatosException.crear(CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO,
					CatalogoMensajes.Datos.TECNICO_ERROR_SQL_CONSULTANDO_PAIS + excepcion.getMessage(), excepcion);
		}
		return resultado;
	}

	private PaisEntidad mapear(ResultSet rs) throws SQLException {
		return new PaisEntidad(UUID.fromString(rs.getString("id")), rs.getString("nombre"));
	}

}
