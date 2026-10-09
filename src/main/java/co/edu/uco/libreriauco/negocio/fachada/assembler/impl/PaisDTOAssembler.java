package co.edu.uco.libreriauco.negocio.fachada.assembler.impl;

import java.util.List;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.assembler.DTOAssembler;

public class PaisDTOAssembler  implements DTOAssembler<PaisDominio, PaisDTO>{
	
	private static final DTOAssembler<PaisDominio, PaisDTO> instancia= new PaisDTOAssembler();

	
	private PaisDTOAssembler() {
		
	}
	@Override
	public PaisDTO convertirADTO(PaisDominio dominio) {

		return instancia;
	}

	@Override
	public PaisDominio convertirADominio(PaisDTO dto) {

		return null;
	}
	@Override
	public List<PaisDTO> convertirADTO(List<PaisDominio> listaDominios) {
		
		
		return listaDominios.stream().map(this:: convertirADTO).toList();
	}

}
