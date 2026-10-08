package co.edu.uco.libreriauco.negocio.negocio.impl;


import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.assembler.impl.PaisEntidadAssembler;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais.AsegurarNombreNuevoPaisNoExistaRule;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais.AsegurarNombrePaisValidoRule;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais.ValidarDatosRegistrarInformacionNuevoPaisRule;
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
		ValidarDatosRegistrarInformacionNuevoPaisRule.obtenerInstancia().ejecutar(datos);		
	    AsegurarNombreNuevoPaisNoExistaRule.obtenerInstancia().ejecutar(datos.getNombre(), daoFactory);
	    
		
		
		var paisEntidad = PaisEntidadAssembler.getInstance().convertirAEntidad(datos);// Es que el que traduce de negocio a entidad, la capa de negocio trabaja solo en terminos de dominio
		paisEntidad.setId(generarIdPaisUnico());
		
		daoFactory.obtenerPaisDAO().crear(paisEntidad);
	}
	
	
	private void asegurarDatosRegistroNuevoPaisValidos(PaisDominio datos) {
		
		
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
