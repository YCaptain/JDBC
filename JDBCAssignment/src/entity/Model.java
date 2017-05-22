package entity;

public class Model {
	private String model;
	private String manufacturer;
	private int seats;
	
	public Model(){}
	
	public Model(String model, String manufacturer, int seats) {
		this.model = model;
		this.manufacturer = manufacturer;
		this.seats = seats;
	}
	
	public String getModel() {
		return model;
	}
	
	public void updateModel(String model) {
		this.model = model;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void updateManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public void updateSeats(int seats) {
		this.seats = seats;
	}
}
