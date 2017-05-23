package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.DaoException;
import dao.RentalCarDao;
import entity.Car;
import entity.RentalCar;
import service.CarService;
import utils.JdbcUtils;

public class RentalCarDaoImpl implements RentalCarDao {

	@Override
	public void addRentalCar(RentalCar car) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO rentalCars(registrationNumber) VALUES (?)";
			st = con.prepareStatement(sql);
			st.setInt(1, car.getRegistrationNumber());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
		
	}

	@Override
	public RentalCar getRentalCar(int registrationNumber) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM rentalCars WHERE registrationNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, registrationNumber);
			rs = st.executeQuery();
			CarService carService = new CarService();
			Car car = carService.query(rs.getInt("registrationNumber"));
			RentalCar rentalCar = new RentalCar(car);
			return rentalCar;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(RentalCar rentalCar) {
		return 0;
	}

	@Override
	public int delete(RentalCar rentalCar) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM rentalCars WHERE registrationNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, rentalCar.getRegistrationNumber());
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
