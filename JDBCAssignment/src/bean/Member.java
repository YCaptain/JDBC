package bean;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Member extends Customer{
	private int memNumber;
	private Date dateOfBirth;
	private Date joinedDate;
	
	public Member(){}
	
	public Member(int SSN, String name, Sex sex, String address, String city, String country, int phone) {
		super(SSN, name, sex, address, city, country, phone);
	}
	
	public Member(Customer customer) {
		this(customer.getSSN(), customer.getName(), customer.getSex(), customer.getAddress(), customer.getCity(),
				customer.getCountry(), customer.getPhone());
	}
	
	public Member(int SSN, String name, Sex sex, String address, String city, String country, int phone, int memNumber, Date dateOfBirth, Date joinedDate) {
		this(SSN, name, sex, address, city, country, phone);
		this.memNumber = memNumber;
		this.dateOfBirth = dateOfBirth;
		this.joinedDate = joinedDate;
	}
	
	public Member(int memNumber, Date dateOfBirth, Date joinedDate, Customer customer) {
		this(customer.getSSN(), customer.getName(), customer.getSex(), customer.getAddress(), customer.getCity(),
				customer.getCountry(), customer.getPhone(), memNumber, dateOfBirth, joinedDate);
	}
	
	public int getMemNumber() {
		return memNumber;
	}
	
	public void updateMemNumber(int memNumber) {
		this.memNumber = memNumber;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void updateDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	
	public void updateJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String dayB = sdf.format(dateOfBirth);
		String dayJ = sdf.format(joinedDate);
		String toReturn = super.toString() + "; [memNumber=" + memNumber + ", dateOfBirth=" + dayB + ", joinedDate=" + dayJ + "]";
		return toReturn;
	}
}
