package Logic;

public class Taxi {
	private String brand;
	private int model;
	private String plate;
	private int valor;
	private boolean luggage;
	private boolean state;
	
	
	public Taxi(String brand, int model, String plate, int valor, boolean luggage,boolean state) {
		this.brand = brand;
		this.model = model;
		this.plate = plate;
		this.valor = valor;
		this.luggage = luggage;
		this.state = state;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}

	public boolean isLuggage() {
		return luggage;
	}
	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	

}
