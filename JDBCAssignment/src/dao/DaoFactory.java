package dao;

import java.io.FileInputStream;
import java.util.Properties;

public class DaoFactory {
	private static ModelDao modelDao = null;
	private static CarDao carDao = null;
	private static CustomerDao customerDao = null;
	private static MemberDao memberDao = null;
	private static NonMemberDao nonMemberDao = null;
	private static RentalCarDao rentalCarDao = null;
	private static SoldCarDao soldCarDao = null;
	private static RentsDao rentsDao = null;
	private static DaoFactory instance = new DaoFactory();
	
	private DaoFactory() {
		Properties prop = new Properties();
		try{
			FileInputStream fis = new FileInputStream("src/utils/daoconfig.properties");
			prop.load(fis);
			
			String className = prop.getProperty("modelDaoClass");
			Class<?> clazz = Class.forName(className);
			modelDao = (ModelDao) clazz.newInstance();
			
			className = prop.getProperty("carDaoClass");
			clazz = Class.forName(className);
			carDao = (CarDao) clazz.newInstance();
			
			className = prop.getProperty("customerDaoClass");
			clazz = Class.forName(className);
			customerDao = (CustomerDao) clazz.newInstance();
			
			className = prop.getProperty("memberDaoClass");
			clazz = Class.forName(className);
			memberDao = (MemberDao) clazz.newInstance();
			
			className = prop.getProperty("nonMemberDaoClass");
			clazz = Class.forName(className);
			nonMemberDao = (NonMemberDao) clazz.newInstance();
			
			className = prop.getProperty("rentalCarDaoClass");
			clazz = Class.forName(className);
			rentalCarDao = (RentalCarDao) clazz.newInstance();
		/*	
			className = prop.getProperty("soldCarDaoClass");
			clazz = Class.forName(className);
			soldCarDao = (SoldCarDao) clazz.newInstance();
			
			className = prop.getProperty("rentsDaoClass");
			clazz = Class.forName(className);
			rentsDao = (RentsDao) clazz.newInstance(); */
			
			fis.close();
		} catch(Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static DaoFactory getInstace() {
		return instance;
	}
	
	public ModelDao createModelDao() {
		return modelDao;
	}
	
	public CarDao createCarDao() {
		return carDao;
	}
	
	public CustomerDao createCustomerDao() {
		return customerDao;
	}
	
	public MemberDao createMemberDao() {
		return memberDao;
	}
	
	public NonMemberDao createNonMemberDao() {
		return nonMemberDao;
	}
	
	public RentalCarDao createRentalCarDao() {
		return rentalCarDao;
	}
	
	public SoldCarDao createSoldCarDao() {
		return soldCarDao;
	}
	
	public RentsDao createRentsDao() {
		return rentsDao;
	}
}
