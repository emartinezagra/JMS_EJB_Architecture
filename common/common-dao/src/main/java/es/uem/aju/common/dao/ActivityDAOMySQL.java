package es.uem.aju.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import es.uem.aju.common.dao.interfaces.ActivityDAO;
import es.uem.aju.common.dto.ActivityDTO;
import es.uem.aju.common.dto.ActivityListDTO;
import es.uem.aju.common.dto.BaseDTO;
import es.uem.aju.common.dto.CompanyListDTO;

public class ActivityDAOMySQL extends BaseDAO implements ActivityDAO {

	private final static String SQL_FIND_ALL = "select * from activity";
	private final static String SQL_FIND_ACTIVITY = "select * from activity where id =?";
	private final static String SQL_FIND_MAX_ID = "select MAX(ID) as MAX_ID from activity";

	public ActivityDAOMySQL(DataSource datasource) {
		super(datasource);
	}

	public List<ActivityDTO> processListResultSet(ResultSet resultSet) throws SQLException {
		List<ActivityDTO> result = new ArrayList<ActivityDTO>();
		try {
			while (resultSet.next()) {
				result.add(new ActivityDTO(resultSet.getInt("id"), resultSet.getInt("user_id"),
						resultSet.getInt("equipment_id"), resultSet.getTimestamp("ac_date"),
						resultSet.getBoolean("entering")));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				log.error("Error closing resultrest: " + e.getMessage());
			}
		}
		return result;
	}

	public List<ActivityDTO> findActivityByDate(Date date, long intervalMillis) {

		return null;
	}

	public ActivityDTO find(Integer pk) {
		List<ActivityDTO> results = new ArrayList<ActivityDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_ACTIVITY);
			ps.setInt(1, pk);

			results = (List<ActivityDTO>) processListResultSet(ps.executeQuery());
			if (results.size() == 1) {
				return results.get(0);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						log.error("Error closing connection : " + e.getMessage());
					}
				}
			}
		}
		return null;
	}

	public int findMaxId() {
		Connection con = null;
		PreparedStatement ps = null;
		Integer maxId = 0;
		try {
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_MAX_ID);
			ResultSet result = ps.executeQuery();
			while (result.next()) {

				maxId = result.getInt("max_id");
			}

		} catch (SQLException e) {
			return maxId;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						log.error("Error closing connection : " + e.getMessage());
					}
				}
			}
		}
		return maxId;
	}

	public ActivityListDTO findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_ALL);
			return new ActivityListDTO(processListResultSet(ps.executeQuery()));

		} catch (SQLException e) {
			return null;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					log.error(e.getMessage());
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						log.error("Error closing connection : " + e.getMessage());
					}
				}
			}
		}
	}

	public void store(ActivityDTO o) throws SQLException {
		int maxId = findMaxId();
		maxId++;
		int entering;
		if (o.isEntering())
			entering = 1;
		else
			entering = 0;
		Connection con = null;

		con = datasource.getConnection();
		Statement statement = con.createStatement();
		String valuesString = String.valueOf(maxId) + "," + String.valueOf(o.getUser()) + ","
				+ String.valueOf(o.getEquipment()) + ",NOW()," + String.valueOf(entering);
		statement.executeUpdate("INSERT INTO ACTIVITY VALUES (" + valuesString + ") ");
	}

	public void update(ActivityDTO o) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int delete(Integer pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
