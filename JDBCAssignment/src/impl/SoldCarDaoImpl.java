package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Car;
import bean.SoldCar;
import dao.DaoException;
import dao.SoldCarDao;
import service.CarService;
import utils.JdbcUtils;

public class SoldCarDaoImpl implements SoldCarDao {

	@Override
	public void addSoldCar(SoldCar soldCar) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO soldCars(soldNumber, SSN, registrationNumber, orderDate, requiredDate, soldPrice)"
					+ " VALUES(?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, soldCar.getSoldNumber());
			st.setInt(2, soldCar.getSSN());
			st.setInt(3, soldCar.getRegistrationNumber());
			st.setDate(4, new Date(soldCar.getOrderDate().getTime()));
			st.setDate(5, new Date(soldCar.getRequiredDate().getTime()));
			st.setDouble(6, soldCar.getSoldPrice());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public SoldCar getSoldCar(int soldNumber) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM soldCars WHERE soldNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, soldNumber);
			rs = st.executeQuery();
			CarService carService = new CarService();
			Car car = carService.query(rs.getInt("registrationNumber"));
			SoldCar soldCar = new SoldCar(car);
			soldCar.updateSoldNumber(rs.getInt("soldNumber"));
			soldCar.updateSSN(rs.getInt("SSN"));
			soldCar.updateRegistrationNumber(rs.getInt("registration"));
			soldCar.updateOrderDate(rs.getDate("orderDate"));
			soldCar.updateRequiredDate(rs.getDate("requiredDate"));
			soldCar.updateSoldPrice(rs.getDouble("soldPrice"));
			return soldCar;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(SoldCar soldCar) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE soldCars SET SSN = ?, registration = ?, orderDate = ?,"
					+ " requiredDate = ?, soldPrice = ? WHERE soldNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, soldCar.getSSN());
			st.setInt(2, soldCar.getRegistrationNumber());
			st.setDate(3, new Date(soldCar.getOrderDate().getTime()));
			st.setDate(4, new Date(soldCar.getRequiredDate().getTime()));
			st.setDouble(5, soldCar.getSoldPrice());
			st.setInt(6, soldCar.getSoldNumber());
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
	public int delete(SoldCar soldCar) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM soldCars WHERE soldNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, soldCar.getSoldNumber());
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
