package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Car {
	public enum Status{
		RENTAL, SOLD
	}
	private int registrationNumber;
	private String model;
	private Status status;
	private Date dateOfManuFacture;
	
	public Car(){}
	
	public Car(int registrationNumber, String model, Status status, Date dateOfManuFacture) {
		this.registrationNumber = registrationNumber;
		this.model = model;
		this.status = status;
		this.dateOfManuFacture = dateOfManuFacture;
	}
	
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void updateRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getModel() {
		return model;
	}
	
	public void updateModel(String model) {
		this.model = model;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void updateStatus(Status status) {
		this.status = status;
	}
	
	public Date getDateOfManufacture() {
		return dateOfManuFacture;
	}
	
	public void updateDateOfManuFacture(Date dateOfManuFacture) {
		this.dateOfManuFacture = dateOfManuFacture;
	}
	
	@Override
	public String toString() {
		String toReturn = "[registrationNumber=" + registrationNumber + ", model=" + model + ", status=" + status.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String day = sdf.format(dateOfManuFacture);
		toReturn += ", dateOfManuFacture=" + day + "]";
		return toReturn;
	}
}
