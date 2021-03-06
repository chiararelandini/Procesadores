package analisis;

import java.util.HashSet;
import java.util.Set;

public class Conjunto {
	
	private Set<Character> digitos = new HashSet<Character>();
	private Set<Character> letras = new HashSet<Character>();
	private Set<Character> caracteres = new HashSet<Character>();
	private Set<Character> caracteres_todos = new HashSet<Character>();
	private Set<Character> delimitadores = new HashSet<Character>();
	private Set<Character> operadores = new HashSet<Character>();
	
	public Conjunto(){
		for(int i = 48; i < 58; i++)		//numeross
			digitos.add((char)i);
		
		for(int c = 65; c < 91; c++)		//caracteres validos para palabras reservadas
			letras.add((char)c);
		for(int c = 97; c < 123; c++)
			letras.add((char)c);
		
		caracteres.addAll(letras);			//caracteres validos para identificadores
		caracteres.addAll(digitos);
		caracteres.add('_');
		
		
		for(int i = 32; i < 126; i++)		//caracteres validos para comentarios (excluido /)
			caracteres_todos.add((char)i);
		caracteres_todos.remove((char)34);
		
		
		delimitadores.add((char)32);	//	space
		delimitadores.add((char)9);		//	tab
		

		operadores.add((char)43);	//	+
		operadores.add((char)45);	//	-
		operadores.add((char)47);	//	/
		operadores.add((char)125);	//	}
		operadores.add((char)123);	//	{
		operadores.add((char)33);	//	!
		operadores.add((char)40);	//	(
		operadores.add((char)41);	//	)
		operadores.add((char)60);	//	<
		operadores.add((char)44);	//	,
		operadores.add((char)59);	//	;
	}
	
	public Set<Character> getDigitos(){
		return digitos;
	}
	
	public Set<Character> getLetras(){
		return letras;
	}
	
	public Set<Character> getCaracteres(){
		return caracteres;
	}

	public Set<Character> getDelimitadores(){
		return delimitadores;
	}
	
	public Set<Character> getOperadores(){
		return operadores;
	}

}
