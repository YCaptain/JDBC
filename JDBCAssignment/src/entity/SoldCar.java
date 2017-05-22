package entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class SoldCar extends Car{
	private int SNumber;
	private int SSN;
	private Date orderDate;
	private Date requiredDate;
	private double soldPrice;
	
	public SoldCar(){}
	
	public SoldCar(int registrationNumber, String model, Status status, Date dateOfManuFacture, int SNumber, int SSN, Date orderDate, Date requiredDate, double soldPrice) {
		super(registrationNumber, model, status, dateOfManuFacture);
		this.SNumber = SNumber;
		this.SSN = SSN;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.soldPrice = soldPrice;
	}
	
	public int getSNumber() {
		return SNumber;
	}
	
	public void updateSNumber(int SNumber) {
		this.SNumber = SNumber;
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
		String toReturn = super.toString() + "; [SNumer=" + SNumber + ", SSN=" + SSN + ", orderDate="  + dayO + ", requiredDate=" + dayR + ", soldPrice=" + soldPrice + "]";
		return toReturn;
	}
}
