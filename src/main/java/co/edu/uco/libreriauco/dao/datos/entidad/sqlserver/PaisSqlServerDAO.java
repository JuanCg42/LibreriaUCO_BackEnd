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
import co.edu.uco.libreriauco.transversal.excepciones.enums.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisSqlServerDAO extends sqlDAO implements PaisDAO {

	public PaisSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(PaisEntidad entidad) {
		var sentencia = "INSERT INTO Pais (id, nombre) VALUES (?, ?)";

		try (PreparedStatement ps = getConexion().prepareStatement(sentencia)) {
			ps.setString(1, entidad.getId().toString());
			ps.setString(2, entidad.getNombre());
			ps.executeUpdate();
		} catch (SQLException excepcion) {
			throw LibreriaUCODatosException.crear(CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO,
					"Error SQL insertando un Pais: " + excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public PaisEntidad consultarPorId(UUID id) {
		var sentencia = "SELECT id, nombre FROM Pais WHERE id = ?";

		try (PreparedStatement ps = getConexion().prepareStatement(sentencia)) {
			ps.setString(1, UtilUUID.obtenerValorDefecto(id).toString());
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next() ? mapear(rs) : null;
			}
		} catch (SQLException excepcion) {
			throw LibreriaUCODatosException.crear(CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO,
					"Error SQL consultando un Pais por id: " + excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public List<PaisEntidad> consultarPorFiltro(PaisEntidad filtro) {
		var sentencia = new StringBuilder("SELECT id, nombre FROM Pais WHERE 1 = 1");
		var parametros = new ArrayList<String>();

		if (filtro != null) {
			if (!UtilUUID.obtenerUUIDDefecto().equals(filtro.getId())) {
				sentencia.append(" AND id = ?");
				parametros.add(filtro.getId().toString());
			}
			if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
				sentencia.append(" AND nombre LIKE ?");
				parametros.add("%" + filtro.getNombre() + "%");
			}
		}
		sentencia.append(" ORDER BY nombre");

		return ejecutarConsulta(sentencia.toString(), parametros);
	}

	@Override
	public List<PaisEntidad> consultarTodos() {
		return ejecutarConsulta("SELECT id, nombre FROM Pais ORDER BY nombre", new ArrayList<>());
	}

	@Override
	public void actualizar(UUID id, PaisEntidad entidad) {
		var sentencia = "UPDATE Pais SET nombre = ? WHERE id = ?";

		try (PreparedStatement ps = getConexion().prepareStatement(sentencia)) {
			ps.setString(1, entidad.getNombre());
			ps.setString(2, UtilUUID.obtenerValorDefecto(id).toString());
			ps.executeUpdate();
		} catch (SQLException excepcion) {
			throw LibreriaUCODatosException.crear(CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO,
					"Error SQL actualizando un Pais: " + excepcion.getMessage(), excepcion);
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
					"Error SQL eliminando un Pais: " + excepcion.getMessage(), excepcion);
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
					"Error SQL consultando Paises: " + excepcion.getMessage(), excepcion);
		}
		return resultado;
	}

	private PaisEntidad mapear(ResultSet rs) throws SQLException {
		var pais = new PaisEntidad();
		pais.setId(UUID.fromString(rs.getString("id")));
		pais.setNombre(rs.getString("nombre"));
		return pais;
	}

}
