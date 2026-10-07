package co.edu.uco.libreriauco.transversal.utilitarios;

public class UtilTexto {
	private static UtilTexto INSTANCIA;
	public static final String VACIA = "";
	public static final String SOLO_LETRAS_ESPACIOS="^[a-zA-Z ñÑáÁéÉíÍóÓúÚ]*$";
	private UtilTexto() {
		
	}
	
	public static UtilTexto getUtilTexto(){
		
		
			synchronized (UtilTexto.class) {
				if(UtilObjeto.esNulo(INSTANCIA) ) {// Si el objeto que me envian, verifique si es nulo
					INSTANCIA = new UtilTexto();
				
			}
		}
		return INSTANCIA;
		
		
		
		
	
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
	
	
	public boolean formatoEsValido(String valor, String patron) {
		return obtenerValorDefecto(valor).matches(obtenerValorDefecto(patron));
		
	}
 


	
	
}
