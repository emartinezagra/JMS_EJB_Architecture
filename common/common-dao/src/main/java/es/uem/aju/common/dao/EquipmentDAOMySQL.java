package es.uem.aju.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import es.uem.aju.common.dao.interfaces.EquipmentDAO;
import es.uem.aju.common.dto.EquipmentDTO;
import es.uem.aju.common.dto.EquipmentListDTO;

public class EquipmentDAOMySQL extends BaseDAO implements EquipmentDAO {

	private final static String SQL_FIND_EQUIPMENT = "select equipment.id, equipment.location_id, status.status from equipment, status where equipment.id =? and equipment.status_id = status.id";
	
	private final static String SQL_FIND_ALL_EQUIPMENT = "select equipment.id, equipment.location_id, status.status from equipment, status where equipment.status_id = status.id;";
	
	public EquipmentDAOMySQL(DataSource datasource) {
		super(datasource);
	}

	public EquipmentDTO find(Integer pk) {
		List<EquipmentDTO> results = new ArrayList<EquipmentDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_EQUIPMENT);
			ps.setInt(1, pk);
			
			results = (List<EquipmentDTO>) processListResultSet(ps.executeQuery());
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
	
	public EquipmentListDTO findAll() {
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_ALL_EQUIPMENT);						
			return new EquipmentListDTO(processListResultSet(ps.executeQuery()));			
						
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
	
	public List<EquipmentDTO> processListResultSet(ResultSet resultSet) throws SQLException {
		List<EquipmentDTO> result = new ArrayList<EquipmentDTO>();
		try{
			while (resultSet.next()){
				result.add(new EquipmentDTO(
								resultSet.getInt("id"),								
								resultSet.getInt("location_id"),
								resultSet.getString("status")
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

	public void store(EquipmentDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void update(EquipmentDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public int delete(Integer pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}	

}
