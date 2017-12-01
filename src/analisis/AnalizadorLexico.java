package analisis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AnalizadorLexico {
	
	private BufferedReader br = null;
	private String fichero;
	private boolean pideToken;
	private Conjunto conjunto;
	private int puntero;
	private String linea;
	
	public AnalizadorLexico(String fichero){
		this.fichero = fichero;
		try {
			br = new BufferedReader(new FileReader(fichero));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		this.conjunto = new Conjunto();
		
		this.pideToken = false;
		
		this.linea = null;
		this.puntero = 0;
	}
	
	public void pruebaLecturaLinea(){
		this.leerLinea();
		System.out.println(linea);
	}
	
	private String encontrarToken(){
		String token = null;	//esta variable contendrá el token que hay que pasar al sintactico
		String palabra = "";	//aquí se concatenan los caracteres leidos que van a formar el token
		
		this.leerLinea();
		
		/*
		 * cada ciclo analiza un caracter y lo concatena en el token correcto
		 * hasta que no se forme un token correcto y el sintactico lo necesite
		 * 
		 */
		while(puntero<linea.length() && pideToken){
			
			//buscar token con if anidados
			//cuando se encuentra un estado final poner pideToken = false
			//	y almacenar el token encontrado en la variable token (token = palabra)
			
			puntero++;
		}
		
		
		return token;
	}

	private void leerLinea(){
		//si la linea es null (aun hay que empezar a leer el fichero) o ha terminado: leer otra línea y poner el puntero a 0
		if(linea == null || puntero == linea.length()){
			puntero = 0;
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
	public String pedirToken(){
		pideToken = true;
		return encontrarToken();
	}
	
}