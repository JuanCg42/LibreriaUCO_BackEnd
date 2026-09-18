package co.edu.uco.libreriauco.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlDAO;




public class DepartamentoSqlServerDAO extends sqlDAO implements DepartamentoDAO {

	public DepartamentoSqlServerDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DepartamentoDAO consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDAO> consultarPorFiltro(DepartamentoDAO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDAO> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
