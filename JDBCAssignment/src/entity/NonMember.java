package entity;

public class NonMember extends Customer{

	public NonMember(){}
	
	public NonMember(int SSN, String name, Sex sex, String address, String city, String country, int phone) {
		super(SSN, name, sex, address, city, country, phone);
	}
	
}
