package co.edu.uco.libreriauco.negocio.negocio.reglas;

public interface Rule<O>{
	
	void ejecutar(O... datos);
	
	

}
