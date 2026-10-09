package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais;

import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class AsegurarNombrePaisValidoRule implements Rule<String> {
	
	private static final AsegurarNombrePaisValidoRule instancia = new AsegurarNombrePaisValidoRule();
	private AsegurarNombrePaisValidoRule() {
		
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}


	@Override
	public void ejecutar(String... datos) {
		var nombrePais = datos[0];
		
		validarObligatoriedad(nombrePais);
		validarFormato(nombrePais);
		validarLongitud(nombrePais, 1, 50);
		
		
	}
	
	private void validarObligatoriedad(String dato) {
		
		if (UtilTexto.getUtilTexto().esVacia(dato)) {
			var mensajeUsuario= CatalogoMensajes.PaisNegocioImpl.NOMBRE_PAIS_OBLIGATORIO;
			throw LibreriaUCONegocioException.crear(mensajeUsuario);
			
		}
		
	}
		
	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
			
			if (UtilTexto.getUtilTexto().longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
				var mensajeUsuario= CatalogoMensajes.PaisNegocioImpl.LONGITUD_NOMBRE_PAIS_NO_VALIDA;
				throw LibreriaUCONegocioException.crear(mensajeUsuario);
				
			}	
			
	
	}
	
	private void validarFormato(String dato) {
		
		if (UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.SOLO_LETRAS_ESPACIOS)) {
			var mensajeUsuario= CatalogoMensajes.PaisNegocioImpl.FORMATO_NOMBRE_PAIS_NO_VALIDO;
			throw LibreriaUCONegocioException.crear(mensajeUsuario);
			
		}	
		

}
	
	
	
	
	

}
