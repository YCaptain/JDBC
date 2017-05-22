package utils;

import java.util.Date;

import entity.Car;
import entity.Car.Status;
import service.CarService;

public class TestDemo {
	public static void main(String[] args) throws Exception{
		CarService carService = new CarService();
		System.out.println("Add Car: ");
		carService.regist(new Car(1, "COMMON", Status.RENTAL, new Date(System.currentTimeMillis())));
	}
}
