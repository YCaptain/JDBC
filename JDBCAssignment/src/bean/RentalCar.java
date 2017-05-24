package bean;

import java.util.Date;

public class RentalCar extends Car{
	private double rentPrice;

	public RentalCar(){}
	
	public RentalCar(int registrationNumber, int modelNum, Date dateOfManuFacture) {
		super(registrationNumber, modelNum, dateOfManuFacture);
	}
	
	public RentalCar(int registrationNumber, int modelNum, Date dateOfManuFacture, double rentPrice) {
		this(registrationNumber, modelNum, dateOfManuFacture);
		this.rentPrice = rentPrice;
	}
	
	public RentalCar(Car car) {
		this(car.getRegistrationNumber(), car.getModelNum(), car.getDateOfManufacture());
	}
	
	public RentalCar(Car car, double rentPrice) {
		this(car);
		this.rentPrice = rentPrice;
	}
	
	public double getRentPrice() {
		return rentPrice;
	}
	
	public void updateRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
}
