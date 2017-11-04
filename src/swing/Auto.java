package swing;

public class Auto {
	private String marca;
	private String modelo;
	private int año;
	private int mes;
	private double precio;
	
	public Auto() {
		
	}
	public Auto(String marca, String modelo, int año, int mes, double precio){
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
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

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
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
		return marca + " " + modelo + " " + año + " " + mes + " " + precio;
	}
	
	
}