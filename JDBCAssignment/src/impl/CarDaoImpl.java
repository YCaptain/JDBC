package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.CarDao;
import dao.DaoException;
import entity.Car;
import entity.Car.Status;
import utils.JdbcUtils;

public class CarDaoImpl implements CarDao{

	@Override
	public void addCar(Car car) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO cars(registrationNumber, model, status, dateOfManufacture)"
					+ " VALUES (?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, car.getRegistrationNumber());
			st.setString(2, car.getModel());
			st.setString(3, car.getStatus().toString());
			st.setDate(4, new Date(car.getDateOfManufacture().getTime()));
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
			car.updateModel(rs.getString("model"));
			car.updateDateOfManuFacture(rs.getDate("dateOfManuFacture"));
			if(rs.getString("status").equals("RENTAL")) {
				car.updateStatus(Status.RENTAL);
			} else if(rs.getString("status").equals("SOLD")) {
				car.updateStatus(Status.SOLD);
			} else {
				throw new Exception();
			}
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
			String sql = "UPDATE cars SET model = ?, status = ?"
					+ ", dateOfManuFacture = ? WHERE registrationNumber = ?";
			st = con.prepareStatement(sql);
			st.setString(1, car.getModel());
			st.setString(2, car.getStatus().toString());
			st.setDate(3, new Date(car.getDateOfManufacture().getTime()));
			st.setInt(4, car.getRegistrationNumber());
			int count = 0;
			count = st.executeUpdate();
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
