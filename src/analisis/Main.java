package analisis;

public class Main {

	public static void main(String[] args) {
		
		AnalizadorLexico lexico = new AnalizadorLexico(args[0]);
		
		AnalizadorSintactico sintactico = new AnalizadorSintactico(lexico);
		
		lexico.pruebaLecturaLinea();
		lexico.pruebaLecturaLinea();
		

	}

}
