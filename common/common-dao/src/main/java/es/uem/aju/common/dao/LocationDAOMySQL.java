package es.uem.aju.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import es.uem.aju.common.dao.interfaces.LocationDAO;
import es.uem.aju.common.dto.LocationDTO;
import es.uem.aju.common.dto.LocationListDTO;

public class LocationDAOMySQL extends BaseDAO implements LocationDAO {

	public LocationDAOMySQL(DataSource datasource) {
		super(datasource);
	}

	private final static String SQL_FIND_LOCATION = "select * from location where id = ?";
	
	private final static String SQL_FIND_ALL_LOCATIONS = "select * from location";
	
	public LocationDTO find(Integer pk) {
		List<LocationDTO> results = new ArrayList<LocationDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_LOCATION);
			ps.setInt(1, pk);
			
			results = (List<LocationDTO>) processListResultSet(ps.executeQuery());
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
	
	public LocationListDTO findAll() {		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_ALL_LOCATIONS);						
			return new LocationListDTO(processListResultSet(ps.executeQuery()));			
						
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


	public void store(LocationDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void update(LocationDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public int delete(Integer pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<LocationDTO> processListResultSet(ResultSet resultSet) throws SQLException {
		List<LocationDTO> result = new ArrayList<LocationDTO>();
		try{						
			while (resultSet.next()){
				result.add(new LocationDTO(
								resultSet.getInt("id"),																
								resultSet.getString("name"),
								resultSet.getInt("COORDENATEX"),
								resultSet.getInt("COORDENATEY"),
								resultSet.getInt("LOCATION_ID")
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
