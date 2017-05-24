package service;

import bean.Rents;
import dao.DaoFactory;
import dao.RentsDao;

public class RentsService {
	private RentsDao rentsDao;
	
	public RentsService() {
		rentsDao = DaoFactory.getInstace().createRentsDao();
		System.out.println("rentsDao: " + rentsDao);
	}
	
	public void regist(Rents rents) {
		if(rents == null) {
			System.out.println("Invalid registration!!");
		} else {
			rentsDao.addRent(rents);
		}
	}
	
	public Rents query(int MNumber) {
		Rents rents = rentsDao.getRent(MNumber);
		if(rents == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(rents.toString());
		}
		return rents;
	}
	
	public void update(Rents rents) {
		if(rents.getRentNumber() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			rentsDao.update(rents);
		}
	}
	
	public void delete(Rents rents) {
		if(rents.getRentNumber() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			rentsDao.delete(rents);
		}
	}
}
