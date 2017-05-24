package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;
import bean.Customer.Sex;
import dao.CustomerDao;
import dao.DaoException;
import utils.JdbcUtils;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void addCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO customers(SSN, name, sex, address, city, country, phone)"
					+ " VALUES(?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, customer.getSSN());
			st.setString(2, customer.getName());
			st.setString(3, customer.getSex().toString());
			st.setString(4, customer.getAddress());
			st.setString(5, customer.getCity());
			st.setString(6, customer.getCountry());
			st.setInt(7, customer.getPhone());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Customer getCustomemr(int SSN) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM customers WHERE SSN = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, SSN);
			rs = st.executeQuery();
			Customer customer = new Customer();
			customer.updateSSN(SSN);
			customer.updateName(rs.getString("name"));
			if(rs.getString("sex").equals("MALE")) {
				customer.updateSex(Sex.MALE);
			} else if(rs.getString("sex").equals("FEMALE")) {
				customer.updateSex(Sex.FEMALE);
			} else if(rs.getString("sex").equals("OTHER")) {
				customer.updateSex(Sex.OTHER);
			} else {
				throw new Exception();
			}
			customer.updateAddress(rs.getString("address"));
			customer.updateCity(rs.getString("city"));
			customer.updateCountry(rs.getString("country"));
			customer.updatePhone(rs.getInt("phone"));
			return customer;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Customer customer) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE customer SET name = ?, sex = ?, address = ?,"
					+ " city = ?, country = ?, phone = ? WHERE SSN = ?";
			st = con.prepareStatement(sql);
			st.setString(1, customer.getName());
			st.setString(2, customer.getSex().toString());
			st.setString(3, customer.getAddress());
			st.setString(4, customer.getCity());
			st.setString(5, customer.getCountry());
			st.setInt(6, customer.getPhone());
			st.setInt(7, customer.getSSN());
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
	public int delete(Customer customer) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM customers WHERE SSN = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, customer.getSSN());
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
