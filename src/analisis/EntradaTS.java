package analisis;

public class EntradaTS {
	
	private int index;
	private String nombre;
	private int tamano;
	private TipoIdentificador tipo;
	private int desplazamiento;
	
	public EntradaTS (String nombre, int index) {
		this.nombre=nombre;
		this.index=index;
	}

	public int getIndex() {
		return index;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public TipoIdentificador getTipo() {
		return tipo;
	}

	public void setTipo(TipoIdentificador tipo) {
		this.tipo = tipo;
	}

	public int getDesplazamiento() {
		return desplazamiento;
	}

	public void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}
	
}
