package co.edu.uco.libreriauco.controlador.respuesta;

import java.util.List;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class RespuestaOK<D> extends Respuesta<D> {

	protected RespuestaOK(List<String> mensajes, List<D> datos) {
		super(mensajes, datos, EstadoRespuesta.OK);
	}
	
	public static <D> RespuestaOK<D> crear(List<String> mensajes, List<D> datos){
		return new RespuestaOK<D>(mensajes,datos);
	}
	
	public static <D> RespuestaOK<D> crear(String mensaje){
		var mensajeFormateado = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(mensaje);
		return new RespuestaOK<>(List.of(mensajeFormateado), List.of());
	}
	
	public static <D> RespuestaOK<D> crear(List<D> datos){//Con una lista de datos
		return new RespuestaOK<D>(List.of(),datos);
	}
	
	public static <D> RespuestaOK<D> crear(D dato){
		return new RespuestaOK<D>(List.of(),List.of(dato));
	}
	
	public static <D> RespuestaOK<D> crear(){//Me la envian vacias
		return new RespuestaOK<D>(List.of(),List.of());
	}
}
