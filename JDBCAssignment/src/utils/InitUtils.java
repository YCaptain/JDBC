package utils;

import java.sql.Connection;
import java.sql.Statement;

public class InitUtils {
	public static void initTables(){
		Connection con = null;
		Statement st = null;
		try{
			con = JdbcUtils.getConnection();
			st = con.createStatement();
			
			String sql = "CREATE TABLE customers("
					+ "SSN INT PRIMARY KEY,"
					+ "name VARCHAR(20) NOT NULL,"
					+ "sex VARCHAR(10) NOT NULL,"
					+ "address VARCHAR(50),"
					+ "city VARCHAR(50),"
					+ "country VARCHAR(50),"
					+ "phone INT)";
			st.execute(sql);

			sql = "CREATE TABLE models("
					+ "modelNum INT PRIMARY KEY,"
					+ "modelName VARCHAR(30),"
					+ "manufacturer VARCHAR(50) NOT NULL,"
					+ "seats INT NOT NULL"
					+ ")AUTO_INCREMENT=10000000";
			st.execute(sql);
		
		
			sql = "CREATE TABLE cars("
				+ "registrationNumber INT PRIMARY KEY,"
				+ "modelNum INT,"
				+ "status VARCHAR(10) NOT NULL,"
				+ "dateOfManufacture datetime NOT NULL,"
				+ ""
				+ "FOREIGN KEY (modelNum) REFERENCES models(modelNum) ON DELETE SET NULL ON UPDATE CASCADE"
				+ ")AUTO_INCREMENT=10100000";
			st.execute(sql);
	 
			sql = "CREATE TABLE members("
					+ "memNumber INT PRIMARY KEY,"
					+ "SSN INT NOT NULL,"
					+ "dateOfBirth dateTime,"
					+ "joinedDate dateTime NOT NULL,"
					+ ""
					+ "UNIQUE(memNumber, SSN),"
					+ "FOREIGN KEY (SSN) REFERENCES customers(SSN) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10200000";
			st.execute(sql);

			sql = "CREATE TABLE nonMembers("
					+ "SSN INT PRIMARY KEY,"
					+ ""
					+ "FOREIGN KEY (SSN) REFERENCES customers (SSN) ON DELETE CASCADE ON UPDATE CASCADE)";
			st.execute(sql);
			
			sql = "CREATE TABLE rentalCars("
					+ "registrationNumber INT PRIMARY KEY,"
					+ ""
					+ "FOREIGN KEY (registrationNumber) REFERENCES cars(registrationNumber) ON DELETE CASCADE ON UPDATE CASCADE)";
			st.execute(sql);
			
			sql = "CREATE TABLE soldCars("
					+ "soldNumber INT PRIMARY KEY,"
					+ "registrationNumber INT,"
					+ "SSN INT,"
					+ "orderDate datetime NOT NULL,"
					+ "requiredDate datetime NOT NULL,"
					+ "soldPrice double NOT NULL,"
					+ ""
					+ "FOREIGN KEY (registrationNumber) REFERENCES cars(registrationNumber) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (SSN) REFERENCES customers(SSN) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10300000";
			st.execute(sql);
			
			sql = "CREATE TABLE rents("
					+ "rentNumber INT PRIMARY KEY,"
					+ "memNumber INT,"
					+ "registrationNumber INT,"
					+ "distance double DEFAULT 0,"
					+ "orderDate datetime NOT NULL,"
					+ "requiredDate datetime NOT NULL,"
					+ "rentPrice double NOT NULL,"
					+ ""
					+ "FOREIGN KEY (registrationNumber) REFERENCES cars(registrationNumber) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (memNumber) REFERENCES members(memNumber) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10400000";
			st.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
	public static void main(String[] args) {
		initTables();
	}
}
