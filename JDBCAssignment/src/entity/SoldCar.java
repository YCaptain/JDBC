package entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class SoldCar extends Car{
	private int soldNumber;
	private int SSN;
	private Date orderDate;
	private Date requiredDate;
	private double soldPrice;
	
	public SoldCar(){}
	
	public SoldCar(Car car) {
		this(car.getRegistrationNumber(), car.getModelNum(), car.getStatus(), car.getDateOfManufacture());
	}
	
	public SoldCar(int registrationNumber, int modelNum, Status status, Date dateOfManuFacture) {
		super(registrationNumber, modelNum, status, dateOfManuFacture);
	}
	
	public SoldCar(int registrationNumber, int modelNum, Status status, Date dateOfManuFacture, int soldNumber, int SSN, Date orderDate, Date requiredDate, double soldPrice) {
		this(registrationNumber, modelNum, status, dateOfManuFacture);
		this.soldNumber = soldNumber;
		this.SSN = SSN;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.soldPrice = soldPrice;
	}
	
	public SoldCar(int soldNumber, int SSN, Date orderDate, Date requiredDate, double soldPrice, Car car) {
		this(car.getRegistrationNumber(), car.getModelNum(), car.getStatus(), car.getDateOfManufacture(), 
				soldNumber, SSN, orderDate, requiredDate, soldPrice);
	}
	
	
	public int getSoldNumber() {
		return soldNumber;
	}
	
	public void updateSoldNumber(int soldNumber) {
		this.soldNumber = soldNumber;
	}
	
	public int getSSN() {
		return SSN;
	}
	
	public void updateSSN(int SSN) {
		this.SSN = SSN;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void updateOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Date getRequiredDate() {
		return requiredDate;
	}
	
	public void updateRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}
	
	public double getSoldPrice() {
		return soldPrice;
	}
	
	public void updateSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String dayO = sdf.format(orderDate);
		String dayR = sdf.format(requiredDate);
		String toReturn = super.toString() + "; [SNumer=" + soldNumber + ", SSN=" + SSN + ", orderDate="  + dayO + ", requiredDate=" + dayR + ", soldPrice=" + soldPrice + "]";
		return toReturn;
	}
}
