package co.edu.uco.libreriauco.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlDAO;
import co.edu.uco.libreriauco.entidad.PaisEntidad;

public class PaisSqlServerDAO extends sqlDAO implements PaisDAO {

    public PaisSqlServerDAO(Connection conexion) {
        super(conexion);
        // TODO Auto-generated constructor stub
    }

   @Override
    public void crear(PaisEntidad entidad) {
	   getConexion();
        
    }

    @Override
    public PaisEntidad consultarPorId(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaisEntidad> consultarPorFiltro(PaisEntidad filtro) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaisEntidad> consultarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

  

    @Override
    public void eliminar(UUID id) {
        // TODO Auto-generated method stub
        
    }

	@Override
	public void actualizar(UUID id, PaisEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

}