package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;
import bean.NonMember;
import dao.DaoException;
import dao.NonMemberDao;
import service.CustomerService;
import utils.JdbcUtils;

public class NonMemberDaoImpl implements NonMemberDao {

	@Override
	public void addNonMember(NonMember nonMember) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO nonMembers(SSN) VALUES (?)";
			st = con.prepareStatement(sql);
			st.setInt(1, nonMember.getSSN());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public NonMember getNonMember(int SSN) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM nonMembers WHERE SSN = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, SSN);
			rs = st.executeQuery();
			CustomerService customerService = new CustomerService();
			Customer customer = customerService.query(rs.getInt("SSN"));
			NonMember nonMember = new NonMember(customer);
			return nonMember;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(NonMember nonMember) {
		return 0;
	}

	@Override
	public int delete(NonMember nonMember) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM nonMembers WHERE SSN = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, nonMember.getSSN());
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
