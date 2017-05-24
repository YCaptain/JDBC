package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Model;
import dao.DaoException;
import dao.ModelDao;
import utils.JdbcUtils;

public class ModelDaoImpl implements ModelDao {

	@Override
	public void addModel(Model model) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO models(modelNum, modelName, manufacturer, seats)"
					+ " VALUES (?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, model.getModelNum());
			st.setString(2, model.getModelName());
			st.setString(3, model.getManufacturer());
			st.setInt(4, model.getSeats());
			int count = st.executeUpdate();
			System.out.println("Add record: " + count);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(null, st, con);
		}
	}

	@Override
	public Model getModel(String modelName) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM models WHERE modelNum = ?";
			st = con.prepareStatement(sql);
			st.setString(1, modelName);
			rs = st.executeQuery();
			Model model = new Model();
			model.updateModelNum(rs.getInt("modelNum"));
			model.updateModelName(rs.getString("modelName"));
			model.updateManufacturer(rs.getString("manufacturer"));
			model.updateSeats(rs.getInt("seats"));
			return model;
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JdbcUtils.free(rs, st, con);
		}
	}

	@Override
	public int update(Model model) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "UPDATE models SET modelName = ?, manufacturer = ?, seats = ?"
					+ " WHERE modelNum = ?";
			st = con.prepareStatement(sql);
			st.setString(1, model.getModelName());
			st.setString(2, model.getManufacturer());
			st.setInt(3, model.getSeats());
			st.setInt(4, model.getModelNum());
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
	public int delete(Model model) {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = JdbcUtils.getConnection();
			String sql = "DELETE FROM models WHERE modelNum = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, model.getModelNum());
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
