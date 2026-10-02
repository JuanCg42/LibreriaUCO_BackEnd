package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisEntidad {
	
	private UUID id;
	private String nombre;
	
	
	
	
	public PaisEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
	}
	
	public PaisEntidad(UUID id, String nombre) {
		setId(id);
		setNombre(nombre);
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
