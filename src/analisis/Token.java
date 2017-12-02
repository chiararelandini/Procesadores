package analisis;

public class Token {

	public TipoToken tipo;
	public int valor=0;

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
	/*
	 * Esta funcion comprueba y devuelve si se cumple la accion semantica del token y, 
	 * en caso afirmativo, genera el token. El token ya esta generado, pero habría que 
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
			 * si no está buscar en TS token.pal
			 * 		si no está añadir y generar token
			 * 		si está generar token
			 * si está generar token 
			 */
			acsem=true;
		case PALABRA_RESERVADA:
			/*
			 * buscar en TS token.pal
			 * si no está añadir a TS y generar token
			 * si está generar token
			 */
			acsem = true;
		}
		return acsem;
	}
}
