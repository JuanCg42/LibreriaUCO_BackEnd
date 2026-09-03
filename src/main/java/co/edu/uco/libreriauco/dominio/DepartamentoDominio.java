package co.edu.uco.libreriauco.dominio;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoDominio {
	
	private UUID id;
	private String nombre;
	private DepartamentoDominio pais;
	
	
	
	private DepartamentoDominio(Builder builder) {
		
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.pais =builder.pais;
	}
	
	

	public UUID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public DepartamentoDominio getPais() {
		return pais;
	}





	public static class Builder{
		
		
		private UUID id;
		private String nombre;
		private DepartamentoDominio pais;
		
		
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIA;
			pais = new DepartamentoDominio.Builder().build();
		}
		
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}
		
		public Builder pais(DepartamentoDominio pais) {
			this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais, new DepartamentoDominio.Builder().build());
			return this;
		}
		
		public DepartamentoDominio build() {
			return new DepartamentoDominio(this);
		}
	}
	

}
