package co.edu.uco.libreriauco.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlDAO;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoSqlServerDAO extends sqlDAO implements DepartamentoDAO{

	private static final String SELECT_BASE = "SELECT d.id AS id, d.nombre AS nombre, p.id AS paisId, p.nombre AS paisNombre "
			+ "FROM Departamento d INNER JOIN Pais p ON d.pais = p.id WHERE 1 = 1";

	public DepartamentoSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public DepartamentoEntidad consultarPorId(UUID id) {
		var filtro = new DepartamentoEntidad();
		filtro.setId(id);

		var resultado = consultarPorFiltro(filtro);
		// Sin null: si no existe se devuelve una entidad con los valores por defecto
		return resultado.isEmpty() ? new DepartamentoEntidad() : resultado.get(0);
	}

	@Override
	public List<DepartamentoEntidad> consultarPorFiltro(DepartamentoEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new DepartamentoEntidad());
		var sentencia = new StringBuilder(SELECT_BASE);
		var parametros = new ArrayList<String>();

		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())) {
			sentencia.append(" AND d.id = ?");
			parametros.add(filtroTmp.getId().toString());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNombre())) {
			sentencia.append(" AND d.nombre = ?");
			parametros.add(filtroTmp.getNombre());
		}
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getPais().getId())) {
			sentencia.append(" AND d.pais = ?");
			parametros.add(filtroTmp.getPais().getId().toString());
		}
		sentencia.append(" ORDER BY d.nombre");

		return ejecutarConsulta(sentencia.toString(), parametros);
	}

	@Override
	public List<DepartamentoEntidad> consultarTodos() {
		return ejecutarConsulta(SELECT_BASE + " ORDER BY d.nombre", new ArrayList<>());
	}

	private List<DepartamentoEntidad> ejecutarConsulta(String sentencia, List<String> parametros) {
		var resultado = new ArrayList<DepartamentoEntidad>();

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
					CatalogoMensajes.Datos.TECNICO_ERROR_SQL_CONSULTANDO_DEPARTAMENTO + excepcion.getMessage(), excepcion);
		}
		return resultado;
	}

	private DepartamentoEntidad mapear(ResultSet rs) throws SQLException {
		var pais = new PaisEntidad(UUID.fromString(rs.getString("paisId")), rs.getString("paisNombre"));

		var departamento = new DepartamentoEntidad();
		departamento.setId(UUID.fromString(rs.getString("id")));
		departamento.setNombre(rs.getString("nombre"));
		departamento.setPais(pais);
		return departamento;
	}

}
