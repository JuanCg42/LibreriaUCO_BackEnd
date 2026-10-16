package co.edu.uco.libreriauco.controlador.impl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.libreriauco.controlador.AbstractRestController;


@RestController
@RequestMapping("/api/v1/paises")//Este servicio rest se va acceder a traves de esa URL
public class PaisControlador extends AbstractRestController {
	
	@GetMapping
	public String consultarTodos() {
		
		return "Ahora si mono método GET exitoso";
		
	}
	
	@PostMapping
	public String registrarInformacionNuevoPais() {
		
		return "Ahora si mono método GET exitoso";
		
	}
	
	
	@PutMapping
	public String ModificarInformacionPaisExistente() {
		
		return "Ahora si mono método GET exitoso";
		
	}
	
	@DeleteMapping
	public String DarBajaInformacionPaisExistente() {
		
		return "Ahora si mono método GET exitoso";
		
	}
	
	
}


