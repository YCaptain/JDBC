package entity;

public class Model {
	private int modelNum;
	private String modelName;
	private String manufacturer;
	private int seats;
	
	public Model(){}
	
	public Model(int modelNum, String modelName, String manufacturer, int seats) {
		this.modelNum = modelNum;
		this.modelName = modelName;
		this.manufacturer = manufacturer;
		this.seats = seats;
	}
	
	public int getModelNum() {
		return modelNum;
	}
	
	public void updateModelNum(int modelNum) {
		this.modelNum = modelNum;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public void updateModelName(String modelName) {
		this.modelName = modelName;
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
