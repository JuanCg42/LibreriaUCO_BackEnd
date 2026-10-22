package co.edu.uco.libreriauco.dto;

import java.util.UUID;

import org.springframework.web.bind.annotation.BindParam;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisDTO {
	
	
	@BindParam("id")
	private UUID id;
	
	@BindParam("nombre")
	private String nombre;
	
	
	
	
	public PaisDTO() {
		setId(null);
		setNombre(UtilTexto.VACIA);
	}


	public UUID getId() {
		return id;
	}
	
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);//verificar si tiene espacio en blanco
	}
	
	
	

}
