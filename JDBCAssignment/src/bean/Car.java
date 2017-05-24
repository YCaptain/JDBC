package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Car {
	private int registrationNumber;
	private int modelNum;
	private Date dateOfManuFacture;
	
	public Car(){}
	
	public Car(int registrationNumber, int modelNum, Date dateOfManuFacture) {
		this.registrationNumber = registrationNumber;
		this.modelNum = modelNum;
		this.dateOfManuFacture = dateOfManuFacture;
	}
	
	public Car(int registrationNumber, Model model,  Date dateOfManuFacture) {
		this(registrationNumber, model.getModelNum(), dateOfManuFacture);
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
	
	public Date getDateOfManufacture() {
		return dateOfManuFacture;
	}
	
	public void updateDateOfManuFacture(Date dateOfManuFacture) {
		this.dateOfManuFacture = dateOfManuFacture;
	}
	
	@Override
	public String toString() {
		String toReturn = "[registrationNumber=" + registrationNumber + ", modelNum=" + modelNum;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String day = sdf.format(dateOfManuFacture);
		toReturn += ", dateOfManuFacture=" + day + "]";
		return toReturn;
	}
}
