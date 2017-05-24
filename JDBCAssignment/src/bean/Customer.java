package bean;

public class Customer {
	public enum Sex{
		MALE, FEMALE, OTHER;
	}
	private int SSN;
	private String name;
	private Sex sex;
	private String address;
	private String city;
	private String country;
	private int phone;
	
	public Customer(){}
	
	public Customer(int SSN, String name, Sex sex, String address, String city, String country, int phone) {
		this.SSN = SSN;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
	}
	
	public int getSSN() {
		return SSN;
	}
	
	public void updateSSN(int SSN) {
		this.SSN = SSN;
	}
	
	public String getName() {
		return name;
	}
	
	public void updateName(String name) {
		this.name = name;
	}
	
	public Sex getSex() {
		return sex;
	}
	
	public void updateSex(Sex sex) {
		this.sex = sex;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void updateAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void updateCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void updateCountry(String country) {
		this.country = country;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void updatePhone(int phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		String toReturn = "[SSN=" + SSN + ", name=" + name + ", sex=" + sex.toString() + ", address=" + address
				+ ", city=" + city + ", country=" + country + ", phone=" + phone + "]";
		return toReturn;
	}
}
