package entity;

import java.util.Date;

public class RentalCar extends Car{

	public RentalCar(){}
	
	public RentalCar(int registrationNumber, int modelNum, Status status, Date dateOfManuFacture) {
		super(registrationNumber, modelNum, status, dateOfManuFacture);
	}
	
	public RentalCar(Car car) {
		this(car.getRegistrationNumber(), car.getModelNum(), car.getStatus(), car.getDateOfManufacture());
	}
	
}
