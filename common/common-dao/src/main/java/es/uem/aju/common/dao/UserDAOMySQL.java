package es.uem.aju.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import es.uem.aju.common.dao.interfaces.UserDAO;

import es.uem.aju.common.dto.UserDTO;
import es.uem.aju.common.dto.UserListDTO;

public class UserDAOMySQL extends BaseDAO implements UserDAO {

	public UserDAOMySQL(DataSource datasource) {
		super(datasource);
	}

	private final static String SQL_FIND_USER = "select * from user where id = ?";
	private final static String SQL_FIND_ALL_USERS = "select * from user";
	
	public UserDTO find(Integer pk)  {
		List<UserDTO> results = new ArrayList<UserDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_USER);
			ps.setInt(1, pk);
			
			results = (List<UserDTO>) processListResultSet(ps.executeQuery());
			if (results.size() ==1){
				return results.get(0);
			}			
		}catch(SQLException e){
			return null;
		}finally{			
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e){
		        	log.error(e.getMessage());
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e){
		        	log.error("Error closing connection : "+e.getMessage());
		        	}
		        }
		    }
		}		
		return null;
	}
	
	public UserListDTO findAll() {		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_ALL_USERS);						
			return new UserListDTO(processListResultSet(ps.executeQuery()));			
						
		}catch(SQLException e){
			return null;
		}finally{			
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e){
		        	log.error(e.getMessage());
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e){
		        	log.error("Error closing connection : "+e.getMessage());
		        	}
		        }
		    }
		}				
	}
	

	public void store(UserDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void update(UserDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public int delete(Integer pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<UserDTO> processListResultSet(ResultSet resultSet) throws SQLException {
		List<UserDTO> result = new ArrayList<UserDTO>();
		try{												
			while (resultSet.next()){
				result.add(new UserDTO(
								resultSet.getInt("id"),																
								resultSet.getString("name"),
								resultSet.getString("email"),
								resultSet.getString("phone"),
								resultSet.getInt("company_id")
								));			
			}			
		}catch(SQLException e){	
			log.error(e.getMessage());
			}
		finally{
			try {
				resultSet.close();
			} catch (SQLException e){
				log.error("Error closing resultrest: "+e.getMessage());
			}			
		}	
		return result;
	}

}
