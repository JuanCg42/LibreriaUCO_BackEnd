package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoENTIDAD {
	
	private PaisENTIDAD pais;
	private UUID id;
	private String nombre;
	
	
	
	public DepartamentoENTIDAD() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setPaisDTO(new PaisENTIDAD());
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



	public PaisENTIDAD getPaisDTO() {
		return pais;
	}



	public void setPaisDTO(PaisENTIDAD paisDTO) {
		this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais,new PaisENTIDAD() );
	}
	
	
		

}
