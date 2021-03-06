package service;

import bean.RentalCar;
import dao.DaoFactory;
import dao.RentalCarDao;

public class RentalCarService {
	private RentalCarDao rentalCarDao;
	
	public RentalCarService() {
		rentalCarDao = DaoFactory.getInstace().createRentalCarDao();
		System.out.println("rentalCarDao: " + rentalCarDao);
	}
	
	public void regist(RentalCar rentalCar) {
		if(rentalCar == null) {
			System.out.println("Invalid registration!!");
		} else {
			rentalCarDao.addRentalCar(rentalCar);
		}
	}
	
	public RentalCar query(int registrationNum) {
		RentalCar rentalCar = rentalCarDao.getRentalCar(registrationNum);
		if(rentalCar == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(rentalCar.toString());
		}
		return rentalCar;
	}
	
	public void update(RentalCar rentalCar) {
		if(rentalCar.getRegistrationNumber() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			rentalCarDao.update(rentalCar);
		}
	}
	
	public void delete(RentalCar rentalCar) {
		if(rentalCar.getRegistrationNumber() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			rentalCarDao.delete(rentalCar);
		}
	}
}
