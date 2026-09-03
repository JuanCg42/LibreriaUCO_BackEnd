package co.edu.uco.libreriauco.transversal.utilitarios;

public class UtilTexto {
	private static UtilTexto INSTANCIA;
	public static String VACIA = "";
	private UtilTexto() {
		
	}
	
	public static UtilTexto getUtilTexto(){
		
		
			synchronized (UtilTexto.class) {
				if(UtilObjeto.esNulo(INSTANCIA) ) {// Si el objeto que me envian, verifique si es nulo
					INSTANCIA = new UtilTexto();
				
			}
		}
		return INSTANCIA;
		
		//"  " -> 2 sin quitar espacio en blanco
		//"  " -> 0 quitando espacios en blanco
		
		
	
	}
	public boolean esNulo(String cadena) {
		return UtilObjeto.esNulo(cadena);
	}
	
	public boolean esVacia(String cadena) {
		return VACIA.equals(obtenerValorDefecto(cadena));
		
	}
	
	public String obtenerValorDefecto(String valor, String valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}
	
	public String obtenerValorDefecto(String valor) {
		return obtenerValorDefecto(valor , VACIA);
	}
	
	public String quitarEspacioEnBlanco(String valor) {
		return obtenerValorDefecto(valor).trim();
		
	}
	
	public int obtenerLongitudCadena(String valor) {
		return obtenerValorDefecto(valor).length();
	}
	
	public int obtenerLongitudCadena(String valor, boolean quitarEspacioEnBlanco) {
		return quitarEspacioEnBlanco 
				? obtenerLongitudCadena(quitarEspacioEnBlanco(valor))
						:obtenerLongitudCadena(valor);
	}
	
	public boolean longitudCadenaEsValida(String valor,int longitudInicial, int longitudFinal,
		boolean quitarEspacioEnBlanco){
			var valorSanitizado = quitarEspacioEnBlanco ? quitarEspacioEnBlanco(valor): valor;
			
			return obtenerLongitudCadena(valorSanitizado) >= longitudInicial
					&& obtenerLongitudCadena(valorSanitizado) <=longitudFinal;
	}
 


	
	
}
