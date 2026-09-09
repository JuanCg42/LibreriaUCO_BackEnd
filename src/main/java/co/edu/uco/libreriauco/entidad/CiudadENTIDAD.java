package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class CiudadEntidad {
	
	private DepartamentoEntidad departamento;
	private UUID id;	
	private String nombre;
	
	
	
	public CiudadEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setDepartamento(new DepartamentoEntidad());
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



	public DepartamentoEntidad getDepartamento() {
		return departamento;
	}



	public void setDepartamento(DepartamentoEntidad departamento) {
		this.departamento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(departamento,new DepartamentoEntidad() );
	}
	
	
		

}
