package co.edu.uco.libreriauco.pruebas;// En que paquete está la clase

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import static co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto.getUtilTexto;

public class PruebasTexto {//El modificador de acceso  desde cualquier lado se puede utilizar

	public static void main(String[] args) {//Void-> no retorna resultado 
		String miVariable = "";
		
		//Me garantiza que este va ser mi valor por defecto

		System.out.println(miVariable);
		System.out.println(getUtilTexto().obtenerLongitudCadena(miVariable, false));
		System.out.println(getUtilTexto().obtenerLongitudCadena(miVariable, true));
		
	
	}

}
