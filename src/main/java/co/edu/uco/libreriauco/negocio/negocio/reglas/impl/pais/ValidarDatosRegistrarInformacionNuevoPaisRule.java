package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;

public class ValidarDatosRegistrarInformacionNuevoPaisRule implements Rule<PaisDominio> {

	
	private static final Rule<PaisDominio> instancia = new ValidarDatosRegistrarInformacion();
	
	private ValidarDatosRegistrarInformacion() {
		
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}
	
	
	@Override
	public void ejecutar(PaisDominio... datos) {
		var dominio = datos[0];
		
		AsegurarNombrePaisValidoRule.obtenerInstancia().ejecutar(dominio.getNombre());		
	}

}
