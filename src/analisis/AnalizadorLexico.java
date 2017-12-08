package analisis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalizadorLexico {
	
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private String fichero;
	private boolean pideToken = false;
	private boolean leyendo = false;
	private Conjunto conjunto;
	private int i;
	char ptr;
	String linea;
	
	public AnalizadorLexico(String fichero){
		this.fichero = fichero;
		try {
			br = new BufferedReader(new FileReader(fichero));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			bw = new BufferedWriter(new FileWriter("fichero_de_tokens"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.pideToken=false;
		this.linea=null;
		conjunto = new Conjunto();
	}

	private void leerLinea(){
		//si la linea es null (aun hay que empezar a leer el fichero) o ha terminado: leer otra línea y poner el puntero a 0
		if(linea == null || i >= linea.length()){
			i = 0;
			try {
				linea = br.readLine().trim();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//else si la linea no ha terminado no se hace nada porque se continua a leer allí
	}
	
	//el analizador sintactico pide un token
	public Token pedirToken(){
		pideToken = true;
		return encontrarToken();
	}
	
	private Token encontrarToken() {
		leerLinea();
		int n = linea.length();
		Token token= new Token();
		boolean comentario = false;
		for (; i < n && pideToken; i++) {
			ptr=linea.charAt(i);
			boolean leido = false;	//creamos esta variable para controlar que estamos pasando delimitadores 
									//de antes del token, ya que los de despu�s indican generacion de Tokens
			if (conjunto.getDelimitadores().contains(ptr)) {
				if (!leido) continue;
				else {
					//se ha llegado al final del "token" (aunque no es la �nica manera); aqu� deber�amos:
					//comprobar las acciones sem�nticas del tipo de token,
					
					//insertarlo en la tabla entes de salir del bucle	!!!!
					
					pideToken=false;
					continue;
				}
			}//si no ha entrado en este if es porque ni ha llegado al final de la linea ni ptr es delimitador
			else {
				if (conjunto.getCaracteres().contains(ptr)&& token.GetTipo().equals(TipoToken.IDENTIFICADOR)) {
					token.Concatenar(ptr);
				}else if (conjunto.getDigitos().contains(ptr)&& token.GetTipo().equals(TipoToken.CONSTANTE_ENTERA)) {
						token.SetValor(token.GetValor()*10+(int)ptr-48); 
						//le restamos el equivalente a 0 en la tabla ASCII
				}else if (ptr=='-'){
					token.SetTipo(TipoToken.OP_ASIG_DECREMENTO);
					leido=true;
				}else if (conjunto.getDigitos().contains(ptr)&&token.GetTipo().equals(null)){
					token.SetTipo(TipoToken.CONSTANTE_ENTERA);
					token.SetValor((int)ptr-48);
					leido=true;
				}else if (conjunto.getLetras().contains(ptr)&&token.GetTipo().equals(null)) {
					token.SetTipo(TipoToken.IDENTIFICADOR);
					token.SetLexema(ptr);
					leido = true;
				}else if (token.GetTipo().equals(TipoToken.CADENA)&& ptr != '"') {
					token.Concatenar(ptr);
				}else if (conjunto.getOperadores().contains(ptr)) {
					switch(ptr){
					case '+': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							
							i--;//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.OP_REL_MENOR);
						}
					case '>': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							i--;//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.OP_REL_MENOR);
						}
					case '(': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							i--;//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.PARENTESIS_ABIERTOS);
						}
					case ')': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							i--;//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.PARENTESIS_CERRADOS);
						}
					case '!': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							i--;//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.OP_LOG_NEGACION);
						}
					case ',': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							i--;//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.SEPARADOR_COMA);
						}
					case ';': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							i--;	//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.SEPARADOR_PUNTOCOMA);
						}
					case '{': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							i--;	//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.LLAVE_ABIERTA);
						}
					case '}': 
						if (!token.GetTipo().equals(null)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
							i--;	//para que en la siguiente iteraci�n vuelva a estar en este simbolo y lo procese
						}else {
							token.SetTipo(TipoToken.LLAVE_CERRADA);
						}
					case '"': 
						if (token.GetTipo().equals(TipoToken.CADENA)) {
							//almacenar los datos en la tabla en caso de identificador.
							//devolver el token que acaba de acabar
						}else {
							if (token.GetTipo().equals(null)) {
								token.SetTipo(TipoToken.CADENA);
								leido=true;
							}else {
								// Funci�n de error
							}
						}
					case '/':
						if(comentario){		//cuando el anterior es '/' entonces es un comentario
							if(linea.charAt(i-1) == '/')
								i = linea.length();		// ir directamente al fin de linea
							//else
								//error: no puede existir '/' isolado
						}
						if(!comentario)		//primer '/' encontrado => necesitamos 2 para reconocer comentario
							comentario = true;
					}
				}else {
					//invocar a una funci�n de error
				}
			leido=true;
			}
			
				
		}
		if (token.GetTipo().equals(TipoToken.IDENTIFICADOR)) {
			//comprobar si es palabra reservada 
			if (!token.AccionSemantica()) {
				//error
			}
		}
		
		return token;

	}
	
	private void imprimirToken(Token token){
		switch(token.GetTipo()){
		case IDENTIFICADOR:
			try {
				bw.append("< " + token.GetTipo().toString() + ", " + token.getEntradaTS().getIndex() + " >");
			} catch (IOException e) {
				e.printStackTrace();
			}
		case CONSTANTE_ENTERA:
			try {
				bw.append("< " + token.GetTipo().toString() + ", " + token.GetValor()+ " >");
			} catch (IOException e) {
				e.printStackTrace();
			}
		case CADENA:
			try {
				bw.append("< " + token.GetTipo().toString() + ", " + token.GetLexema()+ " >");
			} catch (IOException e) {
				e.printStackTrace();
			}
		case PALABRA_RESERVADA:
			try {
				bw.append("< " + token.GetTipo().toString() + ", " + token.GetLexema()+ " >");
			} catch (IOException e) {
				e.printStackTrace();
			}
		default:
			try {
				bw.append("< " + token.GetTipo().toString() + ",  >");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}