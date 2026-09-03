package co.edu.uco.libreriauco.dto;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoDTO {
	
	private PaisDTO pais;
	private UUID id;
	private String nombre;
	
	
	
	public DepartamentoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setPaisDTO(new PaisDTO());
	}
	
	
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id=  UtilUUID.obtenerValorDefecto(id);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
	}



	public PaisDTO getPaisDTO() {
		return pais;
	}



	public void setPaisDTO(PaisDTO paisDTO) {
		this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais,new PaisDTO() );
	}
	
	
		

}
