package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Car;
import dao.CarDao;
import dao.DaoException;
import utils.JdbcUtils;

public class CarDaoImpl implements CarDao {

	@Override
	public void addCar(Car car) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO cars(registrationNumber, modelNum,dateOfManufacture)"
					+ " VALUES (?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, car.getRegistrationNumber());
			st.setInt(2, car.getModelNum());
			st.setDate(3, new Date(car.getDateOfManufacture().getTime()));
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Car getCar(int registrationNumber) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM cars WHERE registrationNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, registrationNumber);
			rs = st.executeQuery();
			Car car = new Car();
			car.updateRegistrationNumber(registrationNumber);
			car.updateModelNum(rs.getInt("modelNum"));
			car.updateDateOfManuFacture(rs.getDate("dateOfManuFacture"));
			return car;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Car car) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE cars SET modelNum = ?, dateOfManuFacture = ? WHERE registrationNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, car.getModelNum());
			st.setDate(2, new Date(car.getDateOfManufacture().getTime()));
			st.setInt(3, car.getRegistrationNumber());
			int count = st.executeUpdate();
			System.out.println("Update record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public int delete(Car car) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM cars WHERE registrationNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, car.getRegistrationNumber());
			int count = st.executeUpdate();
			System.out.println("Delete record: " + count);
			return count;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

}
