package co.edu.uco.libreriauco.transversal.utilitarios;

public class UtilObjeto {
	
	private UtilObjeto() {
		
	}
	
	public static <O> boolean esNulo(O objeto) {
		
		return objeto==null;// Me está preguntando si ese objeto que me enviaron es igual a null
	}
	
	public static <O> O obtenerValorDefectoSiValorOriginalEsNulo(O valor, O valorDefecto) {
		return esNulo(valor) ? valorDefecto:valor; //si el valor es nulo retorne el valor, no entonces retorneme el valor por defecto
	}
	


}
