package entity;

import java.util.Date;

public class RentalCar extends Car{

	public RentalCar(){}
	
	public RentalCar(int registrationNumber, int modelNum, Date dateOfManuFacture) {
		super(registrationNumber, modelNum, dateOfManuFacture);
	}
	
	public RentalCar(Car car) {
		this(car.getRegistrationNumber(), car.getModelNum(), car.getDateOfManufacture());
	}
	
}
