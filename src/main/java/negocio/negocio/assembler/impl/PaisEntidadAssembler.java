package negocio.negocio.assembler.impl;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import negocio.negocio.assembler.EntidadAssembler;

public class PaisEntidadAssembler implements EntidadAssembler<PaisDominio, PaisEntidad>{

	@Override
	public PaisEntidad convertirAEntidad(PaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, 
				new PaisDominio.Builder().build());
		
		return PaisEntidad(dominioTmp.getId(), dominioTmp.getNombre());
	}

	@Override
	public PaisDominio convertirADominio(PaisEntidad entidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
