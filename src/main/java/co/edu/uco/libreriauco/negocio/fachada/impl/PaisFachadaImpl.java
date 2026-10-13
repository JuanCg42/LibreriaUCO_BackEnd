package co.edu.uco.libreriauco.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.PaisFachada;
import co.edu.uco.libreriauco.negocio.fachada.assembler.impl.PaisDTOAssembler;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.impl.PaisNegocioImpl;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOFachadaException;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioException;

public class PaisFachadaImpl implements PaisFachada {

	private DAOFactory daoFactory;
	private PaisNegocio paisNegocio;

	public PaisFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		paisNegocio = new PaisNegocioImpl(daoFactory);
	}

	@Override
	public void registrarInformacionNuevoPais(PaisDTO datos) {
		daoFactory.iniciarTransaccion();
		
		try {
			var paisDominio= PaisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.registrarInformacionNuevoPais(paisDominio);
			
			daoFactory.confirmarTransaccion();
		} catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo país deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			
		}finally {
			daoFactory.cerrarConexion();
			
		}

	}

	@Override
	public void ModificarInformacionPaisExistente(UUID id, PaisDTO datos) {
		daoFactory.iniciarTransaccion();
		
		try {
			var paisDominio= PaisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.ModificarInformacionPaisExistente(id, paisDominio);
			daoFactory.confirmarTransaccion();
		} catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de modificar la información del nuevo país deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			
		}finally {
			daoFactory.cerrarConexion();
			
		}

	}

	@Override
	public void DarBajaInformacionPaisExistente(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PaisDTO> consultarPorFiltro(PaisDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> consultarTodos() {
		
		try {
			var listaPaisesDominio = paisNegocio.consultarTodos();
			return PaisDTOAssembler.getInstance().convertirADTO(listaPaisesDominio);
		} catch (LibreriaUCOExcepcion excepcion) {
			throw excepcion;
		}catch (Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar la información de todos los paises deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw LibreriaUCONegocioException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			
		}finally {
			daoFactory.cerrarConexion();
			
		}
		
	}

	@Override
	public List<PaisDTO> consultarPorId(UUID id) {
		return null;
	}
}
