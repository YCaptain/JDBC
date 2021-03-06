package bean;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Rents {
	private int rentNumber;
	private int memNumber;
	private int registrationNumber;
	private double distance;
	private Date orderDate;
	private Date requiredDate;
	
	public Rents(){}
	
	public Rents(int rentNumber, int memNumber, int registrationNumber, double distance, Date orderDate, Date requiredDate) {
		this.rentNumber = rentNumber;
		this.memNumber = memNumber;
		this.registrationNumber = registrationNumber;
		this.distance = distance;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
	}
	
	public Rents(int rentNumber, Member member, RentalCar rentalCar, double distance, Date orderDate, Date requiredDate) {
		this(rentNumber, member.getMemNumber(), rentalCar.getRegistrationNumber(), distance, orderDate,
				 requiredDate);
	}
	
	public int getRentNumber() {
		return rentNumber;
	}
	
	public void updateRentNumber(int rentNumber) {
		this.rentNumber = rentNumber;
	}
	
	public int getMemNumber() {
		return memNumber;
	}
	
	public void updateMemNumber(int memNumber) {
		this.memNumber = memNumber;
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
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String dayO = sdf.format(orderDate);
		String dayR = sdf.format(requiredDate);
		String toReturn = "[rentNumber=" + rentNumber + ", memNumber=" + memNumber + ", registrationNumber=" + registrationNumber
				+ ", distance=" + distance + ", orderDate=" + dayO + ", requiredDate=" + dayR + "]";
		return toReturn;
	}
}
