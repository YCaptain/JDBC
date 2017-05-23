package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.DaoException;
import dao.MemberDao;
import entity.Customer;
import entity.Member;
import service.CustomerService;
import utils.JdbcUtils;

public class MemberDaoImpl implements MemberDao {

	@Override
	public void addMember(Member member) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO members(memNumber, SSN, dateOfBirth, joinedDate)"
					+ " VALUES(?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, member.getMemNumber());
			st.setInt(2, member.getSSN());
			st.setDate(3, new Date(member.getDateOfBirth().getTime()));
			st.setDate(4, new Date(member.getJoinedDate().getTime()));
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Member getMember(int memNumber) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM members WHERE memNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, memNumber);
			rs = st.executeQuery();
			CustomerService customerService = new CustomerService();
			Customer customer = customerService.query(rs.getInt("SSN"));
			Member member = new Member(customer);
			member.updateMemNumber(memNumber);
			member.updateDateOfBirth(rs.getDate("dateOfBirth"));
			member.updateJoinedDate(rs.getDate("joinedDate"));
			member.updateSSN(rs.getInt("SSN"));
			return member;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Member member) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE members SET SSN = ?, dateOfBirth = ?, joinedDate = ?"
					+ " WHERE memNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, member.getSSN());
			st.setDate(2, new Date(member.getDateOfBirth().getTime()));
			st.setDate(3, new Date(member.getJoinedDate().getTime()));
			st.setInt(4, member.getMemNumber());
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
	public int delete(Member member) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM members WHERE memNumber = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, member.getMemNumber());
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
