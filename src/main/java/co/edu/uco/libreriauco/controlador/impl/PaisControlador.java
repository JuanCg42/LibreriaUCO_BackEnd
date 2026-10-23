package co.edu.uco.libreriauco.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.libreriauco.controlador.AbstractRestController;
import co.edu.uco.libreriauco.controlador.respuesta.RespuestaOK;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.PaisFachada;
import co.edu.uco.libreriauco.negocio.fachada.impl.PaisFachadaImpl;

@RestController
@RequestMapping("/api/v1/paises") // Este servicio rest se va acceder a traves de esa URL
public class PaisControlador extends AbstractRestController {

	public PaisFachada fachada = new PaisFachadaImpl();

	@GetMapping("/login")
	public String hacerLogin(@AuthenticationPrincipal OidcUser datosUsuario) {
		return "Hola Usuario %s. Te has autenticado con el correo %s.Su token es %s".formatted(datosUsuario.getFullName(),
				datosUsuario.getEmail(), datosUsuario.getIdToken());
	}

	@GetMapping("/dummy")
	public PaisDTO obtenerDummy() {

		return new PaisDTO();

	}

	@PostMapping
	public ResponseEntity<RespuestaOK<String>> registrarInformacionNuevoPais(@RequestBody PaisDTO pais) {
		fachada.registrarInformacionNuevoPais(pais);
		RespuestaOK<String> respuesta = RespuestaOK
				.crear("Se ha registrado la información del nuevo pais de forma exitosa");
		return ResponseEntity.ok(respuesta);

	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOK<PaisDTO>> consultarPorId(@PathVariable UUID id) {
		var pais = fachada.consultarPorId(id);
		RespuestaOK<PaisDTO> respuesta = RespuestaOK.crear(pais);
		return ResponseEntity.ok(respuesta);

	}

	// ....../api/v1/paises?id=valor&nombre=Colombia
	// ....../api/v1/paises?id=valor
	// ....../api/v1/paises?nombre=Colombia
	// ....../api/v1/paises?nombre=Colombia&id=valor
	// ....../api/v1/paises
	// ....../api/v1/paises?id=valor Bad Practice
	// ....../api/v1/paises?pais-residencia=valor Best Practice
	@GetMapping
	public ResponseEntity<RespuestaOK<PaisDTO>> consultarPorFiltro(PaisDTO filtro) {
		var paises = fachada.consultarPorFiltro(filtro);
		RespuestaOK<PaisDTO> respuesta = RespuestaOK.crear(paises);
		return ResponseEntity.ok(respuesta);

	}

	@PutMapping("/{id}")
	public ResponseEntity<RespuestaOK<String>> ModificarInformacionPaisExistente(@PathVariable UUID id,
			@RequestBody PaisDTO datos) {

		fachada.ModificarInformacionPaisExistente(id, datos);
		RespuestaOK<String> respuesta = RespuestaOK
				.crear("Se ha modificado la información del pais deseado de forma exitosa");

		return ResponseEntity.ok(respuesta);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<RespuestaOK<String>> DarBajaInformacionPaisExistente(@PathVariable UUID id) {

		fachada.DarBajaInformacionPaisExistente(id);
		RespuestaOK<String> respuesta = RespuestaOK
				.crear("Se ha eliminado la información del pais deseado de forma exitosa");

		return ResponseEntity.ok(respuesta);

	}

}
