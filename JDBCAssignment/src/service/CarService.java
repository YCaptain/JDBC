package service;

import dao.CarDao;
import dao.DaoFactory;
import entity.Car;

public class CarService {
	private CarDao carDao;
	
	public CarService() {
		carDao = DaoFactory.getInstace().createCarDao();
		System.out.println("carDao: " + carDao);
	}
	
	public void regist(Car car) {
		if(car == null) {
			System.out.println("Invalid registration!!");
		} else {
			carDao.addCar(car);
		}
	}
	
	public Car query(int registrationNumber) {
		Car car = carDao.getCar(registrationNumber);
		if(car == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(car.toString());
		}
		return car;
	}
	
	public void update(Car car) {
		if(car.getRegistrationNumber() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			carDao.update(car);
		}
	}
	
	public void delete(Car car) {
		if(car.getRegistrationNumber() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			carDao.delete(car);
		}
	}
	
}
