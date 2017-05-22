package entity;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Member extends Customer{
	private int MNumber;
	private Date dateOfBirth;
	private Date joinedDate;
	
	public Member(){}
	
	public Member(int SSN, String name, Sex sex, String address, String city, String country, int phone, int MNumber, Date dateOfBirth, Date joinedDate) {
		super(SSN, name, sex, address, city, country, phone);
		this.MNumber = MNumber;
		this.dateOfBirth = dateOfBirth;
		this.joinedDate = joinedDate;
	}
	
	public int getMNumber() {
		return MNumber;
	}
	
	public void updateMNumber(int MNumber) {
		this.MNumber = MNumber;
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
		String toReturn = super.toString() + "; [MNumber=" + MNumber + ", dateOfBirth=" + dayB + ", joinedDate=" + dayJ + "]";
		return toReturn;
	}
}
