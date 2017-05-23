package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Car {
	public enum Status{
		RENTAL, SOLD
	}
	private int registrationNumber;
	private int modelNum;
	private Status status;
	private Date dateOfManuFacture;
	
	public Car(){}
	
	public Car(int registrationNumber, int modelNum, Status status, Date dateOfManuFacture) {
		this.registrationNumber = registrationNumber;
		this.modelNum = modelNum;
		this.status = status;
		this.dateOfManuFacture = dateOfManuFacture;
	}
	
	public Car(int registrationNumber, Model model, Status status, Date dateOfManuFacture) {
		this(registrationNumber, model.getModelNum(), status, dateOfManuFacture);
	}
	
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void updateRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public int getModelNum() {
		return modelNum;
	}
	
	public void updateModelNum(int modelNum) {
		this.modelNum = modelNum;
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
		String toReturn = "[registrationNumber=" + registrationNumber + ", modelNum=" + modelNum + ", status=" + status.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String day = sdf.format(dateOfManuFacture);
		toReturn += ", dateOfManuFacture=" + day + "]";
		return toReturn;
	}
}
