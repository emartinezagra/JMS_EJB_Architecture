package es.uem.aju.common.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import es.uem.aju.common.dao.BaseDAO;
import es.uem.aju.common.dto.BaseDTO;

public class DummyDAOMySQL extends BaseDAO implements DummyDAO {

	
	private final static String SQL_FIND_DUMMIES = "select name from dummy";
	
	private static Logger log = Logger.getLogger( DummyDAOMySQL.class );
	
	
	public DummyDAOMySQL(DataSource datasource) {
		super(datasource);	
	}
	
	public List<DummyDTO> findDummies() {

		List<DummyDTO> results = new ArrayList<DummyDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(SQL_FIND_DUMMIES);					
			
			results = (List<DummyDTO>) processListResultSet(ps.executeQuery());
			if (results.size() > 0){
				return results;
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

	public Collection<? extends BaseDTO> processListResultSet(ResultSet resultSet) {
		List<DummyDTO> result = new ArrayList<DummyDTO>();
		byte[] fileBytes;
		try{
			while (resultSet.next()){								
				result.add(new DummyDTO(								
								resultSet.getString("name")								
								));			
			}			
		}catch(SQLException e){	
			log.error(e.getMessage());
			}
		finally{
			try {
				resultSet.close();
			} catch (SQLException e){
				log.error("Error closing resultset : "+e.getMessage());
			}			
		}	
		return result;
	}


	public BaseDTO find(Long pk) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	public void store(DummyDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public void update(DummyDTO o) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public int delete(Long pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public BaseDTO findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
