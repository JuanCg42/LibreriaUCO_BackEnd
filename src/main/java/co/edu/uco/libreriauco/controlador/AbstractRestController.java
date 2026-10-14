package co.edu.uco.libreriauco.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(LibreriaUCOExcepcion excepcion){
		
		var mensajeRespuesta = " Se ha presentado un problema inesperado tratando de llevar a cabo la operación deeseada, Por favor intente de nuevo y si el problema persiste informele al administrador de la apliacion y entreguele el código que se muestra a continuación  ";
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		// logger.printException(excepcion);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}
	

}
