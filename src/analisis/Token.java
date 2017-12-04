package analisis;

public class Token {

	private TipoToken tipo;
	private int valor=0;
	private String lexema = "";
	

	public void SetTipo (TipoToken tipo) {
		this.tipo=tipo;
	}
	public TipoToken GetTipo() {
		return this.tipo;
	}
	public int GetValor() {
		return this.valor;
	}
	public void SetValor (int valor) {
		this.valor=valor;
	}
	public void SetLexema (char a) {
		this.lexema=this.lexema + a;
	}
	public void Concatenar(char caracter) {
		this.lexema=this.lexema+caracter;
	}

	/*
	 * Esta funcion comprueba y devuelve si se cumple la accion semantica del token y, 
	 * en caso afirmativo, genera el token. El token ya esta generado, pero habr�a que 
	 * guardarlo en la TS si procede o no, y, en caso contrario, generar un mensaje de error
	 */
	public boolean AccionSemantica() {
		TipoToken tipo = this.GetTipo();
		boolean acsem = true;
		switch(tipo) {
		case CONSTANTE_ENTERA:
			if (this.valor<32767) {
				acsem=true;
			}else {
				acsem=false;
			}
		case IDENTIFICADOR:
			/*
			 * buscar en TPRes token.pal
			 * si no est� buscar en TS token.pal
			 * 		si no est� a�adir y generar token
			 * 		si est� generar token
			 * si est� generar token 
			 */
			acsem=true;
		}
		return acsem;
	}
}
