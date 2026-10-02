package co.edu.uco.libreriauco.negocio.negocio.impl;


import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.assembler.impl.PaisEntidadAssembler;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.enums.LibreriaUCONegocioException;
import co.edu.uco.libreriauco.transversal.excepciones.enums.LibreriaUCOTransversalException;

public class PaisNegocioImpl implements PaisNegocio{
	
	private DAOFactory daoFactory;
	
	protected PaisNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoPais(PaisDominio datos) {
		asegurarDatosRegistroNuevoPaisValidos(datos);
		asegurarNombrePaisNoExista(datos.getNombre());
		
		
		var paisEntidad = PaisEntidadAssembler.getInstance().convertirAEntidad(datos);// Es que el que traduce de negocio a entidad, la capa de negocio trabaja solo en terminos de dominio
		paisEntidad.setId(generarIdPaisUnico());
		
		daoFactory.obtenerPaisDAO().crear(paisEntidad);
	}
	
	
	private void asegurarDatosRegistroNuevoPaisValidos(PaisDominio datos) {
		
		
	}
	
	private void asegurarNombrePaisNoExista(String nombrePais) {
		var entidadFiltro = new PaisEntidad();
		entidadFiltro.setNombre(nombrePais);
		
		var resultados = daoFactory.obtenerPaisDAO().consultarPorFiltro(entidadFiltro);// El solo va y consulta por nombre debido a que solo lo definimos por eso
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.PAIS_EXISTE_CON_EL_MISMO_NOMBRE_DE_PAIS_YA_A_CREAR;
			throw LibreriaUCONegocioException.crear(mensajeUsuario);
		}
	}
	
	private UUID generarIdPaisUnico() {
		return UUID.randomUUID();//Por el momento
		
	}
	
	

	@Override
	public void ModificarInformacionPaisExistente(UUID id, PaisDominio datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DarBajaInformacionPaisExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisDominio> consultarPorFiltro(PaisDominio filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDominio> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDominio consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
