package swing;

public class Auto {
	private String marca;
	private String modelo;
	private int a�o;
	private int mes;
	private double precio;
	
	public Auto() {
		
	}
	public Auto(String marca, String modelo, int a�o, int mes, double precio){
		this.marca = marca;
		this.modelo = modelo;
		this.a�o = a�o;
		this.mes = mes;
		this.precio = precio;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return marca + " " + modelo + " " + a�o + " " + mes + " " + precio;
	}
	
	
}