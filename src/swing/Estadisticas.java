package swing;

public class Estadisticas implements Comparable<Estadisticas> {
	
	private String marca;
	private String modelo;
	private int a�o;
	private double precioMin;
	private double precioMax;
	private double precioProm;
	private double sumaTotal;
	private int cantidadAutos;
	
	public Estadisticas(String marca, String modelo, int a�o, double precioMin, double precioMax, double precioProm){
		this.marca = marca;
		this.modelo = modelo;
		this.a�o = a�o;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.precioProm = precioProm;
		this.sumaTotal = 0;
		this.cantidadAutos= 0;
	}

	public Estadisticas(Auto autoPaquetito) {
		this.marca = autoPaquetito.getMarca();
		this.modelo = autoPaquetito.getModelo();
		this.a�o = autoPaquetito.getA�o();
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

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
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
		return "Estadisticas [marca=" + marca + ", modelo=" + modelo + ", a�o=" + a�o + ", precioMin=" + precioMin
				+ ", precioMax=" + precioMax + ", precioProm=" + precioProm + "]";
	}

	
}