package service;

import bean.SoldCar;
import dao.DaoFactory;
import dao.SoldCarDao;

public class SoldCarService {
	private SoldCarDao soldCarDao;
	
	public SoldCarService() {
		soldCarDao = DaoFactory.getInstace().createSoldCarDao();
		System.out.println("soldCarDao: " + soldCarDao);
	}
	
	public void regist(SoldCar soldCar) {
		if(soldCar == null) {
			System.out.println("Invalid registration!!");
		} else {
			soldCarDao.addSoldCar(soldCar);
		}
	}
	
	public SoldCar query(int MNumber) {
		SoldCar soldCar = soldCarDao.getSoldCar(MNumber);
		if(soldCar == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(soldCar.toString());
		}
		return soldCar;
	}
	
	public void update(SoldCar soldCar) {
		if(soldCar.getSoldNumber() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			soldCarDao.update(soldCar);
		}
	}
	
	public void delete(SoldCar soldCar) {
		if(soldCar.getSoldNumber() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			soldCarDao.delete(soldCar);
		}
	}
}
