package co.edu.uco.libreriauco.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.dto.PaisDTO;

public interface PaisFachada {
	
	void registrarInformacionNuevoPais(PaisDTO datos);
	
	void ModificarInformacionPaisExistente(UUID id, PaisDTO datos);
	
	void DarBajaInformacionPaisExistente(UUID id);
	
	List<PaisDominio> consultarPorFiltro(PaisDTO filtro);
	
	List<PaisDominio> consultarTodos();
	
	PaisDominio consultarPorId(UUID id);

}
