package analisis;

public class Token {

	private TipoToken tipo;
	private int valor=0;
	private String lexema = "";
	private int tamano;
	static AnalizadorSintactico AS;
	
	static public void setAnalizadorSintactico(AnalizadorSintactico as) {
		AS=as;
	}

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
			if (!AS.TablaPR.contains(this.lexema)) {
				// consultar flag de zona de declaracion de variables 
				//if (flag_declaracion)	añadir a TS
				EntradaTS e;
				if (!AS.Tabla_Simbolos.isEmpty()) {
					EntradaTS ant = AS.Tabla_Simbolos.getLast();
					e = new EntradaTS(this.lexema, ant.getIndex()+1);
				}else { e = new EntradaTS(this.lexema, 0);}
				AS.Tabla_Simbolos.add(e);
				//else (flag_declaracion=false)
				if (!AS.Tabla_Simbolos.contains(this.lexema)) {
					//error identificador no declarado
				}
			}
			acsem=true;
		}
		return acsem;
	}
}
