package analisis;

import java.util.LinkedList;

public class AnalizadorSintactico {
	
	AnalizadorLexico lexico = null;
	
	LinkedList <EntradaTS> Tabla_Simbolos= new LinkedList<EntradaTS>();
	LinkedList <String> TablaPR= new LinkedList<String>();
	
	
	public AnalizadorSintactico(AnalizadorLexico al){
		lexico = al;
		TablaPR.add("while");
		TablaPR.add("write");
		TablaPR.add("prompt");
		TablaPR.add("int");
		TablaPR.add("bool");
		
		TablaPR.add("true");
		TablaPR.add("false");
		
		Token.setAnalizadorSintactico(this);
	}
	
	//cuando termina leer tokens cerrar fichero fuente y tokens

}
