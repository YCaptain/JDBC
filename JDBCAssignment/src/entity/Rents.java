package entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Rents {
	private int RNumber;
	private int MNumber;
	private int registrationNumber;
	private double distance;
	private Date orderDate;
	private Date requiredDate;
	private double rentPrice;
	
	public Rents(){}
	
	public Rents(int RNumber, int MNumber, int registrationNumber, double distance, Date orderDate, Date requiredDate, double rentPrice) {
		this.RNumber = RNumber;
		this.MNumber = MNumber;
		this.registrationNumber = registrationNumber;
		this.distance = distance;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.rentPrice = rentPrice;
	}
	
	public int getRNumber() {
		return RNumber;
	}
	
	public void updateRNumber(int RNumber) {
		this.RNumber = RNumber;
	}
	
	public int getMNumber() {
		return MNumber;
	}
	
	public void updateMNumber(int MNumber) {
		this.MNumber = MNumber;
	}
	
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void updateRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void updateDistance(double distance) {
		this.distance = distance;
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
	
	public double getRentPrice() {
		return rentPrice;
	}
	
	public void updateRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String dayO = sdf.format(orderDate);
		String dayR = sdf.format(requiredDate);
		String toReturn = "[RNumber=" + RNumber + ", MNumber=" + MNumber + ", registrationNumber=" + registrationNumber
				+ ", distance=" + distance + ", orderDate=" + dayO + ", requiredDate=" + dayR + ", rentPrice=" + rentPrice + "]";
		return toReturn;
	}
}
