package utils;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class InitUtils {
	public static void createDataBase() {
		Connection con = null;
		Statement st = null;
		try{
			con = JdbcUtils.getBasicConnection();
			st = con.createStatement();

			String sql = "CREATE DATABASE assignment";
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "new success", "message", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "can not do repititive new database", "error", JOptionPane.ERROR_MESSAGE);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
	public static void dropDatabase() {
		Connection con = null;
		Statement st = null;
		try{
			con = JdbcUtils.getBasicConnection();
			st = con.createStatement();
			
			String sql = "DROP DATABASE assignment";
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "drop success", "message", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "you need create a database firstly", "error", JOptionPane.ERROR_MESSAGE);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
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
					+ "rentPrice DOUBLE,"
					+ ""
					+ "FOREIGN KEY (registrationNumber) REFERENCES cars(registrationNumber) ON DELETE CASCADE ON UPDATE CASCADE)";
			st.execute(sql);
			
			sql = "CREATE TABLE soldCars("
					+ "soldNumber INT PRIMARY KEY,"
					+ "registrationNumber INT,"
					+ "SSN INT,"
					+ "orderDate datetime NOT NULL,"
					+ "requiredDate datetime NOT NULL,"
					+ "soldPrice DOUBLE NOT NULL,"
					+ ""
					+ "FOREIGN KEY (registrationNumber) REFERENCES cars(registrationNumber) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (SSN) REFERENCES customers(SSN) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10300000";
			st.execute(sql);
			
			sql = "CREATE TABLE rents("
					+ "rentNumber INT PRIMARY KEY,"
					+ "memNumber INT,"
					+ "registrationNumber INT,"
					+ "distance DOUBLE DEFAULT 0,"
					+ "orderDate datetime NOT NULL,"
					+ "requiredDate datetime NOT NULL,"
					+ ""
					+ "FOREIGN KEY (registrationNumber) REFERENCES cars(registrationNumber) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY (memNumber) REFERENCES members(memNumber) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")AUTO_INCREMENT=10400000";
			st.execute(sql);
			TestDemo.main(null);
			JOptionPane.showMessageDialog(null, "initialize success", "message", JOptionPane.INFORMATION_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "can not do repititive initial options or you need new database", "error", JOptionPane.ERROR_MESSAGE);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}
	
	public static void main(String[] args) {
		initTables();
	}
}
