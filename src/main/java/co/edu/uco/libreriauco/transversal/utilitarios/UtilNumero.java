package co.edu.uco.libreriauco.transversal.utilitarios;

public class UtilNumero {
	
	public static int CERO=0;
	
	private UtilNumero() {
		
	}
	
	public static <N extends Number> Number obtenerValorDefecto(N valor){
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor , CERO);
	}
	
	public static <N extends Number> boolean mayorQue(N numeroUno, N numeroDos) {
		
		return  obtenerValorDefecto(numeroUno).doubleValue()> obtenerValorDefecto(numeroDos).doubleValue();
	}
}
