package co.edu.uco.libreriauco.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import co.edu.uco.libreriauco.controlador.respuesta.RespuestaError;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;

@RestControllerAdvice
public abstract class AbstractRestController {
	
	@ExceptionHandler(LibreriaUCOExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarLibreriaUcoException(LibreriaUCOExcepcion excepcion){
		
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		// logger.printException(excepcion);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}
	
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarNoResourceFoundException(NoResourceFoundException excepcion){
		
		var mensajeRespuesta = " Ojo mono porque el recurso que me pidio no existe "+ excepcion.getResourcePath();
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		// logger.printException(excepcion);
		excepcion.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(LibreriaUCOExcepcion excepcion){
		
		var mensajeRespuesta = " Se ha presentado un problema inesperado tratando de llevar a cabo la operación deeseada, Por favor intente de nuevo y si el problema persiste informele al administrador de la apliacion y entreguele el código que se muestra a continuación ";
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		// logger.printException(excepcion);
		excepcion.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}

}
