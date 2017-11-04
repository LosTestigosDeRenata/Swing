package swing;

public class Estadisticas implements Comparable<Estadisticas> {
	
	private String marca;
	private String modelo;
	private int año;
	private double precioMin;
	private double precioMax;
	private double precioProm;
	private double sumaTotal;
	private int cantidadAutos;
	
	public Estadisticas(String marca, String modelo, int año, double precioMin, double precioMax, double precioProm){
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.precioProm = precioProm;
		this.sumaTotal = 0;
		this.cantidadAutos= 0;
	}

	public Estadisticas(Auto autoPaquetito) {
		this.marca = autoPaquetito.getMarca();
		this.modelo = autoPaquetito.getModelo();
		this.año = autoPaquetito.getAño();
		this.precioMax = this.precioMin = autoPaquetito.getPrecio();
		this.sumaTotal += autoPaquetito.getPrecio();
		this.cantidadAutos ++;
		this.precioProm= sumaTotal / cantidadAutos;
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

	public double getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(double precioMin) {
		this.precioMin = precioMin;
	}

	public double getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(double precioMax) {
		this.precioMax = precioMax;
	}

	public double getPrecioProm() {
		return precioProm;
	}

	public void setPrecioProm(double precioProm) {
		this.precioProm = precioProm;
	}

	public void actualizar(double precio) {
		this.sumaTotal += precio;
		this.cantidadAutos ++;
		if(precio < precioMin)
			precioMin= precio;
		if(precio > precioMax)
			precioMax = precio;
		precioProm = sumaTotal / cantidadAutos;
		
	}

	@Override
	public int compareTo(Estadisticas o) {
		
		if (this.marca.compareTo(o.marca) == 0)
			return this.modelo.compareTo(o.modelo);
		
		return this.marca.compareTo(o.marca);
	}

	@Override
	public String toString() {
		return "Estadisticas [marca=" + marca + ", modelo=" + modelo + ", año=" + año + ", precioMin=" + precioMin
				+ ", precioMax=" + precioMax + ", precioProm=" + precioProm + "]";
	}

	
}