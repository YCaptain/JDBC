package dao;

import bean.RentalCar;

public interface RentalCarDao {
	public void addRentalCar(RentalCar car);
	public RentalCar getRentalCar(int registrationNumber);
	public int update(RentalCar rentalCar);
	public int delete(RentalCar rentalCar);
}
