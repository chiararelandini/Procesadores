package analisis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AnalizadorLexico {
	
	private BufferedReader br = null;
	private String fichero;
	private boolean pideToken = false;
	private boolean leyendo = false;
	private Conjunto conjunto;
	
	public AnalizadorLexico(String fichero){
		this.fichero = fichero;
		try {
			br = new BufferedReader(new FileReader(fichero));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		conjunto = new Conjunto();
		
		try {
			System.out.println(leerLinea());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String leerLinea() throws IOException{
		return br.readLine();
	}
	
	//el analizador sintactico pide un token
	public void pedirToken(){
		pideToken = true;
	}
	
}