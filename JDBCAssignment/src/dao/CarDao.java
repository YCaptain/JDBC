package dao;

import entity.Car;

public interface CarDao {
	public void addCar(Car car);
	public Car getCar(int registrationNumber);
	public int update(Car car);
	public int delete(Car car);
}
